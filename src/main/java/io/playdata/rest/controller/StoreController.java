package io.playdata.rest.controller;

import io.playdata.rest.model.StoreDTO;
import io.playdata.rest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Controller <-> RestController
// 1. Controller: Spring MVC - Model & View -> 일반적인 웹 어플리케이션
// => 템플릿 엔진 (JSP, Thymeleaf) => Model 데이터를 담아서 => 렌더링 (View)
// String => "redirect...", 템플릿 이름 (view)
// 2. RestController : -> **JSON** API, React, Vue / Android, iOS, Flutter
// ** 직렬화, 역직렬화... (JSON)
// => Kotlin (java upgrade, JVM) / WebFlux -> React - Redux
// ---- Spring Web
@RequestMapping("/store") // URI, URL
// URI : 프로토콜(스킴) (http, https) / host. ip주소,도메인
// / port - 게이트웨이, 리버스 프록시 (AWS API Gateway, Nginx) : 80, 443, 8080, 8000(Django)
// 4000 : flask (유명한 웹 서버 어플리케이션 프레임워크들은 각자의 시험용 포트를 가지고 있음...)
// Docker => 가상환경 => 가상환경 상 실행한 포트와 실제 외부에 열린 포트를 다르게 가져갈 수 있음.
// ---
// http://localhost:8080/{path}/{path2}... -> path... 경로
// @PathVariable : 경로를 변수처럼 사용 => id를 쓰거나, 특정한 검색 조건(카테고리)
// news - blog /news (findAll... new인 것만 필터링...)
// {id} -> 특정한 순서의 구별되는 고유값은 id를 사용해서 1개의 값만 가져올 때
// 클린 URL (Pretty URL) <-> Dirty? ugly?
// Query Parameter, Query String // ../{path...}?key=value&key2=value2
// @RequestParam(...) => 필수 여부나 기타...
// Controller에도 똑같이 적용됨!
// @RequestBody - Form을 사용하거나, data 객체로 json으로 전달 받았을 때, Entity(DTO)로 바로 연결해서 해석할 수 있게
// Controller => @ModelAttribute("diary") model.addAt...(entity) => form mapping => post로 받음
// View가 따로 없는 RestController의 경우에는 Body라고 하는 거에 data를 넣어서 전달 받았다고 가정.
public class StoreController {
    @Autowired
    private StoreService storeService;

    // C.R.U.D - Post, Get, (Put, Patch), Delete
    // Create - Post
//    @PostMapping("") // 생성이 되었을 때 생성된 데이터를 반환
    @PostMapping // 생성이 되었을 때 생성된 데이터를 반환
    // Body -> 요청을 받고, 반환
    /*
    {
        "title": "The Great Gatsby",
        "author": "F. Scott Fitzgerald",
        "isbn": "978-3-16-148410-0",
        "publicationDate": "1925-04-10"
    } => key가 안 맞게 데이터를 넣어주면 400 에러를 냄
    * */
    public StoreDTO createStore(@RequestBody StoreDTO store) {
        return storeService.createStore(store);
    }

    // Read - Read (one) / Read All / search, filtering
//    @GetMapping // ("")
//    public List<StoreDTO> findAllStore() {
//        return storeService.findAll();
//    }

    @GetMapping
    public List<StoreDTO> findAllStoreSortByPrice(@RequestParam(required = false) Boolean price) {
        // true은 오름차순으로, false은 내림차순으로
        if (price == null) {
            return storeService.findAll();
        }
        return storeService.findAll(price);
    }

    @GetMapping("/{id}") // id <- 경로에서 ID 받기
    public Optional<StoreDTO> findById(@PathVariable Long id) {
        return storeService.findById(id);
    }

    @GetMapping("/one") // query parameter로 ID 받기 // one?id=1
    public Optional<StoreDTO> findByIdQuery(@RequestParam Long id) {
        return storeService.findById(id);
    }

    @GetMapping("/search/{kwd}")
    public List<StoreDTO> findByKwd(@PathVariable String kwd) {
        return storeService.findByNameKwd(kwd);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        storeService.deleteById(id);
    }

    // Put -> 새로운 걸 넣어서 완전히 대체하겠다
    @PutMapping("/{id}")
    public StoreDTO updateById(@PathVariable Long id, @RequestBody StoreDTO store) {
        // Put으로 넣으면 데이터 전체를 넣어서 한 번 바꾸는게 규약
        return storeService.updateById(id, store);
    }

    @PatchMapping("/{id}/price")
    public StoreDTO changePriceById(@PathVariable Long id, @RequestParam int price) {
        // 하나의 속성만 바꾸는게 규약
        return storeService.changePriceById(id, price);
    }
}
