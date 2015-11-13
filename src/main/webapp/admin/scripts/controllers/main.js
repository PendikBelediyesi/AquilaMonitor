"use strict";
angular.module("sbAdminApp").controller("MainCtrl", ['$scope', '$position', 'UserService', function ($scope, $position, UserService) {
    console.log('User is ' + UserService.currentUser);
}]);