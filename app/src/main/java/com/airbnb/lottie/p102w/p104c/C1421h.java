package com.airbnb.lottie.p102w.p104c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1361a;

/* compiled from: PathKeyframe.java */
/* renamed from: com.airbnb.lottie.w.c.h */
/* loaded from: classes.dex */
public class C1421h extends C1361a<PointF> {

    /* renamed from: s */
    @Nullable
    private Path f3534s;

    /* renamed from: t */
    private final C1361a<PointF> f3535t;

    public C1421h(C1376g c1376g, C1361a<PointF> c1361a) {
        super(c1376g, c1361a.f3156b, c1361a.f3157c, c1361a.f3158d, c1361a.f3159e, c1361a.f3160f, c1361a.f3161g, c1361a.f3162h);
        this.f3535t = c1361a;
        m3161h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public void m3161h() {
        T t;
        T t2;
        T t3 = this.f3157c;
        boolean z = (t3 == 0 || (t2 = this.f3156b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.f3156b;
        if (t4 == 0 || (t = this.f3157c) == 0 || z) {
            return;
        }
        C1361a<PointF> c1361a = this.f3535t;
        this.f3534s = C1358h.m2838a((PointF) t4, (PointF) t, c1361a.f3169o, c1361a.f3170p);
    }

    @Nullable
    /* renamed from: i */
    Path m3162i() {
        return this.f3534s;
    }
}
