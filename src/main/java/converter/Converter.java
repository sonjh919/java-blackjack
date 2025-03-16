package converter;

@FunctionalInterface
public interface Converter<T> {
    T convert(String request);
}
