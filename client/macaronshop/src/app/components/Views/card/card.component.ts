import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'card',
  templateUrl: '../card/card.component.html',
  styleUrls: ['../card/card.component.scss'],
  standalone: true,
  imports: [
    RouterLink
  ]
})

export class CardView {

}
