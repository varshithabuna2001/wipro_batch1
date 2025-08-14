class Box<T> {
 value: T;
  constructor(value: T) {
        this.value = value;
    }
    getValue(): T {
        return this.value;
    }
}

const str = new Box<string>("varshitha");
console.log(str.getValue());

const bln = new Box<boolean>(true);
console.log(bln.getValue()); 

