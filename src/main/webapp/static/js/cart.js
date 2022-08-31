const deleteFromCartBtnHandler = () => {
    let deleteItemButtons = document.querySelectorAll(".deleteFromCart")
    for (const deleteItemBtn of deleteItemButtons) {
        deleteItemBtn.addEventListener("click", async () => {
            let productId = deleteItemBtn.getAttribute("data-id")


            const dataToBePosted = {
                id: productId,
                quantity: 1,
            };
            const response = await fetch("/api/deleteFromCart", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });

            let cards = document.querySelectorAll('.row>div>div')
            for (const card of cards) {
                if (card.getAttribute("data-id")===productId){
                    card.innerHTML=""
                }
            }
        })
    }

}












const init = () => {
    deleteFromCartBtnHandler();
}

init();