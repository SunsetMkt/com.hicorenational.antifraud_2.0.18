package p375l.p378r.p379a;

import com.google.gson.C2051e;
import com.google.gson.p152d0.C2049a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p375l.C5885n;
import p375l.InterfaceC5876e;

/* compiled from: GsonConverterFactory.java */
/* renamed from: l.r.a.a */
/* loaded from: classes2.dex */
public final class C5897a extends InterfaceC5876e.a {

    /* renamed from: a */
    private final C2051e f21358a;

    private C5897a(C2051e c2051e) {
        this.f21358a = c2051e;
    }

    /* renamed from: a */
    public static C5897a m24871a() {
        return m24872a(new C2051e());
    }

    /* renamed from: a */
    public static C5897a m24872a(C2051e c2051e) {
        if (c2051e != null) {
            return new C5897a(c2051e);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // p375l.InterfaceC5876e.a
    /* renamed from: a */
    public InterfaceC5876e<ResponseBody, ?> mo24744a(Type type, Annotation[] annotationArr, C5885n c5885n) {
        return new C5899c(this.f21358a, this.f21358a.m5557a((C2049a) C2049a.get(type)));
    }

    @Override // p375l.InterfaceC5876e.a
    /* renamed from: a */
    public InterfaceC5876e<?, RequestBody> mo24745a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C5885n c5885n) {
        return new C5898b(this.f21358a, this.f21358a.m5557a((C2049a) C2049a.get(type)));
    }
}
