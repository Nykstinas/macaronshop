import { createReducer, on } from '@ngrx/store';
import { initialBacketState } from './backet.state';
import { addToBacket, removeFromBacket, increaseQty, decreaseQty, clearBacket } from './backet.actions';

export const BacketReducer = createReducer(
  initialBacketState,

  on(addToBacket, (state, { item }) => {
    const existing = state.backet.find(i => i.itemId === item.itemId);
    if (existing) {
      return {
        ...state,
        items: state.backet.map(i =>
          i.itemId === item.itemId
            ? { ...i, quantity: i.quantity + 1 }
            : i
        )
      };
    }
    return { ...state, backet: [...state.backet, { ...item, quantity: 1 }] };
  }),

  on(increaseQty, (state, { itemId }) => ({
    ...state,
    items: state.backet.map(i =>
      i.itemId === itemId ? { ...i, quantity: i.quantity + 1 } : i
    )
  })),

  on(decreaseQty, (state, { itemId }) => ({
    ...state,
    items: state.backet
      .map(i => i.itemId === itemId ? { ...i, quantity: i.quantity - 1 } : i)
      .filter(i => i.quantity > 0)
  })),

  on(removeFromBacket, (state, { itemId }) => ({
    ...state,
    items: state.backet.filter(i => i.itemId !== itemId)
  })),

  on(clearBacket, () => initialBacketState)
);
