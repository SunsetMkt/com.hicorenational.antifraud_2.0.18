package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PaintDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends Drawable {
    protected Paint a = new Paint();

    protected b() {
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setColor(-5592406);
    }

    public void a(int i2) {
        this.a.setColor(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
