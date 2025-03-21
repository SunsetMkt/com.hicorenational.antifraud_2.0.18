package com.airbnb.lottie.p098a0;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1453j;
import com.airbnb.lottie.p106y.p107j.C1454k;
import com.airbnb.lottie.p106y.p107j.C1455l;
import com.airbnb.lottie.p106y.p108k.InterfaceC1460b;
import com.airbnb.lottie.p106y.p109l.C1480d;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* renamed from: com.airbnb.lottie.a0.s */
/* loaded from: classes.dex */
public class C1342s {

    /* renamed from: a */
    private static final AbstractC1330c.a f3118a = AbstractC1330c.a.m2710a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", C3351bh.f11585aJ, "ip", "op", "tm", "cl", "hd");

    /* renamed from: b */
    private static final AbstractC1330c.a f3119b = AbstractC1330c.a.m2710a("d", "a");

    /* renamed from: c */
    private static final AbstractC1330c.a f3120c = AbstractC1330c.a.m2710a("nm");

    /* compiled from: LayerParser.java */
    /* renamed from: com.airbnb.lottie.a0.s$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3121a = new int[C1480d.b.values().length];

        static {
            try {
                f3121a[C1480d.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3121a[C1480d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private C1342s() {
    }

    /* renamed from: a */
    public static C1480d m2763a(C1376g c1376g) {
        Rect m2888a = c1376g.m2888a();
        return new C1480d(Collections.emptyList(), c1376g, "__container", -1L, C1480d.a.PRE_COMP, -1L, null, Collections.emptyList(), new C1455l(), 0, 0, 0, 0.0f, 0.0f, m2888a.width(), m2888a.height(), null, null, Collections.emptyList(), C1480d.b.NONE, null, false);
    }

