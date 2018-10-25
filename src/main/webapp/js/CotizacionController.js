'use strict';

module.controller('CotizacionCtrl', ['$scope', '$filter', '$http', 'NgTableParams', function ($scope, $filter, $http, ngTableParams) {

        $scope.panelEditar = false;
        $scope.paginaActual = 1;
        $scope.cotizacion = {};
        $scope.listaCotizaciones = {};
        $scope.capituloSeleccionado = {};
        $scope.cliente = {};
        $scope.contacto = {};
        $scope.erroresCotizacion = [];

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
            $scope.calcularGastosAdministrativos();
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
            $http.post('./webresources/Cotizacion/false', JSON.stringify($scope.cotizacion), {})
                    .success(function (data, status, headers, config) {
                        bootbox.alert('Pre Cotizacion almacenada Correctamente');
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.editarCotizacion = function (row) {
            $scope.cotizacion = row;
            if (row.cliente) {
                $scope.listarContactos(row.cliente.id);
            }
            if (!$scope.cotizacion.capitulos) {
                $scope.cotizacion.capitulos = [];
            } else {
                angular.forEach($scope.cotizacion.capitulos, function (cap) {
                    $scope.calculaSubtotal(cap);
                })
            }
            if (!row.gastosAdministrativos.length) {
                $scope.calcularGastosAdministrativos();
            } else {
                $scope.totalGastos();
            }
            $scope.panelEditar = true;
            $scope.paginaActual = 1;
        };

        $scope.agregarCapitulo = function () {
            if ($scope.capitulo && $scope.capitulo !== '') {
                var capitulo = {};
                capitulo.descripcion = $scope.capitulo;
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
            $scope.valorGastos = 0;
            $http.get('./webresources/GastosAdministrativos/Activos', {})
                    .success(function (data, status, headers, config) {
                        $scope.cotizacion.gastosAdministrativos = data;
                        $scope.totalGastos();
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.totalGastos = function () {
            $scope.valorGastos = 0;
            angular.forEach($scope.cotizacion.gastosAdministrativos, function (val) {
                $scope.valorGastos += parseFloat(val.porcentaje);
            });
        }

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
            item.apu = {};
            item.apu.id = item.id;
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
            $scope.adicional = 0;
            var subTotal = 0;
            var valorImpuestos = 0;
            if ($scope.cotizacion && $scope.cotizacion.capitulos) {
                angular.forEach($scope.cotizacion.capitulos, function (cap) {
                    subTotal += cap.total;
                });
            }
            if ($scope.cotizacion && $scope.cotizacion.impuestos) {
                angular.forEach($scope.cotizacion.impuestos, function (imp) {
                    var valor = (imp.porcentaje * subTotal) / 100;
                    if (imp.porcentajeAdicional) {
                        $scope.adicional = (valor * imp.porcentajeAdicional) / 100;
                    }
                    valorImpuestos += ($scope.adicional + valor);
                });
            }
            $scope.cotizacion.subTotal = subTotal;
            $scope.cotizacion.valorImpuestos = valorImpuestos;
            $scope.cotizacion.total = subTotal + valorImpuestos;
        };

        $scope.eliminarItem = function (cap, objeto) {
            var index = cap.items.indexOf(objeto);
            if (index > -1) {
                cap.items.splice(index, 1);
            }
            $scope.calculaSubtotal(cap);
        };

        $scope.guardarCliente = function () {
            $http.post('./webresources/Cliente', JSON.stringify($scope.cliente), {}
            ).success(function (data, status, headers, config) {
                $scope.cotizacion.cliente = data;
                $scope.listarContactos(data.id);
                $scope.listarClientes();
                $scope.cliente = {};
                angular.element('#agregarCliente').modal('hide');
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.guardarContacto = function () {
            $scope.contacto.cliente = $scope.cotizacion.cliente;
            $http.post('./webresources/Contacto', JSON.stringify($scope.contacto), {}
            ).success(function (data, status, headers, config) {
                $scope.cotizacion.contacto = data;
                $scope.listarContactos($scope.cotizacion.cliente.id);
                $scope.contacto = {};
                angular.element('#agregarContacto').modal('hide');
            }).error(function (data, status, headers, config) {
                bootbox.alert((data && data.mensaje) || 'Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.quitarGasto = function (objeto) {
            if ($scope.cotizacion.gastosAdministrativos) {
                var index = $scope.cotizacion.gastosAdministrativos.indexOf(objeto);
                if (index > -1) {
                    $scope.cotizacion.gastosAdministrativos.splice(index, 1);
                }
                $scope.totalGastos();
            }
        };

        $scope.agregarGasto = function () {
            var nuevoGasto = {};
            nuevoGasto.porcentaje = 0;
            nuevoGasto.descripcion = "";
            $scope.cotizacion.gastosAdministrativos.push(nuevoGasto);
        };

        $scope.obtenerTiposImpuestos = function () {
            $http.get('./webresources/Impuesto/tipos', {})
                    .success(function (data, status, headers, config) {
                        $scope.tiposImpuestos = data;
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.obtenerTiposImpuestos();

        $scope.buscarImpuestosPorTipo = function (tipo) {
            $http.get('./webresources/Impuesto/tipo/' + tipo, {})
                    .success(function (data, status, headers, config) {
                        $scope.cotizacion.impuestos = data;
                        $scope.calculaTotal();
                    }).error(function (data, status, headers, config) {
                bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });

        };

        $scope.recalcularValores = function () {
            if ($scope.cotizacion.ciudad && $scope.cotizacion.horarioTrabajo && $scope.cotizacion.gastosAdministrativos && $scope.cotizacion.capitulos) {
                var parametros = {};
                parametros.ciudad = $scope.cotizacion.ciudad;
                parametros.horarioTrabajo = $scope.cotizacion.horarioTrabajo;
                parametros.gastosAdministrativos = $scope.cotizacion.gastosAdministrativos;
                parametros.capitulos = $scope.cotizacion.capitulos;
                $http.post('./webresources/CotizacionItem/RecalcularValores', JSON.stringify(parametros), {})
                        .success(function (data, status, headers, config) {
                            $scope.cotizacion.capitulos = data;
                            angular.forEach($scope.cotizacion.capitulos, function (cap) {
                                $scope.calculaSubtotal(cap);
                            })
                        }).error(function (data, status, headers, config) {
                    bootbox.alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        };

        $scope.finalizarCotizacion = function () {
            $scope.erroresCotizacion = [];
            if (!$scope.cotizacion.ciudad) {
                $scope.erroresCotizacion.push("La ciudad de la cotización es obligatoria");
            }
            if (!$scope.cotizacion.horarioTrabajo) {
                $scope.erroresCotizacion.push("El horario de trabajo de la cotización es obligatorio");
            }
            if (!$scope.cotizacion.tiempoEntrega) {
                $scope.erroresCotizacion.push("El tiempo de entrega de la cotización es obligatorio");
            }
            if (!$scope.cotizacion.validez) {
                $scope.erroresCotizacion.push("La validez de la cotización es obligatoria");
            }
            if (!$scope.cotizacion.formaPago) {
                $scope.erroresCotizacion.push("La forma de pago de la cotización es obligatoria");
            }
            if (!$scope.cotizacion.garantia) {
                $scope.erroresCotizacion.push("La garantia de la cotización es obligatoria");
            }
            if (!$scope.cotizacion.observaciones) {
                $scope.erroresCotizacion.push("Las observaciones de la cotización son obligatorias");
            }
            if ($scope.erroresCotizacion.length === 0) {
                $http.post('./webresources/Cotizacion/true', JSON.stringify($scope.cotizacion), {})
                        .success(function (data, status, headers, config) {
                            bootbox.alert('Cotizacion generada Correctamente');
                        }).error(function (data, status, headers, config) {
                    bootbox.alert((data && data.mensaje) ? data.mensaje : 'Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
                });
            }
        }
        
        $scope.eliminarCapitulo = function(cap){
            $scope.cotizacion.capitulos.splice($scope.cotizacion.capitulos.indexOf(cap), 1);
        }

    }]);
