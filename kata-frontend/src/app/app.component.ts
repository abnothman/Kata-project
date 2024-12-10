import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';import {KataPageComponent} from './components/kata-page/kata-page.component';

@Component({
  selector: 'app-root',
  imports: [KataPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'

})
export class AppComponent {
  title = 'kata-frontend';
}
