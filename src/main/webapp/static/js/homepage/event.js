var articleLock = true;
$(window).scroll(function () {
    if ($(document).height() - $(window).scrollTop() - document.body.clientHeight < 4 && articleLock) {
        articleLock = false;
        $.post("/newArticle",
            {},
            function (data, status) {
                $('#article').append(data);
                articleLock = true;
            }
        );
    }
});