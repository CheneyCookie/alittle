package ooad.day01.exercise4.server.impl;

import java.math.BigDecimal;
import java.util.List;

import ooad.day01.exercise4.bean.Goods;
import ooad.day01.exercise4.server.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	private static int increaseCode=1005;

	@Override
	public String add(int code, String name, BigDecimal price,
			List<Goods> goodses) {
		for (Goods goods : goodses) {
			if(name.equals(goods.getName())){
				return "isExist";
			}
		}
		
		Goods goods=new Goods(code,name,price);
		goodses.add(goods);
		increaseCode++;
		return "success";
	}

	@Override
	public boolean delete(String name, List<Goods> goodses) {
		for (Goods goods : goodses) {
			if(name.equals(goods.getName())){
				goodses.remove(goods);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int code, List<Goods> goodses) {
		for (Goods goods : goodses) {
			if(code==goods.getCode()){
				goodses.remove(goods);
				return true;
			}
		}
		return false;
	}

	@Override
	public Goods queryGoods(String name, List<Goods> goodses) {
		Goods qGoods=null;
		for (Goods goods : goodses) {
			if(name.equals(goods.getName())){
				qGoods=goods;
			}
		}
		return qGoods;
	}

	@Override
	public void queryAll(List<Goods> goodses) {
		for (Goods goods : goodses) {
			System.out.println(goods);
		}
	}

	@Override
	public boolean update(String name, BigDecimal price, int number,
			List<Goods> goodses) {
		for (Goods goods : goodses) {
			if(name.equals(goods.getName())){
				goods.setPrice(price);
				goods.setNumber(number);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(int code, BigDecimal price, int number,
			List<Goods> goodses) {
		for (Goods goods : goodses) {
			if(code==goods.getCode()){
				goods.setPrice(price);
				goods.setNumber(number);
				return true;
			}
		}
		return false;
	}

	@Override
	public Goods queryGoods(int code, List<Goods> goodses) {
		Goods qGoods=null;
		for (Goods goods : goodses) {
			if(code==goods.getCode()){
				qGoods=goods;
			}
		}
		return qGoods;
	}

}
