
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// signup.js

function validateEmail(email) {
    // Basic email format validation
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePhoneNumber(phone) {
    // Ensure phone number has exactly 10 digits
    var phoneRegex = /^\d{10}$/;
    return phoneRegex.test(phone);
}

function validatePasswordStrength(password) {
    // Strong password requirements
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
}

function validatePasswordMatch(password, confirmPassword) {
    return password === confirmPassword;
}

function validateForm() {
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    // Validate email
    if (!validateEmail(email)) {
        alert('Please enter a valid email address.');
        return false;
    }

    // Validate phone number
    if (!validatePhoneNumber(phone)) {
        alert('Please enter a valid phone number with exactly 10 digits.');
        return false;
    }

    // Validate password strength
    if (!validatePasswordStrength(password)) {
        alert('Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character. Password is weak.');
        return false;
    }

    // Validate password match
    if (!validatePasswordMatch(password, confirmPassword)) {
        alert('Passwords do not match.');
        return false;
    }

    // If all validations pass, you can proceed with form submission
    return true;
}

