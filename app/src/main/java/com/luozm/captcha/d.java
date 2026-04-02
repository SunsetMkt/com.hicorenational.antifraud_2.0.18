package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: compiled from: CaptchaStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    protected Context a;

    public d(Context context) {
        this.a = context;
    }

    public abstract Paint a();

    public abstract Path a(int i2);

    public abstract f a(int i2, int i3, int i4);

    public void a(Canvas canvas, Path path) {
    }

    public abstract Paint b();

    public f b(int i2, int i3, int i4) {
        return a(i2, i3, i4);
    }

    protected Context c() {
        return this.a;
    }
}
