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


function commitStrategyArticle() {
    commit("/v1/api/commit/strategyArticle", {
        'article.title': $('#title').val(),
        'article.content': myEditor.getData(),
        'article.instance': $("#instance").val()
    });
}

function commitCommonArticle() {
    commit("/v1/api/commit/commonArticle", {
        'article.title': $('#title').val(),
        'article.content': myEditor.getData()
    });
}

function commitAnnouncementArticle() {
    commit("/v1/api/commit/announcementArticle", {
        'article.title': $('#title').val(),
        'article.content': myEditor.getData()
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

//拿云大人，他就是奸细
function whistleblowers(articleId) {
    $.post("/v1/api/commit/reviewArticle", {
            'articleId': articleId
        }, function (data, status) {
            alert(data.articleId === articleId ? "举报成功" : "举报失败");
        }
    );
}

function commit(url, param) {
    $.post(url, param, function (data, status) {
            $(location).attr('href', data.url);
        }
    );
}