'use strict';

/* Controllers */
//var module = angular.module('controllers', []);

module.controller('RolCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.$parent.titulo = 'Roles';
        $scope.lista = {};
        $scope.listaMenu = {};
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listar = function () {
            $http.get('./webresources/Rol', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listar();

        $scope.listarMenu = function () {
            $http.get('./webresources/Menu/submenus', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaMenu = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarMenu();


        $scope.listarPermisos = function () {
            $http.get('./webresources/Menu/submenus', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaPermisos = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        //guardar
        $scope.nuevo = function () {
            $scope.limpiarMenu();
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.guardar = function () {
            $scope.errores = {};
            var error = false;

            if (error)
                return;
            $scope.datosFormulario.menus = [];
            angular.forEach($scope.listaMenu, function (menu) {
                if (menu.seleccionado) {
                    $scope.datosFormulario.menus.push(menu);
                }
                angular.forEach(menu.menusHijos, function (menuHijo) {
                    if (menuHijo.seleccionado) {
                        $scope.datosFormulario.menus.push(menuHijo);
                    }
                });
            });

            $http.post('./webresources/Rol', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                bootbox.alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) ? data.mensaje : 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };

        //editar
        $scope.editar = function (data) {
            $scope.limpiarMenu();
            $scope.panelEditar = true;
            angular.copy(data, $scope.datosFormulario);
            $http.get('./webresources/Menu/Rol/' + data.id, {})
                    .success(function (data, status, headers, config) {
                        angular.forEach(data, function (menuRol) {
                            angular.forEach($scope.listaMenu, function (menu) {
                                if (menuRol.id === menu.id) {
                                    menu.seleccionado = true;
                                }
                                angular.forEach(menu.menusHijos, function (menuHijo) {
                                    if (menuRol.id === menuHijo.id) {
                                        menuHijo.seleccionado = true;
                                    }
                                });
                            });
                        });
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.limpiarMenu = function () {
            angular.forEach($scope.listaMenu, function (menu) {
                menu.seleccionado = false;
                angular.forEach(menu.menusHijos, function (menuHijo) {
                    menuHijo.seleccionado = false;
                });
            });
        };
        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('�Desea elminar este registro?')) {
                $http.delete('./webresources/Rol/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al eliminar la informaci\xf3n de Rol, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.seleccionarHijos = function (menu) {
            angular.forEach(menu.menusHijos, function (menuHijo) {
                menuHijo.seleccionado = menu.seleccionado;
            });
        };
        
        //To do
        $scope.seleccionarPadre = function (menuHijo) {
            angular.forEach(menu.menusHijos, function (menuHijo) {
                menuHijo.seleccionado = menu.seleccionado;
            });
        };

    }]);
