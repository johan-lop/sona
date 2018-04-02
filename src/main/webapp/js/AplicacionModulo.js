'use strict';


// Declare app level module which depends on filters, and services
var module = angular.module('adminAplicacion', [
    'ngRoute',
    'ngAnimate',
    'naif.base64',
    'vtex.ngCurrencyMask',
    'angularValidator',
    'datatables',
    'ui.bootstrap',
    'ngTable',
    'frapontillo.bootstrap-switch'        
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
        $routeProvider.when('/GastosAdministrativos', {templateUrl: 'partials/GastosAdministrativos.html', controller: 'GastosAdministrativosCtrl'});
        $routeProvider.when('/SalariosRecargos', {templateUrl: 'partials/SalariosRecargos.html', controller: 'SalariosRecargosCtrl'});
        $routeProvider.when('/Clientes', {templateUrl: 'partials/Cliente.html', controller: 'ClienteCtrl'});
        $routeProvider.when('/CambiarPassword', {templateUrl: 'partials/CambiarPassword.html', controller: 'CambiarPasswordCtrl'});
        $routeProvider.when('/Cotizaciones', {templateUrl: 'partials/Cotizacion.html', controller: 'CotizacionCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

module.service('servicioComun', function ($rootScope) {
    var listaMateriales = [];
    var listaHerramientas = [];
    var listaManoObra = [];

    var agregarMaterial = function (newObj, cantidad) {
        var existe = false;
        angular.forEach(listaMateriales, function (val) {
            if (val.id === newObj.id) {
                val.cantidad += 1;
                existe = true;
            }
        });
        if (existe) {
            $rootScope.$emit('actualizarMateriales');
        } else {
            if (cantidad) {
                newObj.cantidad = cantidad;
            } else {
                newObj.cantidad = 1;
            }
            listaMateriales.push(newObj);
        }

    };

    var quitarMaterial = function (obj) {
        var index = listaMateriales.indexOf(obj);
        if (index > -1) {
            listaMateriales.splice(index, 1);
        }
    };

    var obtenerMateriales = function () {
        return listaMateriales;
    };

    var agregarHerramientas = function (newObj, cantidad) {
        var existe = false;
        angular.forEach(listaHerramientas, function (val) {
            if (val.id === newObj.id) {
                val.cantidad += 1;
                existe = true;
            }
        });
        if (existe) {
            $rootScope.$emit('actualizarHerramientas');
        } else {
            if (cantidad) {
                newObj.cantidad = cantidad;
            } else {
                newObj.cantidad = 1;
            }
            listaHerramientas.push(newObj);
        }

    };

    var quitarHerramienta = function (obj) {
        var index = listaHerramientas.indexOf(obj);
        if (index > -1) {
            listaHerramientas.splice(index, 1);
        }
    };

    var obtenerHerramientas = function () {
        return listaHerramientas;
    };

    var agregarManoObra = function (newObj, cant) {
        var existe = false;
        angular.forEach(listaManoObra, function (val) {
            if (val.id === newObj.id) {
                existe = true;
                val.cantidad += 60;
            }
        });
        if (existe) {
            $rootScope.$emit('actualizarManoObra');
        } else {
            if (cant) {
                newObj.cantidad = cant;
            } else {
                newObj.cantidad = 60;
            }
            listaManoObra.push(newObj);
        }
    };

    var quitarManoObra = function (obj) {
        var index = listaManoObra.indexOf(obj);
        if (index > -1) {
            listaManoObra.splice(index, 1);
        }
    };

    var obtenerManoObra = function () {
        return listaManoObra;
    };

    var limpiar = function () {
        listaMateriales = [];
        listaHerramientas = [];
        listaManoObra = [];
    };


    return {
        agregarMaterial: agregarMaterial,
        obtenerMateriales: obtenerMateriales,
        quitarMaterial: quitarMaterial,
        agregarHerramientas: agregarHerramientas,
        quitarHerramienta: quitarHerramienta,
        obtenerHerramientas: obtenerHerramientas,
        agregarManoObra: agregarManoObra,
        quitarManoObra: quitarManoObra,
        obtenerManoObra: obtenerManoObra,
        limpiar: limpiar

    };

});

module.directive('int', function() {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.on('keypress', function (event) {

                if (!isIntegerChar())
                    event.preventDefault();

                function isIntegerChar() {
                    return /^[0-9]+\.?[0-9]*$/.test(
                            String.fromCharCode(event.which))
                }

            })

        }
    }
});

