package p375l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p375l.InterfaceC5876e;
import p375l.p380s.InterfaceC5923w;

/* compiled from: BuiltInConverters.java */
/* renamed from: l.a */
/* loaded from: classes2.dex */
final class C5872a extends InterfaceC5876e.a {

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$a */
    static final class a implements InterfaceC5876e<ResponseBody, ResponseBody> {

        /* renamed from: a */
        static final a f21192a = new a();

        a() {
        }

        @Override // p375l.InterfaceC5876e
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public ResponseBody mo24746a(ResponseBody responseBody) throws IOException {
            try {
                return C5887p.m24850a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$b */
    static final class b implements InterfaceC5876e<RequestBody, RequestBody> {

        /* renamed from: a */
        static final b f21193a = new b();

        b() {
        }

        @Override // p375l.InterfaceC5876e
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public RequestBody mo24746a(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$c */
    static final class c implements InterfaceC5876e<ResponseBody, ResponseBody> {

        /* renamed from: a */
        static final c f21194a = new c();

        c() {
        }

        @Override // p375l.InterfaceC5876e
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public ResponseBody mo24746a(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$d */
    static final class d implements InterfaceC5876e<Object, String> {

        /* renamed from: a */
        static final d f21195a = new d();

        d() {
        }

        @Override // p375l.InterfaceC5876e
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public String mo24746a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$e */
    static final class e implements InterfaceC5876e<ResponseBody, Void> {

        /* renamed from: a */
        static final e f21196a = new e();

        e() {
        }

        @Override // p375l.InterfaceC5876e
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Void mo24746a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    C5872a() {
    }

    @Override // p375l.InterfaceC5876e.a
    /* renamed from: a */
    public InterfaceC5876e<ResponseBody, ?> mo24744a(Type type, Annotation[] annotationArr, C5885n c5885n) {
        if (type == ResponseBody.class) {
            return C5887p.m24855a(annotationArr, (Class<? extends Annotation>) InterfaceC5923w.class) ? c.f21194a : a.f21192a;
        }
        if (type == Void.class) {
            return e.f21196a;
        }
        return null;
    }

    @Override // p375l.InterfaceC5876e.a
    /* renamed from: a */
    public InterfaceC5876e<?, RequestBody> mo24745a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C5885n c5885n) {
        if (RequestBody.class.isAssignableFrom(C5887p.m24858c(type))) {
            return b.f21193a;
        }
        return null;
    }
}
