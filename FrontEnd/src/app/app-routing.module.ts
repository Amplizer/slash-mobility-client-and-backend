import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';

const routes: Routes = [
  {
    path : "index", component : IndexComponent
  },
  {
    path : "**", redirectTo : "index"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
