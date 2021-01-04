document.getElementById("main-genres").style = "display: block;"
document.getElementById("main-authors").style = "display: none;"




function openModal(id, first, last){
    const div = document.createElement("div")
    div.className = "admin-modal"

    const modalHtml = `
        <div class="modal-main">
            <p>${first} ${last}</p>
            <div class="modal-buttons">
                <a href="http://localhost:9099/search/0/15/bookName/Author/${id}">
                    <button>Vidi rezultate</button>
                </a>
                <a href="http://localhost:9099/editAuthor/${id}">
                    <button>Izmeni autora</button>
                </a>
                <a onclick="deleteAuthor(${id})">
                    <button>Obriši autora</button>
                </a>
            </div>
    
        </div>
    `
    div.innerHTML = modalHtml



    document.querySelector(".web-footer").insertAdjacentElement("afterend", div)
}

function deleteAuthor(id){
    confirm("Da li ste sigurni da želite da obrišete autora i sva njegova dela?")
    window.location = `http://localhost:9099/deleteAuthor/${id}`
}

window.addEventListener("click", (e) => {
    if(e.target ===  document.querySelector(".admin-modal")) {
        document.querySelector(".admin-modal").style = "display: none"
    }
})

document.getElementById("genres-or-authors").addEventListener("change", (e)=> {
    if(document.getElementById("genres-or-authors").value === "1"){
        document.getElementById("main-genres").style = "display: block;"
        document.getElementById("main-authors").style = "display: none;"
    } else {
        document.getElementById("main-genres").style = "display: none;"
        document.getElementById("main-authors").style = "display: block;"
    }

})



window.onbeforeunload = () => {
    document.getElementById("genres-or-authors").selectedIndex = "0";
}