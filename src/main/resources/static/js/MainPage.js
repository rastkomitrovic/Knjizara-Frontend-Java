const suggestions = document.querySelector(".navigation-right-suggestions");
let suggestionsHtml = ``;
let data = [];



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

window.onload = async function () {
    let myBasket = JSON.parse(localStorage.getItem("myBasket"))
    let details = JSON.parse(localStorage.getItem("details"))
    console.log("ovde")
    if (myBasket != null && details != null) {
        await fetch("http://localhost:9099/processOrder", {
            method: "POST", body: JSON.stringify({
                orderId: details.id,
                items: myBasket
            }), headers: {
                'Content-Type': 'application/json'
            },
        })
    }
}





