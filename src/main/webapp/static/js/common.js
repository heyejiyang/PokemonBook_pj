window.addEventListener("DOMContentLoaded", function() {
    const rootUrl = document.querySelector("meta[name='rootUrl']").content;


    const cursorIcon = new Image();
    cursorIcon.src = `${rootUrl}/images/icon_mouse.png`;

    document.body.appendChild(cursorIcon);

    cursorIcon.onload = function() {
        cursorIcon.style.position = "absolute";

        window.addEventListener("mousemove", function(e) {
            cursorIcon.style.left = (e.pageX + cursorIcon.width  + 2)   + "px";
            cursorIcon.style.top = (e.pageY + cursorIcon.height + 2) + "px";

        });

    };

});