package p251g.p252a.p257e1;

import java.util.concurrent.TimeUnit;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: Timed.java */
/* renamed from: g.a.e1.c */
/* loaded from: classes2.dex */
public final class C4490c<T> {

    /* renamed from: a */
    final T f17338a;

    /* renamed from: b */
    final long f17339b;

    /* renamed from: c */
    final TimeUnit f17340c;

    public C4490c(@InterfaceC4546f T t, long j2, @InterfaceC4546f TimeUnit timeUnit) {
        this.f17338a = t;
        this.f17339b = j2;
        this.f17340c = (TimeUnit) C4601b.m18284a(timeUnit, "unit is null");
    }

    /* renamed from: a */
    public long m17285a() {
        return this.f17339b;
    }

    @InterfaceC4546f
    /* renamed from: b */
    public TimeUnit m17287b() {
        return this.f17340c;
    }

    @InterfaceC4546f
    /* renamed from: c */
    public T m17288c() {
        return this.f17338a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4490c)) {
            return false;
        }
        C4490c c4490c = (C4490c) obj;
        return C4601b.m18285a(this.f17338a, c4490c.f17338a) && this.f17339b == c4490c.f17339b && C4601b.m18285a(this.f17340c, c4490c.f17340c);
    }

    public int hashCode() {
        T t = this.f17338a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j2 = this.f17339b;
        return (((hashCode * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f17340c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f17339b + ", unit=" + this.f17340c + ", value=" + this.f17338a + "]";
    }

    /* renamed from: a */
    public long m17286a(@InterfaceC4546f TimeUnit timeUnit) {
        return timeUnit.convert(this.f17339b, this.f17340c);
    }
}
