"use strict";
angular.module("sbAdminApp").directive("sidebar", ["$location", function () {
    return {
        templateUrl: "scripts/directives/sidebar/sidebar.html",
        restrict: "E",
        replace: !0,
        scope: {},
        controller: function ($scope) {
            $scope.selectedMenu = "dashboard", $scope.collapseVar = 0, $scope.multiCollapseVar = 0, $scope.check = function (x) {
                x == $scope.collapseVar ? $scope.collapseVar = 0 : $scope.collapseVar = x
            }, $scope.multiCheck = function (y) {
                y == $scope.multiCollapseVar ? $scope.multiCollapseVar = 0 : $scope.multiCollapseVar = y
            }
        }
    }
}]);