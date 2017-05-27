'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('adminMenu', [
  'ngRoute',
  'adminMenu.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/Menu.html', controller: 'MenuCtrl'});
  $routeProvider.otherwise({redirectTo: '/'}); 
}]);
