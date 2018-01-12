'use strict';


// Declare app level module which depends on filters, and services
var module = angular.module('adminAplicacion', [
    'ngRoute',
    'ngAnimate',
    'naif.base64',
    'vtex.ngCurrencyMask'
]);
module.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/index.html'});
        $routeProvider.when('/Usuario', {templateUrl: 'partials/Usuario.html', controller: 'UsuarioCtrl'});
        $routeProvider.when('/Rol', {templateUrl: 'partials/Rol.html', controller: 'RolCtrl'});
        $routeProvider.when('/Herramientas', {templateUrl: 'partials/Herramienta.html', controller: 'HerramientaCtrl'});
        $routeProvider.when('/Materiales', {templateUrl: 'partials/Material.html', controller: 'MaterialCtrl'});
        $routeProvider.when('/Ciudades', {templateUrl: 'partials/Ciudad.html', controller: 'CiudadCtrl'});
        $routeProvider.when('/Viaticos', {templateUrl: 'partials/Viatico.html', controller: 'ViaticoCtrl'});
        $routeProvider.when('/Apus', {templateUrl: 'partials/ApuItem.html', controller: 'ApuCtrl'});
        $routeProvider.when('/Mapas', {templateUrl: 'partials/Maps.html', controller: 'ViaticoCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

module.service('servicioComun', function () {
    var listaMateriales = [];

    var agregarMaterial = function (newObj) {
        newObj.cantidad = 1;
        listaMateriales.push(newObj);
    };

    var obtenerMateriales = function () {
        return listaMateriales;
    };

    var limpiar = function () {
        var listaMateriales = [];
    };

    return {
        agregarMaterial: agregarMaterial,
        obtenerMateriales: obtenerMateriales,
        limpiar: limpiar
    };

});