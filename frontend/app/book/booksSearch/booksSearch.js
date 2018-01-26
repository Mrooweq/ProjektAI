'use strict';

angular.module('myApp.booksSearch', ['angular.filter'])

.directive("booksSearchDir", function() {
    return {
        templateUrl : "book/booksSearch/booksSearch.html",
        controller: "booksSearchCtrl"
    };
})


.controller('booksSearchCtrl',  function($scope, $http) {
 $scope.sort='title';

 $scope.advancedSearch= function(){
 	 		$scope.advancedSearchB=!($scope.advancedSearchB);
 }
    $http.get('http://localhost:8080/api/book/getBooks').then(function(response) {
        $scope.books = response.data;
    });
});
