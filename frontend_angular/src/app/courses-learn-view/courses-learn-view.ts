import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

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

  constructor(
      private route: ActivatedRoute,
      private http: HttpClient,
      private sanitizer: DomSanitizer // Required for innerHTML gaps
    ) {}

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
      console.log("Loaded exercises from cache from section:", section.title);
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

  renderTextWithGaps(text: string): SafeHtml {
      if (!text) return '';
      const replaced = text.replace(/\[gap(\d+)\]/g, (match, number) => {
        return `<input type="text" class="gap-input" data-gap="${number}" placeholder="...">`;
      });
      return this.sanitizer.bypassSecurityTrustHtml(replaced);
    }

  checkAnswers(exercise: any) {
    console.log("Checking solutions for:", exercise.parsedContent.solution);
    // tb implementat
    alert("Feature in progress: Verifying answers...");
  }

  checkTrueFalse(ex: any) {
      let correctCount = 0;
      const questions = ex.parsedContent.questions;

      questions.forEach((q: any) => {
        if (q.userAnswer === q.answer) {
          correctCount++;
        }
      });
    }

  checkOption(ex: any) {
    if (!ex.userAnswer) {
      alert("Please select an answer first!");
      return;
    }

    ex.submitted = true;

    if (ex.userAnswer === ex.parsedContent.answer) {
      console.log("Correct!");
    } else {
      console.log("Incorrect. Correct answer is:", ex.parsedContent.answer);
    }
  }

  submitEntireSection(){
      this.exercises.forEach(ex => {if (ex.type !== 'Text')
            {
              ex.submitted = true;
            }
            });
      let score = 0;
      let totalInteractives = 0;
      this.exercises.forEach(ex => {
            if (ex.type === 'Option') {
              totalInteractives++;
              if (ex.userAnswer === ex.parsedContent.answer) score++;
            }
            else if (ex.type === 'True_False') {
              ex.parsedContent.questions.forEach((q: any) => {
                totalInteractives++;
                if (q.userAnswer === q.answer) score++;
              });
            }
          });

         const percentage = Math.round((score / totalInteractives) * 100);
                alert(`Section Complete! Your score: ${score}/${totalInteractives} (${percentage}%)`);

       //to be saved in user progress
    }



}


