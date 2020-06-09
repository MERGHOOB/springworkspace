package com.margub.consumer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.margub.consumer.dal.entities.Consumer;

public interface IConsumerRepository extends CrudRepository<Consumer, Long> {

}
