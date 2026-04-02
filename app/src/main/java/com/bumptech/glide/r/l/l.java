package com.bumptech.glide.r.l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: NotificationTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends e<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RemoteViews f3512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f3513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f3515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Notification f3516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f3517i;

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, null);
    }

    private void b() {
        ((NotificationManager) com.bumptech.glide.util.j.a((NotificationManager) this.f3513e.getSystemService("notification"))).notify(this.f3515g, this.f3514f, this.f3516h);
    }

    @Override // com.bumptech.glide.r.l.p
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        a((Bitmap) null);
    }

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }

    public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    public l(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.f3513e = (Context) com.bumptech.glide.util.j.a(context, "Context must not be null!");
        this.f3516h = (Notification) com.bumptech.glide.util.j.a(notification, "Notification object can not be null!");
        this.f3512d = (RemoteViews) com.bumptech.glide.util.j.a(remoteViews, "RemoteViews object can not be null!");
        this.f3517i = i4;
        this.f3514f = i5;
        this.f3515g = str;
    }

    private void a(@Nullable Bitmap bitmap) {
        this.f3512d.setImageViewBitmap(this.f3517i, bitmap);
        b();
    }
}
