package ooad.day03.exercise8;
/**
 * 过滤字符串长度
 * @author cheney
 *
 */
public class LengthFilter extends AbstractFilter{

	public LengthFilter(String name) {
		super(name);
	}

	@Override
	public String doFilte(String str) {
		if(str.length()>30){
			str=str.substring(0,30);
		}
		if(getFilter()!=null){
			str=getFilter().doFilte(str);
		}
		return str;
	}

}
