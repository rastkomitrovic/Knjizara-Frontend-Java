let username = "";
let password = "";

document.getElementById("username").addEventListener("keypress", () => {
    username = document.getElementById("username").value;
    console.log(username)
    check();
})

document.getElementById("password").addEventListener("keypress",() =>{
    password = document.getElementById("password").value;
    console.log(password)
    check();
})

function check(){
    if(username.length <=2 && password.length <= 2){
        document.getElementById("loginButton").disabled=true;
    }else {
        document.getElementById("loginButton").disabled=false;
    }
}
