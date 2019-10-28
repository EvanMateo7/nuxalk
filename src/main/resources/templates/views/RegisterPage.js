
export const RegisterPage = {
    render: async() => {
        const html = 
        `
        <div class="flexRowCenter">
            <form id="newPatientForm">
            <label for="firstName">First Name</label>
            <input type="text" name="firstName" id="firstName">
            <label for="lastName">Last Name</label>
            <input type="text" name="lastName" id="lastName">
            <label for="DOB">Date of Birth</label>
            <input type="date" name="DOB" id="DOB">
            <button id="form_submit" class="btn-primary" type="submit">Submit</button>
            </form>
        </div>
        `
        return html;
    },
    postRender: async() => {
        const newPatientForm = document.getElementById("newPatientForm");
        
        newPatientForm.addEventListener("submit", e => {
            e.preventDefault();

            const formData = new FormData(newPatientForm);
            
            const object = {};
            formData.forEach(function(value, key){
                object[key] = value;
            });
            const jsonBody = JSON.stringify(object)

            fetch("http://localhost:8080/api/patient/", {
                method: "post",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: jsonBody
            });
        })
    }
}