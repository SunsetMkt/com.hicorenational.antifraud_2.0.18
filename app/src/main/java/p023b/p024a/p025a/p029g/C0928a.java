package p023b.p024a.p025a.p029g;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.DrawableRes;

/* compiled from: CompatUtils.java */
/* renamed from: b.a.a.g.a */
/* loaded from: classes.dex */
public class C0928a {
    @TargetApi(16)
    /* renamed from: a */
    public static void m1079a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    public static Drawable m1078a(Context context, @DrawableRes int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return context.getResources().getDrawable(i2);
        }
        return context.getDrawable(i2);
    }
}
