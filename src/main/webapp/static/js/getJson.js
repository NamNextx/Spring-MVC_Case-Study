var noteList;

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
        noteList = response;
        var ulNote = document.getElementById('id-note');
        ulNote.innerHTML = "";
        for (var i = 0; i < ketQua.length; i++) {
            var category = ketQua[i].category.id;
            if (clicked_id == category) {
                //  document.getElementById("id-note").innerHTML = "<li onclick='getNote("   + ketQua[i].id + ")'>qwerty</li>"
                var note = document.createElement('button');
                note.setAttribute('id', ketQua[i].id);
                note.innerText = ketQua[i].title;
                var showContent = "showContentNote(" + ketQua[i].id + ", " + i + ")";
                note.setAttribute("onclick", showContent);
                ulNote.appendChild(note);
            } else {
                continue;
            }

        }

    });
}

function showContentNote(note_id, noteIndex) {
    console.log(noteList[noteIndex]);
    var ulContent = document.getElementById("id-content");
    ulContent.innerText = "";
    var contentP = document.createElement('p');
    contentP.setAttribute('id', note_id);
    contentP.innerText = noteList[noteIndex].content;
    ulContent.appendChild(contentP)
}

