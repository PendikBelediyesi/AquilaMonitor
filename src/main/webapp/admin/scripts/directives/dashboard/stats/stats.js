"use strict";
angular.module("sbAdminApp").directive("stats", function () {
    return {
        templateUrl: "scripts/directives/dashboard/stats/stats.html",
        restrict: "E",
        replace: !0,
        scope: {model: "=", comments: "@", number: "@", name: "@", colour: "@", details: "@", type: "@", "goto": "@"}
    }
});