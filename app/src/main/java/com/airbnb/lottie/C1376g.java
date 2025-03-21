package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p106y.C1437c;
import com.airbnb.lottie.p106y.C1438d;
import com.airbnb.lottie.p106y.C1442h;
import com.airbnb.lottie.p106y.p109l.C1480d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LottieComposition.java */
/* renamed from: com.airbnb.lottie.g */
/* loaded from: classes.dex */
public class C1376g {

    /* renamed from: c */
    private Map<String, List<C1480d>> f3203c;

    /* renamed from: d */
    private Map<String, C1380k> f3204d;

    /* renamed from: e */
    private Map<String, C1437c> f3205e;

    /* renamed from: f */
    private List<C1442h> f3206f;

    /* renamed from: g */
    private SparseArrayCompat<C1438d> f3207g;

    /* renamed from: h */
    private LongSparseArray<C1480d> f3208h;

    /* renamed from: i */
    private List<C1480d> f3209i;

    /* renamed from: j */
    private Rect f3210j;

    /* renamed from: k */
    private float f3211k;

    /* renamed from: l */
    private float f3212l;

    /* renamed from: m */
    private float f3213m;

    /* renamed from: n */
    private boolean f3214n;

    /* renamed from: a */
    private final C1388s f3201a = new C1388s();

    /* renamed from: b */
    private final HashSet<String> f3202b = new HashSet<>();

    /* renamed from: o */
    private int f3215o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void m2891a(Rect rect, float f2, float f3, float f4, List<C1480d> list, LongSparseArray<C1480d> longSparseArray, Map<String, List<C1480d>> map, Map<String, C1380k> map2, SparseArrayCompat<C1438d> sparseArrayCompat, Map<String, C1437c> map3, List<C1442h> list2) {
        this.f3210j = rect;
        this.f3211k = f2;
        this.f3212l = f3;
        this.f3213m = f4;
        this.f3209i = list;
        this.f3208h = longSparseArray;
        this.f3203c = map;
        this.f3204d = map2;
        this.f3207g = sparseArrayCompat;
        this.f3205e = map3;
        this.f3206f = list2;
    }

    /* renamed from: b */
    public void m2897b(boolean z) {
        this.f3201a.m3078a(z);
    }

    /* renamed from: c */
    public float m2898c() {
        return (long) ((m2900d() / this.f3213m) * 1000.0f);
    }

    /* renamed from: d */
    public float m2900d() {
        return this.f3212l - this.f3211k;
    }

    /* renamed from: e */
    public float m2901e() {
        return this.f3212l;
    }

    /* renamed from: f */
    public Map<String, C1437c> m2902f() {
        return this.f3205e;
    }

    /* renamed from: g */
    public float m2903g() {
        return this.f3213m;
    }

    /* renamed from: h */
    public Map<String, C1380k> m2904h() {
        return this.f3204d;
    }

    /* renamed from: i */
    public List<C1480d> m2905i() {
        return this.f3209i;
    }

    /* renamed from: j */
    public List<C1442h> m2906j() {
        return this.f3206f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: k */
    public int m2907k() {
        return this.f3215o;
    }

    /* renamed from: l */
    public C1388s m2908l() {
        return this.f3201a;
    }

    /* renamed from: m */
    public float m2909m() {
        return this.f3211k;
    }

    /* renamed from: n */
    public ArrayList<String> m2910n() {
        HashSet<String> hashSet = this.f3202b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: o */
    public boolean m2911o() {
        return this.f3214n;
    }

    /* renamed from: p */
    public boolean m2912p() {
        return !this.f3204d.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<C1480d> it = this.f3209i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m3359a("\t"));
        }
        return sb.toString();
    }

    /* compiled from: LottieComposition.java */
    @Deprecated
    /* renamed from: com.airbnb.lottie.g$b */
    public static class b {

        /* compiled from: LottieComposition.java */
        /* renamed from: com.airbnb.lottie.g$b$a */
        private static final class a implements InterfaceC1381l<C1376g>, InterfaceC1350b {

