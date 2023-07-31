import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ErrorInterceptor} from "./_interceptors/error-interceptor.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {JwtInterceptor} from "./_interceptors/jwt-interceptor.service";
import {ProductEditComponent} from "./pages/product-edit/product-edit.component";
import {UserDetailComponent} from "./pages/user-edit/user-detail.component";
import {ProductListComponent} from "./pages/product-list/product.list.component";
import {OrderDetailComponent} from "./pages/order-detail/order-detail.component";
import {OrderComponent} from "./pages/order/order.component";
import {CartComponent} from "./pages/cart/cart.component";
import {DetailComponent} from "./pages/product-detail/detail.component";
import {SignupComponent} from "./pages/signup/signup.component";
import {LoginComponent} from "./pages/login/login.component";
import {PaginationComponent} from "./parts/pagination/pagination.component";
import {CardComponent} from "./pages/card/card.component";
import {NavigationComponent} from "./parts/navigation/navigation.component";
import {CookieService} from "ngx-cookie-service";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    CardComponent,
    PaginationComponent,
    LoginComponent,
    SignupComponent,
    DetailComponent,
    CartComponent,
    OrderComponent,
    OrderDetailComponent,
    ProductListComponent,
    UserDetailComponent,
    ProductEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CookieService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
