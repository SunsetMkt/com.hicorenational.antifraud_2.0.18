package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost.java */
/* renamed from: org.greenrobot.eventbus.j */
/* loaded from: classes2.dex */
final class C6056j {

    /* renamed from: d */
    private static final List<C6056j> f21580d = new ArrayList();

    /* renamed from: a */
    Object f21581a;

    /* renamed from: b */
    C6063q f21582b;

    /* renamed from: c */
    C6056j f21583c;

    private C6056j(Object obj, C6063q c6063q) {
        this.f21581a = obj;
        this.f21582b = c6063q;
    }

    /* renamed from: a */
    static C6056j m25028a(C6063q c6063q, Object obj) {
        synchronized (f21580d) {
            int size = f21580d.size();
            if (size <= 0) {
                return new C6056j(obj, c6063q);
            }
            C6056j remove = f21580d.remove(size - 1);
            remove.f21581a = obj;
            remove.f21582b = c6063q;
            remove.f21583c = null;
            return remove;
        }
    }

    /* renamed from: a */
    static void m25029a(C6056j c6056j) {
        c6056j.f21581a = null;
        c6056j.f21582b = null;
        c6056j.f21583c = null;
        synchronized (f21580d) {
            if (f21580d.size() < 10000) {
                f21580d.add(c6056j);
            }
        }
    }
}
