
'use strict';

angular.module('myApp.adminBookAdd', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/adminBookAdd', {
            templateUrl: 'adminBookAdd/adminBookAdd.html',
            controller: 'adminBookAddCtrl'
        });
    }])

    .controller('adminBookAddCtrl', function($scope, $http, $cookies, $route, myService) {

        if(!$cookies.get("access_token") || $cookies.get("userRole")=="USER"){
            alert("Access denied");
            window.location.href = "#!/userLogIn";
        }
        $scope.rexAuthor ="^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s-]){1,30}$";
        $scope.rexPublisher ="^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s-]){1,30}$";
        $scope.rexISBN ="^[0-9]{3,13}$";
        $scope.rexNumberOfAvailablePieces ="^[0-9]{1,5}$";
        $scope.rexYearOfPublish ="^(19|20)\\d{2}$";
        $scope.rexPlaceOfPublish ="^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s]){1,30}$";

        // $scope.book=
        //     {
        //         author: "Alla",
        //         category: "Adventure",
        //         description: "AllaAllaAllaAlla",
        //         id: 0,
        //         isbn: "313131",
        //         numberOfAvailablePieces: 31,
        //         placeOfPublish: "Alla",
        //         price: 43,
        //         publisher: "Alla",
        //         title: "Alla",
        //         typeOfCover: "HARD",
        //         yearOfPublish: 2011
        //     };
        $scope.book=
            {
                author: "",
                category: "",
                description: "",
                id: 0,
                isbn: "",
                numberOfAvailablePieces: "" ,
                placeOfPublish: "",
                price: "",
                publisher: "",
                title: "",
                typeOfCover: "",
                yearOfPublish: ""
            };
        $scope.bookAdd=[$scope.book];

        $scope.addBook = function() {
            var req = {
                method: 'POST',
                url: "http://localhost:8080/admin/addBooks",
                headers: {"access_token": $cookies.get("access_token")},
                data: $scope.bookAdd

            }
            $http(req).then(function(data){
                window.location.href = "#!/bookList";
            });
        }

    });