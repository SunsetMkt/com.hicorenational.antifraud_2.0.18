package p251g.p252a.p268y0.p284j;

import java.util.List;
import p251g.p252a.p267x0.InterfaceC4572c;

/* compiled from: ListAddBiConsumer.java */
/* renamed from: g.a.y0.j.o */
/* loaded from: classes2.dex */
public enum EnumC5175o implements InterfaceC4572c<List, Object, List> {
    INSTANCE;

    public static <T> InterfaceC4572c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // p251g.p252a.p267x0.InterfaceC4572c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
