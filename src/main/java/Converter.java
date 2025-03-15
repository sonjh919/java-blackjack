@FunctionalInterface
public interface Converter<T> {
    T convert(Request<String> request);
}
