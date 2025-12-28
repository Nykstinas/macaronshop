import { createFeatureSelector, createSelector } from '@ngrx/store';
import { BacketState } from './backet.state';

export const selectBacketState = createFeatureSelector<BacketState>('backet');

export const selectBacketItems = createSelector(
  selectBacketState,
  state => state.backet
);

export const selectTotalCount = createSelector(
  selectBacketItems,
  items => items.reduce((sum, i) => sum + i.quantity, 0)
);

