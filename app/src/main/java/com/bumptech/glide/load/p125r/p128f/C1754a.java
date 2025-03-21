package com.bumptech.glide.load.p125r.p128f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: DrawableDecoderCompat.java */
/* renamed from: com.bumptech.glide.load.r.f.a */
/* loaded from: classes.dex */
public final class C1754a {

    /* renamed from: a */
    private static volatile boolean f4969a = true;

    private C1754a() {
    }

    /* renamed from: a */
    public static Drawable m4414a(Context context, Context context2, @DrawableRes int i2) {
        return m4415a(context, context2, i2, null);
    }

    /* renamed from: b */
    private static Drawable m4416b(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i2, theme);
    }

    /* renamed from: c */
    private static Drawable m4417c(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i2);
    }

    /* renamed from: a */
    public static Drawable m4413a(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return m4415a(context, context, i2, theme);
    }

    /* renamed from: a */
    private static Drawable m4415a(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (f4969a) {
                return m4417c(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            f4969a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m4416b(context2, i2, theme);
    }
}
