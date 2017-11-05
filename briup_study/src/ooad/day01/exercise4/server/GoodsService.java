package ooad.day01.exercise4.server;

import java.math.BigDecimal;
import java.util.List;

import ooad.day01.exercise4.bean.Goods;

public interface GoodsService {
	String add(int code,String name,BigDecimal price,List<Goods> goodses);
	boolean delete(String name,List<Goods> goodses);
	boolean delete(int code,List<Goods> goodses);
	boolean update(String name,BigDecimal price,int number,List<Goods> goodses);
	boolean update(int code,BigDecimal price,int number,List<Goods> goodses);
	Goods queryGoods(String name,List<Goods> goodses);
	Goods queryGoods(int code,List<Goods> goodses);
	void queryAll(List<Goods> goodses);
}
