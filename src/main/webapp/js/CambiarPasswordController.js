'use strict';

module.controller('CambiarPasswordCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.$parent.titulo = "Cambiar Password";
        $scope.errores = '';
        $scope.mensajes = '';


        $scope.cambiarPassword = function () {
            $scope.errores = '';
            $scope.mensajes = '';
            if ($scope.password === $scope.password2) {
                $http.get('./webresources/Usuario/CambiarPassword/' + $scope.password, {})
                        .success(function (data, status, headers, config) {
                            $scope.datosFormulario = {};
                            $scope.mensajes = "Password actualizado correctamente";
                        }).error(function (data, status, headers, config) {
                    $scope.errores = "Errores al guardar: " + data.mensaje;
                });
            } else {
                $scope.errores = "Los Password no coinciden";
            }
        };

        $scope.limpiar = function () {
            $scope.errores = '';
            $scope.mensajes = '';
            $scope.password = '';
            $scope.password2 = '';
        };

    }]);
