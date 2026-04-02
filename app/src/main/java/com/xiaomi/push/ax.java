package com.xiaomi.push;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ax {
    private LinkedList<a> a = new LinkedList<>();

    public static class a {
        private static final ax a = new ax();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f201a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f202a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f203a;

        a(int i2, Object obj) {
            this.f201a = i2;
            this.f202a = obj;
        }
    }

    public static ax a() {
        return a.a;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m156a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m156a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m157a() {
        return this.a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m158a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
