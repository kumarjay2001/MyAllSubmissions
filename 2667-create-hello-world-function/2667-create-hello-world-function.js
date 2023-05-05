/**
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {
        return "Hello World";
        console.log("Hello World");
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */