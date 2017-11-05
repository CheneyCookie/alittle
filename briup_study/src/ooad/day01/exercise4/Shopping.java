package ooad.day01.exercise4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ooad.day01.exercise4.bean.Goods;
import ooad.day01.exercise4.bean.Role;
import ooad.day01.exercise4.bean.ShopCar;
import ooad.day01.exercise4.bean.User;
import ooad.day01.exercise4.server.GoodsService;
import ooad.day01.exercise4.server.ShopCarService;
import ooad.day01.exercise4.server.UserService;
import ooad.day01.exercise4.server.impl.GoodsServiceImpl;
import ooad.day01.exercise4.server.impl.ShopCarServiceImpl;
import ooad.day01.exercise4.server.impl.UserServiceImpl;

public class Shopping {
	static Scanner sc;
	static List<User> users;
	static List<Goods> goodses;
	GoodsService goodsService = new GoodsServiceImpl();
	UserService userServer = new UserServiceImpl();
	ShopCarService shopCarService = new ShopCarServiceImpl();
	List<ShopCar> shopCars = new ArrayList<ShopCar>();

	public static void main(String[] args) {
		Shopping shopping = new Shopping();
		sc = new Scanner(System.in);
		users = new ArrayList<User>();
		User user = new User(1, "cheney", "121716", Role.SUPER_ADMIN);
		users.add(user);
		goodses = new ArrayList<Goods>();
		Goods goods1 = new Goods(1001, "苹果", new BigDecimal(5));
		Goods goods2 = new Goods(1002, "香蕉", new BigDecimal(2.5));
		Goods goods3 = new Goods(1003, "雪梨", new BigDecimal(3.5));
		Goods goods4 = new Goods(1004, "西瓜", new BigDecimal(2));
		goodses.add(goods1);
		goodses.add(goods2);
		goodses.add(goods3);
		goodses.add(goods4);

		while (true) {
			System.out.println("-------- 首页 --------");
			System.out.println("------- 1.登录 -------");
			System.out.println("------- 2.注册 -------");
			System.out.println("------- 3.退出 -------");
			int indexChoose = sc.nextInt();

			switch (indexChoose) {
			case 1:
				shopping.toLogin();
				break;
			case 2:
				shopping.toRegister();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("非法操作!请输入1，2，3");
				break;
			}
		}
	}

	private void toRegister() {
		while(true){
			System.out.println("--- 注册 ---");
			System.out.println("输入out退出注册");
			System.out.println("请输入用户名：");
			String name = sc.next();
			if(name.equals("out")){
				break;
			}
			boolean message1 = userServer.isExist(name, users);
			if (message1==true) {
				System.out.println("用户名已存在");
				continue;
			}
			System.out.println("请输入密码：");
			String password = sc.next();
			System.out.println("请确认密码：");
			String rePassword = sc.next();
			String message = userServer.register(name, password, rePassword, users);
			if (message.equals("notEqual")) {
				System.out.println("密码不一致");
			} else {
				System.out.println("注册成功");
				toLogin();
				break;
			}
		}
	}

	private void toLogin() {
		while (true) {
			System.out.println("--- 登录 ---");
			System.out.println("请输入用户名：");
			String name = sc.next();

			System.out.println("请输入密码：");
			String password = sc.next();

			String message = userServer.login(name, password, users);
			loginSuccess(message, name);
			if (message.equals("false")) {
				System.out.println("用户名或密码错误");
				continue;
			}

		}
	}

