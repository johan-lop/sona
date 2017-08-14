'use strict';


// Declare app level module which depends on filters, and services
var module = angular.module('adminUsuario', [
    'ngRoute',
    'adminUsuario.controllers'
]);
module.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/index.html'});
        $routeProvider.when('/Usuario', {templateUrl: 'partials/Usuario.html', controller: 'UsuarioCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);
