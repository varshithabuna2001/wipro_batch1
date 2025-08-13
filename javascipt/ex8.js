const employees = [
            { name: "varshitha", role: "Manager", empId: 101, salary: 50000 },
            { name: "pavithra", role: "Developer", empId: 102, salary: 40000 },
            { name: "Rudra", role: "Devoloper", empId: 103, salary: 55000 },
            { name: "naina", role: "QA", empId: 104, salary: 35000 },
            { name: "priya", role: "Manager", empId: 105, salary: 60000 }
        ];

        // Filter managers
        const managers = employees.filter(emp => emp.role === "Manager").reduce((sum, emp) => sum + emp.salary, 0)
  console.log(manager)