'use strict';

module.controller('ViaticoCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = {};
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.$parent.titulo = "Viaticos";
        $scope.valorTotal = 0;
        

        $scope.listar = function () {
            $http.get('./webresources/Viatico', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listar();

        $scope.listarCiudad = function () {
            $http.get('./webresources/Ciudad/Activos', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCiudad = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n de ciudad, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCiudad();


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
            $http.post('./webresources/Viatico', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                bootbox.alert("Los datos han sido guardados con Éxito");
                $scope.panelEditar = false;
                $scope.buscarPorCiudad();
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.cancelar = function () {
            $scope.buscarPorCiudad();
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };

        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        $scope.buscarPorCiudad = function () {
            $scope.valorTotal = 0;
            if (!$scope.filtroCiudad || $scope.filtroCiudad === '') {
                $scope.listar();
            } else {
                $http.get('./webresources/Viatico/Ciudad/' + $scope.filtroCiudad, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;                            
                            angular.forEach($scope.lista, function(val) {
                                if (val.activo)
                                $scope.valorTotal += parseInt(val.valorDiario);
                            });
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n de ciudad, por favor intente m\xe1s tarde');
                });
            }
        };
        
        $scope.listarUnidades = function () {
            $http.get('./webresources/Unidad', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaUnidades = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarUnidades();
        
        $scope.guardarUnidad = function () {
            $http.post('./webresources/Unidad', JSON.stringify($scope.unidad), {}
            ).success(function (data, status, headers, config) {
                angular.element('#modalUnidad').modal('hide');
                $scope.listarUnidades();
                $scope.unidad = {};
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

    }]);
