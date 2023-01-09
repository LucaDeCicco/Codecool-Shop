const processingCredentials = () => {
    let goToPayBtn = document.getElementById("goToPay");
    goToPayBtn.addEventListener("mouseover", async () => {
        let name = document.getElementById("userName").value
        let email = document.getElementById("exampleInputEmail1").value
        let phoneNumber = document.getElementById("phoneNumber").value
        let country = document.getElementById("country").value
        let city = document.getElementById("city").value
        let zipCode = document.getElementById("zipCode").value
        let address = document.getElementById("address").value.replace(",","");
        if (makeRequiredInputs()){
            const dataToBePosted = {
                name: name,
                email: email,
                phoneNumber: phoneNumber,
                country: country,
                city: city,
                zipCode: zipCode,
                address: address
            };
            const response1 = await fetch("/api/setCredentials", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });
        }
    })
}

const makeRequiredInputs = (name, email, phoneNumber, country, city, zipCode, address) => {
    if (name && email && phoneNumber && country && city && zipCode && address){
        return true
    }
    else {
        return false
    }

}




const init = () =>{
    processingCredentials();
}

init();