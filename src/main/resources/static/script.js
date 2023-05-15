function addStore() {
    console.log("addStore")
    const url = 'http://localhost:8080/store';
    const data = {
        "name": "순댓국집",
        "category": "음식점",
        "price": 10000
    };
    const payload = {
        method: 'POST',
        headers: {
                    'Content-Type': 'application/json'
                  },
        body: JSON.stringify(data)
    };
    fetch(url, payload);
}

async function loadStore() {
    console.log("loadStore")
    const url = 'http://localhost:8080/store';
    const payload = {
        method: 'GET',
        headers: {
                    'Content-Type': 'application/json'
                  },
    };
    const response = await fetch(url, payload);
    const stores = await response.json()
    document.querySelector("#data").innerHTML = JSON.stringify(stores)
}