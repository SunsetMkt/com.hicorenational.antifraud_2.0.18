package h.a.y0.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ArrayListSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public enum b implements Callable<List<Object>>, h.a.x0.o<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> h.a.x0.o<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // h.a.x0.o
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
