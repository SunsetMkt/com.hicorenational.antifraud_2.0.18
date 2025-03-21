package com.airbnb.lottie.p105x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1360c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p106y.C1443i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* renamed from: com.airbnb.lottie.x.a */
/* loaded from: classes.dex */
public class C1432a {

    /* renamed from: d */
    private final AssetManager f3569d;

    /* renamed from: e */
    @Nullable
    private C1360c f3570e;

    /* renamed from: a */
    private final C1443i<String> f3566a = new C1443i<>();

    /* renamed from: b */
    private final Map<C1443i<String>, Typeface> f3567b = new HashMap();

    /* renamed from: c */
    private final Map<String, Typeface> f3568c = new HashMap();

    /* renamed from: f */
    private String f3571f = ".ttf";

    public C1432a(Drawable.Callback callback, @Nullable C1360c c1360c) {
        this.f3570e = c1360c;
        if (callback instanceof View) {
            this.f3569d = ((View) callback).getContext().getAssets();
        } else {
            C1354d.m2791b("LottieDrawable must be inside of a view for images to work.");
            this.f3569d = null;
        }
    }

    /* renamed from: b */
    private Typeface m3176b(String str) {
        String m2848b;
        Typeface typeface = this.f3568c.get(str);
        if (typeface != null) {
            return typeface;
        }
        C1360c c1360c = this.f3570e;
        Typeface m2847a = c1360c != null ? c1360c.m2847a(str) : null;
        C1360c c1360c2 = this.f3570e;
        if (c1360c2 != null && m2847a == null && (m2848b = c1360c2.m2848b(str)) != null) {
            m2847a = Typeface.createFromAsset(this.f3569d, m2848b);
        }
        if (m2847a == null) {
            m2847a = Typeface.createFromAsset(this.f3569d, "fonts/" + str + this.f3571f);
        }
        this.f3568c.put(str, m2847a);
        return m2847a;
    }

    /* renamed from: a */
    public void m3178a(@Nullable C1360c c1360c) {
        this.f3570e = c1360c;
    }

    /* renamed from: a */
    public void m3179a(String str) {
        this.f3571f = str;
    }

    /* renamed from: a */
    public Typeface m3177a(String str, String str2) {
        this.f3566a.m3219a(str, str2);
        Typeface typeface = this.f3567b.get(this.f3566a);
        if (typeface != null) {
            return typeface;
        }
        Typeface m3175a = m3175a(m3176b(str), str2);
        this.f3567b.put(this.f3566a, m3175a);
        return m3175a;
    }

    /* renamed from: a */
    private Typeface m3175a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }
}
