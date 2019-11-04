
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
});