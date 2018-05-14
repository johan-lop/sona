'use strict';

module.controller('CotizacionCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.panelEditar = false;
        $scope.paginaActual = 1;
        $scope.cotizacion = {};

        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.paginaActual = 1;
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
        };

        $scope.pagina = function (pag) {
            $scope.paginaActual = pag;
        };

        $scope.listarClientes = function () {
            $http.get('./webresources/Cliente', {})
                    .success(function (data, status, headers, config) {
                        $scope.clientes = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarClientes();
        
        $scope.listarHorario = function () {
            $http.get('./webresources/HorarioTrabajo', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaHorarios = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarHorario();
        
        $scope.listarCiudades = function () {
            $http.get('./webresources/Ciudad', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCiudades = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCiudades();

        $scope.listarContactos = function (clienteId) {
            if (clienteId) {
                $http.get('./webresources/Contacto/Cliente/' + clienteId, {})
                        .success(function (data, status, headers, config) {
                            $scope.contactos = data;
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            } else {
                $scope.contactos = {};
            }
        };

        $scope.guardarCotizacion = function () {
            $http.post('./webresources/Cotizacion', JSON.stringify($scope.cotizacion), {})
                    .success(function (data, status, headers, config) {
                        bootbox.alert('Pre Cotizacion almacenada Correctamente');
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        }

    }]);
