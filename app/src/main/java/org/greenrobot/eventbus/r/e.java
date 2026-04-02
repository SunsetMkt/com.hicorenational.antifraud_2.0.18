package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SubscriberMethodInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadMode f12962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f12963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f12964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f12965e;

    public e(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.a = str;
        this.f12962b = threadMode;
        this.f12963c = cls;
        this.f12964d = i2;
        this.f12965e = z;
    }

    public e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false);
    }

    public e(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}
