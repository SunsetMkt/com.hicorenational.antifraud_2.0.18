package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class Pair<F, S> {

    @Nullable
    public final F first;

    @Nullable
    public final S second;

    public Pair(@Nullable F f2, @Nullable S s) {
        this.first = f2;
        this.second = s;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(@Nullable A a2, @Nullable B b2) {
        return new Pair<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f2 = this.first;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.second;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + String.valueOf(this.first) + AbstractC1191a.f2568g + String.valueOf(this.second) + "}";
    }
}
