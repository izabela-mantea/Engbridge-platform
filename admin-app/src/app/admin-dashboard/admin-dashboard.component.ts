import { Component, OnInit, ChangeDetectorRef, NgZone } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AdminService, User } from '../services/admin.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  users: User[] = [];
  currentUser: any = null;
  errorMessage = '';
  successMessage = '';
  loading = false;
  showDeleteConfirm = false;
  userToDelete: User | null = null;

  constructor(
    private adminService: AdminService,
    private authService: AuthService,
    private router: Router,
    private cdr: ChangeDetectorRef,
    private ngZone: NgZone
  ) { }

  ngOnInit(): void {
    this.currentUser = this.authService.getCurrentUser();
    console.log('Dashboard loaded, fetching users...');
    this.loadUsers();
  }

  loadUsers() {
    this.errorMessage = '';
    this.loading = true;
    console.log('Starting to load users...');

    this.adminService.getAllUsers().subscribe({
      next: (data) => {
        this.ngZone.run(() => {
          console.log('Users loaded:', data);
          console.log('Array length:', data.length);
          console.log('Type of data:', typeof data);
          console.log('Is array?', Array.isArray(data));

          // Filter out admin users - don't show them in the list
          this.users = data.filter(user => user.role !== 'ADMIN');
          this.loading = false;

          console.log('this.users after assignment:', this.users);
          console.log('this.users.length:', this.users.length);

          this.cdr.detectChanges();
        });
      },
      error: (err) => {
        this.ngZone.run(() => {
          console.error('Error loading users:', err);
          this.errorMessage = 'Failed to load users: ' + (err.message || 'Unknown error');
          this.loading = false;
          this.cdr.detectChanges();
        });
      }
    });
  }

  getAdminCount(): number {
    return this.users.filter(u => u.role === 'ADMIN').length;
  }

  getStudentCount(): number {
    return this.users.filter(u => u.role === 'STUDENT').length;
  }

  getRoleClass(role: string): string {
    return role.toLowerCase();
  }

  openCreateUser() {
    // TODO: Implement create user functionality
    console.log('Create user clicked');
    this.errorMessage = 'Create user functionality not yet implemented';
  }

  viewUser(user: User) {
    // TODO: Implement view user details
    console.log('View user:', user);
    this.successMessage = `Viewing user: ${user.username}`;
    setTimeout(() => this.successMessage = '', 3000);
  }

  editUser(user: User) {
    // TODO: Implement edit user functionality
    console.log('Edit user:', user);
    this.errorMessage = 'Edit user functionality not yet implemented';
  }

  confirmDelete(user: User) {
    this.userToDelete = user;
    this.showDeleteConfirm = true;
  }

  cancelDelete() {
    this.userToDelete = null;
    this.showDeleteConfirm = false;
  }

  deleteUser(id: number) {
    console.log('Deleting user:', id);
    this.adminService.deleteUser(id).subscribe({
      next: () => {
        console.log('User deleted successfully');
        this.successMessage = 'User deleted successfully';
        this.showDeleteConfirm = false;
        this.userToDelete = null;
        this.loadUsers();
        setTimeout(() => this.successMessage = '', 3000);
      },
      error: (err) => {
        console.error('Error deleting user:', err);
        this.errorMessage = 'Failed to delete user: ' + (err.message || 'Unknown error');
        this.showDeleteConfirm = false;
        this.userToDelete = null;
      }
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
