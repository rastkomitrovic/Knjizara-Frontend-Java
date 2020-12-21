
document.getElementById("input-quantity").addEventListener("keyup",() => {
    const value = parseInt(document.getElementById("input-quantity").value);
    if(value > 20) {
        document.getElementById("input-quantity").value = 20;
    }
})

let slideIndex = 1;
showSlides(slideIndex);

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
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}

async function addToBasket(bookId){
    let basketArr = JSON.parse(localStorage.getItem("myBasket"))
    if(!basketArr){
        basketArr = [];
    }
    console.log(basketArr);
    const quantity = document.querySelector(".details-info-quantity").value;
    for (book of basketArr){
        if(book.bookId === bookId){
            book.quantity = book.quantity + quantity;
            const isAvailable = await checkAvailableQantity(bookId, book.quantity)
            if(!isAvailable){
                book.quantity = book.quantity - quantity;
                window.alert("Nema dovoljno primeraka na stanju!")
            }
            return;
        }
    }
    const isAvailable = await checkAvailableQantity(bookId, quantity)
    if(isAvailable){
        basketArr.push({bookId, quantity, active: true});
        localStorage.removeItem("myBasket");
        localStorage.setItem("myBasket", JSON.stringify(basketArr));
    }
    window.alert("Nema dovoljno primeraka na stanju!");
}

function loadMoreComments(bookId){
    console.log(bookId)
}