package i.z2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.e1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
final class h implements i.x2.m<i.v2.k> {
    private final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i.q2.s.p<CharSequence, Integer, i.i0<Integer, Integer>> f12416d;

    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<i.v2.k>, i.q2.t.q1.a {
        private int a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @j.c.a.e
        private i.v2.k f12419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f12420e;

        a() {
            this.f12417b = i.v2.q.a(h.this.f12414b, 0, h.this.a.length());
            this.f12418c = this.f12417b;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void g() {
            i.i0 i0Var;
            if (this.f12418c < 0) {
                this.a = 0;
                this.f12419d = null;
                return;
            }
            if (h.this.f12415c > 0) {
                this.f12420e++;
                if (this.f12420e >= h.this.f12415c) {
                    this.f12419d = new i.v2.k(this.f12417b, c0.c(h.this.a));
                    this.f12418c = -1;
                } else if (this.f12418c <= h.this.a.length() && (i0Var = (i.i0) h.this.f12416d.invoke(h.this.a, Integer.valueOf(this.f12418c))) != null) {
                    int iIntValue = ((Number) i0Var.component1()).intValue();
                    int iIntValue2 = ((Number) i0Var.component2()).intValue();
                    this.f12419d = i.v2.q.d(this.f12417b, iIntValue);
                    this.f12417b = iIntValue + iIntValue2;
                    this.f12418c = this.f12417b + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f12419d = new i.v2.k(this.f12417b, c0.c(h.this.a));
                    this.f12418c = -1;
                }
            }
            this.a = 1;
        }

        public final void a(@j.c.a.e i.v2.k kVar) {
            this.f12419d = kVar;
        }

        public final void b(int i2) {
            this.f12417b = i2;
        }

        public final int c() {
            return this.f12417b;
        }

        public final void d(int i2) {
            this.a = i2;
        }

        public final int e() {
            return this.f12418c;
        }

        public final int f() {
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                g();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void a(int i2) {
            this.f12420e = i2;
        }

        public final int b() {
            return this.f12420e;
        }

        public final void c(int i2) {
            this.f12418c = i2;
        }

        @j.c.a.e
        public final i.v2.k d() {
            return this.f12419d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @j.c.a.d
        public i.v2.k next() {
            if (this.a == -1) {
                g();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            i.v2.k kVar = this.f12419d;
            if (kVar == null) {
                throw new e1("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f12419d = null;
            this.a = -1;
            return kVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@j.c.a.d CharSequence charSequence, int i2, int i3, @j.c.a.d i.q2.s.p<? super CharSequence, ? super Integer, i.i0<Integer, Integer>> pVar) {
        i.q2.t.i0.f(charSequence, "input");
        i.q2.t.i0.f(pVar, "getNextMatch");
        this.a = charSequence;
        this.f12414b = i2;
        this.f12415c = i3;
        this.f12416d = pVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<i.v2.k> iterator() {
        return new a();
    }
}
