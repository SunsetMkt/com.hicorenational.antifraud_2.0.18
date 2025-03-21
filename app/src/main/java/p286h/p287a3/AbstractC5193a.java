package p286h.p287a3;

import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: TimeSources.kt */
@InterfaceC5202j
@InterfaceC5610t0(version = "1.3")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m23546d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.a3.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5193a implements InterfaceC5208p {

    /* renamed from: b */
    @InterfaceC5816d
    private final TimeUnit f20054b;

    /* compiled from: TimeSources.kt */
    /* renamed from: h.a3.a$a */
    private static final class a extends AbstractC5207o {

        /* renamed from: a */
        private final double f20055a;

        /* renamed from: b */
        private final AbstractC5193a f20056b;

        /* renamed from: c */
        private final double f20057c;

        private a(double d2, AbstractC5193a abstractC5193a, double d3) {
            this.f20055a = d2;
            this.f20056b = abstractC5193a;
            this.f20057c = d3;
        }

        @Override // p286h.p287a3.AbstractC5207o
        /* renamed from: a */
        public double mo18668a() {
            return C5196d.m18696e(C5197e.m18730a(this.f20056b.m18667c() - this.f20055a, this.f20056b.m18666b()), this.f20057c);
        }

        @Override // p286h.p287a3.AbstractC5207o
        @InterfaceC5816d
        /* renamed from: b */
        public AbstractC5207o mo18669b(double d2) {
            return new a(this.f20055a, this.f20056b, C5196d.m18700f(this.f20057c, d2), null);
        }

        public /* synthetic */ a(double d2, AbstractC5193a abstractC5193a, double d3, C5586v c5586v) {
            this(d2, abstractC5193a, d3);
        }
    }

    public AbstractC5193a(@InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        this.f20054b = timeUnit;
    }

    @Override // p286h.p287a3.InterfaceC5208p
    @InterfaceC5816d
    /* renamed from: a */
    public AbstractC5207o mo18665a() {
        return new a(m18667c(), this, C5196d.f20066d.m18728b(), null);
    }

    @InterfaceC5816d
    /* renamed from: b */
    protected final TimeUnit m18666b() {
        return this.f20054b;
    }

    /* renamed from: c */
    protected abstract double m18667c();
}
