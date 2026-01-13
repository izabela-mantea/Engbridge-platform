import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;
  username = '';
  email = '';
  placementScore: number | null = null;
  currentLevel: number = 1;

  coursesOpen = false;
  profileOpen = false;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.isLoggedIn$.subscribe(status => {
      this.isLoggedIn = status;
    });

    this.authService.username$.subscribe(name => {
      this.username = name;
    });

    this.authService.email$.subscribe(mail => {
      this.email = mail;
    });

    this.authService.placementScore$.subscribe(score => {
      this.placementScore = score;
    });

    this.authService.currentLevel$.subscribe(level => {
      this.currentLevel = level;
    });
  }

  toggleCourses(event: Event) {
    event.preventDefault();
    event.stopPropagation();
    this.coursesOpen = !this.coursesOpen;
    this.profileOpen = false;
  }

  toggleProfile(event: Event) {
    event.preventDefault();
    event.stopPropagation();
    this.profileOpen = !this.profileOpen;
    this.coursesOpen = false;
  }

  logout() {
    this.authService.logout();
  }
}