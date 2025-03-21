package com.bumptech.glide.load.p125r.p128f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* renamed from: com.bumptech.glide.load.r.f.e */
/* loaded from: classes.dex */
public class C1758e implements InterfaceC1598l<Uri, Drawable> {

    /* renamed from: b */
    private static final String f4971b = "android";

    /* renamed from: c */
    private static final int f4972c = 0;

    /* renamed from: d */
    private static final int f4973d = 2;

    /* renamed from: e */
    private static final int f4974e = 0;

    /* renamed from: f */
    private static final int f4975f = 1;

    /* renamed from: g */
    private static final int f4976g = 1;

    /* renamed from: h */
    private static final int f4977h = 0;

    /* renamed from: a */
    private final Context f4978a;

    public C1758e(Context context) {
        this.f4978a = context.getApplicationContext();
    }

    @DrawableRes
    /* renamed from: b */
    private int m4431b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return m4428a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return m4429a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull Uri uri, @NonNull C1596j c1596j) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Drawable> mo3842a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        Context m4430a = m4430a(uri, uri.getAuthority());
        return C1757d.m4427a(C1754a.m4414a(this.f4978a, m4430a, m4431b(m4430a, uri)));
    }

    @NonNull
    /* renamed from: a */
    private Context m4430a(Uri uri, String str) {
        if (str.equals(this.f4978a.getPackageName())) {
            return this.f4978a;
        }
        try {
            return this.f4978a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f4978a.getPackageName())) {
                return this.f4978a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    /* renamed from: a */
    private int m4428a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    /* renamed from: a */
    private int m4429a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
