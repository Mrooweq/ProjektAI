'use strict';

angular.module('myApp.userCart', ['ngRoute', 'ngMaterial', 'ngMessages'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/userCart', {
            templateUrl: 'userCart/userCart.html',
            controller: 'userCartCtrl'
        });
    }])

    .controller('userCartCtrl', function ($scope, $http, $cookies, $route, myService) {
        if (!$cookies.get("access_token")) {
            myService.unloggedUserAlert();
        }
        var updateTotalSum = function () {
            $scope.totalSum = Object.keys($scope.cartItems).map(function (k) {
                return +($scope.cartItems[k].price * $scope.cartItems[k].quantity);
            }).reduce(function (a, b) {
                return a + b
            }, 0);
        }

        myService.getCart().then(function (response) {
            $scope.cartItems = response;
            updateTotalSum();
        });

        $scope.updateQuantity = function (id, quantityNew) {

            var re = new RegExp("^[1-9][0-9]*$");
            if (re.test(quantityNew)) {
                var url = "http://localhost:8080/api/book/getBook/" + id;
                $http.get(url).then(function (response) {
                    $scope.book = response.data;
                    myService.getCart().then(function (response) {
                        var cartItemOld = response.filter(function(item) {
                            return item.bookId === id;
                        })[0];
                        var maxQuantity=( parseInt(cartItemOld.quantity)+parseInt($scope.book.numberOfAvailablePieces));
                        if ((parseInt(quantityNew) <= maxQuantity)||(parseInt(quantityNew) < parseInt(cartItemOld.quantity))) {
                            myService.updateCart(id, quantityNew).then(function (response) {
                            });
                            updateTotalSum();
                        }
                        else {
                            myService.quantityAlert(maxQuantity);
                            myService.getCart().then(function (response) {
                                $scope.cartItems = response;
                                updateTotalSum();
                            });
                        }
                    });
                    
                })
            }else{
                myService.getCart().then(function (response) {
                    $scope.cartItems = response;
                    updateTotalSum();
                });
            }
        }

        $scope.deleteFromCart = function (id) {
            myService.updateCart(id, 0).then(function (response) {
                $route.reload();
                updateTotalSum();
            });
        }

        $scope.buy = function () {
            if ($scope.totalSum == 0) {
                myService.emptyCartAlert();
                window.location.href = "#!/bookList";
            } else {
                window.location.href = "#!/userOrderCheckout";
            }
        }

    });