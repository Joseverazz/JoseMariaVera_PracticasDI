import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { AsignaturasService } from 'src/app/services/asignaturas.service';
import { asignatura } from 'src/app/utils/asignatura';

@Component({
  selector: 'rutas-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  curso: string = "";
  @Input() entrada: string ="";

  asignaturasFiltradas:asignatura[] = [];

  constructor(private rutaActiva: ActivatedRoute, private asignaturaServicio:AsignaturasService) { }

  ngOnInit(): void {
    //console.log(this.rutaActiva.snapshot.params['curso']);
    //this.curso = this.rutaActiva.snapshot.params['curso'];
    this.rutaActiva.params.subscribe((param: Params) => {
      this.curso = param['curso'];
      this.asignaturasFiltradas = this.asignaturaServicio.filtrarAsignaturas(this.curso);
      //this.asignaturasFiltradas = this.asignaturaServicio.asignaturas;
      //this.filtrarAsignaturas(this.curso);
    })
  }
  filtrarAsignaturasAnio(anio: string) {
    this.asignaturasFiltradas = this.asignaturaServicio.filtrarAsignaturasPorAnio(this.curso, anio);

  }
  filtrarAsignaturas(curso:string) {
    //this.asignaturasFiltradas = this.asignaturas.filter((item)=> item.ciclo.toLowerCase().includes(curso.toLowerCase()));
  }

}
