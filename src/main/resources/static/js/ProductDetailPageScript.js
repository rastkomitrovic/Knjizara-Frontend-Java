let currentPage = 0;
let htmlComments = "";
document.getElementById("input-quantity").addEventListener("keyup",() => {
    const value = parseInt(document.getElementById("input-quantity").value);
    if(value > 20) {
        document.getElementById("input-quantity").value = 20;
    }
})

let slideIndex = 1;
try{
    showSlides(slideIndex);
} catch(err) {
    console.log(err)
}

// Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    try{
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
    } catch(err){
        console.log(err)
    }
}

async function addToBasket(bookId){
    let basketArr = JSON.parse(localStorage.getItem("myBasket"))
    if(!basketArr){
        basketArr = [];
    }
    const quantity = document.querySelector("#input-quantity").value;
    for (book of basketArr){
        if(book.bookId === bookId){
            console.log("in here")
            book.quantity = parseInt(book.quantity) + parseInt(quantity);
            const isAvailable = await checkAvailableQantity(bookId, book.quantity)
            if(!isAvailable){
                book.quantity = book.quantity - quantity;
                window.alert("Nema dovoljno primeraka na stanju!")
            }else {
                localStorage.removeItem("myBasket")
                localStorage.setItem("myBasket", JSON.stringify(basketArr))
                backToMain()
            }
            return;
        }
    }
    const isAvailable = await checkAvailableQantity(bookId, quantity)
    console.log(isAvailable)
    if(isAvailable === true){
        basketArr.push({bookId, quantity});
        localStorage.removeItem("myBasket");
        localStorage.setItem("myBasket", JSON.stringify(basketArr));
        backToMain()
    }else {
        window.alert("Nema dovoljno primeraka na stanju!");
    }
}
let comments = [];
async function getComments(){
    const res = await fetch(`http://localhost:9090/api/v0/comments/${bookId}`)
    comments = await res.json()
}

getComments().then(() => {
    if(comments.length < 3) {
        document.querySelector(".comments-load-more").style = "display: none;"
        comments.forEach(com => {
            htmlComments = htmlComments + generateComment(com)
        })
        document.querySelector(".product-details-comments").innerHTML = htmlComments;
    } else {
        for(let i=0; i<3; i++){

            htmlComments = htmlComments + generateComment(comments[i])
        }
        currentPage++;
        document.querySelector(".product-details-comments").innerHTML = htmlComments;
        document.querySelector(".comments-load-more").style = "display: block;"
    }
});

function deleteComment(commentId) {
    window.location = `http://localhost:9099/p/deleteComment/${bookId}/${commentId}`
}

function generateComment(comment){
    let deleteButton = ""
    if(comment.user.username === currentUsername) {
        deleteButton = `<button onclick=deleteComment(${comment.commentId}) class=details-info-cta>Obriši komentar</button>`
    }
    return `
                <div class="details-single-comment">
                    <p class="single-comment-user">${comment.user.username}</p>
                    <p class="single-comment-stars">${comment.rating}<i class="fa fa-star"></i></p>
                    <p class="single-comment-review">${comment.text}</p>
                    ${deleteButton}
                </div>
            `
}

function loadMoreComments(){
    for(let i = currentPage *3; i<currentPage*3+3; i++){
        if(comments[i]){

            htmlComments = htmlComments + generateComment(comments[i])

        } else {
            document.querySelector(".comments-load-more").style = "display: none;"
        }
    }
    currentPage++;
    document.querySelector(".product-details-comments").innerHTML = htmlComments;
}

function backToMain(){
    window.alert("Uspešno ste dodali u korpu!")
    window.location = "http://localhost:9099/mainPage"
}

const moreCommentsBtn = document.querySelector(".comments-load-more")
moreCommentsBtn.addEventListener("click", loadMoreComments)

