var books=[]
const cart_butt = document.querySelector("#cart_butt");
const submit_butt = document.querySelector("#submit_butt");
function call(target){
    var book=target.getAttribute("data-value");
    if(!books.includes(book)){
        cart_butt.textContent="view cart";
        books.push(book);
        target.style.backgroundColor="grey";
        target.style.border="2px solid grey";
        target.style.color="white";
        target.textContent="Added to cart";
    }
}
cart_butt.addEventListener("click",()=>{
    if(books.length!=0){
        var order="\"";
        books.forEach((element)=>order=order+element+",");
        order+="\"";
        console.log(order);
        window.location.href="http://localhost:8888/EbookManagement/cart?value="+order;
    }
});