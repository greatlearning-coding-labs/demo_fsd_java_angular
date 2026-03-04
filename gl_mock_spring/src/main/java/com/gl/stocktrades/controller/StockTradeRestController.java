package com.hackerrank.stocktrades.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.service.StockTradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trades")
public class StockTradeRestController {
  

  @Autowired
  StockTradeService stockTradeService;

  @GetMapping
  public ResponseEntity<List<StockTrade>> getAllStockTrades(@RequestParam(required=false) String type, @RequestParam(required=false) Integer userId) {
    return ResponseEntity.ok(stockTradeService.findAllByTypeAndUserId(type, userId));
  }

  @PostMapping
  public ResponseEntity<StockTrade> addNewStockTrade(@RequestBody StockTrade stockTrade){
    StockTrade createdTrade = null;
    String[] typeArr = {"buy", "sell"};
    if(Arrays.asList(typeArr).contains(stockTrade.getType()) && stockTrade.getShares() > 0 && stockTrade.getShares() <= 100){
      // createdTrade = stockTradeService.addNewStockTrade(stockTrade);
      return ResponseEntity.status(201).body(createdTrade);
    }else {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{id}")

  public ResponseEntity<StockTrade> getStockTradesById(@PathVariable Integer id) {
    Optional<StockTrade> stockTradeOpt = stockTradeService.getStockTradesById(id);
    return stockTradeOpt.isPresent() ? ResponseEntity.ok(stockTradeOpt.get()) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTrade(@PathVariable Integer id){
    return ResponseEntity.status(405).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> putTrade(@PathVariable Integer id){
    return ResponseEntity.status(405).build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Object> patchTrade(@PathVariable Integer id){
    return ResponseEntity.status(405).build();
  }
}