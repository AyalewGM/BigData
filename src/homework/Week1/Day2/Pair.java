package homework.Week1.Day2;

/**
 *
 * @param <K>
 * @param <V>
 */

public class Pair<K,V> {
	public K key;
	public V value;
	Pair(K key, V value){
		this.key=key;
		this.value=value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public String toString(){
		return "< "+String.valueOf(this.key) + " , " +String.valueOf(this.value)+" >";
	}

}
