'use strict';


// Declare app level module which depends on filters, and services
var module = angular.module('adminAplicacion', [
    'ngRoute',
    'ngAnimate'
]);
module.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/index.html'});
        $routeProvider.when('/Usuario', {templateUrl: 'partials/Usuario.html', controller: 'UsuarioCtrl'});
        $routeProvider.when('/Rol', {templateUrl: 'partials/Rol.html', controller: 'RolCtrl'});
        $routeProvider.when('/Herramientas', {templateUrl: 'partials/Herramienta.html', controller: 'HerramientaCtrl'});
        $routeProvider.when('/Materiales', {templateUrl: 'partials/Material.html', controller: 'MaterialCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);
