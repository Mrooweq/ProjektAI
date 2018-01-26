angular.module('myApp.userRegistration').factory('userRegistrationService', function ($http, $cookies) {
    return {

        checkUsername: function (username) {
            var req = {
                method: 'GET',
                url: "http://localhost:8080/checkUsername",
                params: {
                    username: username
                }
            };

            return  $http(req).then(function(response) {
                return false;
            }).catch(function(response) {
                if(response.status == 409){return true;}
                else{
                    return false;
                }

            });

        },
        checkEmail: function (email) {
            var req = {
                method: 'GET',
                url: "http://localhost:8080/checkEmail",
                params: {
                    email: email
                }
            };

            return  $http(req).then(function(response) {
                return false;
            }).catch(function(response) {
                if(response.status == 409){return true;}
                else{
                    return false;
                }

            });

        }

    };
});