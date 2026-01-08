import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-courses-learn-view',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './courses-learn-view.html',
  styleUrls: ['./courses-learn-view.css']
})
export class LessonViewComponent implements OnInit {
  levelId: string | null = null;
  courseId: string | null = null;
  sections: any[] = [];
  exercises: any[] = [];
  activeSection: any = null;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit() {
    this.levelId = this.route.snapshot.paramMap.get('levelId');
    this.courseId = this.route.snapshot.paramMap.get('courseId');

    if (this.courseId) {
      this.loadSections();
    }
  }

  loadSections() {
    this.http.get<any[]>(`http://localhost:8081/courses/${this.courseId}/sections`)
      .subscribe(data => {
        this.sections = data;
        if (this.sections.length > 0) {
          this.selectSection(this.sections[0]);
        }
      });
  }

  selectSection(section: any) {
    this.activeSection = section;

    if (section.loadedExercises) {
      this.exercises = section.loadedExercises;
      console.log("Loaded exercies from cache from section:", section.title);
      return;
    }

    // if not found, we fetch them
    this.exercises = [];
    this.http.get<any[]>(`http://localhost:8081/exercises/section/${section.id}`)
      .subscribe({
        next: (data) => {
          section.loadedExercises = data.map(ex => ({
            ...ex,
            parsedContent: typeof ex.content === 'string' ? JSON.parse(ex.content) : ex.content
          }));

          this.exercises = section.loadedExercises;
        },
        error: (err) => {
          console.error("Error loading exercises:", err);
        }
      });
  }

  renderTextWithGaps(text: string): string {
    if (!text) return '';
      //replaces the [gap] in the drop and down exercises
    return text.replace(/\[gap(\d+)\]/g, (match, number) => {
      return `<span class="gap-placeholder" data-gap="${number}">_______</span>`;
    });
  }

  checkAnswers(exercise: any) {
    console.log("Checking solutions for:", exercise.parsedContent.solution);
    // tb implementat
    alert("Feature in progress: Verifying answers...");
  }


}


