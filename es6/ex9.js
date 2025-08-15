function sum(a, b, c) {
  return a + b + c;
}
const numbers = [8,6,3];
const result = sum(...numbers);
console.log(result); 
