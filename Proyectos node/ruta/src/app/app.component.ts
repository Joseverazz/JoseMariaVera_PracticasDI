import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'rutas-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
// Router
  title = 'ruta';

  constructor(private navegador: Router) {

  }

  navegar() {
    this.navegador.navigate(['cursos', 'dam'])
  }
}
