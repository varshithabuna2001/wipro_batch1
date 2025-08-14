class Stack<T> {
    private items: T[] = [];

    push(item: T) {
        this.items.push(item);
    }

    pop() {
        return this.items.pop();
    }

    peek() {
        return this.items[this.items.length - 1];
    }
}


const stack = new Stack<number>();
stack.push(1);
stack.push(2);
console.log(stack.peek());
console.log(stack.pop()); 
