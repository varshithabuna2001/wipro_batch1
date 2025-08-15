export function multiply(a, b) {
  return a * b;
}

export function divide(a, b) {
  if (b === 0) {
    return "Division by zero not allowed";
  }
  return a / b;
}
