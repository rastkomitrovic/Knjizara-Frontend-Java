const suggestions = document.querySelector(".navigation-right-suggestions");
let suggestionsHtml = ``;
let data = [];

document.getElementById("main-genres").style = "display: block;"
document.getElementById("main-authors").style = "display: none;"

document.getElementById("search-field").addEventListener("input",async ()=>{
    const search= document.getElementById("search-field").value
    document.getElementById("search-results-page-link")
        .setAttribute("href", `http://localhost:9099/search/0/15/bookName/Any/${search}`)

    let newData = []
    if(search.length>3) {

        const res = await fetch(`http://localhost:9090/api/v0/books/searchSuggest/${search}`)
        newData = await res.json()
        console.log(newData)
        if(JSON.stringify(data) !== JSON.stringify(newData)){
            suggestions.innerHTML = "";
            suggestionsHtml = "";
            newData.forEach(suggestion => {
                const url="/p/"+suggestion.bookId
                suggestionsHtml = suggestionsHtml + `
                <a href=${url}>
                    <div class="navigation-right-single-suggestion">
                        <img src="${suggestion.images[0].imageUrl}" class="single-suggestion-img"/>
                        <div class="single-suggestion-info">
                            <p class="single-suggestion-info-book">${suggestion.bookName}</p>
                            <p class="single-suggestion-info-name">${suggestion.authors[0].firstName} ${suggestion.authors[0].lastName}</p>
                        </div>
                    </div>
                </a>
            `
            })
            suggestions.innerHTML = suggestionsHtml;
            suggestions.style = "display: block;"
            data = newData;
        }

    } else {
        newData = [];
        data = [];
        suggestions.style = "display: none;"
    }
})

document.getElementById("search-field").addEventListener("keyup", e => {
    if(e.code === "Enter" || e.which === 13) {
        document.getElementById("search-results-page-link").click()
    }
})

document.body.addEventListener("click", () => {
    suggestions.style="display: none;"
    document.getElementById("search-field").value = ""
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

window.addEventListener("click", (e) => {
    if(e.target ===  document.querySelector(".admin-modal")) {
        document.querySelector(".admin-modal").style = "display: none"
    }
})

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
                <a href="http://localhost:9099/editAuthorPage/${id}">
                    <button>Izmeni autora</button>
                </a>
                <a href="http://localhost:9099/deleteAuthor/${id}">
                    <button>Obriši autora</button>
                </a>
            </div>
    
        </div>
    `
    div.innerHTML = modalHtml



    document.querySelector(".web-footer").insertAdjacentElement("afterend", div)
}

