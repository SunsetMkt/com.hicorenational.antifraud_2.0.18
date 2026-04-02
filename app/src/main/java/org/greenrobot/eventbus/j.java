package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PendingPost.java */
/* JADX INFO: loaded from: classes2.dex */
final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<j> f12930d = new ArrayList();
    Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    q f12931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j f12932c;

    private j(Object obj, q qVar) {
        this.a = obj;
        this.f12931b = qVar;
    }

    static j a(q qVar, Object obj) {
        synchronized (f12930d) {
            int size = f12930d.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j jVarRemove = f12930d.remove(size - 1);
            jVarRemove.a = obj;
            jVarRemove.f12931b = qVar;
            jVarRemove.f12932c = null;
            return jVarRemove;
        }
    }

    static void a(j jVar) {
        jVar.a = null;
        jVar.f12931b = null;
        jVar.f12932c = null;
        synchronized (f12930d) {
            if (f12930d.size() < 10000) {
                f12930d.add(jVar);
            }
        }
    }
}
