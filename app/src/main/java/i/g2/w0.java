package i.g2;

import java.util.Map;

/* JADX INFO: compiled from: MapAccessors.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "MapAccessorsKt")
public final class w0 {
    @i.m2.f
    private static final <V, V1 extends V> V1 a(@j.c.a.d Map<? super String, ? extends V> map, Object obj, i.w2.m<?> mVar) {
        i.q2.t.i0.f(map, "$this$getValue");
        return (V1) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    @i.q2.e(name = "getVar")
    @i.m2.f
    private static final <V, V1 extends V> V1 b(@j.c.a.d Map<? super String, ? extends V> map, Object obj, i.w2.m<?> mVar) {
        i.q2.t.i0.f(map, "$this$getValue");
        return (V1) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    @i.q2.e(name = "getVarContravariant")
    @i.c(level = i.d.ERROR, message = "Use getValue() with two type parameters instead")
    @i.m2.g
    @i.m2.f
    private static final <V> V c(@j.c.a.d Map<? super String, ? super V> map, Object obj, i.w2.m<?> mVar) {
        return (V) a1.a((Map<String, ? extends V>) map, mVar.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <V> void a(@j.c.a.d Map<? super String, ? super V> map, Object obj, i.w2.m<?> mVar, V v) {
        i.q2.t.i0.f(map, "$this$setValue");
        map.put(mVar.getName(), v);
    }
}
