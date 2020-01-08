import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup } from '@angular/forms';
import {Personne} from '../personne';
import {PersonneService} from '../personne.service';

@Component({
  selector: 'app-personne-form',
  templateUrl: './personne-form.component.html',
  styleUrls: ['./personne-form.component.css']
})
export class PersonneFormComponent implements OnInit {
    profileForm = new FormGroup({
      nom: new FormControl(''),
      prenom: new FormControl(''),
    });

  constructor(private personneService: PersonneService)  { }

  @Output()
  createPersonne = new EventEmitter<Personne>();

  ngOnInit() {

  }

  onSubmit(){
      let personneForm: Personne =  this.profileForm.value;
      this.personneService.createPersonne(personneForm).subscribe(
        data => this.createPersonne.emit(personneForm),
        error => console.log(error)
      );
    }

}
