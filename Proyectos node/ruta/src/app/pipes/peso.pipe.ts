import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'peso'
})
export class PesoPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): unknown {
    return Math.round((value/2.2046)*100)/100;
  }

}
