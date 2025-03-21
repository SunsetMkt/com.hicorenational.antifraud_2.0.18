package com.airbnb.lottie.p098a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p106y.C1438d;
import com.airbnb.lottie.p106y.p109l.C1480d;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: LottieCompositionParser.java */
/* renamed from: com.airbnb.lottie.a0.u */
/* loaded from: classes.dex */
public class C1344u {

    /* renamed from: a */
    static AbstractC1330c.a f3126a = AbstractC1330c.a.m2710a("w", C3351bh.f11585aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: a */
    public static C1376g m2770a(AbstractC1330c abstractC1330c) throws IOException {
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
            switch (abstractC1330c2.mo2694a(f3126a)) {
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
                    m2771a(abstractC1330c2, c1376g, arrayList2, longSparseArray);
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
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
    private static void m2771a(AbstractC1330c abstractC1330c, C1376g c1376g, List<C1480d> list, LongSparseArray<C1480d> longSparseArray) throws IOException {
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
}
