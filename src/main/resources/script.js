function displayJson(json, div) {
    for (const key of Object.keys(json)) {
        if (key == "Ratings") {
            div.innerHTML += "Ratings: "
            for (const ratingKey of Object.keys(json[key])) {
                div.innerHTML += json[key][ratingKey]["Source"] + ": " + json[key][ratingKey]["Value"] + ", ";
            }
            div.innerHTML += "<br/>"
        } else {
            div.innerHTML += key + ": " + json[key] + "<br/>";
        }
    }
}

function loadPostMsg(name){
    let url = "/form?s=" + name.value;
    fetch (url, {method: 'POST'})
        .then(response => response.json())
        .then(data => {
            let div = document.getElementById("postrespmsg");
            div.innerHTML = "";
            console.log(data);
            displayJson(data, div);
        } /*document.getElementById("postrespmsg").innerHTML = data*/);
  }