package com.airbnb.lottie.p106y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: MutablePair.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.airbnb.lottie.y.i */
/* loaded from: classes.dex */
public class C1443i<T> {

    /* renamed from: a */
    @Nullable
    T f3612a;

    /* renamed from: b */
    @Nullable
    T f3613b;

    /* renamed from: b */
    private static boolean m3218b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public void m3219a(T t, T t2) {
        this.f3612a = t;
        this.f3613b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return m3218b(pair.first, this.f3612a) && m3218b(pair.second, this.f3613b);
    }

    public int hashCode() {
        T t = this.f3612a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f3613b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f3612a) + AbstractC1191a.f2568g + String.valueOf(this.f3613b) + "}";
    }
}
