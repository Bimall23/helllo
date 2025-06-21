angular.module('orchidApp')
.controller('loginController', ['$scope', '$location', 'userService', function($scope, $location, userService) {
    $scope.credentials = {
        username: '',
        password: ''
    };

    $scope.login = function() {
        userService.login($scope.credentials).then(function(user) {
            if (user) {
                alert('Login successful!');
                $location.path('/home');
            } else {
                alert('Invalid credentials. Please try again.');
            }
        }).catch(function(error) {
            console.error('Login error:', error);
            alert('Login failed.');
        });
    };
}]);
