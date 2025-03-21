package p251g.p252a.p268y0.p284j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: HashMapSupplier.java */
/* renamed from: g.a.y0.j.m */
/* loaded from: classes2.dex */
public enum EnumC5173m implements Callable<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
