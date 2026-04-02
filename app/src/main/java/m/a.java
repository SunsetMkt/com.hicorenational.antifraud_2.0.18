package m;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import m.e;
import m.s.w;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends e.a {

    /* JADX INFO: renamed from: m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class C0269a implements m.e<ResponseBody, ResponseBody> {
        static final C0269a a = new C0269a();

        C0269a() {
        }

        @Override // m.e
        public ResponseBody a(ResponseBody responseBody) throws IOException {
            try {
                return p.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class b implements m.e<RequestBody, RequestBody> {
        static final b a = new b();

        b() {
        }

        @Override // m.e
        public RequestBody a(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class c implements m.e<ResponseBody, ResponseBody> {
        static final c a = new c();

        c() {
        }

        @Override // m.e
        public ResponseBody a(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class d implements m.e<Object, String> {
        static final d a = new d();

        d() {
        }

        @Override // m.e
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class e implements m.e<ResponseBody, Void> {
        static final e a = new e();

        e() {
        }

        @Override // m.e
        public Void a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    a() {
    }

    @Override // m.e.a
    public m.e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (type == ResponseBody.class) {
            return p.a(annotationArr, (Class<? extends Annotation>) w.class) ? c.a : C0269a.a;
        }
        if (type == Void.class) {
            return e.a;
        }
        return null;
    }

    @Override // m.e.a
    public m.e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        if (RequestBody.class.isAssignableFrom(p.c(type))) {
            return b.a;
        }
        return null;
    }
}
