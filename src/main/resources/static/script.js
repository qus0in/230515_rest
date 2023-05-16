// 함수키워드 함수명(...패러밑)
function addStore() {
    console.log("addStore"); // print, System.out.println
    // 브라우저 -> f12 -> Console -> log(...)
    const url = 'http://localhost:8080/store';
    // 요청을 보낼 엔드포인트 - const == final (상수)
    // JavaScript 동적 타입(파이썬) / **TypeScript** (React, NodeJS)
    const data = { // Store DTO
        // ID - 생성
        "name": "순댓국집",
        "category": "음식점",
        "price": 10000
    }; // RequestBody에 넣어줄 데이터
    // API 요청 시에 header, 기타 등등 복잡한 요청들이 병행
    const payload = { // 핵심적인 기능 및 데이터 묶음
    // load : 짐 / pay : 지불하다 => 내가 돈 내고 지불할 짐.
        method: 'POST', // 어떠한 HTTP 요청을 할지
        headers: {
                    'Content-Type': 'application/json'
                  },
        body: JSON.stringify(data) // RequestBody를 통해서 전달될 데이터
        // 데이터들의 format은 JSON -> 문자열화(stringify)
    };
    // fetch - 브라우저에서 포스트맨처럼 http 요청을 할 수 있는 기능(함수)
    // **axios** : js 배우실 때 axios. 데이터 통신
    // ajax (Asynchronous JavaScript (=JSON) and XML) - 비동기
    fetch(url, payload); // = 상점 추가 (POST)
    // React
}

// await
async function loadStore() {
    // 거의 유사
    console.log("loadStore")
    const url = 'http://localhost:8080/store';
    const payload = {
        method: 'GET', // GET -> 데이터를 가져온다
        headers: {
                    'Content-Type': 'application/json'
                  },
    };
    // url -> GET -> 응답 -> JSON 리스트
    // async (es8)
    // await : 응답이 제대로 올 때까지 기다리겠다
    // Promise, then, async, await... (비동기 처리)
    const response = await fetch(url, payload);
    // fetch -> json 리스트 -> response
    const stores = await response.json() // 넘어갈 때마다 계속 기다려주겠다는 await를 잊으면 안됨
    // json 변환 -> .json() -> stores
    // http://www.tcpschool.com/javascript/intro
    document.querySelector("#data").innerHTML = JSON.stringify(stores) // stores = json을 문자열화에서 데이터로 주입
    // document -> html 파일 자체 (렌더링된 파일 자체) -> 태그나 속성으로 구현된 상대적 주소 (DOM)
    // id => querySelector("#...") => data라는 id가 있는 태그를 찾은 것
    // innerHTML <- 내부의 html 데이터
}