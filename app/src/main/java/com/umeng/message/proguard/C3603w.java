package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.umeng.message.proguard.w */
/* loaded from: classes2.dex */
public class C3603w {

    /* renamed from: b */
    private static volatile C3603w f13386b;

    /* renamed from: a */
    private final LinkedList<C3554ac> f13387a = new LinkedList<>();

    private C3603w() {
    }

    /* renamed from: a */
    public static C3603w m12454a() {
        if (f13386b == null) {
            synchronized (C3603w.class) {
                if (f13386b == null) {
                    f13386b = new C3603w();
                }
            }
        }
        return f13386b;
    }

    /* renamed from: b */
    public final C3554ac m12457b() {
        C3554ac pollFirst;
        synchronized (this.f13387a) {
            pollFirst = this.f13387a.pollFirst();
        }
        return pollFirst;
    }

    /* renamed from: c */
    public final int m12459c() {
        int size;
        synchronized (this.f13387a) {
            size = this.f13387a.size();
        }
        return size;
    }

    /* renamed from: b */
    public final void m12458b(C3554ac c3554ac) {
        synchronized (this.f13387a) {
            this.f13387a.remove(c3554ac);
        }
    }

    /* renamed from: a */
    public final void m12456a(C3554ac c3554ac) {
        synchronized (this.f13387a) {
            this.f13387a.addLast(c3554ac);
        }
    }

    /* renamed from: a */
    public final C3554ac m12455a(String str) {
        synchronized (this.f13387a) {
            Iterator<C3554ac> it = this.f13387a.iterator();
            while (it.hasNext()) {
                C3554ac next = it.next();
                UMessage uMessage = next.f13151b;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
