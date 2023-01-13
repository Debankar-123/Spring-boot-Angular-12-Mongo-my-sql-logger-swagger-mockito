import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'patient',
})
export class PatientPipe implements PipeTransform {
  transform(patientList: any, searchtext: any): any {
    if (!patientList || !searchtext) {
      return patientList;
      return patientList.filter((atient: any) =>
        atient.patientName.toLocaleLowerCase.includes(
          searchtext.toLocaleLowerCase()
        )
      );
    }
  }
}
