import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { tap, withLatestFrom } from 'rxjs/operators';
import { Store } from '@ngrx/store';
import { addToBacket, removeFromBacket, increaseQty, decreaseQty, clearBacket } from './backet.actions';
import { selectBacketItems } from './backet.selectors';

@Injectable()
export class BacketEffects {
  saveBacket$ = createEffect(
    () =>
      this.actions$.pipe(
        ofType(addToBacket, removeFromBacket, increaseQty, decreaseQty, clearBacket),
        withLatestFrom(this.store.select(selectBacketItems)),
        tap(([action, backet]) => {
          localStorage.setItem('backet', JSON.stringify(backet));
        })
      ),
    { dispatch: false }
  );

  constructor(private actions$: Actions, private store: Store) {}
}
