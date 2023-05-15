package io.playdata.rest.repository;

import io.playdata.rest.model.StoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreDTO, Long> {
}
