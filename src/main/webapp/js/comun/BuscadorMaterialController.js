'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorMaterialCtrl', ['$scope', '$filter', '$http', 'servicioComun', function ($scope, $filter, $http, servicioComun) {
        //listar

        $scope.lista = {};
        $scope.filtro = {};
        $scope.panelBuscarMateriales = true;
        $scope.materialNuevo = {};

        $scope.buscar = function () {
            if ($scope.filtro && $scope.filtro.nombre) {
                $http.get('./webresources/material/descripcion/' + $scope.filtro.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.agregar = function (row) {
            angular.element('#modalMateriales').modal('hide');
            servicioComun.agregarMaterial(row);
        };

        $scope.busquedaMateriales = function () {
            $scope.panelBuscarMateriales = true;
            $scope.materialNuevo = {};
        };

        $scope.nuevoMaterial = function () {
            $scope.panelBuscarMateriales = false;
            $scope.materialNuevo = {};
        };

        $scope.guardarMaterial = function () {
            $http.post('./webresources/material', JSON.stringify($scope.materialNuevo), {}
            ).success(function (data, status, headers, config) {
                bootbox.alert("Los datos han sido guardados con Exito");
                $scope.panelBuscarMateriales = true;
                $scope.filtro.nombre = $scope.nuevoMaterial.nombre;
                $scope.buscar();
                $scope.materialNuevo = {};
            }).error(function (data, status, headers, config) {
                bootbox.alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

    }]);