            /* renamed from: a */
            private final InterfaceC1387r f3216a;

            /* renamed from: b */
            private boolean f3217b;

            @Override // com.airbnb.lottie.InterfaceC1381l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(C1376g c1376g) {
                if (this.f3217b) {
                    return;
                }
                this.f3216a.m3074a(c1376g);
            }

            @Override // com.airbnb.lottie.InterfaceC1350b
            public void cancel() {
                this.f3217b = true;
            }

            private a(InterfaceC1387r interfaceC1387r) {
                this.f3217b = false;
                this.f3216a = interfaceC1387r;
            }
        }

        private b() {
        }

        @Deprecated
        /* renamed from: a */
        public static InterfaceC1350b m2914a(Context context, String str, InterfaceC1387r interfaceC1387r) {
            a aVar = new a(interfaceC1387r);
            C1377h.m2930a(context, str).m3071b(aVar);
            return aVar;
        }

        @Deprecated
        /* renamed from: a */
        public static InterfaceC1350b m2913a(Context context, @RawRes int i2, InterfaceC1387r interfaceC1387r) {
            a aVar = new a(interfaceC1387r);
            C1377h.m2928a(context, i2).m3071b(aVar);
            return aVar;
        }

        @Deprecated
        /* renamed from: a */
        public static InterfaceC1350b m2916a(InputStream inputStream, InterfaceC1387r interfaceC1387r) {
            a aVar = new a(interfaceC1387r);
            C1377h.m2933a(inputStream, (String) null).m3071b(aVar);
            return aVar;
        }

        @Deprecated
        /* renamed from: a */
        public static InterfaceC1350b m2917a(String str, InterfaceC1387r interfaceC1387r) {
            a aVar = new a(interfaceC1387r);
            C1377h.m2934a(str, (String) null).m3071b(aVar);
            return aVar;
        }

        @Deprecated
        /* renamed from: a */
        public static InterfaceC1350b m2915a(AbstractC1330c abstractC1330c, InterfaceC1387r interfaceC1387r) {
            a aVar = new a(interfaceC1387r);
            C1377h.m2932a(abstractC1330c, (String) null).m3071b(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2918a(Context context, String str) {
            return C1377h.m2944b(context, str).m3061b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2921a(InputStream inputStream) {
            return C1377h.m2947b(inputStream, (String) null).m3061b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2922a(InputStream inputStream, boolean z) {
            if (z) {
                C1354d.m2791b("Lottie now auto-closes input stream!");
            }
            return C1377h.m2947b(inputStream, (String) null).m3061b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2919a(Resources resources, JSONObject jSONObject) {
            return C1377h.m2950b(jSONObject, (String) null).m3061b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2923a(String str) {
            return C1377h.m2948b(str, (String) null).m3061b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        /* renamed from: a */
        public static C1376g m2920a(AbstractC1330c abstractC1330c) {
            return C1377h.m2946b(abstractC1330c, (String) null).m3061b();
        }
    }

    /* renamed from: b */
    public float m2894b(float f2) {
        float f3 = this.f3211k;
        return (f2 - f3) / (this.f3212l - f3);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public List<C1480d> m2899c(String str) {
        return this.f3203c.get(str);
    }

    /* renamed from: b */
    public SparseArrayCompat<C1438d> m2895b() {
        return this.f3207g;
    }

    @Nullable
    /* renamed from: b */
    public C1442h m2896b(String str) {
        int size = this.f3206f.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1442h c1442h = this.f3206f.get(i2);
            if (c1442h.m3217a(str)) {
                return c1442h;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void m2892a(String str) {
        C1354d.m2791b(str);
        this.f3202b.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void m2893a(boolean z) {
        this.f3214n = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void m2890a(int i2) {
        this.f3215o += i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public C1480d m2889a(long j2) {
        return this.f3208h.get(j2);
    }

    /* renamed from: a */
    public Rect m2888a() {
        return this.f3210j;
    }

    /* renamed from: a */
    public float m2887a(float f2) {
        return C1357g.m2831c(this.f3211k, this.f3212l, f2);
    }
}
