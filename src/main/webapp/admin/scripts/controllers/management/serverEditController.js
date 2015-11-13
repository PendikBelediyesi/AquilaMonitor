"use strict";
angular.module("sbAdminApp").controller('serverEditCtrl', ['$scope', 'serverFactory', 'Notification', 'ipAddressFactory', 'osFactory', 'serverTypeFactory', 'cpuTypeFactory', 'programFactory',
    function ($scope, factory, Notification, ipAddressFactory, osFactory, serverTypeFactory, cpuTypeFactory, programFactory) {

        $scope.status;
        $scope.bean;
        $scope.editMode;
        $scope.listIpAddress;
        $scope.listOs;
        $scope.listServerType;
        $scope.listCpuType;
        $scope.listParentServer;
        $scope.listProgram;

        getIpAddressList();
        getOsList();
        getServerTypeList();
        getCpuTypeList();
        getParentServerList();
        getProgramList();

        function getProgramList() {
            console.log('getProgramList is working!');
            programFactory.getList()
                .success(function (list) {
                    $scope.listProgram = list;
                })
                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        function getOsList() {
            console.log('getOsList is working!');
            osFactory.getList()
                .success(function (list) {
                    $scope.listOs = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        function getServerTypeList() {
            console.log('getServerTypeList is working!');
            serverTypeFactory.getList()
                .success(function (list) {
                    $scope.listServerType = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        function getCpuTypeList() {
            console.log('getCpuTypeList is working!');
            cpuTypeFactory.getList()
                .success(function (list) {
                    $scope.listCpuType = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        function getParentServerList() {
            console.log('getParentServerList is working!');
            factory.getList()
                .success(function (list) {
                    $scope.listParentServer = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        function getIpAddressList() {
            console.log('getIpAddressList is working!');
            ipAddressFactory.getList()
                .success(function (list) {
                    $scope.listIpAddress = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

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