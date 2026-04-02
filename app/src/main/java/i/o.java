package i;

import java.io.Serializable;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> implements s<T>, Serializable {
    private final T value;

    public o(T t) {
        this.value = t;
    }

    @Override // i.s
    public T getValue() {
        return this.value;
    }

    @Override // i.s
    public boolean isInitialized() {
        return true;
    }

    @j.c.a.d
    public String toString() {
        return String.valueOf(getValue());
    }
}
