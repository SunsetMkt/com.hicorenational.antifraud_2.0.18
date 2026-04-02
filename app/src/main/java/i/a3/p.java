package i.a3;

import i.t0;
import i.y;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public interface p {
    public static final a a = a.a;

    /* JADX INFO: compiled from: TimeSource.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* JADX INFO: compiled from: TimeSource.kt */
    public static final class b implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12061c = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ m f12062b = m.f12059c;

        private b() {
        }

        @Override // i.a3.p
        @j.c.a.d
        public o a() {
            return this.f12062b.a();
        }

        @j.c.a.d
        public String toString() {
            return m.f12059c.toString();
        }
    }

    @j.c.a.d
    o a();
}
