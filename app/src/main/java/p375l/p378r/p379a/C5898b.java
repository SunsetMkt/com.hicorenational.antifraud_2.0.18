package p375l.p378r.p379a;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import p375l.InterfaceC5876e;

/* compiled from: GsonRequestBodyConverter.java */
/* renamed from: l.r.a.b */
/* loaded from: classes2.dex */
final class C5898b<T> implements InterfaceC5876e<T, RequestBody> {

    /* renamed from: c */
    private static final MediaType f21359c = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: d */
    private static final Charset f21360d = Charset.forName("UTF-8");

    /* renamed from: a */
    private final C2051e f21361a;

    /* renamed from: b */
    private final AbstractC2077y<T> f21362b;

    C5898b(C2051e c2051e, AbstractC2077y<T> abstractC2077y) {
        this.f21361a = c2051e;
        this.f21362b = abstractC2077y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p375l.InterfaceC5876e
    /* renamed from: a */
    public /* bridge */ /* synthetic */ RequestBody mo24746a(Object obj) throws IOException {
        return mo24746a((C5898b<T>) obj);
    }

    @Override // p375l.InterfaceC5876e
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public RequestBody mo24746a(T t) throws IOException {
        Buffer buffer = new Buffer();
        C2055d m5556a = this.f21361a.m5556a((Writer) new OutputStreamWriter(buffer.outputStream(), f21360d));
        this.f21362b.write(m5556a, t);
        m5556a.close();
        return RequestBody.create(f21359c, buffer.readByteString());
    }
}
