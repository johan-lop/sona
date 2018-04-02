'use strict';

module.controller('CotizacionCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        
        $scope.panelEditar = false;
        $scope.paginaActual = 1;
        
        $scope.nuevo = function() {
            $scope.panelEditar = true;
            $scope.paginaActual = 1;
        };
        
        $scope.cancelar = function() {
            $scope.panelEditar = false;
        };
        
        $scope.pagina = function(pag) {
            $scope.paginaActual = pag;
        }; 
        
    }]);
