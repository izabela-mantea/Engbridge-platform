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
  finalScore: number = 0;
  totalInteractives: number = 0;
  isSubmitted: boolean = false;

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
            parsedContent: typeof ex.content === 'string' ? JSON.parse(ex.content) : ex.content,
            userAnswers: {}
          }));
        },
        error: (err) => console.error("Error loading exercises:", err)
      });
  }


  getObjectKeys(obj: any): string[] {
    return obj ? Object.keys(obj) : [];
  }

  renderTextWithGaps(text: string): SafeHtml {
    if (!text) return '';
    const replaced = text.replace(/\[gap(\d+)\]/g, (match, number) => {
      return `<input type="text" class="gap-input" data-gap="${number}" placeholder="...">`;
    });
    return this.sanitizer.bypassSecurityTrustHtml(replaced);
  }

  selectGapAnswer(ex: any, gapKey: string, option: string) {
    if (!ex.userAnswers) ex.userAnswers = {};
    ex.userAnswers[gapKey] = option;
  }

  checkOption(ex: any) {
    if (!ex.userAnswer) {
      alert("Please select an answer first!");
      return;
    }
    ex.submitted = true;
  }

submitEntireSection() {
    let totalCorrect = 0;
    this.totalInteractives = 0;

    this.exercises.forEach(ex => {
      if (ex.type === 'Text' || ex.type === 'Video') return;

      ex.submitted = true;

      if (ex.type === 'Option') {
        this.totalInteractives++;
        if (ex.userAnswer === ex.parsedContent.answer) totalCorrect++;
      }
      else if (ex.type === 'True_False') {
        this.totalInteractives++;
        if (ex.userAnswer === ex.parsedContent.answer) totalCorrect++;
      }
      else if (ex.type === 'FillGaps') {
        const keys = Object.keys(ex.parsedContent.answer_key);
        keys.forEach(key => {
          this.totalInteractives++;
          if (ex.userAnswers && ex.userAnswers[key] === ex.parsedContent.answer_key[key]) {
            totalCorrect++;
          }
        });
      }
    });

    if (this.totalInteractives > 0) {
      this.finalScore = parseFloat(((totalCorrect / this.totalInteractives) * 5).toFixed(2));
    } else {
      this.finalScore = 0;
    }

    this.isSubmitted = true;

    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}

