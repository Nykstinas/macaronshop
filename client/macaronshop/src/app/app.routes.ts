import { Routes } from '@angular/router';
import {MainView} from './components/Views/main/main.component';
import {CardView} from './components/Views/card/card.component';
import {itemResolver} from './components/resolver/itemResolver';

export const routes: Routes = [
  {
    path:'',
    component:MainView,
    resolve: { item: itemResolver }
  },{
    path:'card',
    component:CardView
  }
];
