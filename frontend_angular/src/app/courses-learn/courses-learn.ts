// import { Component } from '@angular/core';
//
// @Component({
//   selector: 'app-courses-learn',
//   imports: [],
//   templateUrl: './courses-learn.html',
//   styleUrl: './courses-learn.css',
// })
// export class CoursesLearnComponent {
//
// }

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-courses-learn',
  standalone: true,
  imports: [CommonModule], // Important pentru *ngFor
  templateUrl: './courses-learn.html',
  styleUrl: './courses-learn.css'
})
export class CoursesLearnComponent implements OnInit {
  levelId: string | null = null;
  courses: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit() {
    // 1. Ascultăm URL-ul pentru a afla nivelul (B1, B2...)
    this.route.paramMap.subscribe(params => {
      this.levelId = params.get('levelId');

      if (this.levelId) {
        this.fetchCourses(this.levelId);
      }
    });
  }

  fetchCourses(id: string) {
    // 2. Apelăm endpoint-ul din LevelsController.java
    this.http.get<any[]>(`http://localhost:8081/levels/${id}/courses`)
      .subscribe({
        next: (data) => {
                                console.log('Date primite de la server:', data); // LOG 2
                                this.courses = data;
                              },
        error: (err) => console.error('Eroare la încărcare cursuri:', err)
      });
  }
}
