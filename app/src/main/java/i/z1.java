package i;

import java.io.Serializable;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z1<T> implements s<T>, Serializable {
    private Object _value;
    private i.q2.s.a<? extends T> initializer;

    public z1(@j.c.a.d i.q2.s.a<? extends T> aVar) {
        i.q2.t.i0.f(aVar, "initializer");
        this.initializer = aVar;
        this._value = r1.a;
    }

    private final Object writeReplace() {
        return new o(getValue());
    }

    @Override // i.s
    public T getValue() {
        if (this._value == r1.a) {
            i.q2.s.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                i.q2.t.i0.f();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // i.s
    public boolean isInitialized() {
        return this._value != r1.a;
    }

    @j.c.a.d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
