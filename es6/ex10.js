function sumNumbers(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
console.log(sumNumbers(4, 3, 8, 7, 8)); 
