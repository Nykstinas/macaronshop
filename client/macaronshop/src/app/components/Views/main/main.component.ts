import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'main',
  templateUrl: '../main/main.component.html',
  styleUrls: ['../main/main.component.scss'],
  standalone: true,
  imports: [
    RouterLink,
    CommonModule
  ]
})

export class MainView implements OnInit{
  items: any;


  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.items = this.route.snapshot.data['item'];

  }
}
