package com.xiaomi.push;

import java.util.LinkedList;

/* renamed from: com.xiaomi.push.ax */
/* loaded from: classes2.dex */
public class C4095ax {

    /* renamed from: a */
    private LinkedList<a> f14585a = new LinkedList<>();

    /* renamed from: com.xiaomi.push.ax$a */
    public static class a {

        /* renamed from: a */
        private static final C4095ax f14586a = new C4095ax();

        /* renamed from: a */
        public int f14587a;

        /* renamed from: a */
        public Object f14588a;

        /* renamed from: a */
        public String f14589a;

        a(int i2, Object obj) {
            this.f14587a = i2;
            this.f14588a = obj;
        }
    }

    /* renamed from: a */
    public static C4095ax m13833a() {
        return a.f14586a;
    }

    /* renamed from: a */
    public synchronized void m13837a(Object obj) {
        this.f14585a.add(new a(0, obj));
        m13834a();
    }

    /* renamed from: a */
    private void m13834a() {
        if (this.f14585a.size() > 100) {
            this.f14585a.removeFirst();
        }
    }

    /* renamed from: a */
    public synchronized int m13835a() {
        return this.f14585a.size();
    }

    /* renamed from: a */
    public synchronized LinkedList<a> m13836a() {
        LinkedList<a> linkedList;
        linkedList = this.f14585a;
        this.f14585a = new LinkedList<>();
        return linkedList;
    }
}
