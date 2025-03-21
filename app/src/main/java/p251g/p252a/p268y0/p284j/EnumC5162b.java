package p251g.p252a.p268y0.p284j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p251g.p252a.p267x0.InterfaceC4584o;

/* compiled from: ArrayListSupplier.java */
/* renamed from: g.a.y0.j.b */
/* loaded from: classes2.dex */
public enum EnumC5162b implements Callable<List<Object>>, InterfaceC4584o<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> InterfaceC4584o<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // p251g.p252a.p267x0.InterfaceC4584o
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
