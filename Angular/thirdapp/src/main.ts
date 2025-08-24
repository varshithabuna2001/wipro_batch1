import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Displaylist } from './app/displaylist/displaylist';
import { Component } from '@angular/core';
import { AppComponent } from './app/component/component';
import { home } from './app/home/home';

bootstrapApplication(home, appConfig)
  .catch((err) => console.error(err));
