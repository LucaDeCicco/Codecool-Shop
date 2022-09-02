// let URL_API = "localhost:8888";

const sortBrandPerfume = () => {
    let options = document.querySelectorAll('.option')
    for (const option of options) {
        option.addEventListener("click", async () => {
            let criteria = option.innerText
            const dataToBePosted = {
                criteria: criteria
            };
            let response = await fetch("/api/filterByBrand", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });


            const filteredProducts = await response.json();
            await generateHtmlContainerFiltered(filteredProducts)
            await addCartButtonsHandler()
        })
    }
}

const orderByPrice = () => {
    let options = document.querySelectorAll('.orderPrice')
    for (const option of options) {
        option.addEventListener("click", async () => {
            let criteria = option.innerText
            const dataToBePosted = {
                criteria: criteria
            };
            let response = await fetch("/api/orderByPrice", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToBePosted)
            });


            const filteredProducts = await response.json();
            await generateHtmlContainerFiltered(filteredProducts)
            await addCartButtonsHandler()
        })
    }
}


const sortMenPerfume = () => {
    let menPerfumeBtn = document.getElementById("menPerfume")
    menPerfumeBtn.addEventListener("click", async () => {
        let criteria = "Men"
        const dataToBePosted = {
            criteria: criteria
        };

        let response = await fetch("/api/filter", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dataToBePosted)
        });


        const filteredProducts = await response.json();
        console.log(filteredProducts)
        await generateHtmlContainerFiltered(filteredProducts)
        await addCartButtonsHandler()
    })
}

const generateHtmlContainerFiltered = (filteredProducts) => {
    let htmlContainer = document.getElementById("productsContainer");
    htmlContainer.innerHTML="";
    let dynamicCards = ``;
    for (let product of filteredProducts){
        dynamicCards+=generateInnerContainer(product);
    }
    htmlContainer.innerHTML = `
    <div class="container">
        <div id="products" class="row">
            ${dynamicCards}
        </div>

    </div>
    `;
}

const generateInnerContainer = (product) => {
    return`<div class="col col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img style="width: 100px; height: 250px" 
                    src="/static/img/product_${product.id}.jpg" alt="" />
                    <div class="card-header" style="width: 300px; height: 200px">
                        <h4 class="card-title">${product.name}</h4>
                        <p class="card-text">${product.description}</p>
                    </div>
                    <div class="card-body">
                        <div class="card-text">
                            <p class="lead">${product.defaultPrice} ${product.defaultCurrency}</p>
                        </div>
                        <div class="card-text">
                            <a class="btn btn-success addToCart" href="#" data-id="${product.id}">Add to cart</a>
                        </div>
                    </div>
                </div>
                <br>
            </div>`;
}

const sortWomenPerfume = () => {
    let menPerfumeBtn = document.getElementById("womenPerfume")
    menPerfumeBtn.addEventListener("click", async () => {
        let criteria = "Women"
        const dataToBePosted = {
            criteria: criteria
        };

        let response = await fetch("/api/filter", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dataToBePosted)
        });


        const filteredProducts = await response.json();
        console.log(filteredProducts)
        await generateHtmlContainerFiltered(filteredProducts)
        await addCartButtonsHandler()
    })
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
            await fetch("/api/addToCart", {
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
    addCartButtonsHandler()
    sortMenPerfume()
    sortWomenPerfume()
    sortBrandPerfume()
    orderByPrice()

}


init();