package m.q.a;

import h.a.b0;
import h.a.j0;
import h.a.k0;
import h.a.l;
import h.a.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import m.c;
import m.m;
import m.n;

/* JADX INFO: compiled from: RxJava2CallAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends c.a {

    @Nullable
    private final j0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12805b;

    private h(@Nullable j0 j0Var, boolean z) {
        this.a = j0Var;
        this.f12805b = z;
    }

    public static h a() {
        return new h(null, false);
    }

    public static h b() {
        return new h(null, true);
    }

    public static h a(j0 j0Var) {
        if (j0Var != null) {
            return new h(j0Var, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // m.c.a
    public m.c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        Type typeA;
        boolean z;
        boolean z2;
        Class<?> clsA = c.a.a(type);
        if (clsA == h.a.c.class) {
            return new g(Void.class, this.a, this.f12805b, false, true, false, false, false, true);
        }
        boolean z3 = clsA == l.class;
        boolean z4 = clsA == k0.class;
        boolean z5 = clsA == s.class;
        if (clsA != b0.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeA2 = c.a.a(0, (ParameterizedType) type);
        Class<?> clsA2 = c.a.a(typeA2);
        if (clsA2 == m.class) {
            if (typeA2 instanceof ParameterizedType) {
                typeA = c.a.a(0, (ParameterizedType) typeA2);
                z = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (clsA2 == e.class) {
            if (typeA2 instanceof ParameterizedType) {
                typeA = c.a.a(0, (ParameterizedType) typeA2);
                z = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            typeA = typeA2;
            z = false;
            z2 = true;
            return new g(typeA, this.a, this.f12805b, z, z2, z3, z4, z5, false);
        }
        z2 = false;
        return new g(typeA, this.a, this.f12805b, z, z2, z3, z4, z5, false);
    }
}
