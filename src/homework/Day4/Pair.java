package homework.Day4;

/**
 * Ayalew
 *
 * Pair class
 * @param <K>
 * @param <V>
 */
class Pair<K,V> {
	private K key;
	private V value;
	Pair(K key, V value){
		this.key=key;
		this.value=value;
	}
	public K getKey() {

		return key;
	}

	public V getValue() {

		return value;
	}

	@Override
	public String toString(){

		return "< "+String.valueOf(this.key) + " , " +String.valueOf(this.value)+" >";
	}

}
