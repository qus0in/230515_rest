package io.playdata.rest.repository;

import io.playdata.rest.model.StoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 스프링 컨테이너에 Repository가 존재함을 알려주는 것
// MyBatis -> DB에 쓰이는 SQL 쿼리를 다른 파일에 작성해놓고, 그걸 필요에 따라서 불러쓰는.
// mapper -> 특정한 기능과 특정한 데이터베이스 쿼리를 연결
//public interface StoreRepository extends CrudRepository<StoreDTO, Long> {
public interface StoreRepository extends JpaRepository<StoreDTO, Long> {
    List<StoreDTO> findByNameContaining(String kwd);

    List<StoreDTO> findAllByOrderByPriceAsc();

    List<StoreDTO> findAllByOrderByPriceDesc();

    // save, exists, delete, update, find...
}
