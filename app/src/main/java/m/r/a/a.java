package m.r.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import m.e;
import m.n;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.a {
    private final com.google.gson.e a;

    private a(com.google.gson.e eVar) {
        this.a = eVar;
    }

    public static a a() {
        return a(new com.google.gson.e());
    }

    public static a a(com.google.gson.e eVar) {
        if (eVar != null) {
            return new a(eVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // m.e.a
    public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        return new c(this.a, this.a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(type)));
    }

    @Override // m.e.a
    public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        return new b(this.a, this.a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(type)));
    }
}
