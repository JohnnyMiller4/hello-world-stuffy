package com.stuffy.db;

import org.springframework.data.repository.CrudRepository;

import com.stuffy.business.Stuffy;

//T= type = Stuffy, ID = Integer
public interface StuffyRepository extends CrudRepository<Stuffy, Integer> {

}
