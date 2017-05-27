'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('adminRol', [
  'ngRoute',
  'adminRol.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/Rol.html', controller: 'RolCtrl'});
  $routeProvider.otherwise({redirectTo: '/'}); 
}]);