    /* renamed from: a */
    public static C1480d m2762a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        C1480d.b bVar = C1480d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        abstractC1330c.mo2698d();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        C1480d.b bVar2 = bVar;
        String str2 = null;
        C1480d.a aVar = null;
        String str3 = null;
        C1455l c1455l = null;
        C1453j c1453j = null;
        C1454k c1454k = null;
        C1445b c1445b = null;
        long j2 = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        float f2 = 1.0f;
        float f3 = 0.0f;
        boolean z = false;
        String str4 = "UNSET";
        long j3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3118a)) {
                case 0:
                    str4 = abstractC1330c.mo2707m();
                    break;
                case 1:
                    j3 = abstractC1330c.mo2705k();
                    break;
                case 2:
                    str3 = abstractC1330c.mo2707m();
                    break;
                case 3:
                    int mo2705k = abstractC1330c.mo2705k();
                    if (mo2705k < C1480d.a.UNKNOWN.ordinal()) {
                        aVar = C1480d.a.values()[mo2705k];
                        break;
                    } else {
                        aVar = C1480d.a.UNKNOWN;
                        break;
                    }
                case 4:
                    j2 = abstractC1330c.mo2705k();
                    break;
                case 5:
                    i2 = (int) (abstractC1330c.mo2705k() * C1358h.m2832a());
                    break;
                case 6:
                    i3 = (int) (abstractC1330c.mo2705k() * C1358h.m2832a());
                    break;
                case 7:
                    i4 = Color.parseColor(abstractC1330c.mo2707m());
                    break;
                case 8:
                    c1455l = C1309c.m2660a(abstractC1330c, c1376g);
                    break;
                case 9:
                    int mo2705k2 = abstractC1330c.mo2705k();
                    if (mo2705k2 >= C1480d.b.values().length) {
                        c1376g.m2892a("Unsupported matte type: " + mo2705k2);
                        break;
                    } else {
                        bVar2 = C1480d.b.values()[mo2705k2];
                        int i7 = a.f3121a[bVar2.ordinal()];
                        if (i7 == 1) {
                            c1376g.m2892a("Unsupported matte type: Luma");
                        } else if (i7 == 2) {
                            c1376g.m2892a("Unsupported matte type: Luma Inverted");
                        }
                        c1376g.m2890a(1);
                        break;
                    }
                case 10:
                    abstractC1330c.mo2697c();
                    while (abstractC1330c.mo2702h()) {
                        arrayList3.add(C1345v.m2772a(abstractC1330c, c1376g));
                    }
                    c1376g.m2890a(arrayList3.size());
                    abstractC1330c.mo2699e();
                    break;
                case 11:
                    abstractC1330c.mo2697c();
                    while (abstractC1330c.mo2702h()) {
                        InterfaceC1460b m2682a = C1317g.m2682a(abstractC1330c, c1376g);
                        if (m2682a != null) {
                            arrayList4.add(m2682a);
                        }
                    }
                    abstractC1330c.mo2699e();
                    break;
                case 12:
                    abstractC1330c.mo2698d();
                    while (abstractC1330c.mo2702h()) {
                        int mo2694a = abstractC1330c.mo2694a(f3119b);
                        if (mo2694a == 0) {
                            c1453j = C1311d.m2673b(abstractC1330c, c1376g);
                        } else if (mo2694a != 1) {
                            abstractC1330c.mo2708n();
                            abstractC1330c.mo2709o();
                        } else {
                            abstractC1330c.mo2697c();
                            if (abstractC1330c.mo2702h()) {
                                c1454k = C1307b.m2657a(abstractC1330c, c1376g);
                            }
                            while (abstractC1330c.mo2702h()) {
                                abstractC1330c.mo2709o();
                            }
                            abstractC1330c.mo2699e();
                        }
                    }
                    abstractC1330c.mo2700f();
                    break;
                case 13:
                    abstractC1330c.mo2697c();
                    ArrayList arrayList5 = new ArrayList();
                    while (abstractC1330c.mo2702h()) {
                        abstractC1330c.mo2698d();
                        while (abstractC1330c.mo2702h()) {
                            if (abstractC1330c.mo2694a(f3120c) != 0) {
                                abstractC1330c.mo2708n();
                                abstractC1330c.mo2709o();
                            } else {
                                arrayList5.add(abstractC1330c.mo2707m());
                            }
                        }
                        abstractC1330c.mo2700f();
                    }
                    abstractC1330c.mo2699e();
                    c1376g.m2892a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f2 = (float) abstractC1330c.mo2704j();
                    break;
                case 15:
                    f3 = (float) abstractC1330c.mo2704j();
                    break;
                case 16:
                    i5 = (int) (abstractC1330c.mo2705k() * C1358h.m2832a());
                    break;
                case 17:
                    i6 = (int) (abstractC1330c.mo2705k() * C1358h.m2832a());
                    break;
                case 18:
                    f4 = (float) abstractC1330c.mo2704j();
                    break;
                case 19:
                    f5 = (float) abstractC1330c.mo2704j();
                    break;
                case 20:
                    c1445b = C1311d.m2669a(abstractC1330c, c1376g, false);
                    break;
                case 21:
                    str2 = abstractC1330c.mo2707m();
                    break;
                case 22:
                    z = abstractC1330c.mo2703i();
                    break;
                default:
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                    break;
            }
        }
        abstractC1330c.mo2700f();
        ArrayList arrayList6 = new ArrayList();
        if (f4 > 0.0f) {
            arrayList = arrayList3;
            str = str2;
            arrayList2 = arrayList6;
            arrayList2.add(new C1361a(c1376g, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f4)));
        } else {
            arrayList = arrayList3;
            str = str2;
            arrayList2 = arrayList6;
        }
        if (f5 <= 0.0f) {
            f5 = c1376g.m2901e();
        }
        float f6 = f4;
        ArrayList arrayList7 = arrayList2;
        arrayList7.add(new C1361a(c1376g, valueOf, valueOf, null, f6, Float.valueOf(f5)));
        arrayList7.add(new C1361a(c1376g, valueOf2, valueOf2, null, f5, Float.valueOf(Float.MAX_VALUE)));
        if (str4.endsWith(".ai") || "ai".equals(str)) {
            c1376g.m2892a("Convert your Illustrator layers to shape layers.");
        }
        return new C1480d(arrayList4, c1376g, str4, j3, aVar, j2, str3, arrayList, c1455l, i2, i3, i4, f2, f3, i5, i6, c1453j, c1454k, arrayList7, bVar2, c1445b, z);
    }
}
