import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { MainService } from './main.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'catalyst.ai';
  text!: string;

  constructor(private mainService: MainService) {

  }

  ngOnInit(): void {
      this.mainService.getText().subscribe((data) => {
        console.log(data);
        this.text = data.name;
      })
  }




}
