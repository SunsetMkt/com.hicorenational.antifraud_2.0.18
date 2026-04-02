package m;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import m.c;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends c.a {
    static final c.a a = new f();

    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    class a implements c<Object, b<?>> {
        final /* synthetic */ Type a;

        a(Type type) {
            this.a = type;
        }

        @Override // m.c
        public b<?> a(b<Object> bVar) {
            return bVar;
        }

        @Override // m.c
        public Type a() {
            return this.a;
        }
    }

    f() {
    }

    @Override // m.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (c.a.a(type) != b.class) {
            return null;
        }
        return new a(p.b(type));
    }
}
