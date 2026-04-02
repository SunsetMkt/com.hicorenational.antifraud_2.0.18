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
@y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public abstract class b implements p {

    /* JADX INFO: renamed from: b */
    @j.c.a.d
    private final TimeUnit f12049b;

    /* JADX INFO: compiled from: TimeSources.kt */
    private static final class a extends o {
        private final long a;

        /* JADX INFO: renamed from: b */
        private final b f12050b;

        /* JADX INFO: renamed from: c */
        private final double f12051c;

        private a(long j2, b bVar, double d2) {
            this.a = j2;
            this.f12050b = bVar;
            this.f12051c = d2;
        }

        @Override // i.a3.o
        public double a() {
            return d.e(e.a(this.f12050b.c() - this.a, this.f12050b.b()), this.f12051c);
        }

        @Override // i.a3.o
        @j.c.a.d
        public o b(double d2) {
            return new a(this.a, this.f12050b, d.f(this.f12051c, d2), null);
        }

        public /* synthetic */ a(long j2, b bVar, double d2, v vVar) {
            this(j2, bVar, d2);
        }
    }

    public b(@j.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        this.f12049b = timeUnit;
    }

    @Override // i.a3.p
    @j.c.a.d
    public o a() {
        return new a(c(), this, d.f12055d.b(), null);
    }

    @j.c.a.d
    protected final TimeUnit b() {
        return this.f12049b;
    }

    protected abstract long c();
}
