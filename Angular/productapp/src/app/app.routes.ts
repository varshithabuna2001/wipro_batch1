import { Routes } from '@angular/router';
import { Product } from './product';
import { Productadd } from './productadd/productadd';
import { Productedit } from './productedit/productedit';
import { Productdelete } from './productdelete/productdelete';
import { Productlist } from './productlist/productlist';

export const routes: Routes = [
  { path: '', component: Productlist },
 { path: 'productlist', component: Productlist },
 { path: 'productadd', component: Productadd },
{ path: 'productedit/:id', component: Productedit },
{ path: 'productdelete/:id', component: Productdelete}

]