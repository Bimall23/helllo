angular.module('orchidApp')
.controller('checkoutController', ['$scope', '$location', 'cartService', 'orderService', function($scope, $location, cartService, orderService) {
    $scope.cartItems = [];
    $scope.totalAmount = 0;

    $scope.order = {
        shippingAddress: '',
        billingAddress: ''
    };

    $scope.initCheckout = function() {
        $scope.cartItems = cartService.getItems();
        $scope.totalAmount = cartService.getTotal();
    };

    $scope.removeItem = function(productId) {
        cartService.removeItem(productId);
        $scope.initCheckout();
    };

    $scope.submitOrder = function() {
        var payload = {
            userId: 1, // single user for now
            shippingAddress: $scope.order.shippingAddress,
            billingAddress: $scope.order.billingAddress,
            items: $scope.cartItems.map(item => ({
                productId: item.product.id,
                quantity: item.quantity,
                price: item.product.price
            }))
        };

        orderService.placeOrder(payload).then(function() {
            alert('Order placed successfully!');
            cartService.clearCart();
            $location.path('/orders');
        }).catch(function(error) {
            console.error('Order error:', error);
            alert('Error placing order');
        });
    };
}]);


// app.controller("CheckoutController", function($scope, $http, $location) {
//     $scope.order = {
//         userId: 1,
//         orderDate: new Date(),
//         shippingAddress: '',
//         billingAddress: ''
//     };

//     $scope.submitOrder = function() {
//         $http.post("http://localhost:8080/api/checkout", $scope.order).then(function(response) {
//             $location.path("/order-confirmation");
//         });
//     });