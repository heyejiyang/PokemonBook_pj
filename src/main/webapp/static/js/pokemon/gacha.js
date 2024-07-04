function showGachaResult() {
            var iframe = document.getElementById("gachaIframe");
            iframe.src = "<c:url value='/pokemon/gacharesult' />";
            document.querySelector(".iframeContainer").style.display = "block";
        }