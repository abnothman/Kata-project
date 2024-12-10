import { Component } from '@angular/core';
import { KataService } from '../../services/kata.service';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-kata-modal',
  templateUrl: './kata-modal.component.html',
  imports: [FormsModule, NgIf],
  providers: [KataService],
  styleUrls: ['./kata-modal.component.css'],
})
export class KataModalComponent {
  number: number | null = null;
  numberError: boolean = false;

  // Validation simple pour vérifier que le nombre est dans la plage
  validateNumber(): boolean {
    if (this.number === null || this.number < 0 || this.number > 100) {
      this.numberError = true;
      return false;
    }
    this.numberError = false;
    return true;
  }

  constructor(private kataService: KataService) {}

  apiResult: string | null = null;
  apiError: string | null = null;

  submitForm(): void {
    if (this.validateNumber()) {
      this.kataService.transformNumber(this.number!).subscribe(
        (response) => {
          this.apiResult = response;
          this.apiError = null;
        },
        (error) => {
          this.apiResult = null;
          this.apiError = "Impossible d'appeler l'API.";
        }
      );
    }
  }
}
