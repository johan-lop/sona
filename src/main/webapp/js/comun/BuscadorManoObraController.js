'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorManoObraCtrl', ['$scope', '$filter', '$http', 'servicioComun', function ($scope, $filter, $http, servicioComun) {
        //listar

        $scope.lista = {};

        $scope.buscarSalarios = function () {
            $http.get('./webresources/Cargo/Valor', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaSalarios = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.buscarSalarios();

        $scope.agregarManoObra = function (row) {
            angular.element('#modalManoObra').modal('hide');
            servicioComun.agregarManoObra(row);
        };

    }]);
