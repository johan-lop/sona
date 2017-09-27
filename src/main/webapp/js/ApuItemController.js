'use strict';

module.controller('ApuCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        
        $scope.$parent.titulo = 'Parametrización Apu';
        
        //listar
        $scope.lista = {};
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listar = function () {
            $http.get('./webresources/ApuItem', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.listarMaterial = function () {
            $http.get('./webresources/material', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaMaterial = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de material, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarMaterial();
        $scope.listarCargo = function () {
            $http.get('./webresources/Cargo', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCargo = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de cargo, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCargo();
        $scope.listarHerramienta = function () {
            $http.get('./webresources/herramienta', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaHerramienta = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de herramienta, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarHerramienta();
        $scope.listarApu = function () {
            $http.get('./webresources/Apu', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaApu = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarApu();


        $scope.listar();
        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.guardar = function () {
            $scope.errores = {};
            var error = false;

            if (error)
                return;
            $http.post('./webresources/ApuItem', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };

        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };
        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('�Desea elminar este registro?')) {
                $http.delete('./webresources/ApuItem/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de ApuItem, por favor intente m\xe1s tarde');
                });
            }
        };
    }]);
