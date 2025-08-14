var employees = [
    { empId: 1, empName: "Varshi", salary: 80000 },
    { empId: 2, empName: "Pavi", salary: 60000 },
    { empId: 3, empName: "Bhaskar", salary: 55000 }
];
var printEmployees = function (list) {
    list.forEach(function (emp) { return console.log(emp); });
    return list.length;
};
console.log("Total Employees:", printEmployees(employees));
