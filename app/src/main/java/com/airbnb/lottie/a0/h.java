package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.b;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements k0<com.airbnb.lottie.y.b> {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3342a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3343b = c.a.a("t", "f", bh.aE, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public com.airbnb.lottie.y.b a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        b.a aVar = b.a.CENTER;
        cVar.d();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i2 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (cVar.h()) {
            switch (cVar.a(f3343b)) {
                case 0:
                    str = cVar.m();
                    break;
                case 1:
                    str2 = cVar.m();
                    break;
                case 2:
                    f3 = (float) cVar.j();
                    break;
                case 3:
                    int k2 = cVar.k();
                    if (k2 <= b.a.CENTER.ordinal() && k2 >= 0) {
                        aVar2 = b.a.values()[k2];
                        break;
                    } else {
                        aVar2 = b.a.CENTER;
                        break;
                    }
                case 4:
                    i2 = cVar.k();
                    break;
                case 5:
                    f4 = (float) cVar.j();
                    break;
                case 6:
                    f5 = (float) cVar.j();
                    break;
                case 7:
                    i3 = p.a(cVar);
                    break;
                case 8:
                    i4 = p.a(cVar);
                    break;
                case 9:
                    f6 = (float) cVar.j();
                    break;
                case 10:
                    z = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.b(str, str2, f3, aVar2, i2, f4, f5, i3, i4, f6, z);
    }
}
