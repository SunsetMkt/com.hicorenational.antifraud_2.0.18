package m;

import i.f1;
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

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char[] f12734k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f12735l = " \"<>^`{}|\\?#";
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpUrl f12736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f12737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private HttpUrl.Builder f12738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Request.Builder f12739e = new Request.Builder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private MediaType f12740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f12741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private MultipartBody.Builder f12742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private FormBody.Builder f12743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private RequestBody f12744j;

    /* JADX INFO: compiled from: RequestBuilder.java */
    private static class a extends RequestBody {
        private final RequestBody a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaType f12745b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.a = requestBody;
            this.f12745b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f12745b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.a.writeTo(bufferedSink);
        }
    }

    l(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.a = str;
        this.f12736b = httpUrl;
        this.f12737c = str2;
        this.f12740f = mediaType;
        this.f12741g = z;
        if (headers != null) {
            this.f12739e.headers(headers);
        }
        if (z2) {
            this.f12743i = new FormBody.Builder();
        } else if (z3) {
            this.f12742h = new MultipartBody.Builder();
            this.f12742h.setType(MultipartBody.FORM);
        }
    }

    void a(Object obj) {
        this.f12737c = obj.toString();
    }

    void b(String str, String str2, boolean z) {
        String str3 = this.f12737c;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f12737c = str3.replace("{" + str + "}", a(str2, z));
    }

    void c(String str, @Nullable String str2, boolean z) {
        String str3 = this.f12737c;
        if (str3 != null) {
            this.f12738d = this.f12736b.newBuilder(str3);
            if (this.f12738d == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f12736b + ", Relative: " + this.f12737c);
            }
            this.f12737c = null;
        }
        if (z) {
            this.f12738d.addEncodedQueryParameter(str, str2);
        } else {
            this.f12738d.addQueryParameter(str, str2);
        }
    }

    void a(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f12739e.addHeader(str, str2);
            return;
        }
        MediaType mediaType = MediaType.parse(str2);
        if (mediaType != null) {
            this.f12740f = mediaType;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && f12735l.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                a(buffer, str, iCharCount, length, z);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    private static void a(Buffer buffer, String str, int i2, int i3, boolean z) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && f12735l.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        int i4 = buffer2.readByte() & f1.f12066c;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f12734k[(i4 >> 4) & 15]);
                        buffer.writeByte((int) f12734k[i4 & 15]);
                    }
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z) {
        if (z) {
            this.f12743i.addEncoded(str, str2);
        } else {
            this.f12743i.add(str, str2);
        }
    }

    void a(Headers headers, RequestBody requestBody) {
        this.f12742h.addPart(headers, requestBody);
    }

    void a(MultipartBody.Part part) {
        this.f12742h.addPart(part);
    }

    void a(RequestBody requestBody) {
        this.f12744j = requestBody;
    }

    Request a() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.f12738d;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.f12736b.resolve(this.f12737c);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f12736b + ", Relative: " + this.f12737c);
            }
        }
        RequestBody aVar = this.f12744j;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f12743i;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f12742h;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f12741g) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f12740f;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f12739e.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.f12739e.url(httpUrlResolve).method(this.a, aVar).build();
    }
}
