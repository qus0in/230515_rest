package io.playdata.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity // Spring JPA <- JPA => 데이터를 담고 있는, 테이블로 변환이 되는 대상
// Entity - DTO 혼용 => 다르게. DTO는 Data Transfer Object => Table에 저장이 되는 건 아님
// JWT => @Entity 들어가있으면 Entity로 쓰고, 없으면은 DTO. => Clean Architecture
@Data // Lombok - Entity 멤버변수, 속성 => private 접근자로 외부에서 접근할 수 없게
// -> 임의로 수정할 수 없게 함 -> 메소드를 거쳐서 '작업'한다는 명시를 하게 함.
// getter -> 특정한 객체 안에 있는 데이터를 불러와 주는 메소드
// setter -> ... 데이터를 설정해주는 메소드
// Lombok 사용 여부를 ChatGPT한테 알려주면 좀 더 정확한 코드를 받을 수 있음.
@Table(name = "store") // JPA를 통한 테이블 생성 시 명칭 지정
// ** Spring JPA 어노테이션을 통해서 어떠한 설정을 더 할 수 있는지에 대해서
// ChatGPT, 공식 문서, 책, 강의 ... (제약조건, 편의기능)
public class StoreDTO { // store_dto <- jpa
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 인조키 -> 편의에 따라 데이터를 구분해주는 일련의 숫자들을 임의로 만듦
    private Long id;
    private String name;
    private String category;
    private int price;
}
