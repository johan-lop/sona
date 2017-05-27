var module = angular.module('AdminNuevoUsuario', ['vcRecaptcha']);
module.controller('NuevousuarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.errores = '';
        $scope.formulario = {};
        $scope.tipoDocumentos = {};

        $http.get('./webresources/TipoDocumento', {})
                    .success(function (data, status, headers, config) {
                        $scope.tipoDocumentos = data;
                    }).error(function (data, status, headers, config) {
                alert("Error al consultar los tipos de documentos");
            });

        $scope.guardar = function () {
            $scope.errores = '';
            $http.post('./webresources/Usuario', JSON.stringify($scope.formulario), {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                $scope.errores = data.mensaje;
            });
        };

    }]);

module.config(function (vcRecaptchaServiceProvider) {
    vcRecaptchaServiceProvider.setDefaults({
        key: '6LecFSMUAAAAAK7kg4MjnBUfC0NIWagshpqjR1-0'
    });
});