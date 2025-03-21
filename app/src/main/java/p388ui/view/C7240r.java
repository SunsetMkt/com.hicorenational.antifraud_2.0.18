package p388ui.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.AbstractC1730h;
import com.bumptech.glide.load.p125r.p126d.C1729g0;
import java.security.MessageDigest;

/* compiled from: GlideRoundTransform.java */
/* renamed from: ui.view.r */
/* loaded from: classes2.dex */
public class C7240r extends AbstractC1730h {

    /* renamed from: c */
    private static float f24974c;

    public C7240r() {
        this(4);
    }

    @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1730h
    /* renamed from: a */
    protected Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        return m26027a(interfaceC1626e, C1729g0.m4322a(interfaceC1626e, bitmap, i2, i3));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(MessageDigest messageDigest) {
    }

    public C7240r(int i2) {
        f24974c = Resources.getSystem().getDisplayMetrics().density * i2;
    }

    /* renamed from: a */
    private static Bitmap m26027a(InterfaceC1626e interfaceC1626e, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap mo3920a = interfaceC1626e.mo3920a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (mo3920a == null) {
            mo3920a = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(mo3920a);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f2 = f24974c;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        return mo3920a;
    }
}
