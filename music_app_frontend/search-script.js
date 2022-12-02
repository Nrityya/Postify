window.addEventListener("load", function () { // when the page has loaded
  console.log('loaded')
  const curUser = localStorage.getItem("curUser");
  let listContainer;

  document.getElementById("searchbtn").addEventListener("click", function (e) {

    console.log('searching...')
    e.preventDefault();
    const username = document.getElementById('search-user').value;
    fetch('http://localhost:8080/search/?username=' + username).then(res => res.json()).then(data => {
      console.log(data.length);
      listContainer = document.createElement('div');
      listContainer.className = "list-container";

      data.map(obj => {
        let outerDiv = document.createElement('div');
        outerDiv.className = "v47_241";
        let pfp = document.createElement('div')
        pfp.className = "v170_138"
        outerDiv.appendChild(pfp)
        let usernameText = document.createElement('span')
        usernameText.className = "v47_271"
        usernameText.innerHTML = obj.username;
        outerDiv.appendChild(usernameText)
        let followBtn = document.createElement('button');
        followBtn.className = "follow-btn";
        followBtn.innerHTML = "Follow";
        followBtn.value = obj.username;
        followBtn.onclick = () => {
          followFunc(followBtn.value);
          followBtn.innerHTML = "Unfollow";
        }
        outerDiv.appendChild(followBtn);
        listContainer.appendChild(outerDiv);
      })
      document.getElementById("container").appendChild(listContainer);

    }).catch(err => console.log(err))
  })

  let followFunc = (usn) => {
    let requestBody = { username: curUser, friendUsn: usn, isFollowing: false }
    fetch('http://localhost:8080/follow', {
      method: 'POST',
      body: JSON.stringify(requestBody),
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => {

    }).catch(e => {
      alert("Error, please try again")
    })
  }
})