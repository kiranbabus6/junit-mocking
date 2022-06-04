package com.kiran.test.jumo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.test.jumo.vos.ItemVo;

public interface ItemRepository extends JpaRepository<ItemVo, Integer>{
	

}
