package ooad.day01.exercise4.server.impl;

import java.math.BigDecimal;
import java.util.List;

import ooad.day01.exercise4.bean.Goods;
import ooad.day01.exercise4.bean.ShopCar;
import ooad.day01.exercise4.server.ShopCarService;

public class ShopCarServiceImpl implements ShopCarService{

	@Override
	public void add(List<Goods> goodses,List<Goods> shopGoods,Goods goods,int number) {
		boolean isHave = false;
		Goods newGoods = null;
		for (Goods goods2 : shopGoods) {
			if (goods.getCode() == goods2.getCode()) {
				goods = goods2;
				isHave = true;
			}
		}
		if (isHave) {
			goods.setNumber(goods.getNumber() + number);
		} else {
			newGoods = new Goods(goods.getCode(),
					goods.getName(), goods.getPrice(),
					number);
			shopGoods.add(newGoods);
		}
	}

	@Override
	public BigDecimal getTotal() {
		return null;
	}

	@Override
	public ShopCar queryShopCar() {
		return null;
	}

	@Override
	public boolean delete(List<Goods> goodses,String name) {
		for (Goods goods : goodses) {
			if(name.trim().equals(goods.getName())){
				goodses.remove(goods);
				return true;
			}
		}
		return false;
	}

}
