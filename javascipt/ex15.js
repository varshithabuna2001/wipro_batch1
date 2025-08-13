function addTask() {
        let taskInput = document.getElementById("taskInput");
        let taskText = taskInput.value.trim();

        if (taskText === "") {
            alert("Please enter a task!");
            return;
        }

        let lists = document.createElement("lists");
        lists.textContent = taskText;

        let deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.className = "delete-btn";
        deleteBtn.onclick = function() {
            lists.remove();
        };

        lists.appendChild(deleteBtn);
        document.getElementById("taskList").appendChild(lists);

        taskInput.value = "";
    }