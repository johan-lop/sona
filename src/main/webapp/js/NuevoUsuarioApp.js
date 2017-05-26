var module = angular.module('AdminNuevoUsuario', []);
module.controller('NuevousuarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.listar = function () {
            $http.get('./webresources/Usuario', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.setValor = function () {
            $scope.valor = 'sadsghdfkjashdf';
        }
    }]);