let persons = [
    new Person("Alice", 17, "Mumbai"),
    new Person("Bob", 22, "Delhi"),
    new Person("Charlie", 19, "Chennai"),
    new Person("David", 15, "Hyderabad"),
    new Person("Eva", 30, "Pune")
];


let eligibleVoters = persons.filter(person => person.age >= 18);
 
for (let i=0; i<= eligibleVoters.length; i++)
{
    if(i<=18)
        console.log("adult");
    else
        console.log("Minor");
}