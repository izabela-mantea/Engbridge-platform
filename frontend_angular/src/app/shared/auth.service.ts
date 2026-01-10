import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(this.hasToken());
  private username = new BehaviorSubject<string>(this.getStoredUsername());
  private email = new BehaviorSubject<string>(localStorage.getItem('email') || '');

  isLoggedIn$ = this.loggedIn.asObservable();
  username$ = this.username.asObservable();
  email$ = this.email.asObservable();

  constructor(private router: Router, private http: HttpClient) {
    if (this.hasToken()) {
      this.fetchProfile();
    }
  }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  private getStoredUsername(): string {
    return localStorage.getItem('username') || 'User';
  }

  login(token: string, username: string) {
    localStorage.setItem('token', token);
    localStorage.setItem('username', username);
    this.loggedIn.next(true);
    this.username.next(username);
    this.fetchProfile();
  }

  fetchProfile() {
    const token = localStorage.getItem('token');
    if (!token) return;

    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    this.http.get<any>('http://localhost:8086/api/users/me', { headers }).subscribe({
      next: (data) => {
        if (data.email) {
          localStorage.setItem('email', data.email);
          this.email.next(data.email);
        }
        // Update username if backend returns it (it might differ/be corrected)
        if (data.username) {
            localStorage.setItem('username', data.username);
            this.username.next(data.username);
        }
      },
      error: (err) => console.error("Failed to fetch profile", err)
    });
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    localStorage.removeItem('email');
    this.loggedIn.next(false);
    this.username.next('');
    this.email.next('');
    this.router.navigate(['/']);
  }

  isLoggedIn(): boolean {
    return this.loggedIn.value;
  }
}
