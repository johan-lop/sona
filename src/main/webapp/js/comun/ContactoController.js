'use strict';

module.controller('ContactoCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar

        $scope.email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        $scope.contacto = {};

        $scope.agregarContacto = function () {
            $scope.$parent.contactos.push(contacto);
            $scope.contacto = {};
        };

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
        };

        $scope.guardar = function () {
            $scope.errores = {};
            var error = false;

            if (error)
                return;
            $http.post('./webresources/Contacto', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                bootbox.alert("Los datos han sido guardados con Éxito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
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
            if (confirm('\xbfDesea elminar este registro?')) {
                $http.delete('./webresources/Contacto/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al eliminar la informaci\xf3n de Contacto, por favor intente m\xe1s tarde');
                });
            }
        };
    }]);
