package com.airbnb.lottie.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

/* JADX INFO: compiled from: MutablePair.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class i<T> {

    @Nullable
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    T f2426b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.a = t;
        this.f2426b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return b(pair.first, this.a) && b(pair.second, this.f2426b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f2426b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + d.c.a.b.a.a.f10074g + String.valueOf(this.f2426b) + "}";
    }
}
