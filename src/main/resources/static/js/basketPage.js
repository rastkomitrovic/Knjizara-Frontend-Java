let booksBasket = JSON.parse(localStorage.getItem("myBasket"))

async function renderBasket(){
    if(booksBasket.length===0){
        // render nemate iteme u korpi
        return;
    }
    let booksArr = [];
    let booksHtml = "";
    for(book of booksBasket){
        const res = await fetch(`http://localhost:9090/api/v0/books/${book.bookId}`)
        const singleBook = await res.json();
        booksArr.push({book: singleBook, quantity: book.quantity})
    }
    booksArr.forEach(book => {
        booksHtml = booksHtml + `
            <div class="basket-single-item">
        <img src="${book.book.images[0].imageUrl}"/>
        <p>${book.book.bookName}</p>
        <div class="basket-quantity">
            <button class="basket-quantity-btn btn-plus" id="plus" onclick="changeQantity(i,1)">
                +
            </button>
            <input readonly class="basket-quantity-input" value="${book.quantity}"/>
            <button class="basket-quantity-btn btn-minus" id="minus" onclick="changeQantity(i,-1)">
                -
            </button>
        </div>
        <button class="basket-delete-btn" onclick="deleteFromBasket(i)"><i class="fa fa-trash"></i></button>
    </div>
        `
    })
    document.querySelector(".basket-wrapper").innerHTML = booksHtml;
}


function changeQuantity(book, q){

}

function deleteFromBasket(book){

}

renderBasket();