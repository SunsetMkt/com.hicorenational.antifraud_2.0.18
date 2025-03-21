package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* compiled from: CaptchaStrategy.java */
/* renamed from: com.luozm.captcha.d */
/* loaded from: classes.dex */
public abstract class AbstractC2743d {

    /* renamed from: a */
    protected Context f8475a;

    public AbstractC2743d(Context context) {
        this.f8475a = context;
    }

    /* renamed from: a */
    public abstract Paint mo8193a();

    /* renamed from: a */
    public abstract Path mo8194a(int i2);

    /* renamed from: a */
    public abstract C2745f mo8195a(int i2, int i3, int i4);

    /* renamed from: a */
    public void mo8196a(Canvas canvas, Path path) {
    }

    /* renamed from: b */
    public abstract Paint mo8197b();

    /* renamed from: b */
    public C2745f mo8198b(int i2, int i3, int i4) {
        return mo8195a(i2, i3, i4);
    }

    /* renamed from: c */
    protected Context m8199c() {
        return this.f8475a;
    }
}
