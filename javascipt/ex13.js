function validateEmail() {
    const email = document.getElementById("email").value;
    const emailError = document.getElementById("emailError");
    const pattern =/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;;

    if (!email) { 
        emailError.textContent = "Email is required.";
        emailError.style.display = "block";
        return false;
    }


    if (!pattern.test(email)) {
        emailError.textContent = "Invalid email format.";
        emailError.style.display = "block";
        return false;
    }

    emailError.style.display = "none";
    return true;
}


function validatePassword() {
    const password = document.getElementById("password").value;
    const passwordError = document.getElementById("passwordError");

    if (!password) { 
        passwordError.textContent = "Password is required.";
       passwordError.style.display = "block";
        return false;
    }

    passwordError.style.display = "none";
    return true;
}

function validateForm() {
    const isEmailValid = validateEmail();
    const isPasswordValid = validatePassword();

    if (isEmailValid && isPasswordValid) {
        alert("Login Successful!");
    }
}
