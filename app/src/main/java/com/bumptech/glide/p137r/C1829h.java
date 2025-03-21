package com.bumptech.glide.p137r;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.load.p125r.p126d.AbstractC1741p;

/* compiled from: RequestOptions.java */
/* renamed from: com.bumptech.glide.r.h */
/* loaded from: classes.dex */
public class C1829h extends AbstractC1822a<C1829h> {

    /* renamed from: h0 */
    @Nullable
    private static C1829h f5325h0;

    /* renamed from: i0 */
    @Nullable
    private static C1829h f5326i0;

    /* renamed from: j0 */
    @Nullable
    private static C1829h f5327j0;

    /* renamed from: k0 */
    @Nullable
    private static C1829h f5328k0;

    /* renamed from: l0 */
    @Nullable
    private static C1829h f5329l0;

    /* renamed from: m0 */
    @Nullable
    private static C1829h f5330m0;

    /* renamed from: n0 */
    @Nullable
    private static C1829h f5331n0;

    /* renamed from: o0 */
    @Nullable
    private static C1829h f5332o0;

    @NonNull
    @CheckResult
    /* renamed from: R */
    public static C1829h m4820R() {
        if (f5329l0 == null) {
            f5329l0 = new C1829h().m4761b().m4739a();
        }
        return f5329l0;
    }

    @NonNull
    @CheckResult
    /* renamed from: S */
    public static C1829h m4821S() {
        if (f5328k0 == null) {
            f5328k0 = new C1829h().m4769c().m4739a();
        }
        return f5328k0;
    }

    @NonNull
    @CheckResult
    /* renamed from: T */
    public static C1829h m4822T() {
        if (f5330m0 == null) {
            f5330m0 = new C1829h().m4773d().m4739a();
        }
        return f5330m0;
    }

    @NonNull
    @CheckResult
    /* renamed from: U */
    public static C1829h m4823U() {
        if (f5327j0 == null) {
            f5327j0 = new C1829h().m4781h().m4739a();
        }
        return f5327j0;
    }

    @NonNull
    @CheckResult
    /* renamed from: V */
    public static C1829h m4824V() {
        if (f5332o0 == null) {
            f5332o0 = new C1829h().m4778f().m4739a();
        }
        return f5332o0;
    }

    @NonNull
    @CheckResult
    /* renamed from: W */
    public static C1829h m4825W() {
        if (f5331n0 == null) {
            f5331n0 = new C1829h().m4780g().m4739a();
        }
        return f5331n0;
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4826b(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        return new C1829h().m4740a(f2);
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public static C1829h m4837c(@NonNull InterfaceC1600n<Bitmap> interfaceC1600n) {
        return new C1829h().m4764b(interfaceC1600n);
    }

    @NonNull
    @CheckResult
    /* renamed from: e */
    public static C1829h m4838e(@Nullable Drawable drawable) {
        return new C1829h().m4746a(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: f */
    public static C1829h m4840f(@Nullable Drawable drawable) {
        return new C1829h().m4771c(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: g */
    public static C1829h m4841g(@IntRange(from = 0, m294to = 100) int i2) {
        return new C1829h().m4741a(i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: h */
    public static C1829h m4842h(@DrawableRes int i2) {
        return new C1829h().m4762b(i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: i */
    public static C1829h m4843i(int i2) {
        return m4827b(i2, i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: j */
    public static C1829h m4844j(@DrawableRes int i2) {
        return new C1829h().m4777e(i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: k */
    public static C1829h m4845k(@IntRange(from = 0) int i2) {
        return new C1829h().m4779f(i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4834b(@NonNull AbstractC1665j abstractC1665j) {
        return new C1829h().m4753a(abstractC1665j);
    }

    @NonNull
    @CheckResult
    /* renamed from: e */
    public static C1829h m4839e(boolean z) {
        if (z) {
            if (f5325h0 == null) {
                f5325h0 = new C1829h().m4767b(true).m4739a();
            }
            return f5325h0;
        }
        if (f5326i0 == null) {
            f5326i0 = new C1829h().m4767b(false).m4739a();
        }
        return f5326i0;
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4830b(@NonNull EnumC1582h enumC1582h) {
        return new C1829h().m4747a(enumC1582h);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4827b(int i2, int i3) {
        return new C1829h().m4742a(i2, i3);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4832b(@NonNull InterfaceC1593g interfaceC1593g) {
        return new C1829h().m4749a(interfaceC1593g);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static <T> C1829h m4833b(@NonNull C1595i<T> c1595i, @NonNull T t) {
        return new C1829h().m4750a((C1595i<C1595i<T>>) c1595i, (C1595i<T>) t);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4836b(@NonNull Class<?> cls) {
        return new C1829h().m4756a(cls);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4831b(@NonNull EnumC1588b enumC1588b) {
        return new C1829h().m4748a(enumC1588b);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4828b(@IntRange(from = 0) long j2) {
        return new C1829h().m4743a(j2);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4835b(@NonNull AbstractC1741p abstractC1741p) {
        return new C1829h().m4754a(abstractC1741p);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public static C1829h m4829b(@NonNull Bitmap.CompressFormat compressFormat) {
        return new C1829h().m4745a(compressFormat);
    }
}
