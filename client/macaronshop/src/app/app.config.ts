import { ApplicationConfig, isDevMode } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';

import { routes } from './app.routes';
import { BacketReducer } from './components/store/backet.reducer';
import { BacketEffects } from './components/store/backet.effects';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore({ backet: BacketReducer }),
    provideEffects([BacketEffects]),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: !isDevMode() // отключает DevTools в проде
    })
  ]
};
