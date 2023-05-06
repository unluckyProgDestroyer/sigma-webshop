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