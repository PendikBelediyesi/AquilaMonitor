"use strict";
angular.module("sbAdminApp").directive("headerNotification", function () {
    return {
        templateUrl: "scripts/directives/header/header-notification/header-notification.html",
        restrict: "E",
        replace: !0
    }
});