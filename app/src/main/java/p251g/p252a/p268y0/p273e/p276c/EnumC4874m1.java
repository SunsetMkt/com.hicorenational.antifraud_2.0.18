package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p267x0.InterfaceC4584o;
import p324i.p338d.InterfaceC5821b;

/* compiled from: MaybeToPublisher.java */
/* renamed from: g.a.y0.e.c.m1 */
/* loaded from: classes2.dex */
public enum EnumC4874m1 implements InterfaceC4584o<InterfaceC4588y<Object>, InterfaceC5821b<Object>> {
    INSTANCE;

    public static <T> InterfaceC4584o<InterfaceC4588y<T>, InterfaceC5821b<T>> instance() {
        return INSTANCE;
    }

    @Override // p251g.p252a.p267x0.InterfaceC4584o
    public InterfaceC5821b<Object> apply(InterfaceC4588y<Object> interfaceC4588y) throws Exception {
        return new C4868k1(interfaceC4588y);
    }
}
