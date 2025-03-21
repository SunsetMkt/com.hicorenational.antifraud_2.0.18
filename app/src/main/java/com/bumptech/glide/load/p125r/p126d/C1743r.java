package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.C1627f;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter.java */
/* renamed from: com.bumptech.glide.load.r.d.r */
/* loaded from: classes.dex */
final class C1743r {

    /* renamed from: a */
    private static final String f4934a = "DrawableToBitmap";

    /* renamed from: b */
    private static final InterfaceC1626e f4935b = new a();

    /* compiled from: DrawableToBitmapConverter.java */
    /* renamed from: com.bumptech.glide.load.r.d.r$a */
    class a extends C1627f {
        a() {
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.C1627f, com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
        /* renamed from: a */
        public void mo3924a(Bitmap bitmap) {
        }
    }

    private C1743r() {
    }

    @Nullable
    /* renamed from: a */
    static InterfaceC1677v<Bitmap> m4397a(InterfaceC1626e interfaceC1626e, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = m4398b(interfaceC1626e, current, i2, i3);
            z = true;
        }
        if (!z) {
            interfaceC1626e = f4935b;
        }
        return C1728g.m4315a(bitmap, interfaceC1626e);
    }

    @Nullable
    /* renamed from: b */
    private static Bitmap m4398b(InterfaceC1626e interfaceC1626e, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f4934a, 5)) {
                String str = "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
            }
            return null;
        }
        if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(f4934a, 5)) {
                String str2 = "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Lock m4325a = C1729g0.m4325a();
        m4325a.lock();
        Bitmap mo3920a = interfaceC1626e.mo3920a(i2, i3, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(mo3920a);
            drawable.setBounds(0, 0, i2, i3);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return mo3920a;
        } finally {
            m4325a.unlock();
        }
    }
}
