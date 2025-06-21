angular.module('orchidApp')
.controller('registerController', ['$scope', '$location', 'userService', function($scope, $location, userService) {
    $scope.newUser = {
        username: '',
        password: ''
    };

    $scope.register = function() {
        if (!$scope.newUser.username || !$scope.newUser.password) {
            alert('Username and password are required.');
            return;
        }

        userService.register($scope.newUser).then(function(response) {
            alert('Registration successful. Please log in.');
            $location.path('/login');
        }).catch(function(error) {
            console.error('Registration error:', error);
            alert('Registration failed. Username may already exist.');
        });
    };
}]);
