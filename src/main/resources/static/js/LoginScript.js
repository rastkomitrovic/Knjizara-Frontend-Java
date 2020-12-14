

function check(){

    const username=document.getElementById("username").value
    const password=document.getElementById("password").value

    if(username.length<=2 || password.length<=2){
        let label=document.getElementById("errorMessage")
        //label.style.display="inline-block"
        label.innerText='Korisnicko ime i lozinka moraju imati vise od 2 karaktera'
        return false
    }
    return true
}
