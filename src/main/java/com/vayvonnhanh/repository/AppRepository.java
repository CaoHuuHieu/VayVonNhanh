package com.vayvonnhanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vayvonnhanh.entity.AppEntity;

public interface AppRepository extends JpaRepository<AppEntity, Integer>{

}
