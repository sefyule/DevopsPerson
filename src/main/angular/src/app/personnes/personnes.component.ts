import { Component, OnInit } from '@angular/core';
import {Personne} from './personne';
import {PersonneService} from './personne.service';

@Component({
  selector: 'app-personnes',
  templateUrl: './personnes.component.html',
  styleUrls: ['./personnes.component.css']
})
export class PersonnesComponent implements OnInit {

  private personnes : Array<Personne>;

  constructor(private personneService : PersonneService) { }

  ngOnInit() {
      this.personneService.getAllPersonnes().subscribe(
      data => this.personnes = data


      );
   }

}
