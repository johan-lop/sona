'use strict';

/* Controllers */
//var module = angular.module('controllers', []);

module.controller('UsuarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.$parent.titulo = 'Usuario';

        //listar
        $scope.lista = {};
        $scope.file = {};
        $scope.foto = {};
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listar = function () {
            $http.get('./webresources/Usuario', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.listarRol = function () {
            $http.get('./webresources/Rol', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaRoles = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de usuarioRol, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarRol();

        $scope.listarTiposDocumento = function () {
            $http.get('./webresources/TipoDocumento', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaTiposDocumento = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de usuarioRol, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarTiposDocumento();


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
            $http.post('./webresources/Usuario', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
            $scope.listar();
        };

        //editar
        $scope.editar = function (data) {
            $scope.file = {};
            $scope.foto = {};
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };

        $scope.onLoad = function (e, reader, file, fileList, fileOjects, fileObj) {
            $scope.datosFormulario.firma = fileObj.base64;
            $scope.datosFormulario.tipoImagen = fileObj.filetype;
        };
        
        $scope.onLoadFoto = function (e, reader, file, fileList, fileOjects, fileObj) {
            $scope.datosFormulario.foto = fileObj.base64;
            $scope.datosFormulario.tipoImagenFoto = fileObj.filetype;
        };

        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('�Desea elminar este registro?')) {
                $http.delete('./webresources/Usuario/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de Usuario, por favor intente m\xe1s tarde');
                });
            }
        };
    }]);
