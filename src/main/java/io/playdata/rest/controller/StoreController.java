package io.playdata.rest.controller;

import io.playdata.rest.model.StoreDTO;
import io.playdata.rest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Controller <-> RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    // C.R.U.D
    // Create - Post
//    @PostMapping("") // 생성이 되었을 때 생성된 데이터를 반환
    @PostMapping // 생성이 되었을 때 생성된 데이터를 반환
    // Body -> 요청을 받고, 반환
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
}
