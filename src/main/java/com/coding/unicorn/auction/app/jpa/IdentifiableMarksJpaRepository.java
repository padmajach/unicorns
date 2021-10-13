package com.coding.unicorn.auction.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.unicorn.auction.app.vo.IdentifiableMark;

@Repository
public interface IdentifiableMarksJpaRepository extends JpaRepository<IdentifiableMark, Long>{

}
