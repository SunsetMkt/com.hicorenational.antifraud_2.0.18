package com.airbnb.lottie.a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.l.d;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3418a = c.a.a("w", bh.aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    static c.a f3419b = c.a.a("id", "layers", "w", bh.aJ, bh.aA, bh.aK);

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3420c = c.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f3421d = c.a.a(SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT, "tm", "dr");

    public static com.airbnb.lottie.g a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        com.airbnb.lottie.a0.l0.c cVar2 = cVar;
        float a2 = com.airbnb.lottie.b0.h.a();
        LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat = new SparseArrayCompat<>();
        com.airbnb.lottie.g gVar = new com.airbnb.lottie.g();
        cVar.d();
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (cVar.h()) {
            switch (cVar2.a(f3418a)) {
                case 0:
                    i2 = cVar.k();
                    break;
                case 1:
                    i3 = cVar.k();
                    break;
                case 2:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = (float) cVar.j();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) cVar.j()) - 0.01f;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) cVar.j();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] split = cVar.m().split("\\.");
                    if (!com.airbnb.lottie.b0.h.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        gVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    a(cVar2, gVar, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    a(cVar2, gVar, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    a(cVar2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    a(cVar2, gVar, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    a(cVar2, gVar, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    cVar.n();
                    cVar.o();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
            }
            cVar2 = cVar;
        }
        gVar.a(new Rect(0, 0, (int) (i2 * a2), (int) (i3 * a2)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return gVar;
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, List<com.airbnb.lottie.y.l.d> list, LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray) throws IOException {
        cVar.c();
        int i2 = 0;
        while (cVar.h()) {
            com.airbnb.lottie.y.l.d a2 = s.a(cVar, gVar);
            if (a2.d() == d.a.IMAGE) {
                i2++;
            }
            list.add(a2);
            longSparseArray.put(a2.b(), a2);
            if (i2 > 4) {
                com.airbnb.lottie.b0.d.b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, Map<String, List<com.airbnb.lottie.y.l.d>> map, Map<String, com.airbnb.lottie.k> map2) throws IOException {
        cVar.c();
        while (cVar.h()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.d();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (cVar.h()) {
                int a2 = cVar.a(f3419b);
                if (a2 == 0) {
                    str = cVar.m();
                } else if (a2 == 1) {
                    cVar.c();
                    while (cVar.h()) {
                        com.airbnb.lottie.y.l.d a3 = s.a(cVar, gVar);
                        longSparseArray.put(a3.b(), a3);
                        arrayList.add(a3);
                    }
                    cVar.e();
                } else if (a2 == 2) {
                    i2 = cVar.k();
                } else if (a2 == 3) {
                    i3 = cVar.k();
                } else if (a2 == 4) {
                    str2 = cVar.m();
                } else if (a2 != 5) {
                    cVar.n();
                    cVar.o();
                } else {
                    str3 = cVar.m();
                }
            }
            cVar.f();
            if (str2 != null) {
                com.airbnb.lottie.k kVar = new com.airbnb.lottie.k(i2, i3, str, str2, str3);
                map2.put(kVar.e(), kVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, Map<String, com.airbnb.lottie.y.c> map) throws IOException {
        cVar.d();
        while (cVar.h()) {
            if (cVar.a(f3420c) != 0) {
                cVar.n();
                cVar.o();
            } else {
                cVar.c();
                while (cVar.h()) {
                    com.airbnb.lottie.y.c a2 = k.a(cVar);
                    map.put(a2.c(), a2);
                }
                cVar.e();
            }
        }
        cVar.f();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat) throws IOException {
        cVar.c();
        while (cVar.h()) {
            com.airbnb.lottie.y.d a2 = j.a(cVar, gVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        cVar.e();
    }

    private static void a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, List<com.airbnb.lottie.y.h> list) throws IOException {
        cVar.c();
        while (cVar.h()) {
            String str = null;
            cVar.d();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (cVar.h()) {
                int a2 = cVar.a(f3421d);
                if (a2 == 0) {
                    str = cVar.m();
                } else if (a2 == 1) {
                    f2 = (float) cVar.j();
                } else if (a2 != 2) {
                    cVar.n();
                    cVar.o();
                } else {
                    f3 = (float) cVar.j();
                }
            }
            cVar.f();
            list.add(new com.airbnb.lottie.y.h(str, f2, f3));
        }
        cVar.e();
    }
}
