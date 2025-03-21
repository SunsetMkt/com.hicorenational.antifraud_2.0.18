package p375l;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import p286h.C5230f1;

/* compiled from: RequestBuilder.java */
/* renamed from: l.l */
/* loaded from: classes2.dex */
final class C5883l {

    /* renamed from: k */
    private static final char[] f21253k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: l */
    private static final String f21254l = " \"<>^`{}|\\?#";

    /* renamed from: a */
    private final String f21255a;

    /* renamed from: b */
    private final HttpUrl f21256b;

    /* renamed from: c */
    @Nullable
    private String f21257c;

    /* renamed from: d */
    @Nullable
    private HttpUrl.Builder f21258d;

    /* renamed from: e */
    private final Request.Builder f21259e = new Request.Builder();

    /* renamed from: f */
    @Nullable
    private MediaType f21260f;

    /* renamed from: g */
    private final boolean f21261g;

    /* renamed from: h */
    @Nullable
    private MultipartBody.Builder f21262h;

    /* renamed from: i */
    @Nullable
    private FormBody.Builder f21263i;

    /* renamed from: j */
    @Nullable
    private RequestBody f21264j;

    /* compiled from: RequestBuilder.java */
    /* renamed from: l.l$a */
    private static class a extends RequestBody {

        /* renamed from: a */
        private final RequestBody f21265a;

        /* renamed from: b */
        private final MediaType f21266b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f21265a = requestBody;
            this.f21266b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f21265a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f21266b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f21265a.writeTo(bufferedSink);
        }
    }

    C5883l(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f21255a = str;
        this.f21256b = httpUrl;
        this.f21257c = str2;
        this.f21260f = mediaType;
        this.f21261g = z;
        if (headers != null) {
            this.f21259e.headers(headers);
        }
        if (z2) {
            this.f21263i = new FormBody.Builder();
        } else if (z3) {
            this.f21262h = new MultipartBody.Builder();
            this.f21262h.setType(MultipartBody.FORM);
        }
    }

    /* renamed from: a */
    void m24778a(Object obj) {
        this.f21257c = obj.toString();
    }

    /* renamed from: b */
    void m24784b(String str, String str2, boolean z) {
        String str3 = this.f21257c;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f21257c = str3.replace("{" + str + "}", m24775a(str2, z));
    }

    /* renamed from: c */
    void m24785c(String str, @Nullable String str2, boolean z) {
        String str3 = this.f21257c;
        if (str3 != null) {
            this.f21258d = this.f21256b.newBuilder(str3);
            if (this.f21258d == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f21256b + ", Relative: " + this.f21257c);
            }
            this.f21257c = null;
        }
        if (z) {
            this.f21258d.addEncodedQueryParameter(str, str2);
        } else {
            this.f21258d.addQueryParameter(str, str2);
        }
    }

    /* renamed from: a */
    void m24779a(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f21259e.addHeader(str, str2);
            return;
        }
        MediaType parse = MediaType.parse(str2);
        if (parse != null) {
            this.f21260f = parse;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    /* renamed from: a */
    private static String m24775a(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt >= 32 && codePointAt < 127 && f21254l.indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i2 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i2);
                m24776a(buffer, str, i2, length, z);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    /* renamed from: a */
    private static void m24776a(Buffer buffer, String str, int i2, int i3, boolean z) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && f21254l.indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & C5230f1.f20085c;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f21253k[(readByte >> 4) & 15]);
                        buffer.writeByte((int) f21253k[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    void m24780a(String str, String str2, boolean z) {
        if (z) {
            this.f21263i.addEncoded(str, str2);
        } else {
            this.f21263i.add(str, str2);
        }
    }

    /* renamed from: a */
    void m24781a(Headers headers, RequestBody requestBody) {
        this.f21262h.addPart(headers, requestBody);
    }

    /* renamed from: a */
    void m24782a(MultipartBody.Part part) {
        this.f21262h.addPart(part);
    }

    /* renamed from: a */
    void m24783a(RequestBody requestBody) {
        this.f21264j = requestBody;
    }

    /* renamed from: a */
    Request m24777a() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f21258d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f21256b.resolve(this.f21257c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f21256b + ", Relative: " + this.f21257c);
            }
        }
        RequestBody requestBody = this.f21264j;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.f21263i;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f21262h;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.f21261g) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f21260f;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new a(requestBody, mediaType);
            } else {
                this.f21259e.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.f21259e.url(resolve).method(this.f21255a, requestBody).build();
    }
}
