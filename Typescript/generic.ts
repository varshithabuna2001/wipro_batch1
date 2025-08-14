function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}
const p1 = pair(101, "Hello"); 
console.log(p1);

const p2 = pair(true, 55); 
console.log(p2);