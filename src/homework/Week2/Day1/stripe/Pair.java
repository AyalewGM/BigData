package homework.Week2.Day1.stripe;

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

		return "( "+String.valueOf(this.key) + " , " +String.valueOf(this.value)+" )";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pair)) return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
		return value != null ? value.equals(pair.value) : pair.value == null;
	}

	@Override
	public int hashCode() {
		int result = key != null ? key.hashCode() : 0;
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}
}
