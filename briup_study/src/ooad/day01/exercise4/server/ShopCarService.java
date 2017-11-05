package ooad.day01.exercise4.server;

import java.math.BigDecimal;
import java.util.List;

import ooad.day01.exercise4.bean.Goods;
import ooad.day01.exercise4.bean.ShopCar;

public interface ShopCarService {
	ShopCar queryShopCar();
	BigDecimal getTotal();
	void add(List<Goods> goodses,List<Goods> shopGoods,Goods goods,int number);
	boolean delete(List<Goods> goodses,String name);
}
