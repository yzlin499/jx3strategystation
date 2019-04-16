var myEditor;
ClassicEditor.create(document.querySelector('#content'), {
        ckfinder: {
            uploadUrl: '/'
        }
    }
).then(function (editor) {
    myEditor = editor;
}).catch(function (error) {
    console.log(error);
});

function showa() {
    $('#show').append(myEditor.getData());
}
