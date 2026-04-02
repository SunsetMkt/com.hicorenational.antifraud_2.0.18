package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ch {
    private int a;

    public ch(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<at> list);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m237a(Context context, String str, List<at> list) {
        return true;
    }
}
