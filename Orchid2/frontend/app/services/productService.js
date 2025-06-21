angular.module('orchidApp')
.factory('productService', ['$http', function($http) {
    var API_BASE = 'http://localhost:8080/api/products';

    return {
        getAll: function() {
            return $http.get(API_BASE);
        }
    };
}]);
