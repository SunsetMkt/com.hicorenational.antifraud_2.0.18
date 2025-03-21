package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* compiled from: ModelTypes.java */
/* renamed from: com.bumptech.glide.g */
/* loaded from: classes.dex */
interface InterfaceC1581g<T> {
    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3714a(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3715a(@Nullable Uri uri);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3716a(@Nullable File file);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3717a(@Nullable @DrawableRes @RawRes Integer num);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3718a(@Nullable Object obj);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3719a(@Nullable String str);

    @CheckResult
    @Deprecated
    /* renamed from: a */
    T mo3720a(@Nullable URL url);

    @NonNull
    @CheckResult
    /* renamed from: a */
    T mo3721a(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    /* renamed from: d */
    T mo3722d(@Nullable Drawable drawable);
}
