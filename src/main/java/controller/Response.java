package controller;

public class Response<T> {
    T data;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
