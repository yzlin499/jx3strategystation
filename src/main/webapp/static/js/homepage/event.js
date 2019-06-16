var articleLock = true;
var page = 1;
$(window).scroll(function () {
    if ($(document).height() - $(window).scrollTop() - document.body.clientHeight < 4 && articleLock) {
        articleLock = false;
        $.post("/v1/api/newArticle?page=" + page,
            {},
            function (data, status) {
                page++;
                if (!/^\s*$/.test(data)) {
                    $('#article').append(data);
                    articleLock = true;
                }
            }
        );
    }
});