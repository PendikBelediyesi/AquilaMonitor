"use strict";
angular.module("sbAdminApp").controller('errorCtrl', ['$scope', '$state', 'Notification', 'UserService',
    function ($scope, $state, Notification, UserService) {
        $scope.status;
        UserService.logout();
    }]);