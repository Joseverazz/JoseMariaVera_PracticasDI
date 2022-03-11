import { Injectable } from '@angular/core';
import { asignatura } from '../utils/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

  asignaturas: asignatura[] = [
    {
      asignatura: 'Programacion multimedia y movil',
      siglas: "PMDM",
      horas: 4,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimentos: ['Java', 'Android', 'XML', 'API'],
      imagen: "https://moodlesafareyes.safanet.es/pluginfile.php/42476/course/section/13992/pmdmport.jpg"
    },
    {
      asignatura: 'Desarrollo de interfaces',
      siglas: "DI",
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimentos: ['Java', 'JavaScript', 'JSON'],
      imagen: "https://entreunosyceros.net/wp-content/uploads/2013/11/interface-usuario.png"
    },
    {
      asignatura: 'Sistemas informaticos',
      siglas: "SI",
      horas: 6,
      profesor: 'Alfonso de Uña',
      ciclo: 'DAM | DAW',
      curso: 1,
      conocimentos: ['SO', 'Linux', 'Binario', 'Ordenadores'],
      imagen: "https://www.sercopilevante.com/wp-content/uploads/2015/07/implantacion001.jpg"
    },
    {
      asignatura: 'Bases de datos',
      siglas: "BSD",
      horas: 8,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAM | DAW',
      curso: 1,
      conocimentos: ['SQL', 'Sistemas relacionales', 'E/R', 'Flujo de bases de datos'],
      imagen: "https://www.ymant.com/wp-content/uploads/Base-de-Datos-YMANT.jpg"
    },
    {
      asignatura: 'Desarrollo cliente',
      siglas: "DC",
      horas: 6,
      profesor: 'Borja martin',
      ciclo: 'DAW',
      curso: 2,
      conocimentos: ['JavaScript', 'React', 'Node'],
      imagen: ""
    },
    {
      asignatura: 'Desarrollo servidor',
      siglas: "DS",
      horas: 6,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAW',
      curso: 2,
      conocimentos: ['SQL', 'Sistemas relacionales', 'E/R', 'Flujo de bases de datos'],
      imagen: ""
    }
  ];

  constructor() { }

  filtrarAsignaturas(curso: string) {
     return this.asignaturas.filter((item) => item.ciclo.toLowerCase().includes(curso.toLowerCase()) );
  }

  filtrarAsignaturasPorAnio(curso: string, anio: string):asignatura[] {
    /*if (this.asignaturas.filter((item) => item.ciclo.toLowerCase().includes(curso.toLowerCase()) && Number(anio) == item.curso).length == 0) {
      return this.filtrarAsignaturas(curso);
    }*/
    return this.asignaturas.filter((item) => item.ciclo.toLowerCase().includes(curso.toLowerCase()) && Number(anio) == item.curso);
  }
}
