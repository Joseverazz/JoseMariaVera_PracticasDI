import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosComponent } from './components/cursos/cursos.component';
import { InformacionComponent } from './components/informacion/informacion.component';
import { HomeComponent } from './components/home/home.component';
import { ExtraComponent } from './components/extra/extra.component';

const routes: Routes = [
  { path: 'info', component: InformacionComponent },
  { path: 'cursos/:curso', component: CursosComponent },
  { path: 'home', component: HomeComponent },
  { path: 'extra', component: ExtraComponent },
  { path: '**', redirectTo:"home" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
