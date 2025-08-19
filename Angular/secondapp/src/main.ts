import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
//import { App } from './app/app';
//import { Listcomp } from './app/listcomp/listcomp';
//import { Condicomp } from './app/condicomp/condicomp';
//import { Countrylist } from './app/countrylist/countrylist';
//import { SearchFilter } from './app/search-filter/search-filter';
//import { changecol }  from './app/changecol/changecol';
import { Home } from './app/home/home';

bootstrapApplication(Home, appConfig)
  .catch((err) => console.error(err));
