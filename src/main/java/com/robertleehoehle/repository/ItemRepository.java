package com.robertleehoehle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertleehoehle.beans.Items;

public interface ItemRepository extends JpaRepository<Items, Long> { }
