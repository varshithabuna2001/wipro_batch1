function separateFirstRest(...args) {
  return {
    first: args[0],
    rest: args.slice(1)
  };
}

console.log(separateFirstRest(5, 10, 15, 20));  

