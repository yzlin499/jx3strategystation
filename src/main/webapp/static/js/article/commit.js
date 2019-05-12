function commitTradingArticle() {
    commit("/v1/api/commit/tradingArticle", {
        'article.title': $('#title').val(),
        'article.content': myEditor.getData(),
        'article.minGold': $("#minGold").val(),
        'article.maxGold': $("#maxGold").val(),
        'article.ratio': $("#ratio").val(),
        'article.district': $("#selectItem").val(),
        'article.buySell': $("#buySell").val()
    });
}

function commitComment(articleId) {
    $.post("/v1/api/commit/comment", {
            'comment.article.articleId': articleId,
            'comment.content': myEditor.getData()
        }, function (data, status) {
            window.location.reload();
        }
    );
}

function commit(url, param) {
    $.post(url, param, function (data, status) {
            $(location).attr('href', data.url);
        }
    );
}