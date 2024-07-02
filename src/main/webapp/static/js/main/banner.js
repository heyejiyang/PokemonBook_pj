window.addEventListener("DOMContentLoaded", function() {
    const swiper = new Swiper(".mySwiper", {
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        loop: true,
        speed: 1000,
    });
});