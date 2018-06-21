import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { MapComponent } from './components/map/map.component';
import { EventsComponent } from './components/events/events.component';
import { HeaderComponent } from './components/header/header.component';
import { NavComponent } from './components/nav/nav.component';
import { FooterComponent } from './components/footer/footer.component';
import {
  MatAutocompleteModule,
  MatButtonModule, MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatDialogModule,
  MatFormFieldModule, MatIconModule,
  MatInputModule,
  MatListModule, MatMenuModule, MatSelectModule, MatSidenavModule, MatSliderModule, MatSnackBarModule,
  MatSortModule,
  MatTableModule, MatTabsModule, MatToolbarModule
} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import { HomeViewComponent } from './views/homeview/home-view.component';
import { RegisterDialogComponent } from './components/register/register-dialog/register-dialog.component';
import { RegisterFormComponent } from './components/register/register-form/register-form.component';
import { LoginFormComponent } from './components/login/login-form/login-form.component';
import { LoginDialogComponent } from './components/login/login-dialog/login-dialog.component';
import { UserPanelComponent } from './components/user-panel/user-panel.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HomeComponent,
    MapComponent,
    EventsComponent,
    HeaderComponent,
    NavComponent,
    FooterComponent,
    HomeViewComponent,
    RegisterDialogComponent,
    RegisterFormComponent,
    LoginFormComponent,
    LoginDialogComponent,
    UserPanelComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    MatSnackBarModule,
    MatCheckboxModule,
    MatSliderModule,
    MatDialogModule,
    MatCardModule,
    MatListModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    MatSortModule,
    MatAutocompleteModule,
    MatSelectModule,
    MatSidenavModule,
    MatTabsModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonToggleModule,
    HttpClientModule,
  ],
  entryComponents: [
    RegisterDialogComponent,
    LoginDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
