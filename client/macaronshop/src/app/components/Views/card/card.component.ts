import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {BacketFacade} from '../../store/backet.facade';
import {addToBacket} from '../../store/backet.actions';

@Component({
  selector: 'card',
  templateUrl: '../card/card.component.html',
  styleUrls: ['../card/card.component.scss'],
  standalone: true,
  imports: [RouterLink]
})
export class CardView implements OnInit {
  item: any;

  constructor(
    private route: ActivatedRoute,
    private facade: BacketFacade
  ) {
  }

  ngOnInit(): void {
    this.item = this.route.snapshot.data['item'];
  }

  addToBasket(): void {
    this.facade.add(this.item);
  }
}


