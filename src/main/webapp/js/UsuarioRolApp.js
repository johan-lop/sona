'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('adminUsuarioRol', [
  'ngRoute',
  'adminUsuarioRol.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/UsuarioRol.html', controller: 'UsuarioRolCtrl'});
  $routeProvider.otherwise({redirectTo: '/'}); 
}]);
