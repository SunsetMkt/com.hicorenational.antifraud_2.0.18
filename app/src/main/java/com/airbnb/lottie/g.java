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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: LottieComposition.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.y.l.d>> f2150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, k> f2151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, com.airbnb.lottie.y.c> f2152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.airbnb.lottie.y.h> f2153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SparseArrayCompat<com.airbnb.lottie.y.d> f2154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LongSparseArray<com.airbnb.lottie.y.l.d> f2155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<com.airbnb.lottie.y.l.d> f2156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f2157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f2158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f2159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f2160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2161n;
    private final s a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet<String> f2149b = new HashSet<>();
    private int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(Rect rect, float f2, float f3, float f4, List<com.airbnb.lottie.y.l.d> list, LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray, Map<String, List<com.airbnb.lottie.y.l.d>> map, Map<String, k> map2, SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat, Map<String, com.airbnb.lottie.y.c> map3, List<com.airbnb.lottie.y.h> list2) {
        this.f2157j = rect;
        this.f2158k = f2;
        this.f2159l = f3;
        this.f2160m = f4;
        this.f2156i = list;
        this.f2155h = longSparseArray;
        this.f2150c = map;
        this.f2151d = map2;
        this.f2154g = sparseArrayCompat;
        this.f2152e = map3;
        this.f2153f = list2;
    }

    public void b(boolean z) {
        this.a.a(z);
    }

    public float c() {
        return (long) ((d() / this.f2160m) * 1000.0f);
    }

    public float d() {
        return this.f2159l - this.f2158k;
    }

    public float e() {
        return this.f2159l;
    }

    public Map<String, com.airbnb.lottie.y.c> f() {
        return this.f2152e;
    }

    public float g() {
        return this.f2160m;
    }

    public Map<String, k> h() {
        return this.f2151d;
    }

    public List<com.airbnb.lottie.y.l.d> i() {
        return this.f2156i;
    }

    public List<com.airbnb.lottie.y.h> j() {
        return this.f2153f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int k() {
        return this.o;
    }

    public s l() {
        return this.a;
    }

    public float m() {
        return this.f2158k;
    }

    public ArrayList<String> n() {
        HashSet<String> hashSet = this.f2149b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean o() {
        return this.f2161n;
    }

    public boolean p() {
        return !this.f2151d.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.airbnb.lottie.y.l.d> it = this.f2156i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }

    /* JADX INFO: compiled from: LottieComposition.java */
    @Deprecated
    public static class b {

        /* JADX INFO: compiled from: LottieComposition.java */
        private static final class a implements l<g>, com.airbnb.lottie.b {
            private final r a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f2162b;

            @Override // com.airbnb.lottie.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(g gVar) {
                if (this.f2162b) {
                    return;
                }
                this.a.a(gVar);
            }

            @Override // com.airbnb.lottie.b
            public void cancel() {
                this.f2162b = true;
            }

            private a(r rVar) {
                this.f2162b = false;
                this.a = rVar;
            }
        }

        private b() {
        }

        @Deprecated
        public static com.airbnb.lottie.b a(Context context, String str, r rVar) {
            a aVar = new a(rVar);
            h.a(context, str).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(Context context, @RawRes int i2, r rVar) {
            a aVar = new a(rVar);
            h.a(context, i2).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(InputStream inputStream, r rVar) {
            a aVar = new a(rVar);
            h.a(inputStream, (String) null).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(String str, r rVar) {
            a aVar = new a(rVar);
            h.a(str, (String) null).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(com.airbnb.lottie.a0.l0.c cVar, r rVar) {
            a aVar = new a(rVar);
            h.a(cVar, (String) null).b(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(Context context, String str) {
            return h.b(context, str).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(InputStream inputStream) {
            return h.b(inputStream, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(InputStream inputStream, boolean z) {
            if (z) {
                com.airbnb.lottie.b0.d.b("Lottie now auto-closes input stream!");
            }
            return h.b(inputStream, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(Resources resources, JSONObject jSONObject) {
            return h.b(jSONObject, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(String str) {
            return h.b(str, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(com.airbnb.lottie.a0.l0.c cVar) {
            return h.b(cVar, (String) null).b();
        }
    }

    public float b(float f2) {
        float f3 = this.f2158k;
        return (f2 - f3) / (this.f2159l - f3);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.airbnb.lottie.y.l.d> c(String str) {
        return this.f2150c.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.y.d> b() {
        return this.f2154g;
    }

    @Nullable
    public com.airbnb.lottie.y.h b(String str) {
        int size = this.f2153f.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.airbnb.lottie.y.h hVar = this.f2153f.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        com.airbnb.lottie.b0.d.b(str);
        this.f2149b.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(boolean z) {
        this.f2161n = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(int i2) {
        this.o += i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.y.l.d a(long j2) {
        return this.f2155h.get(j2);
    }

    public Rect a() {
        return this.f2157j;
    }

    public float a(float f2) {
        return com.airbnb.lottie.b0.g.c(this.f2158k, this.f2159l, f2);
    }
}
