package p375l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter.java */
/* renamed from: l.e */
/* loaded from: classes2.dex */
public interface InterfaceC5876e<F, T> {

    /* compiled from: Converter.java */
    /* renamed from: l.e$a */
    public static abstract class a {
        /* renamed from: a */
        protected static Type m24754a(int i2, ParameterizedType parameterizedType) {
            return C5887p.m24846a(i2, parameterizedType);
        }

        @Nullable
        /* renamed from: a */
        public InterfaceC5876e<ResponseBody, ?> mo24744a(Type type, Annotation[] annotationArr, C5885n c5885n) {
            return null;
        }

        @Nullable
        /* renamed from: a */
        public InterfaceC5876e<?, RequestBody> mo24745a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C5885n c5885n) {
            return null;
        }

        @Nullable
        /* renamed from: b */
        public InterfaceC5876e<?, String> m24755b(Type type, Annotation[] annotationArr, C5885n c5885n) {
            return null;
        }

        /* renamed from: a */
        protected static Class<?> m24753a(Type type) {
            return C5887p.m24858c(type);
        }
    }

    /* renamed from: a */
    T mo24746a(F f2) throws IOException;
}
