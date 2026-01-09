import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { SafePipe } from '../shared/safe.pipe';

@Component({
  selector: 'app-courses-learn-view',
  standalone: true,
  imports: [CommonModule, SafePipe, RouterModule],
  templateUrl: './courses-learn-view.html',
  styleUrls: ['./courses-learn-view.css']
})
export class LessonViewComponent implements OnInit {
  levelId: string | null = null;
  courseId: string | null = null;
  sections: any[] = [];
  exercises: any[] = [];
  activeSection: any = null;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const newLevelId = params.get('levelId');
      const newCourseId = params.get('courseId');
      const newSectionId = params.get('sectionId');

      this.levelId = newLevelId;

      if (newCourseId !== this.courseId) {
        this.courseId = newCourseId;
        this.loadSections(newSectionId);
      } else if (newSectionId) {
        this.updateActiveSection(newSectionId);
        this.loadExercisesForSection(newSectionId);
      }
    });
  }

  loadSections(currentSectionId: string | null) {
    this.http.get<any[]>(`http://localhost:8081/courses/${this.courseId}/sections`)
      .subscribe(data => {
        this.sections = data;
        if (currentSectionId) {
          this.updateActiveSection(currentSectionId);
          this.loadExercisesForSection(currentSectionId);
        }
      });
  }

  updateActiveSection(sectionId: string) {

    const section = this.sections.find(s => s.id.toString() === sectionId.toString());
    if (section) {
      this.activeSection = section;
    }
  }

  loadExercisesForSection(id: string) {
    this.http.get<any[]>(`http://localhost:8081/exercises/section/${id}`)
      .subscribe({
        next: (data) => {
          this.exercises = data.map(ex => ({
            ...ex,
            parsedContent: typeof ex.content === 'string' ? JSON.parse(ex.content) : ex.content
          }));
        },
        error: (err) => console.error("Error loading exercises!:", err)
      });
  }

  renderTextWithGaps(text: string): SafeHtml {
    if (!text) return '';
    const replaced = text.replace(/\[gap(\d+)\]/g, (match, number) => {
      return `<input type="text" class="gap-input" data-gap="${number}" placeholder="...">`;
    });
    return this.sanitizer.bypassSecurityTrustHtml(replaced);
  }

  checkOption(ex: any) {
    if (!ex.userAnswer) {
      alert("Please select an answer first!");
      return;
    }
    ex.submitted = true;
  }

  submitEntireSection() {
    this.exercises.forEach(ex => {
      if (ex.type !== 'Text') {
        ex.submitted = true;
      }
    });

    let score = 0;
    let totalInteractives = 0;

    this.exercises.forEach(ex => {
      if (ex.type === 'Option') {
        totalInteractives++;
        if (ex.userAnswer === ex.parsedContent.answer) score++;
      } else if (ex.type === 'True_False') {
        ex.parsedContent.questions.forEach((q: any) => {
          totalInteractives++;
          if (q.userAnswer === q.answer) score++;
        });
      }
    });

    const percentage = totalInteractives > 0 ? Math.round((score / totalInteractives) * 100) : 0;
    alert(`Section Complete! Your score: ${score}/${totalInteractives} (${percentage}%)`);
//
//     TO BE SAVED IN USER PROGRESS!!!!!!!!!!!!!!!!!!!!

  }
}





