package p286h;

import java.io.Serializable;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: LazyJVM.kt */
/* renamed from: h.a1 */
/* loaded from: classes2.dex */
final class C5191a1<T> implements InterfaceC5604s<T>, Serializable {
    private volatile Object _value;
    private InterfaceC5495a<? extends T> initializer;
    private final Object lock;

    public C5191a1(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(interfaceC5495a, "initializer");
        this.initializer = interfaceC5495a;
        this._value = C5598r1.f20454a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new C5466o(getValue());
    }

    @Override // p286h.InterfaceC5604s
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        if (t2 != C5598r1.f20454a) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == C5598r1.f20454a) {
                InterfaceC5495a<? extends T> interfaceC5495a = this.initializer;
                if (interfaceC5495a == null) {
                    C5544i0.m22545f();
                }
                t = interfaceC5495a.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    @Override // p286h.InterfaceC5604s
    public boolean isInitialized() {
        return this._value != C5598r1.f20454a;
    }

    @InterfaceC5816d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C5191a1(InterfaceC5495a interfaceC5495a, Object obj, int i2, C5586v c5586v) {
        this(interfaceC5495a, (i2 & 2) != 0 ? null : obj);
    }
}
