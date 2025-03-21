package com.airbnb.lottie.x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.b0.d;
import com.airbnb.lottie.y.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f3793d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.c f3794e;

    /* renamed from: a, reason: collision with root package name */
    private final i<String> f3790a = new i<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<i<String>, Typeface> f3791b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Typeface> f3792c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private String f3795f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.c cVar) {
        this.f3794e = cVar;
        if (callback instanceof View) {
            this.f3793d = ((View) callback).getContext().getAssets();
        } else {
            d.b("LottieDrawable must be inside of a view for images to work.");
            this.f3793d = null;
        }
    }

    private Typeface b(String str) {
        String b2;
        Typeface typeface = this.f3792c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.c cVar = this.f3794e;
        Typeface a2 = cVar != null ? cVar.a(str) : null;
        com.airbnb.lottie.c cVar2 = this.f3794e;
        if (cVar2 != null && a2 == null && (b2 = cVar2.b(str)) != null) {
            a2 = Typeface.createFromAsset(this.f3793d, b2);
        }
        if (a2 == null) {
            a2 = Typeface.createFromAsset(this.f3793d, "fonts/" + str + this.f3795f);
        }
        this.f3792c.put(str, a2);
        return a2;
    }

    public void a(@Nullable com.airbnb.lottie.c cVar) {
        this.f3794e = cVar;
    }

    public void a(String str) {
        this.f3795f = str;
    }

    public Typeface a(String str, String str2) {
        this.f3790a.a(str, str2);
        Typeface typeface = this.f3791b.get(this.f3790a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(b(str), str2);
        this.f3791b.put(this.f3790a, a2);
        return a2;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }
}
