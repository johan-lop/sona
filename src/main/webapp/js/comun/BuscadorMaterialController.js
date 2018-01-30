'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorMaterialCtrl', ['$scope', '$filter', '$http', 'servicioComun', function ($scope, $filter, $http, servicioComun) {
        //listar

        $scope.lista = {};
        $scope.filtro = {};
        $scope.panelEditar = false;

        $scope.buscar = function () {
            if ($scope.filtro && $scope.filtro.nombre) {
                $http.get('./webresources/material/descripcion/' + $scope.filtro.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };
        
        $scope.agregar = function(row) {
            angular.element('#modalMateriales').modal('hide');
            servicioComun.agregarMaterial(row);
        };

    }]);
