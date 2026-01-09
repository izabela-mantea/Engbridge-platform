import { Routes } from '@angular/router';
import { HomeComponent } from './home/home';
import { B1Component } from './courses/b1/b1';
import { B2Component } from './courses/b2/b2';
import { C1Component } from './courses/c1/c1';
import { CoursesLearnComponent } from './courses-learn/courses-learn';
import { LessonViewComponent } from './courses-learn-view/courses-learn-view';
import { RegisterComponent } from './register/register';
import { CourseRedirectComponent } from './course-redirect/course-redirect';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'course-b1', component: B1Component },
  { path: 'course-b2', component: B2Component },
  { path: 'course-c1', component: C1Component },
  { path: 'courses-learn/:levelId', component: CoursesLearnComponent },
  { path: ':levelId/:courseId', component: CourseRedirectComponent },
  { path: ':levelId/:courseId/:sectionId', component: LessonViewComponent },
//   { path: 'courses-learn-view/:levelId/:courseId/:sectionId', component: LessonViewComponent }
  ];
