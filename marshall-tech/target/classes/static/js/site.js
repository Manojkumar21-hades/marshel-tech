(function () {
    var toggle = document.querySelector(".nav-toggle");
    var nav = document.querySelector("#site-nav");

    if (toggle && nav) {
        toggle.addEventListener("click", function () {
            var open = document.body.classList.toggle("nav-open");
            toggle.setAttribute("aria-expanded", open ? "true" : "false");
        });

        nav.querySelectorAll("a").forEach(function (link) {
            link.addEventListener("click", function () {
                document.body.classList.remove("nav-open");
                toggle.setAttribute("aria-expanded", "false");
            });
        });

        document.addEventListener("keydown", function (event) {
            if (event.key === "Escape") {
                document.body.classList.remove("nav-open");
                toggle.setAttribute("aria-expanded", "false");
            }
        });
    }

    var header = document.querySelector(".site-header");
    if (header) {
        var onScroll = function () {
            header.classList.toggle("is-stuck", window.scrollY > 8);
        };
        onScroll();
        document.addEventListener("scroll", onScroll, { passive: true });
    }

    var filters = document.querySelectorAll(".filter");
    var shots = document.querySelectorAll(".shot");
    var empty = document.querySelector(".empty-filter");
    filters.forEach(function (button) {
        button.addEventListener("click", function () {
            filters.forEach(function (item) {
                item.classList.remove("is-active");
            });
            button.classList.add("is-active");
            var category = button.getAttribute("data-filter");
            var shown = 0;
            shots.forEach(function (shot) {
                var match = category === "all" || shot.getAttribute("data-category") === category;
                shot.hidden = !match;
                if (match) {
                    shown += 1;
                }
            });
            if (empty) {
                empty.hidden = shown !== 0;
            }
        });
    });

    var dialog = document.querySelector("#lightbox");
    if (dialog) {
        var image = dialog.querySelector("img");
        var heading = dialog.querySelector("h2");
        var caption = dialog.querySelector("p");
        document.querySelectorAll(".shot-open").forEach(function (button) {
            button.addEventListener("click", function () {
                image.src = button.getAttribute("data-full");
                image.alt = button.getAttribute("data-caption") || "";
                heading.textContent = button.getAttribute("data-title") || "";
                caption.textContent = button.getAttribute("data-caption") || "";
                dialog.showModal();
            });
        });
        dialog.querySelector(".lightbox-close").addEventListener("click", function () {
            dialog.close();
        });
        dialog.addEventListener("click", function (event) {
            if (event.target === dialog) {
                dialog.close();
            }
        });
    }
})();
