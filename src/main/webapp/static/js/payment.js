
const choosePaymentMethodHandler = () => {
    let cardMethodBtn = document.getElementById("cardMethod")
    let payPalMethodBtn = document.getElementById("payPalMethod")

    cardMethodBtn.addEventListener("click", () => {
        let cardMethod = document.getElementById("cardMethodForm")
        let payPalMethod = document.getElementById("payPalMethodForm")

        cardMethod.style.display = 'block'
        payPalMethod.style.display = 'none'
    })

    payPalMethodBtn.addEventListener("click", () => {
        let payPalMethod = document.getElementById("payPalMethodForm")
        let cardMethod = document.getElementById("cardMethodForm")

        payPalMethod.style.display = 'block'
        cardMethod.style.display = 'none'
    })
}






const init = () => {
choosePaymentMethodHandler()
}

init();