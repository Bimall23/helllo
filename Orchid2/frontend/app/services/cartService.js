angular.module('orchidApp')
.factory('cartService', [function() {
    var cart = [];

    return {
        addItem: function(product) {
            var existing = cart.find(item => item.product.id === product.id);
            if (existing) {
                existing.quantity++;
            } else {
                cart.push({ product: product, quantity: 1 });
            }
        },
        removeItem: function(productId) {
            cart = cart.filter(item => item.product.id !== productId);
        },
        getItems: function() {
            return cart;
        },
        getTotal: function() {
            return cart.reduce((sum, item) => sum + (item.product.price * item.quantity), 0);
        },
        clearCart: function() {
            cart = [];
        }
    };
}]);


// angular.module('orchidApp')
// .factory('cartService', function() {
//     var cart = [];

//     return {
//         add: function(product) {
//             var existingItem = cart.find(item => item.product.id === product.id);
//             if (existingItem) {
//                 existingItem.quantity++;
//             } else {
//                 cart.push({ product: product, quantity: 1 });
//             }
//         },
//         remove: function(productId) {
//             cart = cart.filter(item => item.product.id !== productId);
//         },
//         clear: function() {
//             cart = [];
//         },
//         getCart: function() {
//             return cart;
//         },
//         getTotal: function() {
//             return cart.reduce(function(sum, item) {
//                 return sum + (item.product.price * item.quantity);
//             }, 0);
//         }
//     };
// });
