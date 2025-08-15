class Util {
    static getDate() {
        const today = new Date();
        const day = String(today.getDate());
        const month = String(today.getMonth()+1);
        const year = today.getFullYear();
        return `${day}-${month}-${year}`;
    }

    static getPIValue() {
        return Math.PI;
    }

    static convertC2F(celsius) {
        return (celsius * 9 / 5) + 32;
    }

    static getFibonacci(n) {
        const result = [];
        for (let i = 0; i < n; i++) {
            if (i === 0) result.push(0);
            else if (i === 1) result.push(1);
            else result.push(result[i - 1] + result[i - 2]);
        }
        return result;
    }
}
console.log(Util.getDate());         
console.log(Util.getPIValue());      
console.log(Util.convertC2F(25));    
console.log(Util.getFibonacci(5));   
