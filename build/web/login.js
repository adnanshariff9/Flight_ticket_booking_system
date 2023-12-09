// login.js

function validateEmail(email) {
    // Basic email format validation
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePassword(password) {
    // Check if the password is empty
    if (password.trim() === "") {
        alert("Please enter your password.");
        return false;
    }

    // Strong password requirements
    var passwordRegex =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    // Check if the password meets the requirements
    if (!passwordRegex.test(password)) {
        alert(
            "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character. Password is weak."
        );
        return false;
    }

    return true;
}

function validateForm() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Validate email
    if (!validateEmail(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    // Validate password
    if (!validatePassword(password)) {
        return false;
    }

    // If both email and password are valid, redirect to home page
    redirectToHome(email);

    // Prevent the form from submitting in the traditional way
    return false;
}

function redirectToHome(email) {
    // Redirect to the home page with the email as a query parameter
    window.location.href = `home.html?email=${email}`;
}
