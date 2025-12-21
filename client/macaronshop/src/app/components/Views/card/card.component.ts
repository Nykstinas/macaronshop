import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';

@Component({
  selector: 'card',
  templateUrl: '../card/card.component.html',
  styleUrls: ['../card/card.component.scss'],
  standalone: true,
  imports: [
    RouterLink
  ]
})

export class CardView implements OnInit{

  item: any;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.item = data['item'];
    });
  }
}
