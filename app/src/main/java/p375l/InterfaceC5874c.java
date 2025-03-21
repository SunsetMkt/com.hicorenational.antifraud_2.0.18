package p375l;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: CallAdapter.java */
/* renamed from: l.c */
/* loaded from: classes2.dex */
public interface InterfaceC5874c<R, T> {

    /* compiled from: CallAdapter.java */
    /* renamed from: l.c$a */
    public static abstract class a {
        /* renamed from: a */
        protected static Type m24751a(int i2, ParameterizedType parameterizedType) {
            return C5887p.m24846a(i2, parameterizedType);
        }

        @Nullable
        /* renamed from: a */
        public abstract InterfaceC5874c<?, ?> mo24752a(Type type, Annotation[] annotationArr, C5885n c5885n);

        /* renamed from: a */
        protected static Class<?> m24750a(Type type) {
            return C5887p.m24858c(type);
        }
    }

    /* renamed from: a */
    T mo24748a(InterfaceC5873b<R> interfaceC5873b);

    /* renamed from: a */
    Type mo24749a();
}
