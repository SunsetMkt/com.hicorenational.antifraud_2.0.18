package com.bumptech.glide.p137r;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1594h;
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.load.p123q.p124y.C1707b;
import com.bumptech.glide.load.p125r.p126d.AbstractC1741p;
import com.bumptech.glide.load.p125r.p126d.C1724e;
import com.bumptech.glide.load.p125r.p126d.C1735j0;
import com.bumptech.glide.load.p125r.p126d.C1737l;
import com.bumptech.glide.load.p125r.p126d.C1738m;
import com.bumptech.glide.load.p125r.p126d.C1739n;
import com.bumptech.glide.load.p125r.p126d.C1742q;
import com.bumptech.glide.load.p125r.p126d.C1744s;
import com.bumptech.glide.load.p125r.p126d.C1746u;
import com.bumptech.glide.load.resource.gif.C1774e;
import com.bumptech.glide.load.resource.gif.C1777h;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p140s.C1864c;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;

/* compiled from: BaseRequestOptions.java */
/* renamed from: com.bumptech.glide.r.a */
/* loaded from: classes.dex */
public abstract class AbstractC1822a<T extends AbstractC1822a<T>> implements Cloneable {

    /* renamed from: A */
    private static final int f5260A = -1;

    /* renamed from: B */
    private static final int f5261B = 2;

    /* renamed from: C */
    private static final int f5262C = 4;

    /* renamed from: D */
    private static final int f5263D = 8;

    /* renamed from: E */
    private static final int f5264E = 16;

    /* renamed from: F */
    private static final int f5265F = 32;

    /* renamed from: G */
    private static final int f5266G = 64;

    /* renamed from: H */
    private static final int f5267H = 128;

    /* renamed from: I */
    private static final int f5268I = 256;

    /* renamed from: J */
    private static final int f5269J = 512;

    /* renamed from: K */
    private static final int f5270K = 1024;

    /* renamed from: L */
    private static final int f5271L = 2048;

    /* renamed from: M */
    private static final int f5272M = 4096;

    /* renamed from: N */
    private static final int f5273N = 8192;

    /* renamed from: O */
    private static final int f5274O = 16384;

    /* renamed from: b0 */
    private static final int f5275b0 = 32768;

    /* renamed from: c0 */
    private static final int f5276c0 = 65536;

    /* renamed from: d0 */
    private static final int f5277d0 = 131072;

    /* renamed from: e0 */
    private static final int f5278e0 = 262144;

    /* renamed from: f0 */
    private static final int f5279f0 = 524288;

    /* renamed from: g0 */
    private static final int f5280g0 = 1048576;

    /* renamed from: a */
    private int f5281a;

    /* renamed from: e */
    @Nullable
    private Drawable f5285e;

    /* renamed from: f */
    private int f5286f;

    /* renamed from: g */
    @Nullable
    private Drawable f5287g;

    /* renamed from: h */
    private int f5288h;

    /* renamed from: m */
    private boolean f5293m;

    /* renamed from: o */
    @Nullable
    private Drawable f5295o;

    /* renamed from: p */
    private int f5296p;

    /* renamed from: t */
    private boolean f5300t;

    /* renamed from: u */
    @Nullable
    private Resources.Theme f5301u;

    /* renamed from: v */
    private boolean f5302v;

    /* renamed from: w */
    private boolean f5303w;

    /* renamed from: x */
    private boolean f5304x;

    /* renamed from: z */
    private boolean f5306z;

    /* renamed from: b */
    private float f5282b = 1.0f;

    /* renamed from: c */
    @NonNull
    private AbstractC1665j f5283c = AbstractC1665j.f4541e;

    /* renamed from: d */
    @NonNull
    private EnumC1582h f5284d = EnumC1582h.NORMAL;

    /* renamed from: i */
    private boolean f5289i = true;

    /* renamed from: j */
    private int f5290j = -1;

    /* renamed from: k */
    private int f5291k = -1;

    /* renamed from: l */
    @NonNull
    private InterfaceC1593g f5292l = C1864c.m4949a();

    /* renamed from: n */
    private boolean f5294n = true;

    /* renamed from: q */
    @NonNull
    private C1596j f5297q = new C1596j();

    /* renamed from: r */
    @NonNull
    private Map<Class<?>, InterfaceC1600n<?>> f5298r = new CachedHashCodeArrayMap();

