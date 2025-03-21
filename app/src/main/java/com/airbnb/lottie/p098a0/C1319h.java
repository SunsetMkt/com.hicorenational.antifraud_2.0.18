package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.C1436b;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* renamed from: com.airbnb.lottie.a0.h */
/* loaded from: classes.dex */
public class C1319h implements InterfaceC1326k0<C1436b> {

    /* renamed from: a */
    public static final C1319h f3013a = new C1319h();

    /* renamed from: b */
    private static final AbstractC1330c.a f3014b = AbstractC1330c.a.m2710a("t", "f", C3351bh.f11580aE, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private C1319h() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public C1436b mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        C1436b.a aVar = C1436b.a.CENTER;
        abstractC1330c.mo2698d();
        C1436b.a aVar2 = aVar;
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
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3014b)) {
                case 0:
                    str = abstractC1330c.mo2707m();
                    break;
                case 1:
                    str2 = abstractC1330c.mo2707m();
                    break;
                case 2:
                    f3 = (float) abstractC1330c.mo2704j();
                    break;
                case 3:
                    int mo2705k = abstractC1330c.mo2705k();
                    if (mo2705k <= C1436b.a.CENTER.ordinal() && mo2705k >= 0) {
                        aVar2 = C1436b.a.values()[mo2705k];
                        break;
                    } else {
                        aVar2 = C1436b.a.CENTER;
                        break;
                    }
                case 4:
                    i2 = abstractC1330c.mo2705k();
                    break;
                case 5:
                    f4 = (float) abstractC1330c.mo2704j();
                    break;
                case 6:
                    f5 = (float) abstractC1330c.mo2704j();
                    break;
                case 7:
                    i3 = C1339p.m2745a(abstractC1330c);
                    break;
                case 8:
                    i4 = C1339p.m2745a(abstractC1330c);
                    break;
                case 9:
                    f6 = (float) abstractC1330c.mo2704j();
                    break;
                case 10:
                    z = abstractC1330c.mo2703i();
                    break;
                default:
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                    break;
            }
        }
        abstractC1330c.mo2700f();
        return new C1436b(str, str2, f3, aVar2, i2, f4, f5, i3, i4, f6, z);
    }
}
