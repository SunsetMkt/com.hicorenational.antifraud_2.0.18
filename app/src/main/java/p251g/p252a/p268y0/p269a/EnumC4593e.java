package p251g.p252a.p268y0.p269a;

import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;

/* compiled from: EmptyDisposable.java */
/* renamed from: g.a.y0.a.e */
/* loaded from: classes2.dex */
public enum EnumC4593e implements InterfaceC4611j<Object> {
    INSTANCE,
    NEVER;

    public static void complete(InterfaceC4514i0<?> interfaceC4514i0) {
        interfaceC4514i0.onSubscribe(INSTANCE);
        interfaceC4514i0.onComplete();
    }

    public static void error(Throwable th, InterfaceC4514i0<?> interfaceC4514i0) {
        interfaceC4514i0.onSubscribe(INSTANCE);
        interfaceC4514i0.onError(th);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return true;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public Object poll() throws Exception {
        return null;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(InterfaceC4559v<?> interfaceC4559v) {
        interfaceC4559v.onSubscribe(INSTANCE);
        interfaceC4559v.onComplete();
    }

    public static void error(Throwable th, InterfaceC4491f interfaceC4491f) {
        interfaceC4491f.onSubscribe(INSTANCE);
        interfaceC4491f.onError(th);
    }

    public static void complete(InterfaceC4491f interfaceC4491f) {
        interfaceC4491f.onSubscribe(INSTANCE);
        interfaceC4491f.onComplete();
    }

    public static void error(Throwable th, InterfaceC4524n0<?> interfaceC4524n0) {
        interfaceC4524n0.onSubscribe(INSTANCE);
        interfaceC4524n0.onError(th);
    }

    public static void error(Throwable th, InterfaceC4559v<?> interfaceC4559v) {
        interfaceC4559v.onSubscribe(INSTANCE);
        interfaceC4559v.onError(th);
    }
}
