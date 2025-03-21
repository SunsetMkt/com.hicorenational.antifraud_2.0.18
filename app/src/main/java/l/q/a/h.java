package l.q.a;

import g.a.b0;
import g.a.j0;
import g.a.k0;
import g.a.l;
import g.a.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l.c;
import l.m;
import l.n;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes2.dex */
public final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final j0 f17235a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f17236b;

    private h(@Nullable j0 j0Var, boolean z) {
        this.f17235a = j0Var;
        this.f17236b = z;
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

    @Override // l.c.a
    public l.c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a2 = c.a.a(type);
        if (a2 == g.a.c.class) {
            return new g(Void.class, this.f17235a, this.f17236b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == l.class;
        boolean z4 = a2 == k0.class;
        boolean z5 = a2 == s.class;
        if (a2 != b0.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type a3 = c.a.a(0, (ParameterizedType) type);
        Class<?> a4 = c.a.a(a3);
        if (a4 == m.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = c.a.a(0, (ParameterizedType) a3);
                z = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (a4 == e.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = c.a.a(0, (ParameterizedType) a3);
                z = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = a3;
            z = false;
            z2 = true;
            return new g(type2, this.f17235a, this.f17236b, z, z2, z3, z4, z5, false);
        }
        z2 = false;
        return new g(type2, this.f17235a, this.f17236b, z, z2, z3, z4, z5, false);
    }
}
