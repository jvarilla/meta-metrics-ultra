let readJson = () => {
   // http://localhost:8080
   fetch('./results.json')
   .then(response => {
       if (!response.ok) {
           throw new Error("HTTP error " + response.status);
       }
       return response.json();
   })
   .then(json => {
       console.log(json);
       document.getElementById("results").append(JSON.stringify(json));
       //console.log(this.users);
   })
   .catch(function () {
   })
}

readJson();