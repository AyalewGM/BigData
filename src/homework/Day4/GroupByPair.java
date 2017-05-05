package homework.Day4;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <K>
 * @param <V>
 */
public class GroupByPair<K,V> {
	private K key;
	private List<V> listValue;
	
	public GroupByPair(K key, V value){
		this.listValue=new ArrayList<>();
		this.key=key;
		listValue.add(value);
	}
	public GroupByPair(K key, List<V> values){
		this.key=key;
		this.listValue=values;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public List<V> getListValue() {
		return listValue;
	}
	public void setListValue(List<V> listValue) {
		this.listValue = listValue;
	}
	@Override
	public String toString(){

		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("< "+String.valueOf(this.key)+ " , [");
		for(V value : listValue){
			stringBuilder.append(String.valueOf(value)+",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.append("]>");
		
		return stringBuilder.toString();
	}

}
