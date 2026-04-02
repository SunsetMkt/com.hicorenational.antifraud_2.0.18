package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dw extends dx {
    private int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8914b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Bitmap f405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8915c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private CharSequence f406c;

    public dw(Context context, int i2, String str) {
        super(context, i2, str);
        this.a = 16777216;
        this.f8914b = 16777216;
        this.f8915c = 16777216;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    protected String mo365a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    protected boolean mo359a() {
        if (!j.m624a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public dw b(String str) {
        if (m368b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m48a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    protected String b() {
        return "notification_colorful_copy";
    }

    public dw c(String str) {
        if (m368b() && !TextUtils.isEmpty(str)) {
            try {
                this.f8915c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m48a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public dw a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m368b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f406c = charSequence;
            this.f404a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public dw mo360a(String str) {
        if (m368b() && !TextUtils.isEmpty(str)) {
            try {
                this.f8914b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m48a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public dw setLargeIcon(Bitmap bitmap) {
        if (m368b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f405b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m48a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public void mo358a() {
        if (m368b()) {
            super.mo358a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (((dx) this).f407a == null) {
                a(iA);
            } else {
                m364a().setImageViewBitmap(iA, ((dx) this).f407a);
            }
            int iA2 = a(resources, "title", "id", packageName);
            int iA3 = a(resources, "content", "id", packageName);
            m364a().setTextViewText(iA2, ((dx) this).f409a);
            m364a().setTextViewText(iA3, ((dx) this).f414b);
            if (!TextUtils.isEmpty(this.f406c)) {
                int iA4 = a(resources, "buttonContainer", "id", packageName);
                int iA5 = a(resources, "button", "id", packageName);
                int iA6 = a(resources, "buttonBg", "id", packageName);
                m364a().setViewVisibility(iA4, 0);
                m364a().setTextViewText(iA5, this.f406c);
                m364a().setOnClickPendingIntent(iA4, this.f404a);
                if (this.f8914b != 16777216) {
                    int iA7 = a(70.0f);
                    int iA8 = a(29.0f);
                    m364a().setImageViewBitmap(iA6, com.xiaomi.push.service.x.a(a(this.f8914b, iA7, iA8, iA8 / 2.0f)));
                    m364a().setTextColor(iA5, m366a(this.f8914b) ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            int iA9 = a(resources, "bg", "id", packageName);
            int iA10 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (j.a(a()) >= 10) {
                    m364a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 30.0f)));
                } else {
                    m364a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.a, 984, 192, 0.0f)));
                }
                a(m364a(), iA10, iA2, iA3, m366a(this.a));
            } else if (this.f405b != null) {
                if (j.a(a()) >= 10) {
                    m364a().setImageViewBitmap(iA9, a(this.f405b, 30.0f));
                } else {
                    m364a().setImageViewBitmap(iA9, this.f405b);
                }
                Map<String, String> map = ((dx) this).f412a;
                if (map != null && this.f8915c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i2 = this.f8915c;
                a(m364a(), iA10, iA2, iA3, i2 == 16777216 || !m366a(i2));
            } else if (Build.VERSION.SDK_INT >= 24) {
                m364a().setViewVisibility(iA, 8);
                m364a().setViewVisibility(iA9, 8);
                try {
                    aw.a((Object) this, "setStyle", r.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m364a());
            return;
        }
        m367b();
    }

    private void a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        int iA = a(6.0f);
        remoteViews.setViewPadding(i2, iA, 0, iA, 0);
        if (z) {
            remoteViews.setTextColor(i3, -1);
            remoteViews.setTextColor(i4, -1);
        } else {
            remoteViews.setTextColor(i3, ViewCompat.MEASURED_STATE_MASK);
            remoteViews.setTextColor(i4, ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private Drawable a(int i2, int i3, int i4, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(i4);
        return shapeDrawable;
    }
}
