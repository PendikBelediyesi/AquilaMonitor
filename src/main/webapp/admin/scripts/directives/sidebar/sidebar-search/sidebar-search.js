"use strict";
angular.module("sbAdminApp").directive("sidebarSearch", function () {
    return {
        templateUrl: "scripts/directives/sidebar/sidebar-search/sidebar-search.html",
        restrict: "E",
        replace: !0,
        scope: {},
        controller: function ($scope) {
            $scope.selectedMenu = "home"
        }
    }
});