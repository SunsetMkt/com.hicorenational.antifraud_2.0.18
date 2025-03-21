package com.bumptech.glide.p137r.p138l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.util.C1876j;

/* compiled from: NotificationTarget.java */
/* renamed from: com.bumptech.glide.r.l.l */
/* loaded from: classes.dex */
public class C1844l extends AbstractC1837e<Bitmap> {

    /* renamed from: d */
    private final RemoteViews f5407d;

    /* renamed from: e */
    private final Context f5408e;

    /* renamed from: f */
    private final int f5409f;

    /* renamed from: g */
    private final String f5410g;

    /* renamed from: h */
    private final Notification f5411h;

    /* renamed from: i */
    private final int f5412i;

    public C1844l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, null);
    }

    /* renamed from: b */
    private void m4909b() {
        ((NotificationManager) C1876j.m4985a((NotificationManager) this.f5408e.getSystemService("notification"))).notify(this.f5410g, this.f5409f, this.f5411h);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f interfaceC1856f) {
        m4910a((Bitmap) obj, (InterfaceC1856f<? super Bitmap>) interfaceC1856f);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
        m4908a((Bitmap) null);
    }

    public C1844l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }

    /* renamed from: a */
    public void m4910a(@NonNull Bitmap bitmap, @Nullable InterfaceC1856f<? super Bitmap> interfaceC1856f) {
        m4908a(bitmap);
    }

    public C1844l(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.f5408e = (Context) C1876j.m4986a(context, "Context must not be null!");
        this.f5411h = (Notification) C1876j.m4986a(notification, "Notification object can not be null!");
        this.f5407d = (RemoteViews) C1876j.m4986a(remoteViews, "RemoteViews object can not be null!");
        this.f5412i = i4;
        this.f5409f = i5;
        this.f5410g = str;
    }

    /* renamed from: a */
    private void m4908a(@Nullable Bitmap bitmap) {
        this.f5407d.setImageViewBitmap(this.f5412i, bitmap);
        m4909b();
    }
}
