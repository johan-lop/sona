
var directives = {};

(function () {
    directives.capitalize = function () {
        return {
            require: 'ngModel',
            link: function (scope, element, attrs, ngModel) {
                var capitalize = function (inputValue) {
                    if (inputValue === undefined)
                        inputValue = '';
                    var capitalized = inputValue.toUpperCase();
                    if (capitalized !== inputValue) {
                        ngModel.$setViewValue(capitalized);
                        ngModel.$render();
                    }
                    return capitalized;
                }
                ngModel.$parsers.push(capitalize);
                capitalize(scope[attrs.ngModel]);
            }
        };
    };


    directives.numeric = function () {
        return {
            require: 'ngModel',
            link: function (scope, elem, attr, ngModel) {
                ngModel.$parsers.unshift(function (value) {
                    var valid = /^[0-9]*$/.test(value);
                    if (!valid) {
                        var html = "<span class='error'>El Campo " + elem.attr('error-name') + " debe ser Numérico" +"</span>";
                        elem.addClass("has-error");
                        elem.addClass("numeric-invalid");
                        var div = $($("#" + elem.attr('id')).parent()).children('div.error');
                        if (!div || div.length == 0) {
                            $($("#" + elem.attr('id')).parent()).append('<div class="error"></div>');
                        }
                        $($("#" + elem.attr('id')).parent()).children('div.error').html(html);
                    } else {
                        elem.removeClass("has-error");
                        $($("#" + elem.attr('id')).parent()).children('div.error').remove();
                    }
                    return valid ? value : undefined;

                });
            }
        };
    };

    directives.stringOnly = function () {
        return {
            require: 'ngModel',
            link: function (scope, elem, attr, ngModel) {
                ngModel.$parsers.unshift(function (value) {
                    var valid = /^[a-zA-Z\s]*$/.test(value);
                    if (!valid)
                        elem.addClass("has-error");
                    else
                        elem.removeClass("has-error");
                    return valid ? value : undefined;

                });
            }
        };
    };

    directives.email = function () {
        return {
            require: 'ngModel',
            link: function (scope, elem, attr, ngModel) {
                ngModel.$parsers.unshift(function (value) {
                    var valid = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
                    return valid ? value : undefined;

                });
            }
        };
    };

    $('*[required]').after('<span>*</span>');


})();

module.directive('numeric', directives.numeric)
        .directive('stringonly', directives.stringOnly)
        .directive('capitalize', directives.capitalize)
        .directive('email', directives.email);