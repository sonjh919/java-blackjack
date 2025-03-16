package protocol;

public class Request<T> {
    private final T data;

    public Request(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
