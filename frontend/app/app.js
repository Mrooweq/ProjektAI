'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute', 'angular.filter', 'ngMaterial', 'ngMessages',
  'myApp.bookList',
  'myApp.bookDetails',
  'myApp.booksSearch',
  'myApp.userCart',
  'myApp.userOrderCheckout',
  
  'ngResource',
  'ngCookies',
  'myApp.userLogIn',
  'myApp.userRegistration',
  'myApp.viewMainMenu',
    'myApp.adminBookAdd',
    'myApp.viewTemplate'
  
])
.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
  $routeProvider.otherwise({redirectTo: '/userLogIn'});


}])


;
