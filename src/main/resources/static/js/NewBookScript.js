let counter = 0;

if(errorMessage) {
    window.alert(errorMessage)
}

document.querySelector("#add-images-button").addEventListener("click", (e) => {
    e.preventDefault();

    const input = document.createElement("input");
    input.setAttribute("name", "images");
    input.style = "margin-top: 1rem";
    const button = document.createElement("button");
    button.setAttribute("class", "delete-image-button");
    button.innerText = "X";
    button.setAttribute("onclick", `return deleteInputField(${counter})`)
    button.setAttribute("style", `background: transparent;
    color: red;
    border: none;
    outline: none;`)
    const div = document.createElement("div")
    div.setAttribute("class", "new-image-block")
    div.setAttribute("id", `input-${counter}`);
    div.insertAdjacentElement("afterbegin", input);
    div.insertAdjacentElement("beforeend", button);

    counter++;
    document.querySelector(".more-images").insertAdjacentElement("beforeend", div)
})

function deleteInputField(id) {
    document.querySelector(`#input-${id}`).remove();
    return false;
}

