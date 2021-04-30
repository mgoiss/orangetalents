package com.vobidu.orangetalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vobidu.orangetalents.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {

}
