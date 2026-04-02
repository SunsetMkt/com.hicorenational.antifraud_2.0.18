package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PerformanceTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b> f2239b = new ArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, com.airbnb.lottie.b0.f> f2240c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f2241d = new a();

    /* JADX INFO: compiled from: PerformanceTracker.java */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: PerformanceTracker.java */
    public interface b {
        void a(float f2);
    }

    void a(boolean z) {
        this.a = z;
    }

    public void b(b bVar) {
        this.f2239b.remove(bVar);
    }

    public void c() {
        if (this.a) {
            List<Pair<String, Float>> listB = b();
            for (int i2 = 0; i2 < listB.size(); i2++) {
                Pair<String, Float> pair = listB.get(i2);
                String.format("\t\t%30s:%.2f", pair.first, pair.second);
            }
        }
    }

    public void a(String str, float f2) {
        if (this.a) {
            com.airbnb.lottie.b0.f fVar = this.f2240c.get(str);
            if (fVar == null) {
                fVar = new com.airbnb.lottie.b0.f();
                this.f2240c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                Iterator<b> it = this.f2239b.iterator();
                while (it.hasNext()) {
                    it.next().a(f2);
                }
            }
        }
    }

    public List<Pair<String, Float>> b() {
        if (!this.a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f2240c.size());
        for (Map.Entry<String, com.airbnb.lottie.b0.f> entry : this.f2240c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().a())));
        }
        Collections.sort(arrayList, this.f2241d);
        return arrayList;
    }

    public void a(b bVar) {
        this.f2239b.add(bVar);
    }

    public void a() {
        this.f2240c.clear();
    }
}
