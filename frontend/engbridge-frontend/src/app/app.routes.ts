import { Routes } from '@angular/router';
import { PlacementTest } from './components/placement-test/placement-test';

export const routes: Routes = [
  { path: '', redirectTo: '/placement-test', pathMatch: 'full' },
  { path: 'placement-test', component: PlacementTest }
];
