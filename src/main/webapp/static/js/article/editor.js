var myEditor;
ClassicEditor.create(document.querySelector('#content'), {
        ckfinder: {
            uploadUrl: '/v1/api/updateImg'
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
