function showDetails(id) {
    const div = document.getElementById(id);
    if (div.getAttribute("style") === "display: none;") {
        div.setAttribute("style", "display: block;")
        document.getElementById(`order-btn-${id}`).innerHTML = "Zatvori"
    } else {
        div.setAttribute("style", "display: none;")
        document.getElementById(`order-btn-${id}`).innerHTML = "Prikaži"
    }
}