package io.playdata.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "store") // JPA를 통한 테이블 생성 시 명칭 지정
public class StoreDTO { // store_dto <- jpa
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    int price;
}
