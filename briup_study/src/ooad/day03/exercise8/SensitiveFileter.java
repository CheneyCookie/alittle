package ooad.day03.exercise8;
/**
 * 过滤敏感词汇:反动分子、恐怖主义
 * @author cheney
 *
 */
public class SensitiveFileter extends AbstractFilter{

	public SensitiveFileter(String name) {
		super(name);
	}

	@Override
	public String doFilte(String str) {
		String[] filterWords=new String[]{"反动分子","恐怖主义"};
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
