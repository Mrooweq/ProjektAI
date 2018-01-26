'use strict';

angular.module('myApp.viewMainMenu', ['ngCookies'])

    .directive('viewMainMenu', function () {
        return {
            templateUrl: "viewMainMenu/viewMainMenu.html",
            controller: "ViewMainMenuCtrl"
        };
    })
    .directive('viewMainMenuUser', function () {
        return {
            templateUrl: "viewMainMenu/viewMainMenuUser.html",
            controller: "ViewMainMenuCtrl"
        };
    })

    .controller('ViewMainMenuCtrl',
        ['$scope', '$http', '$cookies', '$rootScope', function ($scope, $http, $cookies, $rootScope) {
            if ($cookies.get("access_token")) {
                $scope.userName = $cookies.get("firstName");
                $scope.userRole = $cookies.get("userRole");
                $scope.userLoggedIn = true;
            }
            else {
                $scope.userName = "User";
                $scope.userRole = "USER";
            }
            $rootScope.$on('userLoggedIn', function () {
                $scope.userName = $cookies.get("firstName");
                $scope.userRole = $cookies.get("userRole");
                $scope.userLoggedIn = true;
            });


            $scope.logOut = function () {
                $cookies.remove("access_token");
                $scope.userName = "User";
                $scope.userRole = "USER";
                $scope.userLoggedIn = false;
                window.location.href = "#!/userLogIn";
            }

        }]);