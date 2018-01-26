'use strict';

angular.module('myApp.bookDetails', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/bookDetails/:id', {
    templateUrl: 'book/bookDetails/bookDetails.html',
    controller: 'bookDetailsCtrl'
  });
}])

    .directive("bookDetailsDir", function() {
        return {
            restrict: 'E',
            scope: {
                bookIdParam: '@'
            },
            templateUrl : "book/bookDetails/bookDetails.html",
            controller: "bookDetailsCtrl"

        };
    })

.controller('bookDetailsCtrl', function($scope, $http, $routeParams, myService) {
 
$scope.book_id = $scope.bookIdParam;
var url = "http://localhost:8080/api/book/getBook/" + $scope.bookIdParam;

 $http.get(url).then(function(response) {
        $scope.book = response.data;
      });

    $scope.addToCart = function(id){
        myService.updateCart(id, 1).then(function(response){
            window.location.href = "#!/userCart";
        });
    }
});