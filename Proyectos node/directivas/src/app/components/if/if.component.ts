import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'directiva-if',
  templateUrl: './if.component.html',
  styleUrls: ['./if.component.css']
})
export class IfComponent implements OnInit {

  mostrar: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

}
