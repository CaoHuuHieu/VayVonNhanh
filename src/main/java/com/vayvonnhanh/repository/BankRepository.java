package com.vayvonnhanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vayvonnhanh.entity.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Integer>{

}
