package m.r.a;

import com.google.gson.l;
import com.google.gson.y;
import java.io.IOException;
import m.e;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GsonResponseBodyConverter.java */
/* JADX INFO: loaded from: classes2.dex */
final class c<T> implements e<ResponseBody, T> {
    private final com.google.gson.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y<T> f12809b;

    c(com.google.gson.e eVar, y<T> yVar) {
        this.a = eVar;
        this.f12809b = yVar;
    }

    @Override // m.e
    public T a(ResponseBody responseBody) throws IOException {
        com.google.gson.e0.a aVarA = this.a.a(responseBody.charStream());
        try {
            T t = this.f12809b.read(aVarA);
            if (aVarA.peek() == com.google.gson.e0.c.END_DOCUMENT) {
                return t;
            }
            throw new l("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
