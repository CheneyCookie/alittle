package ooad.day03.exercise8;
/**
 * 过滤系统词汇
 * @author cheney
 *
 */
public class SystemFilter extends AbstractFilter{

	public SystemFilter(String name) {
		super(name);
	}

	@Override
	public String doFilte(String str) {
		String[] filterWords=new String[]{"管理员","系统"};
		CharSequence newChar="***";
		for(int i=0;i<filterWords.length;i++){
			if(str.contains(filterWords[i])){
				str=str.replace(filterWords[i], newChar);
			}
		}
		if(getFilter()!=null){
			str=getFilter().doFilte(str);
		}
		return str;
	}

}
