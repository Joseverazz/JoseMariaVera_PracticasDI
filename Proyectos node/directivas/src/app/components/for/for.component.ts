import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'directiva-for',
  templateUrl: './for.component.html',
  styleUrls: ['./for.component.css']
})
export class ForComponent implements OnInit {

  lenguajes: any[] = ['JavaScript', 'Java', 'Phython', 'Powershell', 'Bash', 'TypeScript', 'SQL', 'Dart', 1, 2, 3, 4, 5, false]
    ;
  numero: Number = 0;
  
  asignaturas = [
    {
      asignatura: 'Programacion multimedia y movil',
      siglas: "PMDM",
      horas: 4,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimentos:['Java', 'Android', 'XML', 'API']
    },
    {
      asignatura: 'Desarrollo de interfaces',
      siglas: "DI",
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimentos:['Java', 'JavaScript', 'JSON']
    },
    {
      asignatura: 'Sistemas informaticos',
      siglas: "SI",
      horas: 6,
      profesor: 'Alfonso de Uña',
      ciclo: 'DAM | DAW',
      curso: 1,
      conocimentos:['SO', 'Linux', 'Binario', 'Ordenadores']
    },
    {
      asignatura: 'Bases de datos',
      siglas: "BSD",
      horas: 8,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAM | DAW',
      curso: 1,
      conocimentos:['SQL', 'Sistemas relacionales', 'E/R', 'Flujo de bases de datos']
    },
    {
      asignatura: 'Desarrollo cliente',
      siglas: "DC",
      horas: 6,
      profesor: 'Borja martin',
      ciclo: 'DAW',
      curso: 2,
      conocimentos:['JavaScript','React', 'Node']
    },
    {
      asignatura: 'Desarrollo servidor',
      siglas: "DS",
      horas: 6,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAW',
      curso: 2,
      conocimentos:['SQL', 'Sistemas relacionales', 'E/R', 'Flujo de bases de datos']
    }
  ]
  asignaturasFiltradas = this.asignaturas;

  cambiarCurso(curso: string) {
    if (Number(curso) == 0) {
      this.asignaturasFiltradas = this.asignaturas;
    } else {
      this.asignaturasFiltradas = this.asignaturas.filter((item)=> item.curso== Number(curso));
    }
    /* 
    this.asignaturasFiltradas = []
    this.asignaturas.forEach(element => {
      if (element.curso == Number(curso)) {
      this.asignaturasFiltradas.push(element);        
      }
    }); */    
  }

  constructor() { }

  ngOnInit(): void {
  }

}
