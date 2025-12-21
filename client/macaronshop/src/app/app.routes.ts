import { Routes } from '@angular/router';
import {MainView} from './components/Views/main/main.component';
import {CardView} from './components/Views/card/card.component';
import {mainResolver} from './components/resolver/mainResolver'
import {cardResolver} from './components/resolver/cardResolver';

export const routes: Routes = [
  {
    path:'',
    component:MainView,
    resolve: { item: mainResolver }
  },{
    path:'card/:itemId',
    component:CardView,
    resolve: { item: cardResolver }
  }
];
