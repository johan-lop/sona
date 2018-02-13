'use strict';

module.controller('ClienteCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.$parent.titulo = 'Clientes';

        $scope.email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        angular.element('*[required]').prev('label').addClass('label-required');
        angular.element('input.datepicker[required]').parent().prev('label').addClass('label-required');

        $scope.lista = [];
        $scope.datosFormulario = {};
        $scope.contactos = [];
        $scope.panelEditar = false;
        $scope.contacto = {};
        $scope.nombre = '';

        $scope.listar = function () {
            if ($scope.nombre === '') {
                $http.get('./webresources/Cliente', {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            } else {
                $http.get('./webresources/Cliente/descripcion/' + $scope.nombre, {})
                        .success(function (data, status, headers, config) {
                            $scope.lista = data;
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.guardarContacto = function () {
            if ($scope.datosFormulario.id) {
                $scope.contacto.cliente = $scope.datosFormulario;
                $http.post('./webresources/Contacto', JSON.stringify($scope.contacto), {}
                ).success(function (data, status, headers, config) {
                    $scope.buscarContactos($scope.datosFormulario.id);
                    angular.element('#modalContacto').modal('hide');
                }).error(function (data, status, headers, config) {
                    bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            } else {
                $scope.contactos.push($scope.contacto);
                $scope.contacto = {};
                angular.element('#modalContacto').modal('hide');
            }
        };

        $scope.listar();
        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
            $scope.contacto = {};
            $scope.contactos = [];
        };

        $scope.guardar = function () {
            if (!$scope.datosFormulario.id) {
                $scope.datosFormulario.contactos = $scope.contactos;
            }
            $http.post('./webresources/Cliente', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                bootbox.alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
            $scope.listar();
        };


        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
            $scope.buscarContactos(data.id);
        };

        $scope.editarContacto = function (data) {
            angular.copy(data, $scope.contacto);
        };

        $scope.limpiarNuevoContacto = function () {
            $scope.contacto = {};
        };

        $scope.verContactos = function (cliente) {
            $scope.datosFormulario = cliente;
            $scope.buscarContactos(cliente.id);
        };

        $scope.buscarContactos = function (idCliente) {
            $http.get('./webresources/Contacto/Cliente/' + idCliente, {})
                    .success(function (data, status, headers, config) {
                        $scope.contactos = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                $http.delete('./webresources/Cliente/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al eliminar la informaci\xf3n de Cliente, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.myValidationFunction = function () {
            return true;
        }
    }]);
