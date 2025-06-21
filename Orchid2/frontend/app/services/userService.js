angular.module('orchidApp')
.factory('userService', ['$http', '$rootScope', function($http, $rootScope) {
    var API_BASE = 'http://localhost:8080/api/users';
    var currentUser = null;

    return {
        login: function(credentials) {
            return $http.post(API_BASE + '/login', credentials)
                .then(function(response) {
                    currentUser = response.data;
                    $rootScope.$broadcast('userLoggedIn', currentUser);
                    return currentUser;
                });
        },
        register: function(user) {
            return $http.post(API_BASE + '/register', user);
        },
        getCurrentUser: function() {
            return currentUser;
        },
        logout: function() {
            currentUser = null;
        }
    };
}]);
