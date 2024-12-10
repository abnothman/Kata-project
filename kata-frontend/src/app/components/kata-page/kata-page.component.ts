import { Component } from '@angular/core';
import { KataModalComponent } from '../kata-modal/kata-modal.component';

@Component({
  selector: 'app-kata-page',
  imports: [KataModalComponent],
  templateUrl: './kata-page.component.html',
  styleUrls: ['./kata-page.component.css'],
})
export class KataPageComponent {}
