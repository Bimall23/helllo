angular.module('orchidApp')
.controller('homeController', ['$scope', 'productService', 'cartService', function($scope, productService, cartService) {
    $scope.products = [];

    $scope.loadProducts = function() {
        productService.getAll().then(function(response) {
            $scope.products = response.data;
        }).catch(function(error) {
            console.error('Error fetching products:', error);
        });
    };

    $scope.addToCart = function(product) {
        cartService.addItem(product);
        alert(product.name + ' added to cart!');
    };
}]);


// angular.module('orchidApp')
// .controller('homeController', ['$scope', 'productService', 'cartService', function($scope, productService, cartService) {
//     $scope.products = [];
//     $scope.searchText = '';
//     $scope.filters = {
//         priceRange: null // Can expand later for more filters
//     };

//     $scope.loadProducts = function() {
//         productService.getAll().then(function(response) {
//             $scope.products = response.data;
//         }, function(error) {
//             console.error('Error fetching products:', error);
//         });
//     };

//     $scope.addToCart = function(product) {
//         cartService.add(product);
//         alert('Added to cart: ' + product.name);
//     };

//     $scope.loadProducts();
// }]);
