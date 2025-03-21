package com.airbnb.lottie.p098a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.C1380k;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p106y.C1437c;
import com.airbnb.lottie.p106y.C1438d;
import com.airbnb.lottie.p106y.C1442h;
import com.airbnb.lottie.p106y.p109l.C1480d;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* renamed from: com.airbnb.lottie.a0.t */
/* loaded from: classes.dex */
public class C1343t {

    /* renamed from: a */
    private static final AbstractC1330c.a f3122a = AbstractC1330c.a.m2710a("w", C3351bh.f11585aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b */
    static AbstractC1330c.a f3123b = AbstractC1330c.a.m2710a("id", "layers", "w", C3351bh.f11585aJ, C3351bh.f11576aA, C3351bh.f11586aK);

    /* renamed from: c */
    private static final AbstractC1330c.a f3124c = AbstractC1330c.a.m2710a("list");

    /* renamed from: d */
    private static final AbstractC1330c.a f3125d = AbstractC1330c.a.m2710a(SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_COUNT, "tm", "dr");

    /* renamed from: a */
    public static C1376g m2764a(AbstractC1330c abstractC1330c) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        AbstractC1330c abstractC1330c2 = abstractC1330c;
        float m2832a = C1358h.m2832a();
        LongSparseArray<C1480d> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<C1438d> sparseArrayCompat = new SparseArrayCompat<>();
        C1376g c1376g = new C1376g();
        abstractC1330c.mo2698d();
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c2.mo2694a(f3122a)) {
                case 0:
                    i2 = abstractC1330c.mo2705k();
                    break;
                case 1:
                    i3 = abstractC1330c.mo2705k();
                    break;
                case 2:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = (float) abstractC1330c.mo2704j();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) abstractC1330c.mo2704j()) - 0.01f;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) abstractC1330c.mo2704j();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] split = abstractC1330c.mo2707m().split("\\.");
                    if (!C1358h.m2844a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        c1376g.m2892a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    m2767a(abstractC1330c2, c1376g, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    m2768a(abstractC1330c2, c1376g, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    m2769a(abstractC1330c2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    m2765a(abstractC1330c2, c1376g, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    m2766a(abstractC1330c2, c1376g, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
            }
            abstractC1330c2 = abstractC1330c;
        }
        c1376g.m2891a(new Rect(0, 0, (int) (i2 * m2832a), (int) (i3 * m2832a)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return c1376g;
    }

    /* renamed from: a */
    private static void m2767a(AbstractC1330c abstractC1330c, C1376g c1376g, List<C1480d> list, LongSparseArray<C1480d> longSparseArray) throws IOException {
        abstractC1330c.mo2697c();
        int i2 = 0;
        while (abstractC1330c.mo2702h()) {
            C1480d m2762a = C1342s.m2762a(abstractC1330c, c1376g);
            if (m2762a.m3362d() == C1480d.a.IMAGE) {
                i2++;
            }
            list.add(m2762a);
            longSparseArray.put(m2762a.m3360b(), m2762a);
            if (i2 > 4) {
                C1354d.m2791b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        abstractC1330c.mo2699e();
    }

    /* renamed from: a */
    private static void m2768a(AbstractC1330c abstractC1330c, C1376g c1376g, Map<String, List<C1480d>> map, Map<String, C1380k> map2) throws IOException {
        abstractC1330c.mo2697c();
        while (abstractC1330c.mo2702h()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            abstractC1330c.mo2698d();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (abstractC1330c.mo2702h()) {
                int mo2694a = abstractC1330c.mo2694a(f3123b);
                if (mo2694a == 0) {
                    str = abstractC1330c.mo2707m();
                } else if (mo2694a == 1) {
                    abstractC1330c.mo2697c();
                    while (abstractC1330c.mo2702h()) {
                        C1480d m2762a = C1342s.m2762a(abstractC1330c, c1376g);
                        longSparseArray.put(m2762a.m3360b(), m2762a);
                        arrayList.add(m2762a);
                    }
                    abstractC1330c.mo2699e();
                } else if (mo2694a == 2) {
                    i2 = abstractC1330c.mo2705k();
                } else if (mo2694a == 3) {
                    i3 = abstractC1330c.mo2705k();
                } else if (mo2694a == 4) {
                    str2 = abstractC1330c.mo2707m();
                } else if (mo2694a != 5) {
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                } else {
                    str3 = abstractC1330c.mo2707m();
                }
            }
            abstractC1330c.mo2700f();
            if (str2 != null) {
                C1380k c1380k = new C1380k(i2, i3, str, str2, str3);
                map2.put(c1380k.m3056e(), c1380k);
            } else {
                map.put(str, arrayList);
            }
        }
        abstractC1330c.mo2699e();
    }

    /* renamed from: a */
    private static void m2769a(AbstractC1330c abstractC1330c, Map<String, C1437c> map) throws IOException {
        abstractC1330c.mo2698d();
        while (abstractC1330c.mo2702h()) {
            if (abstractC1330c.mo2694a(f3124c) != 0) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                abstractC1330c.mo2697c();
                while (abstractC1330c.mo2702h()) {
                    C1437c m2688a = C1325k.m2688a(abstractC1330c);
                    map.put(m2688a.m3194c(), m2688a);
                }
                abstractC1330c.mo2699e();
            }
        }
        abstractC1330c.mo2700f();
    }

    /* renamed from: a */
    private static void m2765a(AbstractC1330c abstractC1330c, C1376g c1376g, SparseArrayCompat<C1438d> sparseArrayCompat) throws IOException {
        abstractC1330c.mo2697c();
        while (abstractC1330c.mo2702h()) {
            C1438d m2686a = C1323j.m2686a(abstractC1330c, c1376g);
            sparseArrayCompat.put(m2686a.hashCode(), m2686a);
        }
        abstractC1330c.mo2699e();
    }

    /* renamed from: a */
    private static void m2766a(AbstractC1330c abstractC1330c, C1376g c1376g, List<C1442h> list) throws IOException {
        abstractC1330c.mo2697c();
        while (abstractC1330c.mo2702h()) {
            String str = null;
            abstractC1330c.mo2698d();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (abstractC1330c.mo2702h()) {
                int mo2694a = abstractC1330c.mo2694a(f3125d);
                if (mo2694a == 0) {
                    str = abstractC1330c.mo2707m();
                } else if (mo2694a == 1) {
                    f2 = (float) abstractC1330c.mo2704j();
                } else if (mo2694a != 2) {
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                } else {
                    f3 = (float) abstractC1330c.mo2704j();
                }
            }
            abstractC1330c.mo2700f();
            list.add(new C1442h(str, f2, f3));
        }
        abstractC1330c.mo2699e();
    }
}
