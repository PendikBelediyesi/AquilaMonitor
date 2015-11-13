"use strict";
(function () {
    var app = angular.module('sbAdminApp', []);

    app.directive('ngDisabled', function () {
        return {
            controller: function ($scope, $attrs) {
                var self = this;
                $scope.$watch($attrs.ngDisabled, function (isDisabled) {
                    self.isDisabled = isDisabled;
                });
            }
        };
    });
    app.directive("detail", function () {
        return {
            link: function (scope, element, attrs) {
                scope.getContentUrl = function () {
                    return scope.detailUrl;
                }
            },
            templateUrl: "scripts/directives/detail/detailmodal.html", restrict: "E", replace: !0
        }
    });

    function reactToParentNgDisabled(tagName) {
        app.directive(tagName, function () {
            return {
                restrict: 'E',
                require: '?^ngDisabled',
                link: function (scope, element, attrs, ngDisabledController) {
                    if (!ngDisabledController) return;
                    scope.$watch(function () {
                        return ngDisabledController.isDisabled;
                    }, function (isDisabled) {
                        element.prop('disabled', isDisabled);
                    });
                }
            };

        });
    }

    ['input', 'select', 'button', 'textarea'].forEach(reactToParentNgDisabled);
})();