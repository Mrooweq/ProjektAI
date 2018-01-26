'use strict';

angular.module('myApp.viewTemplate', ['ngCookies'])

    .directive('viewTemplate', function() {
        return {
            templateUrl: "viewTemplate/viewTemplate.html",
            controller: "viewTemplateCtrl"
        };
    })

    .controller('viewTemplateCtrl',
        ['$scope', '$http', '$cookies', '$rootScope',function($scope, $http, $cookies, $rootScope) {


        }]);