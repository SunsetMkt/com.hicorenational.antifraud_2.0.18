package com.bumptech.glide.r.l;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AppWidgetTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends e<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f3486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ComponentName f3487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RemoteViews f3488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f3489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f3490h;

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.f3489g = (Context) com.bumptech.glide.util.j.a(context, "Context can not be null!");
        this.f3488f = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f3486d = (int[]) com.bumptech.glide.util.j.a(iArr, "WidgetIds can not be null!");
        this.f3490h = i4;
        this.f3487e = null;
    }

    private void b() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f3489g);
        ComponentName componentName = this.f3487e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f3488f);
        } else {
            appWidgetManager.updateAppWidget(this.f3486d, this.f3488f);
        }
    }

    @Override // com.bumptech.glide.r.l.p
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        a((Bitmap) null);
    }

    public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    private void a(@Nullable Bitmap bitmap) {
        this.f3488f.setImageViewBitmap(this.f3490h, bitmap);
        b();
    }

    public a(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
    }

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        this.f3489g = (Context) com.bumptech.glide.util.j.a(context, "Context can not be null!");
        this.f3488f = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f3487e = (ComponentName) com.bumptech.glide.util.j.a(componentName, "ComponentName can not be null!");
        this.f3490h = i4;
        this.f3486d = null;
    }

    public a(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
    }
}
