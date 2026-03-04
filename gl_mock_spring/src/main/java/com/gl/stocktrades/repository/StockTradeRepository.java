package com.hackerrank.stocktrades.repository;

import java.util.List;

import com.hackerrank.stocktrades.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer> {

  public List<StockTrade> findAll();
  public List<StockTrade> findAllByType(String type);
  public List<StockTrade> findAllByUserId(Integer userId);
  public List<StockTrade> findAllByTypeAndUserId(String type, Integer userId);

}
