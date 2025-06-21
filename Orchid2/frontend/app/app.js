angular.module('orchidApp', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/home.html',
            controller: 'homeController'
        })
        .when('/login', {
            templateUrl: 'views/login.html',
            controller: 'loginController'
        })
        .when('/register', {
            templateUrl: 'views/register.html',
            controller: 'registerController'
        })
        .when('/checkout', {
            templateUrl: 'views/checkout.html',
            controller: 'checkoutController'
        })
        .when('/orders', {
            templateUrl: 'views/orders.html',
            controller: 'orderController'
        })
        .otherwise({
            redirectTo: '/'
        });
}])
.controller('mainController', ['$scope', 'userService', function($scope, userService) {
    $scope.currentUser = userService.getCurrentUser();

    $scope.isLoggedIn = function() {
        return !!userService.getCurrentUser();
    };

    $scope.logout = function() {
        userService.logout();
        $scope.currentUser = null;
        window.location = '#!/login';
    };

    // Watch for user login state changes (optional)
    $scope.$on('userLoggedIn', function(event, user) {
        $scope.currentUser = user;
    });
}]);


// var app = angular.module('orchidApp', ['ngRoute']);

// app.config(function($routeProvider) {
//     $routeProvider
//     .when("/login", {
//         templateUrl: "views/login.html",
//         controller: "loginController"
//     })
//     .when("/register", {
//         templateUrl: "views/register.html",
//         controller: "registerController"
//     })
//     .otherwise({
//         redirectTo: "/login"
//     });
// });

