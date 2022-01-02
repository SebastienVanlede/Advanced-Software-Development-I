package domein;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class MyCollection <T extends Reductiebon> {
	private final Queue<T> lijst;
	public MyCollection() {
		lijst = new ArrayDeque<>();
	}
	
	public void addElement(T x) {
		lijst.offer(x);
	}
	
	public T getElement() {
		return lijst.poll();
	}
	
	public void addReeks(List<? extends T> bonnen) {
		lijst.addAll(bonnen);
	}

	public double gemiddeldPercentage(){
		return lijst.stream().mapToDouble(T::getPercentage).average().getAsDouble();
	}
}
