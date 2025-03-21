package com.bumptech.glide.p137r.p138l;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.util.C1876j;

/* compiled from: AppWidgetTarget.java */
/* renamed from: com.bumptech.glide.r.l.a */
/* loaded from: classes.dex */
public class C1833a extends AbstractC1837e<Bitmap> {

    /* renamed from: d */
    private final int[] f5373d;

    /* renamed from: e */
    private final ComponentName f5374e;

    /* renamed from: f */
    private final RemoteViews f5375f;

    /* renamed from: g */
    private final Context f5376g;

    /* renamed from: h */
    private final int f5377h;

    public C1833a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.f5376g = (Context) C1876j.m4986a(context, "Context can not be null!");
        this.f5375f = (RemoteViews) C1876j.m4986a(remoteViews, "RemoteViews object can not be null!");
        this.f5373d = (int[]) C1876j.m4986a(iArr, "WidgetIds can not be null!");
        this.f5377h = i4;
        this.f5374e = null;
    }

    /* renamed from: b */
    private void m4873b() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f5376g);
        ComponentName componentName = this.f5374e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f5375f);
        } else {
            appWidgetManager.updateAppWidget(this.f5373d, this.f5375f);
        }
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f interfaceC1856f) {
        m4874a((Bitmap) obj, (InterfaceC1856f<? super Bitmap>) interfaceC1856f);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
        m4872a((Bitmap) null);
    }

    /* renamed from: a */
    public void m4874a(@NonNull Bitmap bitmap, @Nullable InterfaceC1856f<? super Bitmap> interfaceC1856f) {
        m4872a(bitmap);
    }

    /* renamed from: a */
    private void m4872a(@Nullable Bitmap bitmap) {
        this.f5375f.setImageViewBitmap(this.f5377h, bitmap);
        m4873b();
    }

    public C1833a(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
    }

    public C1833a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        this.f5376g = (Context) C1876j.m4986a(context, "Context can not be null!");
        this.f5375f = (RemoteViews) C1876j.m4986a(remoteViews, "RemoteViews object can not be null!");
        this.f5374e = (ComponentName) C1876j.m4986a(componentName, "ComponentName can not be null!");
        this.f5377h = i4;
        this.f5373d = null;
    }

    public C1833a(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
    }
}
