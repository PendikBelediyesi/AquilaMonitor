"use strict";
angular.module("sbAdminApp").controller('monitorChartCtrl', ['$scope', 'monitorChartFactory', 'Notification', '$timeout',
    function ($scope, factory, Notification, $timeout) {

        $scope.status;
        $scope.listBean;
        $scope.bean;

        $scope.line = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            series: ["Series A", "Series B", "Series C"],
            data: [[65, 59, 80, 81, 56, 55, 40], [28, 48, 40, 19, 86, 27, 90], [84, 8, 90, 10, 64, 7, 11]],
            onClick: function (points, evt) {
                console.log(points, evt)
            }
        };
        $scope.bar = {
            labels: ["2006", "2007", "2008", "2009", "2010", "2011", "2012"],
            series: ["Series A", "Series B"],
            data: [[65, 59, 80, 81, 56, 55, 40], [28, 48, 40, 19, 86, 27, 90]]
        };
        $scope.donut = {
            labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
            data: [300, 500, 100]
        };
        $scope.radar = {
            labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
            data: [[65, 59, 90, 81, 56, 55, 40], [28, 48, 40, 19, 96, 27, 100]]
        };
        $scope.pie = {
            labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
            data: [300, 500, 100]
        };
        $scope.polar = {
            labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
            data: [300, 500, 100, 40, 120]
        };
        $scope.dynamic = {
            labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
            data: [300, 500, 100, 40, 120],
            type: "PolarArea",
            toggle: function () {
                this.type = "PolarArea" === this.type ? "Pie" : "PolarArea"
            }
        };

        getList();

        function getList() {
            console.log('getList is working!');
            factory.getList()
                .success(function (list) {
                    $scope.listBean = list;
                })

                .error(function (error) {
                    $scope.status = 'Unable to load listBean data: ' + error.message;
                    console.log($scope.status);
                });
        }

        $scope.setBean = function (bean) {
            console.log('setBean is working!');
            factory.tempBean = bean;
            $scope.bean = bean;
        };

        $scope.add = function () {
            console.log('add is working!');
            factory.tempBean = {};
        };

        $scope.delete = function () {
            console.log('delete is working!');
            var selectedBean = $scope.bean;
            factory.deleteBean(selectedBean.id)
                .success(function () {
                    $scope.status = 'Deleted ! Refreshing os list.';

                    for (var i = 0; i < $scope.listBean.length; i++) {
                        var temp = $scope.listBean[i];
                        if (temp.id == selectedBean.id) {
                            $scope.listBean.splice(i, 1);
                            break;
                        }
                    }
                    Notification.success($scope.status);
                    console.log($scope.status);
                })
                .error(function (error) {
                    $scope.status = 'Unable to delete : ' + error.message;
                    Notification.error($scope.status);
                    console.log($scope.status);
                });

        };


    }]);