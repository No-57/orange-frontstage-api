package com.orange.main.price.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.orange.main.price.bo.Price;

public interface PriceRepository  extends PagingAndSortingRepository<Price, Long>{ 

}
