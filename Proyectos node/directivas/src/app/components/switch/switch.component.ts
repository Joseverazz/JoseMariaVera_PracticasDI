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
}
