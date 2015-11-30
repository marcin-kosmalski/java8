package exceptions;

@FunctionalInterface
public interface ExceptionHandler<T,R, X extends Throwable> {
	R accept(T instance) throws X;

}
