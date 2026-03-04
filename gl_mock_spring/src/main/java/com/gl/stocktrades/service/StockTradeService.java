package com.hackerrank.stocktrades.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockTradeService {

  @Autowired
  StockTradeRepository stockTradeRepository;

  public List<StockTrade> findAllByTypeAndUserId(String type, Integer userId) {
    if (type != null && userId != null) {
      return stockTradeRepository.findAllByTypeAndUserId(type, userId);
    } else if (type != null) {
      return stockTradeRepository.findAllByType(type);
    } else if (userId != null) {
      return stockTradeRepository.findAllByUserId(userId);
    } else {
      return stockTradeRepository.findAll();
    }
  }

  public StockTrade addNewStockTrade(StockTrade stockTrade) {
    return stockTradeRepository.save(stockTrade);
  }

  public Optional<StockTrade> getStockTradesById(Integer id) {
    return stockTradeRepository.findById(id);
  }
  
}