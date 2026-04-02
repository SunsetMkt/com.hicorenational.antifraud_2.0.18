package i;

import java.io.Serializable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a1<T> implements s<T>, Serializable {
    private volatile Object _value;
    private i.q2.s.a<? extends T> initializer;
    private final Object lock;

    public a1(@j.c.a.d i.q2.s.a<? extends T> aVar, @j.c.a.e Object obj) {
        i.q2.t.i0.f(aVar, "initializer");
        this.initializer = aVar;
        this._value = r1.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new o(getValue());
    }

    @Override // i.s
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        if (t != r1.a) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == r1.a) {
                i.q2.s.a<? extends T> aVar = this.initializer;
                if (aVar == null) {
                    i.q2.t.i0.f();
                }
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // i.s
    public boolean isInitialized() {
        return this._value != r1.a;
    }

    @j.c.a.d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ a1(i.q2.s.a aVar, Object obj, int i2, i.q2.t.v vVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
