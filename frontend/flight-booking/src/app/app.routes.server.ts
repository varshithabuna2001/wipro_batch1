import { RenderMode, ServerRoute } from '@angular/ssr';

export const serverRoutes: ServerRoute[] = [
  {
    path: 'booking/:id',
    renderMode: RenderMode.Client
  },
  {
    path: 'payment/:id',
    renderMode: RenderMode.Client
  },
  {
    path: 'ticket/:id',
    renderMode: RenderMode.Client
  },
  {
    path: '**',
    renderMode: RenderMode.Prerender
  }
];
