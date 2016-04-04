package system;

import java.io.Serializable;
import java.util.Comparator;

public class SerializableComparator<T>  implements Serializable, Comparator<T>{

	private static final long serialVersionUID = 9162311846120506134L;

	public SerializableComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
