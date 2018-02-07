'use strict';

module.controller('ApuCtrl', ['$scope', '$filter', '$http', 'servicioComun', function ($scope, $filter, $http, servicioComun) {

        $scope.$parent.titulo = 'Parametrización Apu';

        //listar
        $scope.lista = [];
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.filtro = {};
        $scope.totalMateriales = 0;
        $scope.totalHerramientas = 0;
        $scope.totalManoObra = 0;
        $scope.mensajes = '';

        $scope.inicializar = function () {
            servicioComun.limpiar();
            $scope.herramientas = servicioComun.obtenerHerramientas();
            $scope.materiales = servicioComun.obtenerMateriales();
            $scope.manoObra = servicioComun.obtenerManoObra();
            $scope.mensajes = '';
        };

        $scope.$watchCollection("materiales", function (newValue, oldValue) {
            $scope.calculaTotalMateriales();
        });

        $scope.calculaTotalMateriales = function () {
            $scope.totalMateriales = 0;
            angular.forEach($scope.materiales, function (mat) {
                $scope.totalMateriales += parseInt(mat.precio) * mat.cantidad;
            });
        };

        $scope.$watchCollection("herramientas", function (newValue, oldValue) {
            $scope.calculaTotalHerramientas();
        });

        $scope.calculaTotalHerramientas = function () {
            $scope.totalHerramientas = 0;
            angular.forEach($scope.herramientas, function (mat) {
                $scope.totalHerramientas += ((parseInt(mat.valor) * mat.cantidad) * mat.porcentaje) / 100;
            });
        };

        $scope.$watchCollection("manoObra", function (newValue, oldValue) {
            $scope.calculaTotalManoObra();
        });

        $scope.calculaTotalManoObra = function () {
            $scope.totalManoObra = 0;
            angular.forEach($scope.manoObra, function (mat) {
                $scope.totalManoObra += parseFloat(mat.totalHora) * mat.cantidad;
            });
        };

        $scope.quitarMaterial = function (row) {
            servicioComun.quitarMaterial(row);
        };

        $scope.quitarHerramienta = function (row) {
            servicioComun.quitarHerramienta(row);
        };

        $scope.quitarManoObra = function (row) {
            servicioComun.quitarManoObra(row);
        };

        $scope.$on("$destroy", function () {
            servicioComun.limpiar();
        });

        $scope.listarCargo = function () {
            $http.get('./webresources/Cargo', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCargo = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de cargo, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCargo();
        $scope.listarHerramienta = function () {
            $http.get('./webresources/herramienta', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaHerramienta = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de herramienta, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarHerramienta();
        $scope.listarApu = function () {
            $http.get('./webresources/Apu', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaApu = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarApu();

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
            $scope.inicializar();
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
            $scope.inicializar();
        };

        //editar
        $scope.editar = function (data) {
            $scope.inicializar();
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
            angular.forEach($scope.datosFormulario.items, function (item) {
                if (item.cargo) {
                    servicioComun.agregarManoObra(item.cargo, item.cantidad);
                }
                if (item.material) {
                    servicioComun.agregarMaterial(item.material, item.cantidad);
                }
                if (item.herramienta) {
                    servicioComun.agregarHerramientas(item.herramienta, item.cantidad);
                }
            });
            $scope.calculaTotalHerramientas();
            $scope.calculaTotalMateriales()();
            $scope.calculaTotalManoObra()();
        };

        $scope.crearTemplate = function (data) {
            $scope.inicializar();
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
            $scope.datosFormulario.id = null;
            angular.forEach($scope.datosFormulario.items, function (item) {
                if (item.cargo) {
                    servicioComun.agregarManoObra(item.cargo, item.cantidad);
                }
                if (item.material) {
                    servicioComun.agregarMaterial(item.material, item.cantidad);
                }
                if (item.herramienta) {
                    servicioComun.agregarHerramientas(item.herramienta, item.cantidad);
                }
            });
            $scope.calculaTotalHerramientas();
            $scope.calculaTotalMateriales()();
            $scope.calculaTotalManoObra()();
        };


        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('�Desea elminar este registro?')) {
                $http.delete('./webresources/ApuItem/' + data.id, {})
                        .success(function (data, status, headers, config) {
                            $scope.listar();
                        }).error(function (data, status, headers, config) {
                    alert('Error al eliminar la informaci\xf3n de ApuItem, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.listarEstados = function () {
            $http.get('./webresources/EstadoApu', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaEstado = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarEstados();

        $scope.guardar = function () {
            $scope.mensajes = '';
            if (!$scope.herramientas.length || !$scope.manoObra.length) {
                $scope.mensajes = 'Debe seleccionar Herramientas y Mano de Obra';
                return;
            }
            var items = [];
            angular.forEach($scope.materiales, function (mat) {
                var item = {};
                item.material = mat;
                item.cantidad = mat.cantidad;
                items.push(item);
            });

            angular.forEach($scope.herramientas, function (mat) {
                var item = {};
                item.herramienta = mat;
                item.cantidad = mat.cantidad;
                items.push(item);
            });

            angular.forEach($scope.manoObra, function (mat) {
                var item = {};
                item.cargo = mat;
                item.cantidad = mat.cantidad;
                items.push(item);
            });
            $scope.datosFormulario.items = items;
            $http.post('./webresources/Apu', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listarApu();
                servicioComun.limpiar();
                $scope.inicializar();
            }).error(function (data, status, headers, config) {
                alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };


    }]);
