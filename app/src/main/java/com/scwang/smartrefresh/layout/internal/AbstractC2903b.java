package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: PaintDrawable.java */
/* renamed from: com.scwang.smartrefresh.layout.internal.b */
/* loaded from: classes.dex */
public abstract class AbstractC2903b extends Drawable {

    /* renamed from: a */
    protected Paint f9254a = new Paint();

    protected AbstractC2903b() {
        this.f9254a.setStyle(Paint.Style.FILL);
        this.f9254a.setAntiAlias(true);
        this.f9254a.setColor(-5592406);
    }

    /* renamed from: a */
    public void m8800a(int i2) {
        this.f9254a.setColor(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f9254a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9254a.setColorFilter(colorFilter);
    }
}
