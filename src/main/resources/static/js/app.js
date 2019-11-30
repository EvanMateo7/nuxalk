

const form = document.getElementById('newPatientForm');
const inputs = document.querySelectorAll('input[name]');
const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#\$%\^&])[A-Za-z\d!@#\$%\^&]{8,}/;
const HINRegex = /^[A-Za-z]{4}[\d]{8}$/;

const username = document.getElementById('username');
const password = document.getElementById('password');
const firstName = document.getElementById('firstName');
const lastName = document.getElementById('lastName');
const email = document.getElementById('email');
const insuranceNumber = document.getElementById('insuranceNumber');


form.addEventListener('submit', (event) => {
    validate();
    form.classList.add('was-validated');
    if (form.checkValidity() === false) {
        event.preventDefault();
        console.error("Invalid form.");
    }
    else {
        confirm("Are you sure you want to submit?") ? console.log("Valid form submitted.") : event.preventDefault();
    }
});

inputs.forEach( input => {
    input.addEventListener('keyup', (event) => {
        validate();
    })
});

function validate() {
    // Username
    let usernameValid = username.value.trim().length > 0 && username.value.trim().length < 30;
    if(!usernameValid) {
        username.setCustomValidity("Invalid")
    }
    else {
        username.setCustomValidity("")
    }

    // First Name
    let firstNameValid = firstName.value.trim().length > 0 && firstName.value.trim().length < 30;
    if(!firstNameValid) {
        firstName.setCustomValidity("Invalid")
    }
    else {
        firstName.setCustomValidity("")
    }

    // Last Name
    let lastNameValid = lastName.value.trim().length > 0 && lastName.value.trim().length < 30;
    if(!lastNameValid) {
        lastName.setCustomValidity("Invalid")
    }
    else {
        lastName.setCustomValidity("")
    }

    // Password
    let passwordValid = !!password.value.match(passwordRegex);
    if(!passwordValid) {
        password.setCustomValidity("Invalid")
    }
    else {
        password.setCustomValidity("")
    }

    // Email
    let emailValid = !!email.value.match(emailRegex);
    if(!emailValid) {
        email.setCustomValidity("Invalid")
    }
    else {
        email.setCustomValidity("")
    }

    // Insurance Number
    let insuranceNumberValid = !!insuranceNumber.value.match(HINRegex);
    if(!insuranceNumberValid) {
        insuranceNumber.setCustomValidity("Invalid")
    }
    else {
        insuranceNumber.setCustomValidity("")
    }
}

/*
const newPatientForm = document.getElementById("newPatientForm");
        
newPatientForm.addEventListener("submit", e => {
    e.preventDefault();

    const formData = new FormData(newPatientForm);
    
    const object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    const jsonBody = JSON.stringify(object)

    fetch("/api/patient/", {
        method: "post",
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonBody
    });
});*/

