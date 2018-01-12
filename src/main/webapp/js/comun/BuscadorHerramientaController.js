'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorHerramientaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        

        $scope.lista = {};
        $scope.filtro = {};
        $scope.panelEditar = false;

        $scope.buscar = function () {
            if ($scope.filtro && $scope.filtro.nombre) {
                $http.get('./webresources/herramienta/descripcion/' + $scope.filtro.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };

    }]);
