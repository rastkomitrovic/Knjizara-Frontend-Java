let page = 1;
const sectionOne = document.getElementById("form-section-1")
const sectionTwo = document.getElementById("form-section-2")
const sectionThree = document.getElementById("form-section-3")

sectionTwo.style = "display:none;"
sectionThree.style = "display:none"

document.getElementById("username").addEventListener("focusout", checkUsername)

function checkUsername() {
    const username = document.getElementById("username").value;

    if (username.length < 3) {
        document.getElementById("errorUsername").innerText = "Korisničko ime mora sadržati barem 3 karaktera!"
        return false
    } else {
        document.getElementById("errorUsername").innerText = ""
        return true
    }
}

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
    if (password !== repeatPassword) {
        document.getElementById("errorRepeatPassword").innerText = "Šifre se ne poklapaju!"
        return false
    } else {
        document.getElementById("errorRepeatPassword").innerText = ""
        return true
    }
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

document.getElementById("dateOfBirth").addEventListener("focusout", checkDate)

function checkDate() {
    const date = document.getElementById("dateOfBirth").value;
    const realDate = new Date(date);
    const currentDate = Date.now();
    const diff = currentDate - realDate.getTime()

    console.log(diff / 1000 / 60 / 60 / 24 / 365.25)
    if (diff / 1000 / 60 / 60 / 24 / 365.25 < 18) {
        document.getElementById("errorDateOfBirth").innerText = "Osoba mora biti punoletna!"
        return false
    } else {
        document.getElementById("errorDateOfBirth").innerText = ""
        return true
    }
}

function check() {
    const next = checkUsername() && checkPass() && checkRepeatPass() && checkName() && checkLastName() && checkEmail() && checkPhone() && checkAddress() && checkDate()
    if (!next) {
        if (!(checkUsername() && checkPass() && checkRepeatPass())) {
            showNext(1)
            return next
        } else if (!(checkName() && checkLastName() && checkEmail())) {
            showNext(2)
            return next
        } else {
            showNext(3)
            return next
        }
    }
    return next
}


function showNext(p) {
    if (p === 1) {
        sectionOne.style = "display: block;"
        sectionTwo.style = "display: none;"
        sectionThree.style = "display: none;"
    } else if (p === 2) {
        sectionOne.style = "display: none;"
        sectionTwo.style = "display: block;"
        sectionThree.style = "display: none;"
    } else {
        sectionOne.style = "display: none;"
        sectionTwo.style = "display: none;"
        sectionThree.style = "display: block;"
    }
}