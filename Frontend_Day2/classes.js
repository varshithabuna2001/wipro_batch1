 
let persons = [
    new Person("varshitha", 17, "Mumbai"),
    new Person("priya", 22, "Delhi"),
    new Person("vamshi", 19, "Chennai"),
    new Person("rudra", 27, "Hyderabad"),
    new Person("naina", 30, "Pune")
]; 

let Voters = persons.filter(person => person.age >= 18);

console.log("voters:");
