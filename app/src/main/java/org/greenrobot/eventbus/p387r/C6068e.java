package org.greenrobot.eventbus.p387r;

import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SubscriberMethodInfo.java */
/* renamed from: org.greenrobot.eventbus.r.e */
/* loaded from: classes2.dex */
public class C6068e {

    /* renamed from: a */
    final String f21620a;

    /* renamed from: b */
    final ThreadMode f21621b;

    /* renamed from: c */
    final Class<?> f21622c;

    /* renamed from: d */
    final int f21623d;

    /* renamed from: e */
    final boolean f21624e;

    public C6068e(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f21620a = str;
        this.f21621b = threadMode;
        this.f21622c = cls;
        this.f21623d = i2;
        this.f21624e = z;
    }

    public C6068e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false);
    }

    public C6068e(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}
