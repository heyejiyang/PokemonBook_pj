window.addEventListener("DOMContentLoaded", function() {
    const rootUrl = document.querySelector("meta[name='rootUrl']").content;


    const cursorIcon = new Image();
    cursorIcon.src = `${rootUrl}/images/m_icon.png`;

    document.body.appendChild(cursorIcon);

    cursorIcon.onload = function() {
        cursorIcon.style.position = "absolute";
        cursorIcon.style.zIndex = 10000;
        window.addEventListener("mousemove", function(e) {
            cursorIcon.style.left = (e.pageX + cursorIcon.width)   + "px";
            cursorIcon.style.top = (e.pageY + cursorIcon.height) + "px";

        });

    };

});