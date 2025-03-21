package p251g.p252a.p268y0.p283i;

import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p324i.p338d.InterfaceC5822c;

/* compiled from: EmptySubscription.java */
/* renamed from: g.a.y0.i.g */
/* loaded from: classes2.dex */
public enum EnumC5157g implements InterfaceC4613l<Object> {
    INSTANCE;

    public static void complete(InterfaceC5822c<?> interfaceC5822c) {
        interfaceC5822c.onSubscribe(INSTANCE);
        interfaceC5822c.onComplete();
    }

    public static void error(Throwable th, InterfaceC5822c<?> interfaceC5822c) {
        interfaceC5822c.onSubscribe(INSTANCE);
        interfaceC5822c.onError(th);
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
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
    public Object poll() {
        return null;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        EnumC5160j.validate(j2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
    public int requestFusion(int i2) {
        return i2 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
