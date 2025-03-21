package p286h;

import java.io.Serializable;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Lazy.kt */
/* renamed from: h.z1 */
/* loaded from: classes2.dex */
public final class C5720z1<T> implements InterfaceC5604s<T>, Serializable {
    private Object _value;
    private InterfaceC5495a<? extends T> initializer;

    public C5720z1(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "initializer");
        this.initializer = interfaceC5495a;
        this._value = C5598r1.f20454a;
    }

    private final Object writeReplace() {
        return new C5466o(getValue());
    }

    @Override // p286h.InterfaceC5604s
    public T getValue() {
        if (this._value == C5598r1.f20454a) {
            InterfaceC5495a<? extends T> interfaceC5495a = this.initializer;
            if (interfaceC5495a == null) {
                C5544i0.m22545f();
            }
            this._value = interfaceC5495a.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // p286h.InterfaceC5604s
    public boolean isInitialized() {
        return this._value != C5598r1.f20454a;
    }

    @InterfaceC5816d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
