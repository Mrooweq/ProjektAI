'use strict';

angular.module('myApp.userLogIn', ['ngRoute', 'ngResource','ngCookies'
	])

.config(['$routeProvider', '$httpProvider' , function($routeProvider, $httpProvider) {
  $routeProvider.when('/userLogIn', {
    templateUrl: 'userLogIn/userLogIn.html',
    controller: 'UserLogInCtrl'
  });
  // $httpProvider.defaults.useXDomain = true;
 // $httpProvider.defaults.withCredentials = true;
}])

.controller('UserLogInCtrl', function($scope, $http, $httpParamSerializer, $resource, $cookies, $rootScope) {
  	
     $scope.mycookie=$cookies.get("access_token");
     
  $scope.klik = function() {
   	 $cookies.remove("access_token");
   	 $scope.mycookie=$cookies.get("access_token");
   }

    $scope.data = {
        username: "",
        password: ""
    };

   $scope.login = function() {
       // $scope.data.password = btoa($scope.data.password);
        var req = {
            method: 'POST',
            url: "http://localhost:8080/login",
            data: $scope.data
        }
        $http(req).then(function(data){
             $cookies.put("access_token", data.data.token);
             $cookies.put("userId", data.data.userId);
             $cookies.put("firstName", data.data.firstname);
             $cookies.put("userRole", data.data.role);
             $scope.mycookie=$cookies.get("access_token");
             $rootScope.$broadcast('userLoggedIn');
             window.location.href = "#!/bookList";

        }).catch(function(response) {
            alert("Wrong login or password")
            console.error('Gists error', response.status, response.data);
        });
   }




});