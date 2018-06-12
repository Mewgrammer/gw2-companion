import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {HomeViewComponent} from './views/homeview/home-view.component';
import {UserPanelComponent} from './components/user-panel/user-panel.component';
import {MapComponent} from './components/map/map.component';
import {EventsComponent} from './components/events/events.component';


const appRoutes = [
  { path: '', component:  HomeViewComponent},
  { path: 'userpanel', component:  UserPanelComponent},
  { path: 'map', component:  MapComponent},
  { path: 'events', component:  EventsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {useHash: true})],
  exports: [RouterModule],
})
export class AppRoutingModule {}
