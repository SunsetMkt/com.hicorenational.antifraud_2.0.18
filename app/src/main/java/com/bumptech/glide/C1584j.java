package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1823b;
import com.bumptech.glide.p137r.C1827f;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.C1831j;
import com.bumptech.glide.p137r.C1832k;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.p137r.InterfaceC1826e;
import com.bumptech.glide.p137r.InterfaceC1828g;
import com.bumptech.glide.p137r.InterfaceFutureC1824c;
import com.bumptech.glide.p137r.p138l.AbstractC1850r;
import com.bumptech.glide.p137r.p138l.C1845m;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p140s.C1862a;
import com.bumptech.glide.util.C1870d;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder.java */
/* renamed from: com.bumptech.glide.j */
/* loaded from: classes.dex */
public class C1584j<TranscodeType> extends AbstractC1822a<C1584j<TranscodeType>> implements Cloneable, InterfaceC1581g<C1584j<TranscodeType>> {

    /* renamed from: v0 */
    protected static final C1829h f4141v0 = new C1829h().m4753a(AbstractC1665j.f4539c).m4747a(EnumC1582h.LOW).m4767b(true);

    /* renamed from: h0 */
    private final Context f4142h0;

    /* renamed from: i0 */
    private final ComponentCallbacks2C1585k f4143i0;

    /* renamed from: j0 */
    private final Class<TranscodeType> f4144j0;

    /* renamed from: k0 */
    private final ComponentCallbacks2C1576b f4145k0;

    /* renamed from: l0 */
    private final C1578d f4146l0;

    /* renamed from: m0 */
    @NonNull
    private AbstractC1586l<?, ? super TranscodeType> f4147m0;

    /* renamed from: n0 */
    @Nullable
    private Object f4148n0;

    /* renamed from: o0 */
    @Nullable
    private List<InterfaceC1828g<TranscodeType>> f4149o0;

    /* renamed from: p0 */
    @Nullable
    private C1584j<TranscodeType> f4150p0;

    /* renamed from: q0 */
    @Nullable
    private C1584j<TranscodeType> f4151q0;

    /* renamed from: r0 */
    @Nullable
    private Float f4152r0;

    /* renamed from: s0 */
    private boolean f4153s0;

    /* renamed from: t0 */
    private boolean f4154t0;

    /* renamed from: u0 */
    private boolean f4155u0;

    /* compiled from: RequestBuilder.java */
    /* renamed from: com.bumptech.glide.j$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4156a;

        /* renamed from: b */
        static final /* synthetic */ int[] f4157b = new int[EnumC1582h.values().length];

