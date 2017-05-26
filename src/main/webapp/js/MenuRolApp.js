'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('adminMenuRol', [
  'ngRoute',
  'adminMenuRol.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/MenuRol.html', controller: 'MenuRolCtrl'});
  $routeProvider.otherwise({redirectTo: '/'}); 
}]);
