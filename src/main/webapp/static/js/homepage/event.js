var articleLock = true;
$(window).scroll(function () {
    if ($(document).height() - $(window).scrollTop() - document.body.clientHeight < 4 && articleLock) {
        articleLock = false;
        $.post("/v1/api/newArticle",
            {},
            function (data, status) {
                $('#article').append(data);
                articleLock = true;
            }
        );
    }
});