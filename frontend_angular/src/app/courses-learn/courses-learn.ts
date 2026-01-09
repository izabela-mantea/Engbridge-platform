import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-courses-learn',
  standalone: true,
  imports: [CommonModule, RouterLink],
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
    this.route.paramMap.subscribe(params => {
      this.levelId = params.get('levelId');
      console.log('2. Level ID from URL:', this.levelId);
      if (this.levelId) {
        console.log('3. Fetching courses for ID:', this.levelId);
        this.fetchCourses(this.levelId);
      }
      else
      {
        console.warn('3. No Level ID found!');
      }
    });
  }

  fetchCourses(id: string) {
    this.http.get<any[]>(`http://localhost:8081/levels/${id}/courses`)
      .subscribe({
        next: (data) =>
        {
          console.log('data fetched from server:', data);
          this.courses = data;
        },
        error: (err) => console.error('Loading error:', err)
      });
  }
}


