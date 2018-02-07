'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorHerramientaCtrl', ['$scope', '$filter', '$http', 'servicioComun', function ($scope, $filter, $http, servicioComun) {


        $scope.lista = {};
        $scope.filtro = {};
        $scope.panelEditar = false;

        $scope.buscar = function () {
            if ($scope.filtro && $scope.filtro.nombre) {
                $http.get('./webresources/herramienta/descripcionActivo/' + $scope.filtro.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.agregarHerramienta = function (row) {
            angular.element('#modalHerramientas').modal('hide');
            servicioComun.agregarHerramientas(row);
        };

        $scope.myFilter = function (item) {
            if (item)
            return item.activo;
        };

    }]);
