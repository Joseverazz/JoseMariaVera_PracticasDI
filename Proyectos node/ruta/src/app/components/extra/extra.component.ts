import { Component, OnInit } from '@angular/core';
import { CochesService } from 'src/app/services/coches.service';
import { coche } from 'src/app/utils/coche';

@Component({
  selector: 'rutas-extra',
  templateUrl: './extra.component.html',
  styleUrls: ['./extra.component.css']
})
export class ExtraComponent implements OnInit {

  constructor(private cocheService: CochesService) { }

  coches:coche[] = this.cocheService.coches;


  ngOnInit(): void {

  }

}
