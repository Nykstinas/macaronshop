import { Routes } from '@angular/router';
import {MainView} from './components/Views/main/main.component';
import {CardView} from './components/Views/card/card.component';

export const routes: Routes = [
  {
    path:'',
    component:MainView
  },{
    path:'card',
    component:CardView
  }
];
