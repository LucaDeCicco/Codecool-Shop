
const choosePaymentMethodHandler = () => {
    let cardMethodBtn = document.getElementById("cardMethod")
    let payPalMethodBtn = document.getElementById("payPalMethod")

    cardMethodBtn.addEventListener("click", () => {
        let cardMethod = document.getElementById("cardMethodForm")
        let payPalMethod = document.getElementById("payPalMethodForm")

        console.log("click1")
        cardMethod.style.display = 'block'
        payPalMethod.style.display = 'none'
    })

    payPalMethodBtn.addEventListener("click", () => {
        let payPalMethod = document.getElementById("payPalMethodForm")
        let cardMethod = document.getElementById("cardMethodForm")

        console.log("click2")
        payPalMethod.style.display = 'block'
        cardMethod.style.display = 'none'
    })
}






const init = () => {
choosePaymentMethodHandler()
}

init();