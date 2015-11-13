"use strict";
angular.module("sbAdminApp").controller('serverProgramEditCtrl', ['$scope', 'serverProgramFactory', 'Notification', 'serverFactory', 'programFactory',
    function ($scope, factory, Notification, serverFactory, programFactory) {

        $scope.status;
        $scope.bean;
        $scope.editMode;
        $scope.listServer;
        $scope.listProgram;


        getServerList();
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

        /*  function getServerProgramList() {
         console.log('getServerTypeList is working!');
         factory.getList()
         .success(function (list) {
         $scope.listBean = list;
         })

         .error(function (error) {
         $scope.status = 'Unable to load listBean data: ' + error.message;
         console.log($scope.status);
         });
         }*/


        function getServerList() {
            console.log('getServerTypeList is working!');
            serverFactory.getList()
                .success(function (list) {
                    $scope.listServer = list;
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

        $scope.descUpdate = function () {
            if ($scope.bean.serverByServerId != null) {
                $scope.bean.desc = $scope.bean.serverByServerId.desc;
                if ($scope.bean.programByProgramId != null)
                    $scope.bean.desc += ' - ' + $scope.bean.programByProgramId.desc;
                return true;
            }

            if ($scope.bean.programByProgramId != null)
                $scope.bean.desc = $scope.bean.programByProgramId.desc;

        };

        $scope.insert = function () {
            console.log("insert ->");
            $scope.bean.serverProgramsById = [{pk: {program: {id: 1}}, desc: '1 1'}, {
                pk: {program: {id: 2}},
                desc: '1 2'
            }];

            var temp = $scope.bean;
            //        console.log($scope.bean);

            console.log($scope.bean);

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