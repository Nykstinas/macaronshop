import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { provideStore, provideState } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { App } from './app/app';
import { routes } from './app/app.routes';
import { BacketReducer } from './app/components/store/backet.reducer';
import { BacketFacade } from './app/components/store/backet.facade';

bootstrapApplication(App, {
  providers: [
    provideRouter(routes),
    provideStore(),
    provideState('backet', BacketReducer),
    provideEffects([]),
    BacketFacade
  ]
});
