function commit() {
    $.post("/v1/api/commitArticle",
        {
            'article.title': $('#title').val(),
            'article.content': myEditor.getDate()
        },
        function (data, status) {
            $(location).attr('href', data.url);
        }
    );
}