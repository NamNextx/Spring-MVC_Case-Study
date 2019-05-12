function getNote(clicked_id) {
    // update...
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/list-note",
        "method": "GET"
    }
    $.ajax(settings).done(function (response) {
        console.log(response);
        var ketQua = response;
        var ulNote = document.getElementById('id-note');
        ulNote.innerHTML = "";
        for (var i = 0 ; i < ketQua.length; i++) {
            var category=ketQua[i].category.id;
            if (clicked_id == category){
                var note = document.createElement('BUTTON');
                note.setAttribute('id', ketQua[i].id);
                note.innerText = ketQua[i].title;
                ulNote.appendChild(note);
            }
            else {
                continue;
            }

        }

    });
}

function deleteCategory(clicked_id) {
    // update...
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/delete-category/"+clicked_id,
        "method": "POST"
    }
    $.ajax(settings).done(function (response) {
        console.log(response);
        var ketQua = response;
        var ulNote = document.getElementById('id-category');
        ulNote.innerHTML = "";
        for (var i = 0 ; i < ketQua.length; i++) {

                var note = document.createElement('BUTTON');
                note.setAttribute('id', ketQua[i].id);
                note.innerText = ketQua[i].title;
                ulNote.appendChild(note);


        }

    });
}
