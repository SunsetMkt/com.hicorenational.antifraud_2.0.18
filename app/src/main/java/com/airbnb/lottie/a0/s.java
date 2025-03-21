package com.airbnb.lottie.a0;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.l.d;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3414a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", bh.aJ, "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3415b = c.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3416c = c.a.a("nm");

    /* compiled from: LayerParser.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3417a = new int[d.b.values().length];

        static {
            try {
                f3417a[d.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3417a[d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private s() {
    }

    public static com.airbnb.lottie.y.l.d a(com.airbnb.lottie.g gVar) {
        Rect a2 = gVar.a();
        return new com.airbnb.lottie.y.l.d(Collections.emptyList(), gVar, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new com.airbnb.lottie.y.j.l(), 0, 0, 0, 0.0f, 0.0f, a2.width(), a2.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }

    public static com.airbnb.lottie.y.l.d a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        d.b bVar = d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.d();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        String str2 = null;
        d.a aVar = null;
        String str3 = null;
        com.airbnb.lottie.y.j.l lVar = null;
        com.airbnb.lottie.y.j.j jVar = null;
        com.airbnb.lottie.y.j.k kVar = null;
        com.airbnb.lottie.y.j.b bVar3 = null;
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
        while (cVar.h()) {
            switch (cVar.a(f3414a)) {
                case 0:
                    str4 = cVar.m();
                    break;
                case 1:
                    j3 = cVar.k();
                    break;
                case 2:
                    str3 = cVar.m();
                    break;
                case 3:
                    int k2 = cVar.k();
                    if (k2 < d.a.UNKNOWN.ordinal()) {
                        aVar = d.a.values()[k2];
                        break;
                    } else {
                        aVar = d.a.UNKNOWN;
                        break;
                    }
                case 4:
                    j2 = cVar.k();
                    break;
                case 5:
                    i2 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 6:
                    i3 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 7:
                    i4 = Color.parseColor(cVar.m());
                    break;
                case 8:
                    lVar = c.a(cVar, gVar);
                    break;
                case 9:
                    int k3 = cVar.k();
                    if (k3 >= d.b.values().length) {
                        gVar.a("Unsupported matte type: " + k3);
                        break;
                    } else {
                        bVar2 = d.b.values()[k3];
                        int i7 = a.f3417a[bVar2.ordinal()];
                        if (i7 == 1) {
                            gVar.a("Unsupported matte type: Luma");
                        } else if (i7 == 2) {
                            gVar.a("Unsupported matte type: Luma Inverted");
                        }
                        gVar.a(1);
                        break;
                    }
                case 10:
                    cVar.c();
                    while (cVar.h()) {
                        arrayList3.add(v.a(cVar, gVar));
                    }
                    gVar.a(arrayList3.size());
                    cVar.e();
                    break;
                case 11:
                    cVar.c();
                    while (cVar.h()) {
                        com.airbnb.lottie.y.k.b a2 = g.a(cVar, gVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    cVar.e();
                    break;
                case 12:
                    cVar.d();
                    while (cVar.h()) {
                        int a3 = cVar.a(f3415b);
                        if (a3 == 0) {
                            jVar = d.b(cVar, gVar);
                        } else if (a3 != 1) {
                            cVar.n();
                            cVar.o();
                        } else {
                            cVar.c();
                            if (cVar.h()) {
                                kVar = b.a(cVar, gVar);
                            }
                            while (cVar.h()) {
                                cVar.o();
                            }
                            cVar.e();
                        }
                    }
                    cVar.f();
                    break;
                case 13:
                    cVar.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.h()) {
                        cVar.d();
                        while (cVar.h()) {
                            if (cVar.a(f3416c) != 0) {
                                cVar.n();
                                cVar.o();
                            } else {
                                arrayList5.add(cVar.m());
                            }
                        }
                        cVar.f();
                    }
                    cVar.e();
                    gVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f2 = (float) cVar.j();
                    break;
                case 15:
                    f3 = (float) cVar.j();
                    break;
                case 16:
                    i5 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 17:
                    i6 = (int) (cVar.k() * com.airbnb.lottie.b0.h.a());
                    break;
                case 18:
                    f4 = (float) cVar.j();
                    break;
                case 19:
                    f5 = (float) cVar.j();
                    break;
                case 20:
                    bVar3 = d.a(cVar, gVar, false);
                    break;
                case 21:
                    str2 = cVar.m();
                    break;
                case 22:
                    z = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        ArrayList arrayList6 = new ArrayList();
        if (f4 > 0.0f) {
            arrayList = arrayList3;
            str = str2;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.c0.a(gVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f4)));
        } else {
            arrayList = arrayList3;
            str = str2;
            arrayList2 = arrayList6;
        }
        if (f5 <= 0.0f) {
            f5 = gVar.e();
        }
        float f6 = f4;
        ArrayList arrayList7 = arrayList2;
        arrayList7.add(new com.airbnb.lottie.c0.a(gVar, valueOf, valueOf, null, f6, Float.valueOf(f5)));
        arrayList7.add(new com.airbnb.lottie.c0.a(gVar, valueOf2, valueOf2, null, f5, Float.valueOf(Float.MAX_VALUE)));
        if (str4.endsWith(".ai") || "ai".equals(str)) {
            gVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.y.l.d(arrayList4, gVar, str4, j3, aVar, j2, str3, arrayList, lVar, i2, i3, i4, f2, f3, i5, i6, jVar, kVar, arrayList7, bVar2, bVar3, z);
    }
}
