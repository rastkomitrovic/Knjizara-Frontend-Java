

function checkPrevious(){
    console.log(isFirst)
    return !isFirst;
}

function checkNext(){
    console.log(isLast)
    return !isLast;
}

function checkCurrent(current){
    console.log(currentPage, current)
    return !(current === currentPage)
}