package m;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T> {
    private final Response a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f12746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ResponseBody f12747c;

    private m(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.a = response;
        this.f12746b = t;
        this.f12747c = responseBody;
    }

    public static <T> m<T> a(@Nullable T t) {
        return a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public int b() {
        return this.a.code();
    }

    @Nullable
    public ResponseBody c() {
        return this.f12747c;
    }

    public Headers d() {
        return this.a.headers();
    }

    public boolean e() {
        return this.a.isSuccessful();
    }

    public String f() {
        return this.a.message();
    }

    public Response g() {
        return this.a;
    }

    public String toString() {
        return this.a.toString();
    }

    public static <T> m<T> a(@Nullable T t, Headers headers) {
        p.a(headers, "headers == null");
        return a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> m<T> a(@Nullable T t, Response response) {
        p.a(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new m<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> m<T> a(int i2, ResponseBody responseBody) {
        if (i2 >= 400) {
            return a(responseBody, new Response.Builder().code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> m<T> a(ResponseBody responseBody, Response response) {
        p.a(responseBody, "body == null");
        p.a(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new m<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    @Nullable
    public T a() {
        return this.f12746b;
    }
}
