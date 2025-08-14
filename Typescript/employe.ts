interface Employee {
    empId: number;
    empName: string;
    salary: number;
}

const employees: Employee[] = [
    { empId: 1, empName: "Varshi", salary: 80000 },
    { empId: 2, empName: "Pavi", salary: 60000 },
    { empId: 3, empName: "Bhaskar", salary: 55000 }
];

const printEmployees = (list: Employee[]) => {
    list.forEach(emp => console.log(emp));
    return list.length;
};

console.log("Total Employees:", printEmployees(employees));
