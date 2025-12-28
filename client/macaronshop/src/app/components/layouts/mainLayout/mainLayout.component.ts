import {Component, DestroyRef, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router, RouterOutlet} from '@angular/router';
import {AsyncPipe} from '@angular/common';
import {BacketFacade} from '../../store/backet.facade';
import {filter} from 'rxjs';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {selectBacketItems} from '../../store/backet.selectors';

@Component({
  standalone: true,
  imports: [RouterOutlet, AsyncPipe],
  templateUrl: './mainLayout.component.html',
})
export class mainLayout implements OnInit {
  routeLink = '';
  readonly backetItems;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private destroyRef: DestroyRef,
    public backet: BacketFacade
  ) {
    this.backetItems = this.backet.items$;
  }

  ngOnInit() {
    this.router.events
      .pipe(
        filter(e => e instanceof NavigationEnd),
        takeUntilDestroyed(this.destroyRef)
      )
      .subscribe(() => {
        let r = this.route;
        while (r.firstChild) r = r.firstChild;

        const data = r.snapshot.data;
        this.routeLink = data['item']?.name
          ? `Готовые наборы > ${data['item'].name}`
          : data['routeLink'] ?? '';
      });
  }
}
