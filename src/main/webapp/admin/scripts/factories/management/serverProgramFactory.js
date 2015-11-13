"use strict";
angular.module("sbAdminApp").factory('serverProgramFactory', ['$http', function ($http) {

    var urlBase = '/serverProgram';
    var factory = {};
    var tempBean;

    factory.getList = function () {
        return $http.get(urlBase);
    };

    factory.getBean = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    factory.insertBean = function (bean) {
        return $http.post(urlBase, bean);
    };

    factory.updateBean = function (bean) {
        return $http.put(urlBase, bean)
    };

    factory.deleteBean = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    return factory;
}]);