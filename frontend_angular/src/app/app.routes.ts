import { Routes } from '@angular/router';
import { HomeComponent } from './home/home';
import { B1Component } from './courses/b1/b1';
import { B2Component } from './courses/b2/b2';
import { C1Component } from './courses/c1/c1';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'course-b1', component: B1Component },
  { path: 'course-b2', component: B2Component },
  { path: 'course-c1', component: C1Component },
  ];
