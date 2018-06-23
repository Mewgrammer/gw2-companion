import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {HomeViewComponent} from './views/homeview/home-view.component';
import {UserPanelComponent} from './components/user-panel/user-panel.component';
import {CharactersComponent} from './components/user-panel/characters/characters.component';
import {WalletComponent} from './components/user-panel/wallet/wallet.component';
import {BankComponent} from './components/user-panel/bank/bank.component';
import {InfoComponent} from './components/info/info.component';
import {AchievementsComponent} from './components/user-panel/achievements/achievements.component';


const appRoutes = [
  { path: '', component:  HomeViewComponent},
  { path: 'userpanel', component:  UserPanelComponent},
  { path: 'characters', component:  CharactersComponent},
  { path: 'currencies', component:  WalletComponent},
  { path: 'bank', component:  BankComponent},
  { path: 'achievements', component:  AchievementsComponent},
  { path: 'about', component:  InfoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {useHash: true})],
  exports: [RouterModule],
})
export class AppRoutingModule {}
