import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Personne} from '../personne';
import {PersonneService} from '../personne.service';


@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css']
})
export class PersonneComponent implements OnInit {

  @Input()
  personne: Personne;

  @Output()
  deletePersonne= new EventEmitter<Personne>();

  constructor(private personneService: PersonneService) { }

  ngOnInit() {
  }

  onDelete(){
    this.personneService.deletePersonne(this.personne.id).subscribe(
      data => this.deletePersonne.emit(this.personne),
      error => console.log(error)
    )
  }

}
