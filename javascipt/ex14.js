let cities = ["Delhi", "Hydreabad", "Mumbai", "Pune", "Chennai", "Bangalore"];

        function addCities() {
            let dropdown = document.getElementById("cityList");

            dropdown.length = 1;
            let sorted = cities.slice().sort();

            for (let city of sorted) {
                let option = document.createElement("option");
                option.text = city;
                option.value = city;
                dropdown.add(option);
            }
        }