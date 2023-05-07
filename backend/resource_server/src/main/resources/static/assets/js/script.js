/* ripple effect funciton */
function createRipple(event) {
    const rippleButton = event.currentTarget;
    const circle = document.createElement('span');
    const diameter = Math.max(rippleButton.clientWidth, rippleButton.clientHeight);
    const radius = diameter / 2;

    circle.style.width = circle.style.height = `${diameter}px`;
    circle.style.top = `${(-radius + event.offsetY)}px`;
    circle.style.left = `${event.clientX - (rippleButton.offsetLeft + radius)}px`;

    circle.classList.add("ripple-span");

    const duplicateRippleCheck = rippleButton.getElementsByClassName("ripple-span")[0];

    if (duplicateRippleCheck) {
        duplicateRippleCheck.remove();
    }

    rippleButton.appendChild(circle);
}

const rippleEffects = document.querySelectorAll('.ripple-button');
for (const rippleEffect of rippleEffects) {
    rippleEffect.addEventListener("mousedown", createRipple);
}
/* ripple effect funciton */

const body = document.querySelector("body");
const overlay = document.querySelector('[data-element-type="overlay"]');
const addProductContainer = document.querySelector('[data-element-type="add-product-container"]');
const addProductTrigger = document.querySelector('[data-element-type="add-product-trigger"]');
const closeProductContainer = document.querySelector('[data-element-type="close-product-container"]');
const saveNewProduct = document.querySelector('[data-element-type="save-new-product"]');


// új termék hozzáadása ablak megnyitása plusz gombra (kártya) kattintva
addProductTrigger.addEventListener("click", function () {
    addProductContainer.classList.add("visible");
    body.style.setProperty("overflow", "hidden");

    if (!overlay.classList.contains("hidden") && !overlay.classList.contains("visible")) {
        overlay.classList.add("visible");
    } else if (overlay.classList.contains("hidden")) {
        overlay.classList.remove("hidden");
        overlay.classList.add("visible");
    }
})

// új termék hozzáadása ablak bezárása visszanyilas gombra kattintva
closeProductContainer.addEventListener("click", function () {
    addProductContainer.classList.remove("visible");
    body.style.removeProperty("overflow");

    if (overlay.classList.contains("visible")) {
        overlay.classList.remove("visible");
        overlay.classList.add("hidden");
    }
})

// új termék hozzáadása gombra kattintásra gombon belüli töltő animáció elindítása + overlay megjelenítése
saveNewProduct.addEventListener("click", function () {
    saveNewProduct.classList.toggle("awaiting-server-animation-open");
    addProductContainer.classList.toggle("loading-overlay-open");
})
