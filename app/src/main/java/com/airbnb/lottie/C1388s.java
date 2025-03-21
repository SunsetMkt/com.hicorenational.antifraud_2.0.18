package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.p100b0.C1356f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* renamed from: com.airbnb.lottie.s */
/* loaded from: classes.dex */
public class C1388s {

    /* renamed from: a */
    private boolean f3365a = false;

    /* renamed from: b */
    private final Set<b> f3366b = new ArraySet();

    /* renamed from: c */
    private final Map<String, C1356f> f3367c = new HashMap();

    /* renamed from: d */
    private final Comparator<Pair<String, Float>> f3368d = new a();

    /* compiled from: PerformanceTracker.java */
    /* renamed from: com.airbnb.lottie.s$a */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* renamed from: com.airbnb.lottie.s$b */
    public interface b {
        /* renamed from: a */
        void m3083a(float f2);
    }

    /* renamed from: a */
    void m3078a(boolean z) {
        this.f3365a = z;
    }

    /* renamed from: b */
    public void m3080b(b bVar) {
        this.f3366b.remove(bVar);
    }

    /* renamed from: c */
    public void m3081c() {
        if (this.f3365a) {
            List<Pair<String, Float>> m3079b = m3079b();
            for (int i2 = 0; i2 < m3079b.size(); i2++) {
                Pair<String, Float> pair = m3079b.get(i2);
                String.format("\t\t%30s:%.2f", pair.first, pair.second);
            }
        }
    }

    /* renamed from: a */
    public void m3077a(String str, float f2) {
        if (this.f3365a) {
            C1356f c1356f = this.f3367c.get(str);
            if (c1356f == null) {
                c1356f = new C1356f();
                this.f3367c.put(str, c1356f);
            }
            c1356f.m2818a(f2);
            if (str.equals("__container")) {
                Iterator<b> it = this.f3366b.iterator();
                while (it.hasNext()) {
                    it.next().m3083a(f2);
                }
            }
        }
    }

    /* renamed from: b */
    public List<Pair<String, Float>> m3079b() {
        if (!this.f3365a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f3367c.size());
        for (Map.Entry<String, C1356f> entry : this.f3367c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().m2817a())));
        }
        Collections.sort(arrayList, this.f3368d);
        return arrayList;
    }

    /* renamed from: a */
    public void m3076a(b bVar) {
        this.f3366b.add(bVar);
    }

    /* renamed from: a */
    public void m3075a() {
        this.f3367c.clear();
    }
}
