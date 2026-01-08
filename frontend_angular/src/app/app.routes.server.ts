import { RenderMode, ServerRoute } from '@angular/ssr';

export const serverRoutes: ServerRoute[] = [
  {
    path: 'courses-learn/:levelId',
    renderMode: RenderMode.Client
  },
  {
    path: 'courses-learn-view/:levelId/:courseId',
    renderMode: RenderMode.Client
  },
  {
    path: '**',
    renderMode: RenderMode.Prerender
  }
];