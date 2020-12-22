const checkAvailableQantity = async function (id, q){
    const res = await fetch(`http://localhost:9090/api/v0/books/isAvailable/${id}/${q}`);
    const body = await res.json();
    return body
}