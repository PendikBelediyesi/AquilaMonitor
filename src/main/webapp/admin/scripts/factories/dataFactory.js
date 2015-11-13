"use strict";
angular.module("sbAdminApp").factory('dataFactory', ['$http', function ($http) {

    var urlBase = '';
    var dataFactory = {};
    var tempBean;

    console.log('ahaaa');
    dataFactory.setUrlBase = function (url) {
        urlBase = "/" + url;
        return;
    };

    dataFactory.getList = function () {
        return $http.get(urlBase);
    };

    dataFactory.getBean = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertBean = function (bean) {
        return $http.post(urlBase, bean);
    };

    dataFactory.updateBean = function (bean) {
        return $http.put(urlBase, bean)
    };

    dataFactory.deleteBean = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    return dataFactory;
}]);