        static {
            try {
                f4157b[EnumC1582h.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4157b[EnumC1582h.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4157b[EnumC1582h.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4157b[EnumC1582h.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4156a = new int[ImageView.ScaleType.values().length];
            try {
                f4156a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4156a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4156a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4156a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4156a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4156a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4156a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4156a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected C1584j(@NonNull ComponentCallbacks2C1576b componentCallbacks2C1576b, ComponentCallbacks2C1585k componentCallbacks2C1585k, Class<TranscodeType> cls, Context context) {
        this.f4153s0 = true;
        this.f4145k0 = componentCallbacks2C1576b;
        this.f4143i0 = componentCallbacks2C1585k;
        this.f4144j0 = cls;
        this.f4142h0 = context;
        this.f4147m0 = componentCallbacks2C1585k.m3789b((Class) cls);
        this.f4146l0 = componentCallbacks2C1576b.m3663g();
        m3752a(componentCallbacks2C1585k.m3796g());
        mo3763a((AbstractC1822a<?>) componentCallbacks2C1585k.m3797h());
    }

    @NonNull
    @CheckResult
    /* renamed from: R */
    protected C1584j<File> m3758R() {
        return new C1584j(File.class, this).mo3763a((AbstractC1822a<?>) f4141v0);
    }

    @NonNull
    /* renamed from: S */
    public InterfaceC1848p<TranscodeType> m3759S() {
        return m3775d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    /* renamed from: T */
    public InterfaceFutureC1824c<TranscodeType> m3760T() {
        return m3776e(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.p137r.AbstractC1822a
    @NonNull
    @CheckResult
    /* renamed from: a */
    public /* bridge */ /* synthetic */ AbstractC1822a mo3763a(@NonNull AbstractC1822a abstractC1822a) {
        return mo3763a((AbstractC1822a<?>) abstractC1822a);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public C1584j<TranscodeType> m3771b(@Nullable InterfaceC1828g<TranscodeType> interfaceC1828g) {
        this.f4149o0 = null;
        return m3764a((InterfaceC1828g) interfaceC1828g);
    }

    @Deprecated
    /* renamed from: c */
    public InterfaceFutureC1824c<TranscodeType> m3774c(int i2, int i3) {
        return m3776e(i2, i3);
    }

    @NonNull
    /* renamed from: e */
    public InterfaceFutureC1824c<TranscodeType> m3776e(int i2, int i3) {
        C1827f c1827f = new C1827f(i2, i3);
        return (InterfaceFutureC1824c) m3767a((C1584j<TranscodeType>) c1827f, c1827f, C1870d.m4966a());
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: d */
    public C1584j<TranscodeType> mo3722d(@Nullable Drawable drawable) {
        return m3755b((Object) drawable).mo3763a((AbstractC1822a<?>) C1829h.m4834b(AbstractC1665j.f4538b));
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public C1584j<TranscodeType> m3770b(@Nullable C1584j<TranscodeType> c1584j) {
        this.f4150p0 = c1584j;
        return this;
    }

    @Override // com.bumptech.glide.p137r.AbstractC1822a
    @CheckResult
    /* renamed from: clone */
    public C1584j<TranscodeType> mo26850clone() {
        C1584j<TranscodeType> c1584j = (C1584j) super.mo26850clone();
        c1584j.f4147m0 = (AbstractC1586l<?, ? super TranscodeType>) c1584j.f4147m0.m26851clone();
        return c1584j;
    }

    @NonNull
    /* renamed from: d */
    public InterfaceC1848p<TranscodeType> m3775d(int i2, int i3) {
        return m3773b((C1584j<TranscodeType>) C1845m.m4911a(this.f4143i0, i2, i3));
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public C1584j<TranscodeType> m3769b(float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.f4152r0 = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    /* renamed from: b */
    private C1584j<TranscodeType> m3755b(@Nullable Object obj) {
        this.f4148n0 = obj;
        this.f4154t0 = true;
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Y extends InterfaceC1848p<TranscodeType>> Y m3773b(@NonNull Y y) {
        return (Y) m3767a((C1584j<TranscodeType>) y, (InterfaceC1828g) null, C1870d.m4968b());
    }

    /* renamed from: b */
    private <Y extends InterfaceC1848p<TranscodeType>> Y m3757b(@NonNull Y y, @Nullable InterfaceC1828g<TranscodeType> interfaceC1828g, AbstractC1822a<?> abstractC1822a, Executor executor) {
        C1876j.m4985a(y);
        if (this.f4154t0) {
            InterfaceC1825d m3749a = m3749a(y, interfaceC1828g, abstractC1822a, executor);
            InterfaceC1825d mo3705a = y.mo3705a();
            if (m3749a.mo4806a(mo3705a) && !m3753a(abstractC1822a, mo3705a)) {
                if (!((InterfaceC1825d) C1876j.m4985a(mo3705a)).isRunning()) {
                    mo3705a.mo4809c();
                }
                return y;
            }
            this.f4143i0.m3783a((InterfaceC1848p<?>) y);
            y.mo3707a(m3749a);
            this.f4143i0.m3784a(y, m3749a);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private void m3752a(List<InterfaceC1828g<Object>> list) {
        Iterator<InterfaceC1828g<Object>> it = list.iterator();
        while (it.hasNext()) {
            m3764a((InterfaceC1828g) it.next());
        }
    }

    @SuppressLint({"CheckResult"})
    protected C1584j(Class<TranscodeType> cls, C1584j<?> c1584j) {
        this(c1584j.f4145k0, c1584j.f4143i0, cls, c1584j.f4142h0);
        this.f4148n0 = c1584j.f4148n0;
        this.f4154t0 = c1584j.f4154t0;
        mo3763a((AbstractC1822a<?>) c1584j);
    }

    @Override // com.bumptech.glide.p137r.AbstractC1822a
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3763a(@NonNull AbstractC1822a<?> abstractC1822a) {
        C1876j.m4985a(abstractC1822a);
        return (C1584j) super.mo3763a(abstractC1822a);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> m3762a(@NonNull AbstractC1586l<?, ? super TranscodeType> abstractC1586l) {
        this.f4147m0 = (AbstractC1586l) C1876j.m4985a(abstractC1586l);
        this.f4153s0 = false;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> m3764a(@Nullable InterfaceC1828g<TranscodeType> interfaceC1828g) {
        if (interfaceC1828g != null) {
            if (this.f4149o0 == null) {
                this.f4149o0 = new ArrayList();
            }
            this.f4149o0.add(interfaceC1828g);
        }
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1584j<TranscodeType> m3761a(@Nullable C1584j<TranscodeType> c1584j) {
        this.f4151q0 = c1584j;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> m3765a(@Nullable C1584j<TranscodeType>... c1584jArr) {
        C1584j<TranscodeType> c1584j = null;
        if (c1584jArr != null && c1584jArr.length != 0) {
            for (int length = c1584jArr.length - 1; length >= 0; length--) {
                C1584j<TranscodeType> c1584j2 = c1584jArr[length];
                if (c1584j2 != null) {
                    c1584j = c1584j == null ? c1584j2 : c1584j2.m3770b((C1584j) c1584j);
                }
            }
            return m3770b((C1584j) c1584j);
        }
        return m3770b((C1584j) null);
    }

    @CheckResult
    @Deprecated
    /* renamed from: b */
    public InterfaceFutureC1824c<File> m3772b(int i2, int i3) {
        return m3758R().m3776e(i2, i3);
    }

    @NonNull
    /* renamed from: b */
    private EnumC1582h m3754b(@NonNull EnumC1582h enumC1582h) {
        int i2 = a.f4157b[enumC1582h.ordinal()];
        if (i2 == 1) {
            return EnumC1582h.NORMAL;
        }
        if (i2 == 2) {
            return EnumC1582h.HIGH;
        }
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException("unknown priority: " + m4793t());
        }
        return EnumC1582h.IMMEDIATE;
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3718a(@Nullable Object obj) {
        return m3755b(obj);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.r.a] */
    /* renamed from: b */
    private InterfaceC1825d m3756b(Object obj, InterfaceC1848p<TranscodeType> interfaceC1848p, InterfaceC1828g<TranscodeType> interfaceC1828g, @Nullable InterfaceC1826e interfaceC1826e, AbstractC1586l<?, ? super TranscodeType> abstractC1586l, EnumC1582h enumC1582h, int i2, int i3, AbstractC1822a<?> abstractC1822a, Executor executor) {
        EnumC1582h m3754b;
        C1584j<TranscodeType> c1584j = this.f4150p0;
        if (c1584j != null) {
            if (!this.f4155u0) {
                AbstractC1586l<?, ? super TranscodeType> abstractC1586l2 = c1584j.f4153s0 ? abstractC1586l : c1584j.f4147m0;
                if (this.f4150p0.m4727F()) {
                    m3754b = this.f4150p0.m4793t();
                } else {
                    m3754b = m3754b(enumC1582h);
                }
                EnumC1582h enumC1582h2 = m3754b;
                int m4790q = this.f4150p0.m4790q();
                int m4789p = this.f4150p0.m4789p();
                if (C1878l.m5008b(i2, i3) && !this.f4150p0.m4733L()) {
                    m4790q = abstractC1822a.m4790q();
                    m4789p = abstractC1822a.m4789p();
                }
                C1832k c1832k = new C1832k(obj, interfaceC1826e);
                InterfaceC1825d m3750a = m3750a(obj, interfaceC1848p, interfaceC1828g, abstractC1822a, c1832k, abstractC1586l, enumC1582h, i2, i3, executor);
                this.f4155u0 = true;
                C1584j<TranscodeType> c1584j2 = this.f4150p0;
                InterfaceC1825d m3751a = c1584j2.m3751a(obj, interfaceC1848p, interfaceC1828g, c1832k, abstractC1586l2, enumC1582h2, m4790q, m4789p, c1584j2, executor);
                this.f4155u0 = false;
                c1832k.m4871a(m3750a, m3751a);
                return c1832k;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.f4152r0 != null) {
            C1832k c1832k2 = new C1832k(obj, interfaceC1826e);
            c1832k2.m4871a(m3750a(obj, interfaceC1848p, interfaceC1828g, abstractC1822a, c1832k2, abstractC1586l, enumC1582h, i2, i3, executor), m3750a(obj, interfaceC1848p, interfaceC1828g, abstractC1822a.mo26850clone().m4740a(this.f4152r0.floatValue()), c1832k2, abstractC1586l, m3754b(enumC1582h), i2, i3, executor));
            return c1832k2;
        }
        return m3750a(obj, interfaceC1848p, interfaceC1828g, abstractC1822a, interfaceC1826e, abstractC1586l, enumC1582h, i2, i3, executor);
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3714a(@Nullable Bitmap bitmap) {
        return m3755b(bitmap).mo3763a((AbstractC1822a<?>) C1829h.m4834b(AbstractC1665j.f4538b));
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3719a(@Nullable String str) {
        return m3755b(str);
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3715a(@Nullable Uri uri) {
        return m3755b(uri);
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3716a(@Nullable File file) {
        return m3755b(file);
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3717a(@Nullable @DrawableRes @RawRes Integer num) {
        return m3755b(num).mo3763a((AbstractC1822a<?>) C1829h.m4832b(C1862a.m4943a(this.f4142h0)));
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @CheckResult
    @Deprecated
    /* renamed from: a */
    public C1584j<TranscodeType> mo3720a(@Nullable URL url) {
        return m3755b(url);
    }

    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<TranscodeType> mo3721a(@Nullable byte[] bArr) {
        C1584j<TranscodeType> m3755b = m3755b(bArr);
        if (!m3755b.m4724C()) {
            m3755b = m3755b.mo3763a((AbstractC1822a<?>) C1829h.m4834b(AbstractC1665j.f4538b));
        }
        return !m3755b.m4729H() ? m3755b.mo3763a((AbstractC1822a<?>) C1829h.m4839e(true)) : m3755b;
    }

    @NonNull
    /* renamed from: a */
    <Y extends InterfaceC1848p<TranscodeType>> Y m3767a(@NonNull Y y, @Nullable InterfaceC1828g<TranscodeType> interfaceC1828g, Executor executor) {
        return (Y) m3757b(y, interfaceC1828g, this, executor);
    }

    /* renamed from: a */
    private boolean m3753a(AbstractC1822a<?> abstractC1822a, InterfaceC1825d interfaceC1825d) {
        return !abstractC1822a.m4726E() && interfaceC1825d.mo4811d();
    }

    @NonNull
    /* renamed from: a */
    public AbstractC1850r<ImageView, TranscodeType> m3768a(@NonNull ImageView imageView) {
        AbstractC1822a<?> abstractC1822a;
        C1878l.m5007b();
        C1876j.m4985a(imageView);
        if (!m4732K() && m4730I() && imageView.getScaleType() != null) {
            switch (a.f4156a[imageView.getScaleType().ordinal()]) {
                case 1:
                    abstractC1822a = mo26850clone().m4735N();
                    break;
                case 2:
                    abstractC1822a = mo26850clone().m4736O();
                    break;
                case 3:
                case 4:
                case 5:
                    abstractC1822a = mo26850clone().m4738Q();
                    break;
                case 6:
                    abstractC1822a = mo26850clone().m4736O();
                    break;
            }
            return (AbstractC1850r) m3757b(this.f4146l0.m3690a(imageView, this.f4144j0), null, abstractC1822a, C1870d.m4968b());
        }
        abstractC1822a = this;
        return (AbstractC1850r) m3757b(this.f4146l0.m3690a(imageView, this.f4144j0), null, abstractC1822a, C1870d.m4968b());
    }

    @CheckResult
    @Deprecated
    /* renamed from: a */
    public <Y extends InterfaceC1848p<File>> Y m3766a(@NonNull Y y) {
        return (Y) m3758R().m3773b((C1584j<File>) y);
    }

    /* renamed from: a */
    private InterfaceC1825d m3749a(InterfaceC1848p<TranscodeType> interfaceC1848p, @Nullable InterfaceC1828g<TranscodeType> interfaceC1828g, AbstractC1822a<?> abstractC1822a, Executor executor) {
        return m3751a(new Object(), interfaceC1848p, interfaceC1828g, (InterfaceC1826e) null, this.f4147m0, abstractC1822a.m4793t(), abstractC1822a.m4790q(), abstractC1822a.m4789p(), abstractC1822a, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private InterfaceC1825d m3751a(Object obj, InterfaceC1848p<TranscodeType> interfaceC1848p, @Nullable InterfaceC1828g<TranscodeType> interfaceC1828g, @Nullable InterfaceC1826e interfaceC1826e, AbstractC1586l<?, ? super TranscodeType> abstractC1586l, EnumC1582h enumC1582h, int i2, int i3, AbstractC1822a<?> abstractC1822a, Executor executor) {
        InterfaceC1826e interfaceC1826e2;
        InterfaceC1826e interfaceC1826e3;
        if (this.f4151q0 != null) {
            interfaceC1826e3 = new C1823b(obj, interfaceC1826e);
            interfaceC1826e2 = interfaceC1826e3;
        } else {
            interfaceC1826e2 = null;
            interfaceC1826e3 = interfaceC1826e;
        }
        InterfaceC1825d m3756b = m3756b(obj, interfaceC1848p, interfaceC1828g, interfaceC1826e3, abstractC1586l, enumC1582h, i2, i3, abstractC1822a, executor);
        if (interfaceC1826e2 == null) {
            return m3756b;
        }
        int m4790q = this.f4151q0.m4790q();
        int m4789p = this.f4151q0.m4789p();
        if (C1878l.m5008b(i2, i3) && !this.f4151q0.m4733L()) {
            m4790q = abstractC1822a.m4790q();
            m4789p = abstractC1822a.m4789p();
        }
        C1584j<TranscodeType> c1584j = this.f4151q0;
        C1823b c1823b = interfaceC1826e2;
        c1823b.m4804a(m3756b, c1584j.m3751a(obj, interfaceC1848p, interfaceC1828g, c1823b, c1584j.f4147m0, c1584j.m4793t(), m4790q, m4789p, this.f4151q0, executor));
        return c1823b;
    }

    /* renamed from: a */
    private InterfaceC1825d m3750a(Object obj, InterfaceC1848p<TranscodeType> interfaceC1848p, InterfaceC1828g<TranscodeType> interfaceC1828g, AbstractC1822a<?> abstractC1822a, InterfaceC1826e interfaceC1826e, AbstractC1586l<?, ? super TranscodeType> abstractC1586l, EnumC1582h enumC1582h, int i2, int i3, Executor executor) {
        Context context = this.f4142h0;
        C1578d c1578d = this.f4146l0;
        return C1831j.m4851a(context, c1578d, obj, this.f4148n0, this.f4144j0, abstractC1822a, i2, i3, enumC1582h, interfaceC1848p, interfaceC1828g, this.f4149o0, interfaceC1826e, c1578d.m3693d(), abstractC1586l.m3812b(), executor);
    }
}
