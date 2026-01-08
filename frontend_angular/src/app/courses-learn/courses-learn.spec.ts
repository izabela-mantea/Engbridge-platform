import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursesLearn } from './courses-learn';

describe('CoursesLearn', () => {
  let component: CoursesLearn;
  let fixture: ComponentFixture<CoursesLearn>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoursesLearn]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoursesLearn);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
