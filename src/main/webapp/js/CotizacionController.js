'use strict';

module.controller('CotizacionCtrl', ['$scope', '$filter', '$http', 'NgTableParams', function ($scope, $filter, $http, ngTableParams) {

        $scope.panelEditar = false;
        $scope.paginaActual = 1;
        $scope.cotizacion = {};
        $scope.listaCotizaciones = {};
        $scope.capituloSeleccionado = {};

        $scope.listarCotizaciones = function () {
            $http.get('./webresources/Cotizacion', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCotizaciones = data;
                        $scope.tableParams = new ngTableParams({}, {dataset: data});
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.listarCotizaciones();

        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.paginaActual = 1;
            $scope.cotizacion = {};
            $scope.cotizacion.capitulos = [];
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.listarCotizaciones();
        };

        $scope.pagina = function (pag) {
            if (pag === 2) {
                if (!$scope.cotizacion.ciudad || !$scope.cotizacion.horarioTrabajo) {
                    bootbox.alert("La ciudad y el horario de trabajo son obligatorios");
                    return;
                }
            }
            $scope.paginaActual = pag;
        };

        $scope.listarClientes = function () {
            $http.get('./webresources/Cliente', {})
                    .success(function (data, status, headers, config) {
                        $scope.clientes = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarClientes();

        $scope.listarHorario = function () {
            $http.get('./webresources/HorarioTrabajo', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaHorarios = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarHorario();

        $scope.listarCiudades = function () {
            $http.get('./webresources/Ciudad', {})
                    .success(function (data, status, headers, config) {
                        $scope.listaCiudades = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarCiudades();

        $scope.listarContactos = function (clienteId) {
            if (clienteId) {
                $http.get('./webresources/Contacto/Cliente/' + clienteId, {})
                        .success(function (data, status, headers, config) {
                            $scope.contactos = data;
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            } else {
                $scope.contactos = {};
            }
        };

        $scope.guardarCotizacion = function () {
            $http.post('./webresources/Cotizacion', JSON.stringify($scope.cotizacion), {})
                    .success(function (data, status, headers, config) {
                        bootbox.alert('Pre Cotizacion almacenada Correctamente');
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.editar = function (row) {
            $scope.cotizacion = row;
            if (row.cliente) {
                $scope.listarContactos(row.cliente.id);
            }
            if (!$scope.cotizacion.capitulos) {
                $scope.cotizacion.capitulos = [];
            }
            $scope.panelEditar = true;
            $scope.paginaActual = 1;
        };

        $scope.agregarCapitulo = function () {
            if ($scope.capitulo && $scope.capitulo !== '') {
                var capitulo = {};
                capitulo.nombre = $scope.capitulo;
                $scope.cotizacion.capitulos.push(capitulo);
                $scope.capitulo = '';
            } else {
                bootbox.alert('Debe escribir un nombre para el capitulo');
            }
        };

        $scope.ver = function (row) {
            alert(JSON.stringify(row));
        };

        $scope.myFilter = function (item) {
            return item.herramienta;
        };

        $scope.calcularGastosAdministrativos = function () {
            $scope.porcentajeGastos = 0.0;
            $http.get('./webresources/GastosAdministrativos/Activos', {})
                    .success(function (data, status, headers, config) {
                        angular.forEach(data, function (val) {
                            $scope.porcentajeGastos += val.porcentaje;
                        });
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };
        $scope.calcularGastosAdministrativos();

        $scope.seleccionarCapitulo = function (capitulo) {
            $scope.capituloSeleccionado = capitulo;
            $scope.buscarItems($scope.cotizacion.ciudad, $scope.cotizacion.horarioTrabajo);
        };

        $scope.buscarItems = function (ciudad, horarioTrabajo) {
            $scope.parametros = {};
            $scope.parametros.ciudad = ciudad;
            $scope.parametros.horarioTrabajo = horarioTrabajo;
            $http.post('./webresources/Apu/Cotizacion', JSON.stringify($scope.parametros), {})
                    .success(function (data, status, headers, config) {
                        $scope.listaApu = data;
                        angular.forEach($scope.listaApu, function (val) {
                            if (val.estadoApu)
                                val.estado = val.estadoApu.descripcion;
                        });
                        $scope.tableParams = new ngTableParams({}, {dataset: $scope.listaApu});
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n de apu, por favor intente m\xe1s tarde');
            });
        };

        $scope.agregarItem = function (item) {
            if (!$scope.capituloSeleccionado.items) {
                $scope.capituloSeleccionado.items = [];
            }
            item.cantidad = 1;
            $scope.capituloSeleccionado.items.push(item);
            $scope.calculaSubtotal($scope.capituloSeleccionado);
            angular.element('#buscarApu').modal('hide');
        };

        $scope.calculaSubtotal = function (cap) {
            var valorTotal = 0;
            if (cap && cap.items) {
                angular.forEach(cap.items, function (item) {
                    valorTotal += item.cantidad * item.valorTotal;
                });
            }
            cap.total = valorTotal;
            $scope.calculaTotal();
        };

        $scope.calculaTotal = function () {
            var valorTotal = 0;
            if ($scope.cotizacion && $scope.cotizacion.capitulos) {
                angular.forEach($scope.cotizacion.capitulos, function (cap) {
                    valorTotal += cap.total;
                });
            }
            $scope.cotizacion.total = valorTotal;
        };

        $scope.eliminarItem = function (cap, objeto) {
            var index = cap.items.indexOf(objeto);
            if (index > -1) {
                cap.items.splice(index, 1);
            }
            $scope.calculaSubtotal(cap);
        };

    }]);
