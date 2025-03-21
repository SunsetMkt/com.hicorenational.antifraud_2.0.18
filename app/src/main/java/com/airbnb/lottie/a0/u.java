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

/* compiled from: LottieCompositionParser.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    static c.a f3422a = c.a.a("w", bh.aJ, "ip", "op", SocializeProtocolConstants.PROTOCOL_KEY_FR, "v", "layers", "assets", "fonts", "chars", "markers");

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
            switch (cVar2.a(f3422a)) {
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
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
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
}
