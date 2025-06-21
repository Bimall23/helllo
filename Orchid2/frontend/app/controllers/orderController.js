angular.module('orchidApp')
.controller('orderController', ['$scope', 'orderService', function($scope, orderService) {
  $scope.orders = [];

  $scope.initOrders = function() {
    var userId = 1; // Single user for demo

    orderService.getOrdersByUser(userId).then(function(response) {
      $scope.orders = response.data;
    }).catch(function(error) {
      console.error('Failed to load orders', error);
      $scope.orders = [];
    });
  };
}]);


// app.controller("CartController", function($scope, $http) {
//     $scope.cartItems = [];

//     $http.get("http://localhost:8080/api/cart/1").then(function(response) {
//         $scope.cartItems = response.data;
//     });

//     $scope.checkout = function() {
//         const order = {
//             userId: 1,
//             orderDate: new Date(),
//             shippingAddress: "123 Street",
//             billingAddress: "123 Street"
//         };

//         $http.post("http://localhost:8080/api/checkout", order).then(function() {
//             alert("Order placed successfully!");
//         });
//     };
// });
