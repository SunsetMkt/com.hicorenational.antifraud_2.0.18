package p286h;

import java.io.Serializable;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Lazy.kt */
/* renamed from: h.o */
/* loaded from: classes2.dex */
public final class C5466o<T> implements InterfaceC5604s<T>, Serializable {
    private final T value;

    public C5466o(T t) {
        this.value = t;
    }

    @Override // p286h.InterfaceC5604s
    public T getValue() {
        return this.value;
    }

    @Override // p286h.InterfaceC5604s
    public boolean isInitialized() {
        return true;
    }

    @InterfaceC5816d
    public String toString() {
        return String.valueOf(getValue());
    }
}
