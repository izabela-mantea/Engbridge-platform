import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false);
  private username = new BehaviorSubject<string>('');
  private email = new BehaviorSubject<string>('');

  isLoggedIn$ = this.loggedIn.asObservable();
  username$ = this.username.asObservable();
  email$ = this.email.asObservable();

  constructor(
    private router: Router,
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    if (this.isBrowser()) {
      const hasToken = this.hasToken();
      this.loggedIn.next(hasToken);
      this.username.next(this.getStoredUsername());
      this.email.next(localStorage.getItem('email') || '');

      if (hasToken) {
        this.fetchProfile();
      }
    }
  }

  private isBrowser(): boolean {
    return isPlatformBrowser(this.platformId);
  }

  private hasToken(): boolean {
    if (!this.isBrowser()) return false;
    return !!localStorage.getItem('token');
  }

  private getStoredUsername(): string {
    if (!this.isBrowser()) return '';
    return localStorage.getItem('username') || 'User';
  }

  login(token: string, username: string) {
    if (this.isBrowser()) {
      localStorage.setItem('token', token);
      localStorage.setItem('username', username);
    }
    this.loggedIn.next(true);
    this.username.next(username);
    this.fetchProfile();
  }

  fetchProfile() {
    if (!this.isBrowser()) return;
    const token = localStorage.getItem('token');
    if (!token) return;

    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    this.http.get<any>('http://localhost:8086/api/users/me', { headers }).subscribe({
      next: (data) => {
        if (this.isBrowser()) {
          if (data.email) {
            localStorage.setItem('email', data.email);
            this.email.next(data.email);
          }
          if (data.username) {
              localStorage.setItem('username', data.username);
              this.username.next(data.username);
          }
        }
      },
      error: (err) => console.error("Failed to fetch profile", err)
    });
  }

  logout() {
    if (this.isBrowser()) {
      localStorage.removeItem('token');
      localStorage.removeItem('username');
      localStorage.removeItem('email');
    }
    this.loggedIn.next(false);
    this.username.next('');
    this.email.next('');
    this.router.navigate(['/']);
  }

  isLoggedIn(): boolean {
    return this.loggedIn.value;
  }
}
