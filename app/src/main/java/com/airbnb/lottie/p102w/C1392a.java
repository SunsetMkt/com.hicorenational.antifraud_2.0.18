package com.airbnb.lottie.p102w;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* compiled from: LPaint.java */
/* renamed from: com.airbnb.lottie.w.a */
/* loaded from: classes.dex */
public class C1392a extends Paint {
    public C1392a() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public C1392a(int i2) {
        super(i2);
    }

    public C1392a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public C1392a(int i2, PorterDuff.Mode mode) {
        super(i2);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
