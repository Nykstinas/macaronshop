export interface backetItem {
  itemId: number;
  quantity: number;
}

export interface BacketState {
  backet: backetItem[];
}

export const initialBacketState: BacketState = {
  backet: []
};
