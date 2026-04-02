package i;

import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
@y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", DispatchConstants.OTHER, "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class q implements Comparable<q> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12193e = 255;
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12198d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12195g = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final q f12194f = new q(1, 3, 70);

    /* JADX INFO: compiled from: KotlinVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    public q(int i2, int i3, int i4) {
        this.f12196b = i2;
        this.f12197c = i3;
        this.f12198d = i4;
        this.a = b(this.f12196b, this.f12197c, this.f12198d);
    }

    public final int a() {
        return this.f12196b;
    }

    public final int b() {
        return this.f12197c;
    }

    public final int c() {
        return this.f12198d;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            obj = null;
        }
        q qVar = (q) obj;
        return qVar != null && this.a == qVar.a;
    }

    public int hashCode() {
        return this.a;
    }

    @j.c.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12196b);
        sb.append('.');
        sb.append(this.f12197c);
        sb.append('.');
        sb.append(this.f12198d);
        return sb.toString();
    }

    private final int b(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@j.c.a.d q qVar) {
        i.q2.t.i0.f(qVar, DispatchConstants.OTHER);
        return this.a - qVar.a;
    }

    public q(int i2, int i3) {
        this(i2, i3, 0);
    }

    public final boolean a(int i2, int i3) {
        int i4 = this.f12196b;
        return i4 > i2 || (i4 == i2 && this.f12197c >= i3);
    }

    public final boolean a(int i2, int i3, int i4) {
        int i5;
        int i6 = this.f12196b;
        return i6 > i2 || (i6 == i2 && ((i5 = this.f12197c) > i3 || (i5 == i3 && this.f12198d >= i4)));
    }
}
