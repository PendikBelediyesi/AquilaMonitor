"use strict";
angular.module("sbAdminApp").controller('loginCtrl', ['$scope', '$state', 'userFactory', 'Notification', 'UserService',
    function ($scope, $state, factory, Notification, UserService) {

        $scope.status;
        $scope.username = "";
        $scope.password = "";
        $scope.user;

        $scope.check = function () {
            console.log("check ->");
            factory.checkBean($scope.username, $scope.password)
                .success(function (data) {
                    $scope.status = 'Succcess Login';
                    data.role = 'editor';
                    $scope.user = data;
                    UserService.login(data);
                    Notification.success($scope.status);
                    console.log(data);
                    $state.go('dashboard.home');
                }).
                error(function (error) {
                    $scope.status = 'Unable to Login : ' + error.message;
                    console.log($scope.status);
                    Notification.error($scope.status);
                    $state.reload('login');
                });
        };

    }]);