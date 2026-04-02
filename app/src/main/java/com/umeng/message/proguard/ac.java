package com.umeng.message.proguard;

import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class ac {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UMessage f7944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7946d;

    public ac(int i2, UMessage uMessage) {
        this.a = i2;
        this.f7944b = uMessage;
    }

    public final boolean equals(Object obj) {
        return obj != null && ac.class == obj.getClass() && this.a == ((ac) obj).a;
    }
}
