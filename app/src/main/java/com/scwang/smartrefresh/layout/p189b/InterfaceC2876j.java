package com.scwang.smartrefresh.layout.p189b;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2883c;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2885e;

/* compiled from: RefreshLayout.java */
/* renamed from: com.scwang.smartrefresh.layout.b.j */
/* loaded from: classes.dex */
public interface InterfaceC2876j {
    /* renamed from: a */
    InterfaceC2876j mo8614a(@FloatRange(from = 1.0d, m293to = 10.0d) float f2);

    /* renamed from: a */
    InterfaceC2876j mo8615a(int i2, boolean z);

    /* renamed from: a */
    InterfaceC2876j mo8616a(int i2, boolean z, boolean z2);

    /* renamed from: a */
    InterfaceC2876j mo8617a(@NonNull View view);

    /* renamed from: a */
    InterfaceC2876j mo8618a(@NonNull View view, int i2, int i3);

    /* renamed from: a */
    InterfaceC2876j mo8619a(@NonNull Interpolator interpolator);

    /* renamed from: a */
    InterfaceC2876j mo8620a(@NonNull InterfaceC2872f interfaceC2872f);

    /* renamed from: a */
    InterfaceC2876j mo8621a(@NonNull InterfaceC2872f interfaceC2872f, int i2, int i3);

    /* renamed from: a */
    InterfaceC2876j mo8622a(@NonNull InterfaceC2873g interfaceC2873g);

    /* renamed from: a */
    InterfaceC2876j mo8623a(@NonNull InterfaceC2873g interfaceC2873g, int i2, int i3);

    /* renamed from: a */
    InterfaceC2876j mo8624a(InterfaceC2877k interfaceC2877k);

    /* renamed from: a */
    InterfaceC2876j mo8625a(InterfaceC2882b interfaceC2882b);

    /* renamed from: a */
    InterfaceC2876j mo8626a(InterfaceC2883c interfaceC2883c);

    /* renamed from: a */
    InterfaceC2876j mo8627a(InterfaceC2884d interfaceC2884d);

    /* renamed from: a */
    InterfaceC2876j mo8628a(InterfaceC2885e interfaceC2885e);

    @Deprecated
    /* renamed from: a */
    InterfaceC2876j mo8629a(boolean z);

    /* renamed from: a */
    InterfaceC2876j mo8630a(@ColorRes int... iArr);

    /* renamed from: a */
    boolean mo8632a();

    @Deprecated
    /* renamed from: a */
    boolean mo8633a(int i2);

    /* renamed from: a */
    boolean mo8634a(int i2, int i3, float f2, boolean z);

    /* renamed from: b */
    InterfaceC2876j mo8637b();

    /* renamed from: b */
    InterfaceC2876j mo8638b(@FloatRange(from = 0.0d, m293to = 1.0d) float f2);

    /* renamed from: b */
    InterfaceC2876j mo8639b(int i2);

    /* renamed from: b */
    InterfaceC2876j mo8640b(boolean z);

    /* renamed from: b */
    boolean mo8641b(int i2, int i3, float f2, boolean z);

    /* renamed from: c */
    InterfaceC2876j mo8644c();

    /* renamed from: c */
    InterfaceC2876j mo8642c(float f2);

    /* renamed from: c */
    InterfaceC2876j mo8643c(boolean z);

    @Deprecated
    /* renamed from: c */
    boolean mo8645c(int i2);

    /* renamed from: d */
    InterfaceC2876j mo8646d();

    /* renamed from: d */
    InterfaceC2876j mo8647d(@FloatRange(from = 1.0d, m293to = 10.0d) float f2);

    /* renamed from: d */
    InterfaceC2876j mo8648d(int i2);

    /* renamed from: d */
    InterfaceC2876j mo8649d(boolean z);

    /* renamed from: e */
    InterfaceC2876j mo8650e(float f2);

    /* renamed from: e */
    InterfaceC2876j mo8651e(int i2);

    /* renamed from: e */
    InterfaceC2876j mo8652e(boolean z);

    /* renamed from: e */
    boolean mo8653e();

    /* renamed from: f */
    InterfaceC2876j mo8656f();

    /* renamed from: f */
    InterfaceC2876j mo8654f(float f2);

    /* renamed from: f */
    InterfaceC2876j mo8655f(boolean z);

    /* renamed from: g */
    InterfaceC2876j mo8658g();

    /* renamed from: g */
    InterfaceC2876j mo8659g(@FloatRange(from = 0.0d, m293to = 1.0d) float f2);

    /* renamed from: g */
    InterfaceC2876j mo8660g(boolean z);

    ViewGroup getLayout();

    @Nullable
    InterfaceC2872f getRefreshFooter();

    @Nullable
    InterfaceC2873g getRefreshHeader();

    EnumC2879b getState();

    /* renamed from: h */
    InterfaceC2876j mo8661h(@FloatRange(from = 0.0d, m293to = 1.0d) float f2);

    /* renamed from: h */
    InterfaceC2876j mo8662h(boolean z);

    /* renamed from: h */
    boolean mo8663h();

    /* renamed from: i */
    InterfaceC2876j mo8664i(float f2);

    /* renamed from: i */
    InterfaceC2876j mo8665i(boolean z);

    /* renamed from: i */
    boolean mo8666i();

    /* renamed from: j */
    InterfaceC2876j mo8667j(boolean z);

    /* renamed from: k */
    InterfaceC2876j mo8670k(boolean z);

    /* renamed from: l */
    InterfaceC2876j mo8673l(boolean z);

    /* renamed from: m */
    InterfaceC2876j mo8675m(boolean z);

    /* renamed from: n */
    InterfaceC2876j mo8677n(boolean z);

    /* renamed from: o */
    InterfaceC2876j mo8678o(boolean z);

    /* renamed from: p */
    InterfaceC2876j mo8679p(boolean z);

    /* renamed from: q */
    InterfaceC2876j mo8680q(boolean z);

    /* renamed from: r */
    InterfaceC2876j mo8681r(boolean z);

    /* renamed from: s */
    InterfaceC2876j mo8682s(boolean z);

    InterfaceC2876j setPrimaryColors(@ColorInt int... iArr);

    @Deprecated
    /* renamed from: t */
    InterfaceC2876j mo8683t(boolean z);

    /* renamed from: u */
    InterfaceC2876j mo8684u(boolean z);
}
