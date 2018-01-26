'use strict';

angular.module('myApp.userRegistration', ['ngRoute', 'ngResource','ngCookies'
	])

.config(['$routeProvider', '$httpProvider' , function($routeProvider, $httpProvider) {
  $routeProvider.when('/userRegistration', {
    templateUrl: 'userRegistration/userRegistration.html',
    controller: 'UserRegistrationCtrl'
  });
}])

.controller('UserRegistrationCtrl', function($scope, $http, userRegistrationService) {

 $scope.rexUsername ="^(?=.*[a-z])[\\wąćęłńóśźżĄĘŁŃÓŚŹŻ\\d]{3,20}$";
 $scope.rexPassword = "^(?=.*[A-Z])(?=.*[0-9]).{6,20}$";
    $scope.rexFirstName ="^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$";
    $scope.rexLastName ="^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$";
    $scope.rexEmail ="^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    $scope.rexCity ="^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s]){1,30}$";
    $scope.rexStreet ="^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s]){1,30}$";
    $scope.rexHouseNumber ="^[\\d]{1,3}(/[\\d]{1,3})?$";
    $scope.rexPostNumber ="^[\\d]{2}-[\\d]{3}$";

$scope.comparePass = function(){
	if ( $scope.userReg.password == $scope.userReg.passwordRepeat ) { $scope.badPasswords=false; }
	else{ $scope.badPasswords=true; }
}

    // $scope.userReg={
    //     username: "Anna22",
    //     password: "Anna22",
    //     email: "anna22@o2.pl",
    //     firstname: "Anna",
    //     lastname: "Sowa",
    //     city: "Olsztn",
    //     street: "Mila",
    //     houseNumber: "22/34",
    //     postNumber: "22-111"
    // };
    // $scope.userReg.passwordRepeat="Anna22";

    $scope.userReg={
        username: "",
        password: "",
        email: "",
        firstname: "",
        lastname: "",
        city: "",
        street: "",
        houseNumber: "",
        postNumber: ""
    };
    $scope.userReg.passwordRepeat="";

  var register = function () {
      var req = {
          method: 'POST',
          url: "http://localhost:8080/register",
          data: $scope.userReg

      };
      $http(req).then(function (data) {
          window.location.href = "#!/login";
      });
  };

    $scope.registerIn = function() {
        userRegistrationService.checkUsername($scope.userReg.username).then(function (response) {
            $scope.usernameBusy = response;
            userRegistrationService.checkEmail($scope.userReg.email).then(function (response) {
                $scope.emailBusy = response;

                if(!$scope.usernameBusy && !$scope.emailBusy) {
register();
                }
            });
        });

    }


});