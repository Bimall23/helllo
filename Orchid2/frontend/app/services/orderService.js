angular.module('orchidApp')
.factory('orderService', ['$http', function($http) {
    var baseUrl = '/api/orders';

    return {
        placeOrder: function(orderData) {
            return $http.post(baseUrl, orderData);
        },
        getOrdersByUser: function(userId) {
            return $http.get(baseUrl + '/user/' + userId);
        }
    };
}]);
