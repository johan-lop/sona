'use strict';

/* Controllers */
//var module = angular.module('adminmaterial.controllers', []);

module.controller('BuscadorApuCtrl', ['$scope', '$filter', '$http', 'servicioComun', 'NgTableParams',
    function ($scope, $filter, $http, servicioComun, ngTableParams) {


        $scope.lista = {};
        $scope.filtro = {};
        $scope.panelEditar = false;

        $scope.buscar = function () {
            $http.get('./webresources/Apu', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaApu = data;
                        angular.forEach($scope.listaApu, function (val) {
                            if (val.estadoApu)
                                val.estado = val.estadoApu.descripcion;
                        });
                        $scope.tableParams = new ngTableParams({}, {dataset: $scope.listaApu});
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };
        $scope.buscar();



    }]);
