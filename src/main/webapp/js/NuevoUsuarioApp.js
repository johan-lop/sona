var module = angular.module('AdminNuevoUsuario', ['vcRecaptcha', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'angularValidator']);
module.controller('NuevousuarioCtrl', ['$scope', '$filter', '$http', 'vcRecaptchaService',
    function ($scope, $filter, $http, vcRecaptchaService) {

        $scope.errores = '';
        $scope.formulario = {};
        $scope.tipoDocumentos = {};
        $scope.empresas = [];

        $scope.buscarTiposDocumento = function () {
            $http.get('./webresources/TipoDocumento', {})
                    .success(function (data, status, headers, config) {
                        $scope.tipoDocumentos = data;
                    }).error(function (data, status, headers, config) {
                alert("Error al consultar los tipos de documentos");
            });
        };
        $scope.buscarTiposDocumento();

        $scope.buscarEmpresas = function () {
            $http.get('./webresources/Empresa/', {})
                    .success(function (data, status, headers, config) {
                        $scope.empresas = data;
                    }).error(function (data, status, headers, config) {
                alert("Error al consultar la Empresa");
            });
        };

        $scope.buscarEmpresas();

        $scope.guardar = function () {
            $scope.errores = '';
            if (true) {
                $http.post('./webresources/Usuario', JSON.stringify($scope.formulario), {})
                        .success(function (data, status, headers, config) {
                            window.location.replace("/Green/login.html?success="+ data.nombreUsuario);
                        }).error(function (data, status, headers, config) {
                    vcRecaptchaService.reload($scope.widgetId);
                    $scope.formulario.gRecaptchaResponse = null;
                    $scope.errores = data && data.mensaje ? data.mensaje : 'Error inesperado';
                });
            } else {
                $scope.errores = 'Existen campos sin diligenciar en el formulario';
            }
        };

        $scope.myCustomValidator = function () {
            if ($scope.formulario.empresa && $scope.formulario.empresa.id) {
                return true;
            }
            return false;
        };

    }]);


module.config(function (vcRecaptchaServiceProvider) {
    vcRecaptchaServiceProvider.setDefaults({
        key: '6LecFSMUAAAAAK7kg4MjnBUfC0NIWagshpqjR1-0'
    });
});