	private void loginSuccess(String message, String name) {
		while (true) {
			boolean flag=false;
			if (message.equals("sa")) {
				System.out.println("------- ag:添加商品 -------");
				System.out.println("------- dg:删除商品 -------");
				System.out.println("------- ug:更新商品 -------");
				System.out.println("------- qg:查看商品 -------");
				System.out.println("----- qag:查看所有商品  -----");
				System.out.println("------- qu:查看用户 -------");
				System.out.println("----- qau:查看所有用户  -----");
				System.out.println("------- up:更改角色 -------");
				System.out.println("----- out.退出登录 ------");
				System.out.println("------ exit.退出登录 ------");

			} else if (message.equals("a")) {
				System.out.println("------- ag:添加商品 -------");
				System.out.println("------- ug:更新商品 -------");
				System.out.println("------- qg:查看商品 -------");
				System.out.println("----- qag:查看所有商品  -----");
				System.out.println("------- qu:查看用户 -------");
				System.out.println("----- qau:查看所有用户  -----");
				System.out.println("----- out.退出登录 ------");
				System.out.println("------ exit.退出登录 ------");
			} else if (message.equals("m")) {
				ShopCar shopCar = null;
				boolean isHaveCar = false;
				User user = null;
				for (User user2 : users) {
					if (user2.getName().equals(name)) {
						user = user2;
					}
				}
				for (ShopCar shopCar2 : shopCars) {
					if (shopCar.getUser().getName()
							.equals(shopCar2.getUser().getName())) {
						shopCar = shopCar2;
						isHaveCar = true;
					}
				}
				if (!isHaveCar) {

					shopCar = new ShopCar(user);
				}
				while (true) {
					System.out.println("------- 1.添加商品 -------");
					System.out.println("----- 2.查看购物车商品 -----");
					System.out.println("----- 3.删除购物车商品 -----");
					System.out.println("----- 4.清空购物车商品 -----");
					System.out.println("----- out.退出登录 ------");
					System.out.println("----- exit.退出登录 ------");

					String shopStr = sc.next();
					if (shopStr.equals("out")) {
						break;
					}
					if (shopStr.equals("exit")) {
						System.exit(0);
					}
					if (shopStr.equals("1")) {
						addShopCar(shopCar);
					}
					if (shopStr.equals("2")) {
						List<Goods> goodses2 = shopCar.getGoodses();
						for (Goods goods : goodses2) {
							System.out.println(goods);
						}
					}
					if (shopStr.equals("3")) {
						List<Goods> goodses2 = shopCar.getGoodses();
						System.out.println("请输入要删除的商品名");
						String name1 = sc.next();
						boolean flag1 = shopCarService.delete(goodses2, name1);
						if (flag1 == true) {
							System.out.println("删除成功");
						} else {
							System.out.println("删除失败，购物车中没有该商品");
						}
					}
					if (shopStr.equals("4")) {
						shopCar.getGoodses().removeAll(shopCar.getGoodses());
					}

				}
			}
			String selection = sc.next();
			
			switch (selection) {
			case "ag":
				addGoods();
				break;
			case "dg":
				deleteGoods();
				break;
			case "ug":
				updateGoods();
				break;
			case "qg":
				queryGoods();
				break;
			case "qag":
				goodsService.queryAll(goodses);
				break;
			case "qu":
				System.out.println("请输入用户名");
				String name1 = sc.next();
				userServer.query(name1, users);
				break;
			case "qau":
				System.out.println("所有用户如下");
				for (User user : users) {
					System.out.println(user);
				}
				break;
			case "out":
				flag=true;
				break;
			case "exit":
				System.exit(0);
				break;
			case "up":
				System.out.println("请输入要更改角色的用户名");
				String nameP = sc.next();

				setPermission(nameP);
				break;

			default:
				System.out.println("输入有误，请检查!");
				break;
			}
			if(flag==true){
				break;
			}
		}
	}

	private void addShopCar(ShopCar shopCar) {
		for (Goods goods : goodses) {
			System.out.println(goods);
		}
		List<Goods> shopGoods = shopCar.getGoodses();
		System.out.println();
		while (true) {
			System.out.println("请选择要购买的商品及数量\"-\"分隔,例如：1001-2");
			System.out.println("输入\"ok\"完成购买");
			String buyGoods = sc.next();
			if (buyGoods.equals("ok")) {
				break;
			}
			int code = Integer.parseInt(buyGoods.split("-")[0]);
			int number = Integer.parseInt(buyGoods.split("-")[1]);
			Goods goods = goodsService.queryGoods(code, goodses);
			if (goods != null) {
				goods.setNumber(goods.getNumber() - number);
				shopCarService.add(shopGoods, shopGoods, goods, number);
			} else {
				System.out.println("此商品不存在");
			}
		}
	}

	private void setPermission(String nameP) {
		boolean isExist = userServer.query(nameP, users);
		if (isExist) {
			System.out.println("---- 1.超级管理员 ----");
			System.out.println("---- 2.管理员 ----");
			System.out.println("---- 3.普通用户 -----");
			System.out.println();
			Role role = null;
			while (true) {
				System.out.println("请输入 要更设置的角色");
				int permission = sc.nextInt();

				if (permission == 1) {
					role = Role.SUPER_ADMIN;
					break;
				} else if (permission == 2) {
					role = Role.GENERAL_ADMIN;
					break;
				} else if (permission == 3) {
					role = Role.MEMBER;
					break;
				} else {
					System.out.println("设置错误请检查");
				}
			}
			userServer.setPermission(nameP, role, users);
		} else {
			System.out.println("该用户不存在");
		}
	}

