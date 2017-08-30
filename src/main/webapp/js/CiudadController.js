'use strict';

module.controller('CiudadCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = {};
        $scope.datosFormulario = {};
        $scope.filtro="";
        $scope.$parent.titulo = "Parametrización Ciudades";


        $scope.listar = function () {
            $http.get('./webresources/Ciudad/Nombre/' + $scope.filtro, {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listar();

        $scope.listarDepartamento = function () {
            $http.get('./webresources/Departamento', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaDepartamento = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de departamento, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarDepartamento();


        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.guardar = function (ciudad) {
            $http.post('./webresources/Ciudad', JSON.stringify(ciudad), {}
            ).success(function (data, status, headers, config) {
                console.log("Guardado..." + ciudad.id);
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
                $http.delete('./webresources/Ciudad/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de Ciudad, por favor intente m\xe1s tarde');
                });
            }
        };
    }]);
