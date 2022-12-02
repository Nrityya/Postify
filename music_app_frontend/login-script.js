window.addEventListener("load", function () { // when the page has loaded
  console.log('loaded')
  document.getElementById("loginbtn").addEventListener("click", function (e) { // passing the event
    console.log('in function')
    e.preventDefault(); // you do not want to let the form submit because you handle the nex page 
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const creds = { username: username, password: password }

    fetch('http://localhost:8080/login', {
      method: 'POST',
      body: JSON.stringify(creds),
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res =>
      res.json()
    ).then(data => {
      console.log(data)
      if (data.response == "Login Successful") {
        localStorage.setItem("curUser", username)
        window.location.href = "http://localhost:5500/feed.html"
        alert(data.response)
      } else {
        alert(data.response)
      }
    }).catch(err => {
      console.log(err)
    })
  })

})