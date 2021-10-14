const form = document.getElementById("myForm")
const errorMessage = document.getElementById("errorMessage")

function handleSubmit(e){
    const formData = new FormData(form);

    const name = formData.get('nameTxt')
    const email = formData.get('emailTxt')
    const gender = formData.get('genderTxt')
    const address = formData.get('addressTxt')
    const city = formData.get('cityTxt')
    const agree = formData.get('agree')
    let error = []

    // VALIDATION
    if(!name){
        error.push("Name cannot be empty!")
    }

    else if(!address){
        error.push("Address cannot be empty");
    }

    else if(!gender){
        error.push("Choose your gender")
    }

    else if(!email){
        error.push("Email cannot be empty")
    }

    else if(city == ""){
        error.push("City must be choosen")
    }

    else if(agree != "true"){
        error.push("You must agree to the terms and services of this company")
    }

    // ERROR MESSAGE
    if(error.length > 0){
        alert(error.join("\n"))
        errorMessage.innerHTML = error.join("</br>")
        e.preventDefault()
    }
    else{
        if(!confirm("Are you sure you have given the right informations ? Click OK to confirm and click Cancel to edit your information again")){
            e.preventDefault()
        }
    }
}

form.addEventListener('submit', handleSubmit)