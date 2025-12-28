import { Routes } from '@angular/router';
import {MainView} from './components/Views/main/main.component';
import {CardView} from './components/Views/card/card.component';
import {mainResolver} from './components/resolver/mainResolver'
import {cardResolver} from './components/resolver/cardResolver';
import {mainLayout} from './components/layouts/mainLayout/mainLayout.component';

export const routes: Routes = [
  {
    path: '',
    component: mainLayout,
    children: [
      {
        path: '',
        component: MainView,
        resolve: { item: mainResolver },
        data: { routeLink: 'Каталог > Готовые наборы' }
      },
      {
        path: 'card/:itemId',
        component: CardView,
        resolve: { item: cardResolver }
      }
    ]
  }
];
