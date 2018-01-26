
'use strict';

angular.module('myApp.bookList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/bookList', {
    templateUrl: 'book/bookList/bookList.html',
    controller: 'bookListCtrl'
  });
}])

.controller('bookListCtrl',   function($scope, $http, $cookies, myService) {

$http.get('http://localhost:8080/api/book/getBooks').then(function(response) {
        $scope.books = response.data;
      });

$scope.addToCart = function(id) {
    if (!$cookies.get("access_token")) {
        myService.unloggedUserAlert();
    } else {
        myService.updateCart(id, 1).then(function (response) {
            window.location.href = "#!/userCart";
        });
    }
}
});