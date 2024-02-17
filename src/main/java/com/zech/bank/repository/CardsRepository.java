package com.zech.bank.repository;

import java.util.List;

import com.zech.bank.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CardsRepository<C, S> extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);

}
