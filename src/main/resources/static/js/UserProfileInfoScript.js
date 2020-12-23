
document.getElementById("password").addEventListener("focusout", checkPass)

function checkPass() {
    const password = document.getElementById("password").value;
    const strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");

    if (!strongRegex.test(password)) {
        document.getElementById("errorPassword").innerText = "Šifra nije dovoljno jaka!"
        return false
    } else {
        document.getElementById("errorPassword").innerText = ""
        return true
    }
}

document.getElementById("repeatPassword").addEventListener("focusout", checkRepeatPass)

function checkRepeatPass() {
    const password = document.getElementById("password").value;
    const repeatPassword = document.getElementById("repeatPassword").value
    if(password!==""){
        if (password !== repeatPassword) {
            document.getElementById("errorRepeatPassword").innerText = "Šifre se ne poklapaju!"
            return false
        } else {
            document.getElementById("errorRepeatPassword").innerText = ""
            return true
        }
    }
    return true
}

document.getElementById("name").addEventListener("focusout", checkName)

function checkName() {
    const name = document.getElementById("name").value;

    if (name.length < 3) {
        document.getElementById("errorName").innerText = "Ime mora imati barem 3 karaktera!"
        return false
    } else {
        document.getElementById("errorName").innerText = ""
        return true
    }
}

document.getElementById("lastName").addEventListener("focusout", checkLastName)

function checkLastName() {
    const lastName = document.getElementById("lastName").value;

    if (lastName.length < 3) {
        document.getElementById("errorLastName").innerText = "Prezime mora imati barem 3 karaktera!"
        return false
    } else {
        document.getElementById("errorLastName").innerText = ""
        return true
    }
}

document.getElementById("email").addEventListener("focusout", checkEmail)

function checkEmail() {
    const email = document.getElementById("email").value;
    // const regExp = new RegExp("/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/");
    if (email.length < 5) {
        document.getElementById("errorEmail").innerText = "Unesite validan e-mail!"
        return false
    } else {
        document.getElementById("errorEmail").innerText = ""
        return true
    }
}

document.getElementById("phone").addEventListener("focusout", checkPhone)

function checkPhone() {
    const phone = document.getElementById("phone").value;

    if (phone.length < 9) {
        document.getElementById("errorPhone").innerText = "Unesite validan broj telefona!"
        return false
    } else {
        document.getElementById("errorPhone").innerText = ""
        return true;
    }
}

document.getElementById("address").addEventListener("focusout", checkAddress)

function checkAddress() {
    const address = document.getElementById("address").value;
    if (address.length < 5) {
        document.getElementById("errorAddress").innerText = "Adresa mora sadržati barem 5 karaktera!"
        return false
    } else {
        document.getElementById("errorAddress").innerText = ""
        return true;
    }
}


function check() {
    const next = checkUsername() && checkPass() && checkRepeatPass() && checkName() && checkLastName() && checkEmail() && checkPhone() && checkAddress() && checkDate()
    return next
}