	private void queryGoods() {
		while (true) {
			System.out.println("----- code:根据商品编号查看 -----");
			System.out.println("----- name:根据商品名查看 ------");
			System.out.println("----- back:返回上一层 ------");
			String queryStr = sc.next();
			if (queryStr.equals("back")) {
				break;
			} else if (queryStr.equals("code")) {
				while (true) {

					System.out.println("请输入商品编号");
					System.out.println("输入back返回上一层");
					String code = sc.next();
					if (code.equals("back")) {
						break;
					}
					Goods goods = goodsService.queryGoods(
							Integer.parseInt(code), goodses);
					System.out.println(goods);
				}
			} else if (queryStr.equals("name")) {
				while (true) {

					System.out.println("请输入商品编号");
					System.out.println("输入back返回上一层");
					String name = sc.next();
					if (name.equals("back")) {
						break;
					}
					Goods goods = goodsService.queryGoods(name, goodses);
					System.out.println(goods);
				}
			} else {
				System.out.println("输入有误，请检查!");
			}

		}
	}

	private void updateGoods() {
		while (true) {
			System.out.println("----- code:根据商品编号更新 -----");
			System.out.println("----- name:根据商品名更新 ------");
			System.out.println("----- back:返回上一层 ------");
			String deleteStr = sc.next();
			if (deleteStr.equals("back")) {
				break;
			} else if (deleteStr.equals("code")) {
				while (true) {
					System.out.println("请输入要更新商品的编号");
					System.out.println("输入back返回上一层");
					String code = sc.next();
					if (code.equals("back")) {
						break;
					}
					boolean flag = goodsService.delete(Integer.parseInt(code),
							goodses);
					if (flag == true) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败，该编号不存在");
					}
				}
			} else if (deleteStr.equals("name")) {
				while (true) {
					System.out.println("请输入要删除商品的编号");
					System.out.println("输入back返回上一层");
					String name = sc.next();
					if (name.equals("back")) {
						break;
					}
					boolean flag = goodsService.delete(name, goodses);
					if (flag == true) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败，该编号不存在");
					}
				}
			} else {
				System.out.println("输入有误，请检查!");
			}

		}
	}

	private void deleteGoods() {
		while (true) {
			System.out.println("----- code:根据商品编号删除 -----");
			System.out.println("----- name:根据商品名删除 ------");
			System.out.println("----- back:返回上一层 ------");
			String deleteStr = sc.next();
			if (deleteStr.equals("back")) {
				break;
			} else if (deleteStr.equals("code")) {
				while (true) {
					System.out.println("请输入要删除商品的编号");
					System.out.println("输入back返回上一层");
					String code = sc.next();
					if (code.equals("back")) {
						break;
					}
					System.out.println("请输入价格");
					int priceInt = sc.nextInt();
					BigDecimal price = new BigDecimal(priceInt);
					System.out.println("请输入数量");
					int number = sc.nextInt();
					boolean flag = goodsService.update(code, price, number,
							goodses);
					if (flag == true) {
						System.out.println("更新成功");
					} else {
						System.out.println("更新失败，该编号不存在");
					}
				}
			} else if (deleteStr.equals("name")) {
				while (true) {
					System.out.println("请输入要删除商品名");
					System.out.println("输入back返回上一层");
					String name = sc.next();
					if (name.equals("back")) {
						break;
					}
					System.out.println("请输入价格");
					int priceInt = sc.nextInt();
					BigDecimal price = new BigDecimal(priceInt);
					System.out.println("请输入数量");
					int number = sc.nextInt();
					boolean flag = goodsService.update(name, price, number,
							goodses);
					if (flag == true) {
						System.out.println("更新成功");
					} else {
						System.out.println("更新失败，该商品不存在");
					}
				}
			} else {
				System.out.println("输入有误，请检查!");
			}

		}
	}

	private void addGoods() {
		while (true) {
			try {
				System.out.println("----- 请输入商品信息，例：1001-苹果-5 -----");
				System.out.println("----- 输入back返回上一层 -----");
				String message = sc.next();
				if (message.equals("back")) {
					break;
				}
				String[] msg = message.split("-");
				String code = msg[0].trim();
				String name = msg[1].trim();
				String price = msg[2].trim();
				String reMsg = goodsService.add(Integer.parseInt(code), name,
						new BigDecimal(price), goodses);
				if (reMsg.equals("isExist")) {
					System.out.println("商品已存在!");
				} else {
					System.out.println("添加成功!");
				}
			} catch (Exception e) {
				System.out.println("格式不正确 !");
			}

		}
	}
}
