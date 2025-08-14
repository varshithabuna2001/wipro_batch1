var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var str = new Box("varshitha");
console.log(str.getValue());
var bln = new Box(true);
console.log(bln.getValue());
