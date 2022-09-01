

const deleteFromCartBtnHandler = () => {
    let deleteItemButtons = document.querySelectorAll(".deleteFromCart")
    for (const deleteItemBtn of deleteItemButtons) {
        deleteItemBtn.addEventListener("click", async () => {
            let productId = deleteItemBtn.getAttribute("data-id")


            const dataToBePosted = {
                id: productId,
                quantity: 1,
            };
            const response1 = await fetch("/api/deleteFromCart", {
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
            let displayTotal = document.getElementById("total")
            displayTotal.innerHTML=""
            let response = await fetch("/api/getTotal")
            const total = await response.json();
            displayTotal.innerHTML = total;
        })
    }

}


const increaseQuantityBtnHandler = () => {
    let increaseButtons = document.querySelectorAll(".increaseQuantity")
    for (const increaseButton of increaseButtons) {
        increaseButton.addEventListener("click", async () => {
            let prodId = increaseButton.getAttribute("data-id")
            let quantities = document.querySelectorAll(".quantity")
            for (const quantity of quantities) {
                let newQuantity = (parseInt(quantity.innerHTML) + 1).toString()
                if (quantity.getAttribute("data-id") === prodId) {
                    const dataToBePosted = {
                        id: prodId,
                        quantity: newQuantity
                    };
                    const response = await fetch('/api/increaseQuantity', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(dataToBePosted)
                    });
                    quantity.innerHTML = newQuantity;
                }
            }
            let displayTotal = document.getElementById("total")
            displayTotal.innerHTML=""
            let response = await fetch("/api/getTotal")
            const total = await response.json();
            displayTotal.innerHTML = total;
        })
    }
}

const decreaseQuantityBtnHandler = () => {
    let decreaseButtons = document.querySelectorAll(".decreaseQuantity")
    for (const decreaseButton of decreaseButtons) {
        decreaseButton.addEventListener("click", async () => {
            let prodId = decreaseButton.getAttribute("data-id")
            let quantities = document.querySelectorAll(".quantity")
            for (const quantity of quantities) {
                if (quantity.getAttribute("data-id") === prodId) {
                    let newQuantity = (parseInt(quantity.innerHTML) - 1).toString()
                    const dataToBePosted = {
                        id: prodId,
                        quantity: newQuantity
                    };

                    if (parseInt(newQuantity)===0){
                        const response = await fetch("/api/deleteFromCart", {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(dataToBePosted)
                        });
                        let cards = document.querySelectorAll('.row>div>div')
                        for (const card of cards) {
                            if (card.getAttribute("data-id")===prodId){
                                card.innerHTML=""
                            }
                        }
                    }
                    else {
                        const response = await fetch("/api/decreaseQuantity", {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: JSON.stringify(dataToBePosted)
                        });
                        quantity.innerHTML = (parseInt(quantity.innerHTML) - 1).toString();
                    }
                }
            }
            let displayTotal = document.getElementById("total")
            displayTotal.innerHTML=""
            let response = await fetch("/api/getTotal")
            const total = await response.json();
            displayTotal.innerHTML = total;
        })
    }
}









const init = () => {
    deleteFromCartBtnHandler();
    increaseQuantityBtnHandler();
    decreaseQuantityBtnHandler();
}

init();