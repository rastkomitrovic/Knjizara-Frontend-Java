
async function renderBasket(){
    let booksBasket = JSON.parse(localStorage.getItem("myBasket"))
    if(booksBasket.length===0){
        document.querySelector(".basket-wrapper").innerHTML = "<h3>Korpa je prazna</h3>";
        return;
    }
    let booksArr = [];
    let booksHtml = "";
    for(book of booksBasket){
        const res = await fetch(`http://localhost:9090/api/v0/books/${book.bookId}`)
        const singleBook = await res.json();
        booksArr.push({book: singleBook, quantity: book.quantity})
    }
    booksArr.forEach((book, i) => {
        booksHtml = booksHtml + `
    <div class="basket-single-item">
        <img src="${book.book.images[0].imageUrl}"/>
        <p>${book.book.bookName}</p>
        <div class="basket-quantity">
            <button class="basket-quantity-btn btn-plus" id="plus" onclick="changeQuantity(${i},1)">
                +
            </button>
            <input readonly class="basket-quantity-input" value="${book.quantity}" id="${i}"/>
            <button class="basket-quantity-btn btn-minus" id="minus" onclick="changeQuantity(${i},-1)">
                -
            </button>
        </div>
        <button class="basket-delete-btn" onclick="deleteFromBasket(${i})"><i class="fa fa-trash"></i></button>
    </div>
        `
    })
    document.querySelector(".basket-wrapper").innerHTML = booksHtml;
}


async function changeQuantity(book, q){
    const basketBooks = JSON.parse(localStorage.getItem("myBasket"));
    if(q === -1 && parseInt(basketBooks[book].quantity) === 1){
        await deleteFromBasket(book)
        return;
    }

    basketBooks[book].quantity = parseInt(basketBooks[book].quantity) + parseInt(q)
    localStorage.removeItem("myBasket")
    localStorage.setItem("myBasket", JSON.stringify(basketBooks))
    let p = parseInt(document.getElementById(book).value)
    let r = parseInt(q)
    let res = p + r
    document.getElementById(book).value = res

}

async function deleteFromBasket(book){
    const basketBooks = JSON.parse(localStorage.getItem("myBasket"));
    basketBooks.splice(book, 1)

    localStorage.removeItem("myBasket")
    localStorage.setItem("myBasket", JSON.stringify(basketBooks))


    await renderBasket()
}

renderBasket();