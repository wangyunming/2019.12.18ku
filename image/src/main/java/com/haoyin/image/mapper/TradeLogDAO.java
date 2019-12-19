package com.haoyin.image.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.TradeLog;
import com.haoyin.image.entity.TradeLogQuery;

@Mapper
public interface TradeLogDAO {

	TradeLog queryTradeLog(TradeLogQuery query);

	int saveTradeLog(TradeLog tradeLog);

}
