import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectBacketItems, selectTotalCount } from './backet.selectors';
import { addToBacket, removeFromBacket, increaseQty, decreaseQty, clearBacket } from './backet.actions';
import { backetItem } from './backet.state';

@Injectable({ providedIn: 'root' })
export class BacketFacade {
  constructor(private store: Store) {}

  get items$() { return this.store.select(selectBacketItems); }
  get totalCount$() { return this.store.select(selectTotalCount); }

  add(item: backetItem) { this.store.dispatch(addToBacket({ item })); }
  increase(id: number) { this.store.dispatch(increaseQty({ itemId: id })); }
  decrease(id: number) { this.store.dispatch(decreaseQty({ itemId: id })); }
  remove(id: number) { this.store.dispatch(removeFromBacket({ itemId: id })); }
  clear() { this.store.dispatch(clearBacket()); }
}
