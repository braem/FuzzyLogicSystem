package system;

/**
 * This is a generic class to represent a pair of objects.
 * @author The Internet
 *
 * @param <K> Formal type parameter for the first pair element
 * @param <V> Formal type parameter for the second pair element.
 */

public class Pair<K, V>{
	   private K first;
	   private V second;
	   
	   /**
	    * Constructs a new K V pair
	    * @param first The first element of the pair
	    * @param second The second element of the pair
	    */
	   public Pair(K first, V second){
	     this.first = first;
	     this.second = second;
	   }

	   /**
	    * Sets the first element of the pair
	    * @param first The first element of the pair
	    */
	   public void setFirst(K first){
	    this.first = first;
	   }

	   /**
	    * Sets the second element of the pair
	    * @param second The second element of the pair
	    */
	   public void setSecond(V second) {
	     this.second = second;
	   }

	   /**
	    * Returns the first element of the pair
	    * @return first The first element of the pair
	    */
	   public K getFirst() {
	     return this.first;
	   }

	   /**
	    * Returns the second element of the pair
	    * @return second The second element of the pair
	    */
	   public V getSecond() {
	     return this.second;
	   }
	}

