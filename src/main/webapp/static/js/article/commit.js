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

function commit(url, param) {
    $.post(url, param, function (data, status) {
            $(location).attr('href', data.url);
        }
    );
}