package ooad.day01.exercise3;

public enum Permission {
	ADD("添加"),
	DELETE("删除"),
	UPDATE("修改"),
	QUERY("查询");
	
	private final String NAME;
	
	private Permission(String name){
		NAME=name;
	}

	public String getNAME() {
		return NAME;
	}
	
	
}
