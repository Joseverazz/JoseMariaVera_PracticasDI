import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'directiva-switch',
  templateUrl: './switch.component.html',
  styleUrls: ['./switch.component.css']
})
export class SwitchComponent implements OnInit {

  opcionMostrar: number = 2;

  constructor() { }

  ngOnInit(): void {
  }
  cambiarOpcion(opcion: string) {
    this.opcionMostrar = Number(opcion);
  }

  cambiarOpcionEvento(evento: any) {
    //console.log(evento.target.value);
    this.opcionMostrar = Number(evento.target.value)
  }
} 
