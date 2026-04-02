package m.r.a;

import com.google.gson.y;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import m.e;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes2.dex */
final class b<T> implements e<T, RequestBody> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MediaType f12806c = MediaType.parse("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f12807d = Charset.forName("UTF-8");
    private final com.google.gson.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y<T> f12808b;

    b(com.google.gson.e eVar, y<T> yVar) {
        this.a = eVar;
        this.f12808b = yVar;
    }

    @Override // m.e
    public RequestBody a(T t) throws IOException {
        Buffer buffer = new Buffer();
        com.google.gson.e0.d dVarA = this.a.a((Writer) new OutputStreamWriter(buffer.outputStream(), f12807d));
        this.f12808b.write(dVarA, t);
        dVarA.close();
        return RequestBody.create(f12806c, buffer.readByteString());
    }
}
