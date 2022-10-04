package interfaz;

@FunctionalInterface
public interface OperacionGenerica<T> {
	public T operar(T n1, T n2);
}
