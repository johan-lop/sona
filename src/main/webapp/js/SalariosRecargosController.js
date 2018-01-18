'use strict';

module.controller('SalariosRecargosCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.$parent.titulo = 'Parametrización de Salarios y Recargos';

        angular.element('*[required]').prev('label').addClass('label-required');
        //listar
        $scope.lista = [];
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.cargo = {};
        $scope.datosFormulario.valorTotal = 0;
        $scope.listar = function () {
            $http.get('./webresources/SalariosRecargos', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.listarCargo = function () {
            $http.get('./webresources/Cargo', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCargo = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de cargo, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCargo();


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
            $http.post('./webresources/SalariosRecargos', JSON.stringify($scope.datosFormulario), {}
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
            $scope.datosFormulario.valorTotal = 0;
            $scope.datosFormulario.filtroCargo = '';
            $scope.buscarPorCargo();
        };

        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        $scope.calculaTotal = function () {
            if ($scope.datosFormulario.cantidad && $scope.datosFormulario.valor) {
                $scope.datosFormulario.total = parseFloat($scope.datosFormulario.cantidad) * parseFloat($scope.datosFormulario.valor);
            }
        };
        //eliminar
        $scope.guardarCargo = function () {
            $http.post('./webresources/Cargo', JSON.stringify($scope.cargo), {}
            ).success(function (data, status, headers, config) {
                $scope.listarCargo();
                $scope.cargo = {};
                angular.element('#modalCargo').modal('hide');
            }).error(function (data, status, headers, config) {
                alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.buscarPorCargo = function () {
            if ($scope.datosFormulario.filtroCargo === '') {
                $scope.listar();
                $scope.datosFormulario.valorTotal = 0;
            } else {
                $http.get('./webresources/SalariosRecargos/Cargo/' + $scope.datosFormulario.filtroCargo, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                            angular.forEach($scope.lista, function (val) {
                                if (val.activo)
                                    $scope.datosFormulario.valorTotal += parseInt(val.total);
                            });
                        }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n de ciudad, por favor intente m\xe1s tarde');
                });
            }
        };

    }]);
