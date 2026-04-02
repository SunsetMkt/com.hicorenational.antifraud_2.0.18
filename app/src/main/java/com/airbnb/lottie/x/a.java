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

/* JADX INFO: compiled from: FontAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetManager f2392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.c f2393e;
    private final i<String> a = new i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<i<String>, Typeface> f2390b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Typeface> f2391c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2394f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.c cVar) {
        this.f2393e = cVar;
        if (callback instanceof View) {
            this.f2392d = ((View) callback).getContext().getAssets();
        } else {
            d.b("LottieDrawable must be inside of a view for images to work.");
            this.f2392d = null;
        }
    }

    private Typeface b(String str) {
        String strB;
        Typeface typeface = this.f2391c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.c cVar = this.f2393e;
        Typeface typefaceA = cVar != null ? cVar.a(str) : null;
        com.airbnb.lottie.c cVar2 = this.f2393e;
        if (cVar2 != null && typefaceA == null && (strB = cVar2.b(str)) != null) {
            typefaceA = Typeface.createFromAsset(this.f2392d, strB);
        }
        if (typefaceA == null) {
            typefaceA = Typeface.createFromAsset(this.f2392d, "fonts/" + str + this.f2394f);
        }
        this.f2391c.put(str, typefaceA);
        return typefaceA;
    }

    public void a(@Nullable com.airbnb.lottie.c cVar) {
        this.f2393e = cVar;
    }

    public void a(String str) {
        this.f2394f = str;
    }

    public Typeface a(String str, String str2) {
        this.a.a(str, str2);
        Typeface typeface = this.f2390b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceA = a(b(str), str2);
        this.f2390b.put(this.a, typefaceA);
        return typefaceA;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i2 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }
}
