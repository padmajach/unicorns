package com.coding.unicorn.auction.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.unicorn.auction.app.vo.Unicorn;

@Repository
public interface UnicornJpaRespository extends JpaRepository<Unicorn, Long>  {

}
