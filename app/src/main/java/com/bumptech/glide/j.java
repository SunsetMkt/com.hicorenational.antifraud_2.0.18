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
import com.bumptech.glide.r.l.m;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.r.l.r;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class j<TranscodeType> extends com.bumptech.glide.r.a<j<TranscodeType>> implements Cloneable, g<j<TranscodeType>> {
    protected static final com.bumptech.glide.r.h v0 = new com.bumptech.glide.r.h().a(com.bumptech.glide.load.p.j.f2962c).a(h.LOW).b(true);
    private final Context h0;
    private final k i0;
    private final Class<TranscodeType> j0;
    private final b k0;
    private final d l0;

    @NonNull
    private l<?, ? super TranscodeType> m0;

    @Nullable
    private Object n0;

    @Nullable
    private List<com.bumptech.glide.r.g<TranscodeType>> o0;

    @Nullable
    private j<TranscodeType> p0;

    @Nullable
    private j<TranscodeType> q0;

    @Nullable
    private Float r0;
    private boolean s0;
    private boolean t0;
    private boolean u0;

    /* JADX INFO: compiled from: RequestBuilder.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f2697b = new int[h.values().length];

        static {
            try {
                f2697b[h.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2697b[h.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2697b[h.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2697b[h.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[ImageView.ScaleType.values().length];
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected j(@NonNull b bVar, k kVar, Class<TranscodeType> cls, Context context) {
        this.s0 = true;
        this.k0 = bVar;
        this.i0 = kVar;
        this.j0 = cls;
        this.h0 = context;
        this.m0 = kVar.b((Class) cls);
        this.l0 = bVar.g();
        a(kVar.g());
        a((com.bumptech.glide.r.a<?>) kVar.h());
    }

    @NonNull
    @CheckResult
    protected j<File> R() {
        return new j(File.class, this).a((com.bumptech.glide.r.a<?>) v0);
    }

    @NonNull
    public p<TranscodeType> S() {
        return d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public com.bumptech.glide.r.c<TranscodeType> T() {
        return e(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.r.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.r.a a(@NonNull com.bumptech.glide.r.a aVar) {
        return a((com.bumptech.glide.r.a<?>) aVar);
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(@Nullable com.bumptech.glide.r.g<TranscodeType> gVar) {
        this.o0 = null;
        return a((com.bumptech.glide.r.g) gVar);
    }

    @Deprecated
    public com.bumptech.glide.r.c<TranscodeType> c(int i2, int i3) {
        return e(i2, i3);
    }

    @NonNull
    public com.bumptech.glide.r.c<TranscodeType> e(int i2, int i3) {
        com.bumptech.glide.r.f fVar = new com.bumptech.glide.r.f(i2, i3);
        return (com.bumptech.glide.r.c) a(fVar, fVar, com.bumptech.glide.util.d.a());
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> d(@Nullable Drawable drawable) {
        return b((Object) drawable).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f2961b));
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(@Nullable j<TranscodeType> jVar) {
        this.p0 = jVar;
        return this;
    }

    @Override // com.bumptech.glide.r.a
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public j<TranscodeType> mo34clone() {
        j<TranscodeType> jVar = (j) super.mo34clone();
        jVar.m0 = jVar.m0.m35clone();
        return jVar;
    }

    @NonNull
    public p<TranscodeType> d(int i2, int i3) {
        return b(m.a(this.i0, i2, i3));
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.r0 = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    private j<TranscodeType> b(@Nullable Object obj) {
        this.n0 = obj;
        this.t0 = true;
        return this;
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y b(@NonNull Y y) {
        return (Y) a(y, (com.bumptech.glide.r.g) null, com.bumptech.glide.util.d.b());
    }

    private <Y extends p<TranscodeType>> Y b(@NonNull Y y, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        com.bumptech.glide.util.j.a(y);
        if (this.t0) {
            com.bumptech.glide.r.d dVarA = a(y, gVar, aVar, executor);
            com.bumptech.glide.r.d dVarA2 = y.a();
            if (dVarA.a(dVarA2) && !a(aVar, dVarA2)) {
                if (!((com.bumptech.glide.r.d) com.bumptech.glide.util.j.a(dVarA2)).isRunning()) {
                    dVarA2.c();
                }
                return y;
            }
            this.i0.a((p<?>) y);
            y.a(dVarA);
            this.i0.a(y, dVarA);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @SuppressLint({"CheckResult"})
    private void a(List<com.bumptech.glide.r.g<Object>> list) {
        Iterator<com.bumptech.glide.r.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.r.g) it.next());
        }
    }

    @SuppressLint({"CheckResult"})
    protected j(Class<TranscodeType> cls, j<?> jVar) {
        this(jVar.k0, jVar.i0, cls, jVar.h0);
        this.n0 = jVar.n0;
        this.t0 = jVar.t0;
        a((com.bumptech.glide.r.a<?>) jVar);
    }

    @Override // com.bumptech.glide.r.a
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@NonNull com.bumptech.glide.r.a<?> aVar) {
        com.bumptech.glide.util.j.a(aVar);
        return (j) super.a(aVar);
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@NonNull l<?, ? super TranscodeType> lVar) {
        this.m0 = (l) com.bumptech.glide.util.j.a(lVar);
        this.s0 = false;
        return this;
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable com.bumptech.glide.r.g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.o0 == null) {
                this.o0 = new ArrayList();
            }
            this.o0.add(gVar);
        }
        return this;
    }

    @NonNull
    public j<TranscodeType> a(@Nullable j<TranscodeType> jVar) {
        this.q0 = jVar;
        return this;
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable j<TranscodeType>... jVarArr) {
        j<TranscodeType> jVarB = null;
        if (jVarArr != null && jVarArr.length != 0) {
            for (int length = jVarArr.length - 1; length >= 0; length--) {
                j<TranscodeType> jVar = jVarArr[length];
                if (jVar != null) {
                    jVarB = jVarB == null ? jVar : jVar.b((j) jVarB);
                }
            }
            return b((j) jVarB);
        }
        return b((j) null);
    }

    @CheckResult
    @Deprecated
    public com.bumptech.glide.r.c<File> b(int i2, int i3) {
        return R().e(i2, i3);
    }

    @NonNull
    private h b(@NonNull h hVar) {
        int i2 = a.f2697b[hVar.ordinal()];
        if (i2 == 1) {
            return h.NORMAL;
        }
        if (i2 == 2) {
            return h.HIGH;
        }
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException("unknown priority: " + t());
        }
        return h.IMMEDIATE;
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Object obj) {
        return b(obj);
    }

    private com.bumptech.glide.r.d b(Object obj, p<TranscodeType> pVar, com.bumptech.glide.r.g<TranscodeType> gVar, @Nullable com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        h hVarB;
        j<TranscodeType> jVar = this.p0;
        if (jVar != null) {
            if (!this.u0) {
                l<?, ? super TranscodeType> lVar2 = jVar.s0 ? lVar : jVar.m0;
                if (this.p0.F()) {
                    hVarB = this.p0.t();
                } else {
                    hVarB = b(hVar);
                }
                h hVar2 = hVarB;
                int iQ = this.p0.q();
                int iP = this.p0.p();
                if (com.bumptech.glide.util.l.b(i2, i3) && !this.p0.L()) {
                    iQ = aVar.q();
                    iP = aVar.p();
                }
                com.bumptech.glide.r.k kVar = new com.bumptech.glide.r.k(obj, eVar);
                com.bumptech.glide.r.d dVarA = a(obj, pVar, gVar, aVar, kVar, lVar, hVar, i2, i3, executor);
                this.u0 = true;
                j<TranscodeType> jVar2 = this.p0;
                com.bumptech.glide.r.d dVarA2 = jVar2.a(obj, pVar, gVar, kVar, lVar2, hVar2, iQ, iP, jVar2, executor);
                this.u0 = false;
                kVar.a(dVarA, dVarA2);
                return kVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.r0 != null) {
            com.bumptech.glide.r.k kVar2 = new com.bumptech.glide.r.k(obj, eVar);
            kVar2.a(a(obj, pVar, gVar, aVar, kVar2, lVar, hVar, i2, i3, executor), a(obj, pVar, gVar, aVar.mo34clone().a(this.r0.floatValue()), kVar2, lVar, b(hVar), i2, i3, executor));
            return kVar2;
        }
        return a(obj, pVar, gVar, aVar, eVar, lVar, hVar, i2, i3, executor);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Bitmap bitmap) {
        return b(bitmap).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f2961b));
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable String str) {
        return b(str);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Uri uri) {
        return b(uri);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable File file) {
        return b(file);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable @DrawableRes @RawRes Integer num) {
        return b(num).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.s.a.a(this.h0)));
    }

    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    public j<TranscodeType> a(@Nullable URL url) {
        return b(url);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable byte[] bArr) {
        j<TranscodeType> jVarB = b(bArr);
        if (!jVarB.C()) {
            jVarB = jVarB.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f2961b));
        }
        return !jVarB.H() ? jVarB.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.e(true)) : jVarB;
    }

    @NonNull
    <Y extends p<TranscodeType>> Y a(@NonNull Y y, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, Executor executor) {
        return (Y) b(y, gVar, this, executor);
    }

    private boolean a(com.bumptech.glide.r.a<?> aVar, com.bumptech.glide.r.d dVar) {
        return !aVar.E() && dVar.d();
    }

    @NonNull
    public r<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        com.bumptech.glide.r.a aVarN;
        com.bumptech.glide.util.l.b();
        com.bumptech.glide.util.j.a(imageView);
        if (!K() && I() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarN = mo34clone().N();
                    break;
                case 2:
                    aVarN = mo34clone().O();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarN = mo34clone().Q();
                    break;
                case 6:
                    aVarN = mo34clone().O();
                    break;
                default:
                    aVarN = this;
                    break;
            }
        } else {
            aVarN = this;
        }
        return (r) b(this.l0.a(imageView, this.j0), null, aVarN, com.bumptech.glide.util.d.b());
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y a(@NonNull Y y) {
        return (Y) R().b(y);
    }

    private com.bumptech.glide.r.d a(p<TranscodeType> pVar, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        return a(new Object(), pVar, gVar, (com.bumptech.glide.r.e) null, this.m0, aVar.t(), aVar.q(), aVar.p(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.r.d a(Object obj, p<TranscodeType> pVar, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, @Nullable com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        com.bumptech.glide.r.e eVar2;
        com.bumptech.glide.r.e bVar;
        if (this.q0 != null) {
            bVar = new com.bumptech.glide.r.b(obj, eVar);
            eVar2 = bVar;
        } else {
            eVar2 = null;
            bVar = eVar;
        }
        com.bumptech.glide.r.d dVarB = b(obj, pVar, gVar, bVar, lVar, hVar, i2, i3, aVar, executor);
        if (eVar2 == null) {
            return dVarB;
        }
        int iQ = this.q0.q();
        int iP = this.q0.p();
        if (com.bumptech.glide.util.l.b(i2, i3) && !this.q0.L()) {
            iQ = aVar.q();
            iP = aVar.p();
        }
        j<TranscodeType> jVar = this.q0;
        com.bumptech.glide.r.b bVar2 = eVar2;
        bVar2.a(dVarB, jVar.a(obj, pVar, gVar, bVar2, jVar.m0, jVar.t(), iQ, iP, this.q0, executor));
        return bVar2;
    }

    private com.bumptech.glide.r.d a(Object obj, p<TranscodeType> pVar, com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, Executor executor) {
        Context context = this.h0;
        d dVar = this.l0;
        return com.bumptech.glide.r.j.a(context, dVar, obj, this.n0, this.j0, aVar, i2, i3, hVar, pVar, gVar, this.o0, eVar, dVar.d(), lVar.b(), executor);
    }
}
