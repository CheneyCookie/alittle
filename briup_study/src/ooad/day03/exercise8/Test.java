package ooad.day03.exercise8;

public class Test {
	public static void main(String[] args) {
		AbstractFilter sensitive=new SensitiveFileter("sensitive");
		AbstractFilter system=new SystemFilter("system");
		AbstractFilter length=new LengthFilter("length");
		
		sensitive.setFilter(system);
		system.setFilter(length);
		
		String str="第一个是几个固定的敏感词语不能出现比如反动分子、恐怖主义等等，第二是和系统相关的词语不能出现例如管理员、系统等，第三是文字不能太长，否则就裁剪到超过的长度部分。";
		str=sensitive.doFilte(str);
		System.out.println(str);
		
	}
}
