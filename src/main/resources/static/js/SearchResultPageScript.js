

function checkPrevious(){
    return !isFirst;
}

function checkNext(){
    return !isLast;
}

function checkCurrent(current){
    return !(current === currentPage)
}