    /* renamed from: s */
    @NonNull
    private Class<?> f5299s = Object.class;

    /* renamed from: y */
    private boolean f5305y = true;

    /* renamed from: R */
    private T m4715R() {
        return this;
    }

    @NonNull
    /* renamed from: S */
    private T m4716S() {
        if (this.f5300t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return m4715R();
    }

    /* renamed from: b */
    private static boolean m4718b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    /* renamed from: A */
    public final boolean m4722A() {
        return this.f5303w;
    }

    /* renamed from: B */
    protected boolean m4723B() {
        return this.f5302v;
    }

    /* renamed from: C */
    public final boolean m4724C() {
        return m4721g(4);
    }

    /* renamed from: D */
    public final boolean m4725D() {
        return this.f5300t;
    }

    /* renamed from: E */
    public final boolean m4726E() {
        return this.f5289i;
    }

    /* renamed from: F */
    public final boolean m4727F() {
        return m4721g(8);
    }

    /* renamed from: G */
    boolean m4728G() {
        return this.f5305y;
    }

    /* renamed from: H */
    public final boolean m4729H() {
        return m4721g(256);
    }

    /* renamed from: I */
    public final boolean m4730I() {
        return this.f5294n;
    }

    /* renamed from: J */
    public final boolean m4731J() {
        return this.f5293m;
    }

    /* renamed from: K */
    public final boolean m4732K() {
        return m4721g(2048);
    }

    /* renamed from: L */
    public final boolean m4733L() {
        return C1878l.m5008b(this.f5291k, this.f5290j);
    }

    @NonNull
    /* renamed from: M */
    public T m4734M() {
        this.f5300t = true;
        return m4715R();
    }

    @NonNull
    @CheckResult
    /* renamed from: N */
    public T m4735N() {
        return m4755a(AbstractC1741p.f4911e, new C1737l());
    }

    @NonNull
    @CheckResult
    /* renamed from: O */
    public T m4736O() {
        return m4719c(AbstractC1741p.f4910d, new C1738m());
    }

    @NonNull
    @CheckResult
    /* renamed from: P */
    public T m4737P() {
        return m4755a(AbstractC1741p.f4911e, new C1739n());
    }

    @NonNull
    @CheckResult
    /* renamed from: Q */
    public T m4738Q() {
        return m4719c(AbstractC1741p.f4909c, new C1746u());
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4740a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        if (this.f5302v) {
            return (T) mo26850clone().m4740a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f5282b = f2;
        this.f5281a |= 2;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T m4763b(@Nullable Drawable drawable) {
        if (this.f5302v) {
            return (T) mo26850clone().m4763b(drawable);
        }
        this.f5295o = drawable;
        this.f5281a |= 8192;
        this.f5296p = 0;
        this.f5281a &= -16385;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public T m4772c(boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4772c(z);
        }
        this.f5306z = z;
        this.f5281a |= 1048576;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: d */
    public T m4775d(boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4775d(z);
        }
        this.f5303w = z;
        this.f5281a |= 262144;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: e */
    public T m4777e(@DrawableRes int i2) {
        if (this.f5302v) {
            return (T) mo26850clone().m4777e(i2);
        }
        this.f5288h = i2;
        this.f5281a |= 128;
        this.f5287g = null;
        this.f5281a &= -65;
        return m4716S();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractC1822a)) {
            return false;
        }
        AbstractC1822a abstractC1822a = (AbstractC1822a) obj;
        return Float.compare(abstractC1822a.f5282b, this.f5282b) == 0 && this.f5286f == abstractC1822a.f5286f && C1878l.m5009b(this.f5285e, abstractC1822a.f5285e) && this.f5288h == abstractC1822a.f5288h && C1878l.m5009b(this.f5287g, abstractC1822a.f5287g) && this.f5296p == abstractC1822a.f5296p && C1878l.m5009b(this.f5295o, abstractC1822a.f5295o) && this.f5289i == abstractC1822a.f5289i && this.f5290j == abstractC1822a.f5290j && this.f5291k == abstractC1822a.f5291k && this.f5293m == abstractC1822a.f5293m && this.f5294n == abstractC1822a.f5294n && this.f5303w == abstractC1822a.f5303w && this.f5304x == abstractC1822a.f5304x && this.f5283c.equals(abstractC1822a.f5283c) && this.f5284d == abstractC1822a.f5284d && this.f5297q.equals(abstractC1822a.f5297q) && this.f5298r.equals(abstractC1822a.f5298r) && this.f5299s.equals(abstractC1822a.f5299s) && C1878l.m5009b(this.f5292l, abstractC1822a.f5292l) && C1878l.m5009b(this.f5301u, abstractC1822a.f5301u);
    }

    @NonNull
    @CheckResult
    /* renamed from: f */
    public T m4779f(@IntRange(from = 0) int i2) {
        return m4750a((C1595i<C1595i>) C1707b.f4773b, (C1595i) Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    /* renamed from: g */
    public T m4780g() {
        if (this.f5302v) {
            return (T) mo26850clone().m4780g();
        }
        this.f5298r.clear();
        this.f5281a &= -2049;
        this.f5293m = false;
        this.f5281a &= -131073;
        this.f5294n = false;
        this.f5281a |= 65536;
        this.f5305y = true;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: h */
    public T m4781h() {
        return m4720d(AbstractC1741p.f4909c, new C1746u());
    }

    public int hashCode() {
        return C1878l.m4996a(this.f5301u, C1878l.m4996a(this.f5292l, C1878l.m4996a(this.f5299s, C1878l.m4996a(this.f5298r, C1878l.m4996a(this.f5297q, C1878l.m4996a(this.f5284d, C1878l.m4996a(this.f5283c, C1878l.m4998a(this.f5304x, C1878l.m4998a(this.f5303w, C1878l.m4998a(this.f5294n, C1878l.m4998a(this.f5293m, C1878l.m4992a(this.f5291k, C1878l.m4992a(this.f5290j, C1878l.m4998a(this.f5289i, C1878l.m4996a(this.f5295o, C1878l.m4992a(this.f5296p, C1878l.m4996a(this.f5287g, C1878l.m4992a(this.f5288h, C1878l.m4996a(this.f5285e, C1878l.m4992a(this.f5286f, C1878l.m4990a(this.f5282b)))))))))))))))))))));
    }

    @NonNull
    /* renamed from: i */
    public final AbstractC1665j m4782i() {
        return this.f5283c;
    }

    /* renamed from: j */
    public final int m4783j() {
        return this.f5286f;
    }

    @Nullable
    /* renamed from: k */
    public final Drawable m4784k() {
        return this.f5285e;
    }

    @Nullable
    /* renamed from: l */
    public final Drawable m4785l() {
        return this.f5295o;
    }

    /* renamed from: m */
    public final int m4786m() {
        return this.f5296p;
    }

    /* renamed from: n */
    public final boolean m4787n() {
        return this.f5304x;
    }

    @NonNull
    /* renamed from: o */
    public final C1596j m4788o() {
        return this.f5297q;
    }

    /* renamed from: p */
    public final int m4789p() {
        return this.f5290j;
    }

    /* renamed from: q */
    public final int m4790q() {
        return this.f5291k;
    }

    @Nullable
    /* renamed from: r */
    public final Drawable m4791r() {
        return this.f5287g;
    }

    /* renamed from: s */
    public final int m4792s() {
        return this.f5288h;
    }

    @NonNull
    /* renamed from: t */
    public final EnumC1582h m4793t() {
        return this.f5284d;
    }

    @NonNull
    /* renamed from: u */
    public final Class<?> m4794u() {
        return this.f5299s;
    }

    @NonNull
    /* renamed from: v */
    public final InterfaceC1593g m4795v() {
        return this.f5292l;
    }

    /* renamed from: w */
    public final float m4796w() {
        return this.f5282b;
    }

    @Nullable
    /* renamed from: x */
    public final Resources.Theme m4797x() {
        return this.f5301u;
    }

    @NonNull
    /* renamed from: y */
    public final Map<Class<?>, InterfaceC1600n<?>> m4798y() {
        return this.f5298r;
    }

    /* renamed from: z */
    public final boolean m4799z() {
        return this.f5306z;
    }

    @Override // 
    @CheckResult
    /* renamed from: clone */
    public T mo26850clone() {
        try {
            T t = (T) super.clone();
            t.f5297q = new C1596j();
            t.f5297q.m3841a(this.f5297q);
            t.f5298r = new CachedHashCodeArrayMap();
            t.f5298r.putAll(this.f5298r);
            t.f5300t = false;
            t.f5302v = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    /* renamed from: f */
    public T m4778f() {
        return m4750a((C1595i<C1595i>) C1777h.f5046b, (C1595i) true);
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public T m4771c(@Nullable Drawable drawable) {
        if (this.f5302v) {
            return (T) mo26850clone().m4771c(drawable);
        }
        this.f5287g = drawable;
        this.f5281a |= 64;
        this.f5288h = 0;
        this.f5281a &= -129;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: d */
    public T m4774d(int i2) {
        return m4742a(i2, i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4759a(boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4759a(z);
        }
        this.f5304x = z;
        this.f5281a |= 524288;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: d */
    public T m4773d() {
        return m4765b(AbstractC1741p.f4910d, new C1739n());
    }

    @NonNull
    /* renamed from: d */
    private T m4720d(@NonNull AbstractC1741p abstractC1741p, @NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        return m4717a(abstractC1741p, interfaceC1600n, true);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T m4762b(@DrawableRes int i2) {
        if (this.f5302v) {
            return (T) mo26850clone().m4762b(i2);
        }
        this.f5286f = i2;
        this.f5281a |= 32;
        this.f5285e = null;
        this.f5281a &= -17;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: e */
    public T m4776e() {
        return m4750a((C1595i<C1595i>) C1742q.f4922k, (C1595i) false);
    }

    /* renamed from: g */
    private boolean m4721g(int i2) {
        return m4718b(this.f5281a, i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4753a(@NonNull AbstractC1665j abstractC1665j) {
        if (this.f5302v) {
            return (T) mo26850clone().m4753a(abstractC1665j);
        }
        this.f5283c = (AbstractC1665j) C1876j.m4985a(abstractC1665j);
        this.f5281a |= 4;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public T m4770c(@DrawableRes int i2) {
        if (this.f5302v) {
            return (T) mo26850clone().m4770c(i2);
        }
        this.f5296p = i2;
        this.f5281a |= 16384;
        this.f5295o = null;
        this.f5281a &= -8193;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T m4767b(boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4767b(true);
        }
        this.f5289i = !z;
        this.f5281a |= 256;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4747a(@NonNull EnumC1582h enumC1582h) {
        if (this.f5302v) {
            return (T) mo26850clone().m4747a(enumC1582h);
        }
        this.f5284d = (EnumC1582h) C1876j.m4985a(enumC1582h);
        this.f5281a |= 8;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T m4761b() {
        return m4765b(AbstractC1741p.f4911e, new C1737l());
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public T m4769c() {
        return m4720d(AbstractC1741p.f4910d, new C1738m());
    }

    @NonNull
    /* renamed from: c */
    private T m4719c(@NonNull AbstractC1741p abstractC1741p, @NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        return m4717a(abstractC1741p, interfaceC1600n, false);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    final T m4765b(@NonNull AbstractC1741p abstractC1741p, @NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        if (this.f5302v) {
            return (T) mo26850clone().m4765b(abstractC1741p, interfaceC1600n);
        }
        m4754a(abstractC1741p);
        return m4764b(interfaceC1600n);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4746a(@Nullable Drawable drawable) {
        if (this.f5302v) {
            return (T) mo26850clone().m4746a(drawable);
        }
        this.f5285e = drawable;
        this.f5281a |= 16;
        this.f5286f = 0;
        this.f5281a &= -33;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T m4764b(@NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        return m4752a(interfaceC1600n, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    /* renamed from: b */
    public T m4768b(@NonNull InterfaceC1600n<Bitmap>... interfaceC1600nArr) {
        return m4752a((InterfaceC1600n<Bitmap>) new C1594h(interfaceC1600nArr), true);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public <Y> T m4766b(@NonNull Class<Y> cls, @NonNull InterfaceC1600n<Y> interfaceC1600n) {
        return m4758a((Class) cls, (InterfaceC1600n) interfaceC1600n, true);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4744a(@Nullable Resources.Theme theme) {
        if (this.f5302v) {
            return (T) mo26850clone().m4744a(theme);
        }
        this.f5301u = theme;
        this.f5281a |= 32768;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4742a(int i2, int i3) {
        if (this.f5302v) {
            return (T) mo26850clone().m4742a(i2, i3);
        }
        this.f5291k = i2;
        this.f5290j = i3;
        this.f5281a |= 512;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4749a(@NonNull InterfaceC1593g interfaceC1593g) {
        if (this.f5302v) {
            return (T) mo26850clone().m4749a(interfaceC1593g);
        }
        this.f5292l = (InterfaceC1593g) C1876j.m4985a(interfaceC1593g);
        this.f5281a |= 1024;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public <Y> T m4750a(@NonNull C1595i<Y> c1595i, @NonNull Y y) {
        if (this.f5302v) {
            return (T) mo26850clone().m4750a(c1595i, y);
        }
        C1876j.m4985a(c1595i);
        C1876j.m4985a(y);
        this.f5297q.m3839a(c1595i, y);
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4756a(@NonNull Class<?> cls) {
        if (this.f5302v) {
            return (T) mo26850clone().m4756a(cls);
        }
        this.f5299s = (Class) C1876j.m4985a(cls);
        this.f5281a |= 4096;
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4745a(@NonNull Bitmap.CompressFormat compressFormat) {
        return m4750a((C1595i<C1595i>) C1724e.f4831c, (C1595i) C1876j.m4985a(compressFormat));
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4741a(@IntRange(from = 0, m294to = 100) int i2) {
        return m4750a((C1595i<C1595i>) C1724e.f4830b, (C1595i) Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4743a(@IntRange(from = 0) long j2) {
        return m4750a((C1595i<C1595i>) C1735j0.f4863g, (C1595i) Long.valueOf(j2));
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4748a(@NonNull EnumC1588b enumC1588b) {
        C1876j.m4985a(enumC1588b);
        return (T) m4750a((C1595i<C1595i>) C1742q.f4918g, (C1595i) enumC1588b).m4750a(C1777h.f5045a, enumC1588b);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4754a(@NonNull AbstractC1741p abstractC1741p) {
        return m4750a((C1595i<C1595i>) AbstractC1741p.f4914h, (C1595i) C1876j.m4985a(abstractC1741p));
    }

    @NonNull
    /* renamed from: a */
    final T m4755a(@NonNull AbstractC1741p abstractC1741p, @NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        if (this.f5302v) {
            return (T) mo26850clone().m4755a(abstractC1741p, interfaceC1600n);
        }
        m4754a(abstractC1741p);
        return m4752a(interfaceC1600n, false);
    }

    @NonNull
    /* renamed from: a */
    private T m4717a(@NonNull AbstractC1741p abstractC1741p, @NonNull InterfaceC1600n<Bitmap> interfaceC1600n, boolean z) {
        T m4755a;
        if (z) {
            m4755a = m4765b(abstractC1741p, interfaceC1600n);
        } else {
            m4755a = m4755a(abstractC1741p, interfaceC1600n);
        }
        m4755a.f5305y = true;
        return m4755a;
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4760a(@NonNull InterfaceC1600n<Bitmap>... interfaceC1600nArr) {
        if (interfaceC1600nArr.length > 1) {
            return m4752a((InterfaceC1600n<Bitmap>) new C1594h(interfaceC1600nArr), true);
        }
        if (interfaceC1600nArr.length == 1) {
            return m4764b(interfaceC1600nArr[0]);
        }
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T m4751a(@NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        return m4752a(interfaceC1600n, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: a */
    T m4752a(@NonNull InterfaceC1600n<Bitmap> interfaceC1600n, boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4752a(interfaceC1600n, z);
        }
        C1744s c1744s = new C1744s(interfaceC1600n, z);
        m4758a(Bitmap.class, interfaceC1600n, z);
        m4758a(Drawable.class, c1744s, z);
        m4758a(BitmapDrawable.class, c1744s.m4400a(), z);
        m4758a(GifDrawable.class, new C1774e(interfaceC1600n), z);
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public <Y> T m4757a(@NonNull Class<Y> cls, @NonNull InterfaceC1600n<Y> interfaceC1600n) {
        return m4758a((Class) cls, (InterfaceC1600n) interfaceC1600n, false);
    }

    @NonNull
    /* renamed from: a */
    <Y> T m4758a(@NonNull Class<Y> cls, @NonNull InterfaceC1600n<Y> interfaceC1600n, boolean z) {
        if (this.f5302v) {
            return (T) mo26850clone().m4758a(cls, interfaceC1600n, z);
        }
        C1876j.m4985a(cls);
        C1876j.m4985a(interfaceC1600n);
        this.f5298r.put(cls, interfaceC1600n);
        this.f5281a |= 2048;
        this.f5294n = true;
        this.f5281a |= 65536;
        this.f5305y = false;
        if (z) {
            this.f5281a |= 131072;
            this.f5293m = true;
        }
        return m4716S();
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public T mo3763a(@NonNull AbstractC1822a<?> abstractC1822a) {
        if (this.f5302v) {
            return (T) mo26850clone().mo3763a(abstractC1822a);
        }
        if (m4718b(abstractC1822a.f5281a, 2)) {
            this.f5282b = abstractC1822a.f5282b;
        }
        if (m4718b(abstractC1822a.f5281a, 262144)) {
            this.f5303w = abstractC1822a.f5303w;
        }
        if (m4718b(abstractC1822a.f5281a, 1048576)) {
            this.f5306z = abstractC1822a.f5306z;
        }
        if (m4718b(abstractC1822a.f5281a, 4)) {
            this.f5283c = abstractC1822a.f5283c;
        }
        if (m4718b(abstractC1822a.f5281a, 8)) {
            this.f5284d = abstractC1822a.f5284d;
        }
        if (m4718b(abstractC1822a.f5281a, 16)) {
            this.f5285e = abstractC1822a.f5285e;
            this.f5286f = 0;
            this.f5281a &= -33;
        }
        if (m4718b(abstractC1822a.f5281a, 32)) {
            this.f5286f = abstractC1822a.f5286f;
            this.f5285e = null;
            this.f5281a &= -17;
        }
        if (m4718b(abstractC1822a.f5281a, 64)) {
            this.f5287g = abstractC1822a.f5287g;
            this.f5288h = 0;
            this.f5281a &= -129;
        }
        if (m4718b(abstractC1822a.f5281a, 128)) {
            this.f5288h = abstractC1822a.f5288h;
            this.f5287g = null;
            this.f5281a &= -65;
        }
        if (m4718b(abstractC1822a.f5281a, 256)) {
            this.f5289i = abstractC1822a.f5289i;
        }
        if (m4718b(abstractC1822a.f5281a, 512)) {
            this.f5291k = abstractC1822a.f5291k;
            this.f5290j = abstractC1822a.f5290j;
        }
        if (m4718b(abstractC1822a.f5281a, 1024)) {
            this.f5292l = abstractC1822a.f5292l;
        }
        if (m4718b(abstractC1822a.f5281a, 4096)) {
            this.f5299s = abstractC1822a.f5299s;
        }
        if (m4718b(abstractC1822a.f5281a, 8192)) {
            this.f5295o = abstractC1822a.f5295o;
            this.f5296p = 0;
            this.f5281a &= -16385;
        }
        if (m4718b(abstractC1822a.f5281a, 16384)) {
            this.f5296p = abstractC1822a.f5296p;
            this.f5295o = null;
            this.f5281a &= -8193;
        }
        if (m4718b(abstractC1822a.f5281a, 32768)) {
            this.f5301u = abstractC1822a.f5301u;
        }
        if (m4718b(abstractC1822a.f5281a, 65536)) {
            this.f5294n = abstractC1822a.f5294n;
        }
        if (m4718b(abstractC1822a.f5281a, 131072)) {
            this.f5293m = abstractC1822a.f5293m;
        }
        if (m4718b(abstractC1822a.f5281a, 2048)) {
            this.f5298r.putAll(abstractC1822a.f5298r);
            this.f5305y = abstractC1822a.f5305y;
        }
        if (m4718b(abstractC1822a.f5281a, 524288)) {
            this.f5304x = abstractC1822a.f5304x;
        }
        if (!this.f5294n) {
            this.f5298r.clear();
            this.f5281a &= -2049;
            this.f5293m = false;
            this.f5281a &= -131073;
            this.f5305y = true;
        }
        this.f5281a |= abstractC1822a.f5281a;
        this.f5297q.m3841a(abstractC1822a.f5297q);
        return m4716S();
    }

    @NonNull
    /* renamed from: a */
    public T m4739a() {
        if (this.f5300t && !this.f5302v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f5302v = true;
        return m4734M();
    }
}
