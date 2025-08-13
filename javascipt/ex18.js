function calculate(operation) {
    let n1 = parseFloat(document.getElementById("num1").value);
    let n2 = parseFloat(document.getElementById("num2").value);
    let result = 0;

    if (isNaN(n1) || isNaN(n2)) {
        document.getElementById("result").textContent = "Please enter both numbers!";
        return;
    }

    if (operation === "+") result = n1 + n2;
    else if (operation === "-") result = n1 - n2;
    else if (operation === "*") result = n1 * n2;
    else if (operation === "/") {
        if (n2 === 0) {
            document.getElementById("result").textContent = "Cannot divide by zero!";
            return;
        }
        result = n1 / n2;
    }

    document.getElementById("result").textContent = "Result: " + result;
}