window.addEventListener("load", function () { // when the page has loaded
  console.log('loaded')
  document.getElementById("submitbtn").addEventListener("click", function (e) { // passing the event
    console.log('in function')
    e.preventDefault(); // you do not want to let the form submit because you handle the nex page 
    const songId = document.getElementById('songId').value;
    const username = localStorage.getItem("curUser");
    const requestBody = { username: username, songId: songId }

    fetch('http://localhost:8080/post', {
      method: 'POST',
      body: JSON.stringify(requestBody),
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res =>
      alert("Created post!")
    ).catch(err => {
      console.log(err)
      alert("Error, please try again")
    })
  })

})