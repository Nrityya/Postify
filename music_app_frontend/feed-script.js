window.addEventListener("load", function () { // when the page has loaded
    console.log('loaded')
    const username = this.localStorage.getItem("curUser")
    console.log(username);
    fetch('http://localhost:8080/feed/?username=' + username).then(res => res.json()).then(data => {
        console.log(data.length);
        let listContainer = document.createElement('div');
        listContainer.className = "list-container";

        data.map(obj => {
            let outerDiv = document.createElement('div');
            outerDiv.className = "v47_241";
            let user = this.document.createElement('div');
            user.className = "user";
            user.innerText = obj.postUsn;
            outerDiv.appendChild(user);
            let song = this.document.createElement('iframe');
            song.className = "song";
            song.src = `https://open.spotify.com/embed/track/${obj.songId}?utm_source=generator`;
            song.allow = "encrypted-media";
            song.style = "border-radius:12px";
            song.frameBorder = "0";
            outerDiv.appendChild(song);
            listContainer.appendChild(outerDiv);
        })
        document.getElementById("container").appendChild(listContainer);

    }).catch(err => console.log(err))

    // let list = [
    //     {
    //         songID: "5I8mg57tDvhGGGC3x14mIZ",
    //         songUser: "alex002"
    //     },
    //     {
    //         songID: "0IGUXY4JbK18bu9oD4mPIm",
    //         songUser: "bri234"
    //     },
    //     {
    //         songID: "3IPnBzGRMg6BfViFxxa0Gq",
    //         songUser: "mari92"
    //     },
    //     {
    //         songID: "65dl9RGmVFgVk8HWRlY4ti",
    //         songUser: "jasmine001"
    //     },
    //     {
    //         songID: "6xaI4qZkLocQVOV1swKoph",
    //         songUser: "klce45"
    //     }
    // ]
    // let listContainer = document.createElement('div');
    // listContainer.className = "list-container";

    // list.map(obj => {
    //     let outerDiv = document.createElement('div');
    //     outerDiv.className = "v47_241";
    //     let user = this.document.createElement('div');
    //     user.className = "user";
    //     user.innerText = obj.postUsn;
    //     outerDiv.appendChild(user);
    //     let song = this.document.createElement('iframe');
    //     song.className = "song";
    //     song.src = `https://open.spotify.com/embed/track/${obj.songId}?utm_source=generator`;
    //     song.allow = "encrypted-media";
    //     song.style = "border-radius:12px";
    //     song.frameBorder = "0";
    //     outerDiv.appendChild(song);
    //     listContainer.appendChild(outerDiv);
    // })
    // document.getElementById("container").appendChild(listContainer);

    this.document.getElementById("searchBtn").addEventListener("click", (e) => {
        e.preventDefault();
        window.location.href = "http://localhost:5500/search.html";
    })

})