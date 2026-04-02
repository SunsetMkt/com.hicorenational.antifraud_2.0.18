package d.b.c.d0.a0.g;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    private final List<b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9568c;

    c(List<b> list, int i2, boolean z) {
        this.a = new ArrayList(list);
        this.f9567b = i2;
        this.f9568c = z;
    }

    List<b> a() {
        return this.a;
    }

    int b() {
        return this.f9567b;
    }

    boolean c() {
        return this.f9568c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a()) && this.f9568c == cVar.f9568c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.f9568c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }

    boolean a(List<b> list) {
        return this.a.equals(list);
    }
}
