import {createAction, props} from '@ngrx/store';
import {backetItem} from './backet.state';

export const addToBacket = createAction(
  '[Backet] Add',
  props<{ item: backetItem }>()
);

export const removeFromBacket = createAction(
  '[Backet] Remove',
  props<{ itemId: number }>()
);

export const increaseQty = createAction(
  '[Backet] Increase',
  props<{ itemId: number }>()
);

export const decreaseQty = createAction(
  '[Backet] Decrease',
  props<{ itemId: number }>()
);

export const clearBacket = createAction('[Backet] Clear');
