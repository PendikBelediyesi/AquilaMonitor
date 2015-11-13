"use strict";
angular.module("sbAdminApp").controller('programEditCtrl', ['$scope', 'programFactory', 'Notification',
    function ($scope, factory, Notification) {

        $scope.status;
        $scope.bean;
        $scope.editMode;

        if (angular.isObject(factory.tempBean) && angular.isNumber(factory.tempBean.id)) {
            $scope.bean = factory.tempBean;
            get(factory.tempBean.id);
            $scope.editMode = true;
            factory.tempBean = null;
        } else {
            $scope.editMode = false;
        }

        function get(id) {
            console.log("get ->" + id);
            factory.getBean(id)
                .success(function (returnBean) {
                    $scope.bean = returnBean;
                })
                .error(function (error) {
                    $scope.status = 'Unable to load bean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        $scope.showCreatedDate = function (message) {
            return message.hasOwnProperty('createdDate')
        }

        $scope.update = function () {
            console.log("update ->" + $scope.bean.id);
            factory.updateBean($scope.bean)
                .success(function () {
                    $scope.status = 'Updated ! Refreshing list.';
                    Notification.success($scope.status);
                })
                .error(function (error) {
                    $scope.status = 'Unable to update : ' + error.message;
                    Notification.error($scope.status);
                });

        };

        $scope.insert = function () {
            console.log("insert ->");
            var temp = $scope.bean;
            factory.insertBean(temp)
                .success(function (data) {
                    $scope.status = 'Inserted Bean! Refreshing list.';
                    $scope.editMode = true;
                    $scope.bean = data;
                    Notification.success($scope.status);
                    console.log($scope.status);
                }).
                error(function (error) {
                    $scope.status = 'Unable to insert : ' + error.message;
                    console.log($scope.status);
                    Notification.error($scope.status);
                });
        };

    }]);