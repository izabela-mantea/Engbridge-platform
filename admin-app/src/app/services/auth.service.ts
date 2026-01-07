import { Injectable, PLATFORM_ID, inject } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, tap, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { jwtDecode } from 'jwt-decode';

export interface LoginResponse {
  token: string;
  error?: string;
}

export interface JWTPayload {
  sub: string;
  role: string;
  exp: number;
  iss: string;
  jti: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = `${environment.apiUrl}/auth`;
  private platformId = inject(PLATFORM_ID);

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, { username, password })
      .pipe(
        tap(response => {
          if (response.error) {
            throw new Error(response.error);
          }

          if (isPlatformBrowser(this.platformId)) {
            try {
              const decoded = jwtDecode<JWTPayload>(response.token);

              if (decoded.role !== 'ADMIN') {
                throw new Error('Access denied. Only administrators can use this application.');
              }

              localStorage.setItem('jwtToken', response.token);
              localStorage.setItem('currentUser', JSON.stringify({
                uid: decoded.sub,
                role: decoded.role
              }));
            } catch (error) {
              localStorage.removeItem('jwtToken');
              localStorage.removeItem('currentUser');
              throw error;
            }
          }
        }),
        catchError((error: HttpErrorResponse) => {
          let errorMessage = 'Login failed. Please check your credentials.';

          if (error.status === 401) {
            errorMessage = 'Invalid username or password.';
          } else if (error.status === 500) {
            errorMessage = 'Server error. Please try again later.';
          } else if (error.status === 0) {
            errorMessage = 'Cannot connect to server. Please check your connection.';
          } else if (error.error?.message) {
            errorMessage = error.error.message;
          }

          return throwError(() => new Error(errorMessage));
        })
      );
  }

  logout(): void {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('jwtToken');
    }
  }

  isLoggedIn(): boolean {
    if (isPlatformBrowser(this.platformId)) {
      return !!localStorage.getItem('jwtToken');
    }
    return false;
  }

  getToken(): string | null {
    if (isPlatformBrowser(this.platformId)) {
      return localStorage.getItem('jwtToken');
    }
    return null;
  }

  getCurrentUser(): any {
    if (isPlatformBrowser(this.platformId)) {
      const user = localStorage.getItem('currentUser');
      return (user && user !== 'undefined') ? JSON.parse(user) : null;
    }
    return null;
  }

  isAdmin(): boolean {
    const user = this.getCurrentUser();
    return user && user.role === 'ADMIN';
  }

  getUserRole(): string | null {
    const user = this.getCurrentUser();
    return user ? user.role : null;
  }
}
