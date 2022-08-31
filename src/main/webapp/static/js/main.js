// let URL_API = "localhost:8888";

const proba = () => {
    console.log("proba");
}


const addCartButtonsHandler = () => {
    let addToCartButtons = document.querySelectorAll(".addToCart")
    for (const addToCartBtn of addToCartButtons) {
        addToCartBtn.addEventListener("click", async () => {
            let productId = addToCartBtn.getAttribute("data-id")

            const dataToBePosted = {
                id: productId,
                quantity: 1,
            };
            const response = await fetch("/api/addToCart", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });

        })
    }
}





const init = () => {
    proba();
    addCartButtonsHandler()

}


init();