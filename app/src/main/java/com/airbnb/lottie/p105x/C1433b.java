package com.airbnb.lottie.p105x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1380k;
import com.airbnb.lottie.InterfaceC1373d;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* renamed from: com.airbnb.lottie.x.b */
/* loaded from: classes.dex */
public class C1433b {

    /* renamed from: e */
    private static final Object f3572e = new Object();

    /* renamed from: a */
    private final Context f3573a;

    /* renamed from: b */
    private final String f3574b;

    /* renamed from: c */
    @Nullable
    private InterfaceC1373d f3575c;

    /* renamed from: d */
    private final Map<String, C1380k> f3576d;

    public C1433b(Drawable.Callback callback, String str, InterfaceC1373d interfaceC1373d, Map<String, C1380k> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f3574b = str;
        } else {
            this.f3574b = str + '/';
        }
        if (callback instanceof View) {
            this.f3573a = ((View) callback).getContext();
            this.f3576d = map;
            m3183a(interfaceC1373d);
        } else {
            C1354d.m2791b("LottieDrawable must be inside of a view for images to work.");
            this.f3576d = new HashMap();
            this.f3573a = null;
        }
    }

    /* renamed from: b */
    private Bitmap m3180b(String str, @Nullable Bitmap bitmap) {
        synchronized (f3572e) {
            this.f3576d.get(str).m3052a(bitmap);
        }
        return bitmap;
    }

    /* renamed from: a */
    public void m3183a(@Nullable InterfaceC1373d interfaceC1373d) {
        this.f3575c = interfaceC1373d;
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m3182a(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap m3051a = this.f3576d.get(str).m3051a();
            m3180b(str, bitmap);
            return m3051a;
        }
        C1380k c1380k = this.f3576d.get(str);
        Bitmap m3051a2 = c1380k.m3051a();
        c1380k.m3052a(null);
        return m3051a2;
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m3181a(String str) {
        C1380k c1380k = this.f3576d.get(str);
        if (c1380k == null) {
            return null;
        }
        Bitmap m3051a = c1380k.m3051a();
        if (m3051a != null) {
            return m3051a;
        }
        InterfaceC1373d interfaceC1373d = this.f3575c;
        if (interfaceC1373d != null) {
            Bitmap m2877a = interfaceC1373d.m2877a(c1380k);
            if (m2877a != null) {
                m3180b(str, m2877a);
            }
            return m2877a;
        }
        String m3054c = c1380k.m3054c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (m3054c.startsWith("data:") && m3054c.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(m3054c.substring(m3054c.indexOf(44) + 1), 0);
                return m3180b(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                C1354d.m2793c("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f3574b)) {
                try {
                    return m3180b(str, C1358h.m2836a(BitmapFactory.decodeStream(this.f3573a.getAssets().open(this.f3574b + m3054c), null, options), c1380k.m3057f(), c1380k.m3055d()));
                } catch (IllegalArgumentException e3) {
                    C1354d.m2793c("Unable to decode image.", e3);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e4) {
            C1354d.m2793c("Unable to open asset.", e4);
            return null;
        }
    }

    /* renamed from: a */
    public boolean m3184a(Context context) {
        return (context == null && this.f3573a == null) || this.f3573a.equals(context);
    }
}
