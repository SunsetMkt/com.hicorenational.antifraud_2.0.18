package h.a.y0.j;

import java.util.List;

/* JADX INFO: compiled from: ListAddBiConsumer.java */
/* JADX INFO: loaded from: classes2.dex */
public enum o implements h.a.x0.c<List, Object, List> {
    INSTANCE;

    public static <T> h.a.x0.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // h.a.x0.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
