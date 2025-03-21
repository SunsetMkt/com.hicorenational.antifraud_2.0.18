package p286h.p323z2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p286h.p319v2.C5642k;
import p286h.p319v2.C5648q;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Strings.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m23546d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.h */
/* loaded from: classes2.dex */
final class C5735h implements InterfaceC5699m<C5642k> {

    /* renamed from: a */
    private final CharSequence f20688a;

    /* renamed from: b */
    private final int f20689b;

    /* renamed from: c */
    private final int f20690c;

    /* renamed from: d */
    private final InterfaceC5510p<CharSequence, Integer, C5334i0<Integer, Integer>> f20691d;

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.h$a */
    public static final class a implements Iterator<C5642k>, InterfaceC5569a {

        /* renamed from: a */
        private int f20692a = -1;

        /* renamed from: b */
        private int f20693b;

        /* renamed from: c */
        private int f20694c;

        /* renamed from: d */
        @InterfaceC5817e
        private C5642k f20695d;

        /* renamed from: e */
        private int f20696e;

        a() {
            int m23051a;
            m23051a = C5648q.m23051a(C5735h.this.f20689b, 0, C5735h.this.f20688a.length());
            this.f20693b = m23051a;
            this.f20694c = this.f20693b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        
            if (r6.f20696e < r6.f20697f.f20690c) goto L9;
         */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void m23981g() {
            /*
                r6 = this;
                int r0 = r6.f20694c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f20692a = r1
                r0 = 0
                r6.f20695d = r0
                goto La2
            Lc:
                h.z2.h r0 = p286h.p323z2.C5735h.this
                int r0 = p286h.p323z2.C5735h.m23979c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L25
                int r0 = r6.f20696e
                int r0 = r0 + r3
                r6.f20696e = r0
                int r0 = r6.f20696e
                h.z2.h r4 = p286h.p323z2.C5735h.this
                int r4 = p286h.p323z2.C5735h.m23979c(r4)
                if (r0 >= r4) goto L33
            L25:
                int r0 = r6.f20694c
                h.z2.h r4 = p286h.p323z2.C5735h.this
                java.lang.CharSequence r4 = p286h.p323z2.C5735h.m23978b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L49
            L33:
                int r0 = r6.f20693b
                h.v2.k r1 = new h.v2.k
                h.z2.h r4 = p286h.p323z2.C5735h.this
                java.lang.CharSequence r4 = p286h.p323z2.C5735h.m23978b(r4)
                int r4 = p286h.p323z2.C5726c0.m23753c(r4)
                r1.<init>(r0, r4)
                r6.f20695d = r1
                r6.f20694c = r2
                goto La0
            L49:
                h.z2.h r0 = p286h.p323z2.C5735h.this
                h.q2.s.p r0 = p286h.p323z2.C5735h.m23977a(r0)
                h.z2.h r4 = p286h.p323z2.C5735h.this
                java.lang.CharSequence r4 = p286h.p323z2.C5735h.m23978b(r4)
                int r5 = r6.f20694c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                h.i0 r0 = (p286h.C5334i0) r0
                if (r0 != 0) goto L79
                int r0 = r6.f20693b
                h.v2.k r1 = new h.v2.k
                h.z2.h r4 = p286h.p323z2.C5735h.this
                java.lang.CharSequence r4 = p286h.p323z2.C5735h.m23978b(r4)
                int r4 = p286h.p323z2.C5726c0.m23753c(r4)
                r1.<init>(r0, r4)
                r6.f20695d = r1
                r6.f20694c = r2
                goto La0
            L79:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f20693b
                h.v2.k r4 = p286h.p319v2.C5646o.m23038d(r4, r2)
                r6.f20695d = r4
                int r2 = r2 + r0
                r6.f20693b = r2
                int r2 = r6.f20693b
                if (r0 != 0) goto L9d
                r1 = 1
            L9d:
                int r2 = r2 + r1
                r6.f20694c = r2
            La0:
                r6.f20692a = r3
            La2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p286h.p323z2.C5735h.a.m23981g():void");
        }

        /* renamed from: a */
        public final void m23983a(@InterfaceC5817e C5642k c5642k) {
            this.f20695d = c5642k;
        }

        /* renamed from: b */
        public final void m23985b(int i2) {
            this.f20693b = i2;
        }

        /* renamed from: c */
        public final int m23986c() {
            return this.f20693b;
        }

        /* renamed from: d */
        public final void m23989d(int i2) {
            this.f20692a = i2;
        }

        /* renamed from: e */
        public final int m23990e() {
            return this.f20694c;
        }

        /* renamed from: f */
        public final int m23991f() {
            return this.f20692a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20692a == -1) {
                m23981g();
            }
            return this.f20692a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: a */
        public final void m23982a(int i2) {
            this.f20696e = i2;
        }

        /* renamed from: b */
        public final int m23984b() {
            return this.f20696e;
        }

        /* renamed from: c */
        public final void m23987c(int i2) {
            this.f20694c = i2;
        }

        @InterfaceC5817e
        /* renamed from: d */
        public final C5642k m23988d() {
            return this.f20695d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @InterfaceC5816d
        public C5642k next() {
            if (this.f20692a == -1) {
                m23981g();
            }
            if (this.f20692a == 0) {
                throw new NoSuchElementException();
            }
            C5642k c5642k = this.f20695d;
            if (c5642k == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f20695d = null;
            this.f20692a = -1;
            return c5642k;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5735h(@InterfaceC5816d CharSequence charSequence, int i2, int i3, @InterfaceC5816d InterfaceC5510p<? super CharSequence, ? super Integer, C5334i0<Integer, Integer>> interfaceC5510p) {
        C5544i0.m22546f(charSequence, "input");
        C5544i0.m22546f(interfaceC5510p, "getNextMatch");
        this.f20688a = charSequence;
        this.f20689b = i2;
        this.f20690c = i3;
        this.f20691d = interfaceC5510p;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<C5642k> iterator() {
        return new a();
    }
}
