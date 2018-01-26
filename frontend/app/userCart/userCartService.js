angular.module('myApp.userCart').factory('myService', function ($http, $cookies, $mdDialog) {
    return {

        getCart: function () {
            var req = {
                method: 'GET',
                url: "http://localhost:8080/api/cart/getCart",
                params: {
                    userId: $cookies.get("userId")
                },
                headers: {"access_token": $cookies.get("access_token")}
            };

            return  $http(req).then(function(response) {
                return response.data;
            });

        },
        updateCart: function (bookId, quantity) {
            var req = {
                method: 'GET',
                url: "http://localhost:8080/api/cart/updateCart",
                params: {
                    userId: $cookies.get("userId"),
                    bookId: bookId,
                    quantity: quantity
                },
                headers: {"access_token": $cookies.get("access_token")}
            }

            return  $http(req).then(function(response) {
            });

        },
        buy: function () {
            var req = {
                method: 'GET',
                url: "http://localhost:8080/api/cart/buy",
                params: {
                    userId: $cookies.get("userId")
                },
                headers: {"access_token": $cookies.get("access_token")}
            };

            return  $http(req).then(function(response) {
                return response.data;
            });

        },
        quantityAlert: function (maxQuantity) {
            $mdDialog.show(
                $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Max quantity ' + maxQuantity)
                    .textContent('Were sorry, we do not have enough copies.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Got it!')
            );
            return  0;
        },
        emptyCartAlert: function () {
            $mdDialog.show(
                $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Error')
                    .textContent('Your cart is empty.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Got it!')
            );
            return  0;
        },
        unloggedUserAlert: function () {

                var logIn = $mdDialog.confirm()
                    .title('Please Log In')
                    .textContent('Only logged users have access')
                    .ariaLabel('Lucky day')
                    .ok('Log in!')
                    .cancel('No, thank you');

                $mdDialog.show(logIn).then(function() {
                    window.location.href = "#!/userLogIn";
                }, function() {
                    window.location.href = "#!/bookList";
                });
            return  0;
        }
    };
});