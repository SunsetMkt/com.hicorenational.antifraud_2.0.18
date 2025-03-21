package p375l;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Response.java */
/* renamed from: l.m */
/* loaded from: classes2.dex */
public final class C5884m<T> {

    /* renamed from: a */
    private final Response f21267a;

    /* renamed from: b */
    @Nullable
    private final T f21268b;

    /* renamed from: c */
    @Nullable
    private final ResponseBody f21269c;

    private C5884m(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.f21267a = response;
        this.f21268b = t;
        this.f21269c = responseBody;
    }

    /* renamed from: a */
    public static <T> C5884m<T> m24787a(@Nullable T t) {
        return m24789a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* renamed from: b */
    public int m24792b() {
        return this.f21267a.code();
    }

    @Nullable
    /* renamed from: c */
    public ResponseBody m24793c() {
        return this.f21269c;
    }

    /* renamed from: d */
    public Headers m24794d() {
        return this.f21267a.headers();
    }

    /* renamed from: e */
    public boolean m24795e() {
        return this.f21267a.isSuccessful();
    }

    /* renamed from: f */
    public String m24796f() {
        return this.f21267a.message();
    }

    /* renamed from: g */
    public Response m24797g() {
        return this.f21267a;
    }

    public String toString() {
        return this.f21267a.toString();
    }

    /* renamed from: a */
    public static <T> C5884m<T> m24788a(@Nullable T t, Headers headers) {
        C5887p.m24845a(headers, "headers == null");
        return m24789a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* renamed from: a */
    public static <T> C5884m<T> m24789a(@Nullable T t, Response response) {
        C5887p.m24845a(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new C5884m<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    /* renamed from: a */
    public static <T> C5884m<T> m24786a(int i2, ResponseBody responseBody) {
        if (i2 >= 400) {
            return m24790a(responseBody, new Response.Builder().code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    /* renamed from: a */
    public static <T> C5884m<T> m24790a(ResponseBody responseBody, Response response) {
        C5887p.m24845a(responseBody, "body == null");
        C5887p.m24845a(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new C5884m<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    @Nullable
    /* renamed from: a */
    public T m24791a() {
        return this.f21268b;
    }
}
