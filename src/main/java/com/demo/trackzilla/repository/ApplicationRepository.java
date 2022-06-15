package com.demo.trackzilla.repository;

import com.demo.trackzilla.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
}
