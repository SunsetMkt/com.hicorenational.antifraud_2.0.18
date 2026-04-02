package i.a3;

import i.q2.t.i0;
import i.q2.t.v;
import i.t0;
import i.y;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public abstract class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final TimeUnit f12046b;

    /* JADX INFO: renamed from: i.a3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimeSources.kt */
    private static final class C0234a extends o {
        private final double a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f12047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final double f12048c;

        private C0234a(double d2, a aVar, double d3) {
            this.a = d2;
            this.f12047b = aVar;
            this.f12048c = d3;
        }

        @Override // i.a3.o
        public double a() {
            return d.e(e.a(this.f12047b.c() - this.a, this.f12047b.b()), this.f12048c);
        }

        @Override // i.a3.o
        @j.c.a.d
        public o b(double d2) {
            return new C0234a(this.a, this.f12047b, d.f(this.f12048c, d2), null);
        }

        public /* synthetic */ C0234a(double d2, a aVar, double d3, v vVar) {
            this(d2, aVar, d3);
        }
    }

    public a(@j.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        this.f12046b = timeUnit;
    }

    @Override // i.a3.p
    @j.c.a.d
    public o a() {
        return new C0234a(c(), this, d.f12055d.b(), null);
    }

    @j.c.a.d
    protected final TimeUnit b() {
        return this.f12046b;
    }

    protected abstract double c();
}
