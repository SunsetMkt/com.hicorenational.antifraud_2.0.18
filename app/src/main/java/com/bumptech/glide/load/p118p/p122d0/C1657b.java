package com.bumptech.glide.load.p118p.p122d0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.load.p118p.p122d0.C1659d;
import com.bumptech.glide.util.C1878l;
import java.util.HashMap;

/* compiled from: BitmapPreFiller.java */
/* renamed from: com.bumptech.glide.load.p.d0.b */
/* loaded from: classes.dex */
public final class C1657b {

    /* renamed from: a */
    private final InterfaceC1648j f4447a;

    /* renamed from: b */
    private final InterfaceC1626e f4448b;

    /* renamed from: c */
    private final EnumC1588b f4449c;

    /* renamed from: d */
    private final Handler f4450d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private RunnableC1656a f4451e;

    public C1657b(InterfaceC1648j interfaceC1648j, InterfaceC1626e interfaceC1626e, EnumC1588b enumC1588b) {
        this.f4447a = interfaceC1648j;
        this.f4448b = interfaceC1626e;
        this.f4449c = enumC1588b;
    }

    /* renamed from: a */
    public void m4057a(C1659d.a... aVarArr) {
        RunnableC1656a runnableC1656a = this.f4451e;
        if (runnableC1656a != null) {
            runnableC1656a.m4053b();
        }
        C1659d[] c1659dArr = new C1659d[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            C1659d.a aVar = aVarArr[i2];
            if (aVar.m4068b() == null) {
                aVar.m4066a(this.f4449c == EnumC1588b.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            c1659dArr[i2] = aVar.m4067a();
        }
        this.f4451e = new RunnableC1656a(this.f4448b, this.f4447a, m4056a(c1659dArr));
        this.f4450d.post(this.f4451e);
    }

    @VisibleForTesting
    /* renamed from: a */
    C1658c m4056a(C1659d... c1659dArr) {
        long mo4004b = (this.f4447a.mo4004b() - this.f4447a.getCurrentSize()) + this.f4448b.mo3925b();
        int i2 = 0;
        for (C1659d c1659d : c1659dArr) {
            i2 += c1659d.m4063c();
        }
        float f2 = mo4004b / i2;
        HashMap hashMap = new HashMap();
        for (C1659d c1659d2 : c1659dArr) {
            hashMap.put(c1659d2, Integer.valueOf(Math.round(c1659d2.m4063c() * f2) / m4055a(c1659d2)));
        }
        return new C1658c(hashMap);
    }

    /* renamed from: a */
    private static int m4055a(C1659d c1659d) {
        return C1878l.m4993a(c1659d.m4064d(), c1659d.m4062b(), c1659d.m4061a());
    }
}
