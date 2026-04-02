package com.airbnb.lottie.w.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CompoundTrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private List<t> a = new ArrayList();

    void a(t tVar) {
        this.a.add(tVar);
    }

    public void a(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.b0.h.a(path, this.a.get(size));
        }
    }
}
