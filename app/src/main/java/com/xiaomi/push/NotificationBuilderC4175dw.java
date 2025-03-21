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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4402x;
import java.util.Map;

/* renamed from: com.xiaomi.push.dw */
/* loaded from: classes2.dex */
public class NotificationBuilderC4175dw extends AbstractNotificationBuilderC4176dx {

    /* renamed from: a */
    private int f15042a;

    /* renamed from: a */
    private PendingIntent f15043a;

    /* renamed from: b */
    private int f15044b;

    /* renamed from: b */
    private Bitmap f15045b;

    /* renamed from: c */
    private int f15046c;

    /* renamed from: c */
    private CharSequence f15047c;

    public NotificationBuilderC4175dw(Context context, int i2, String str) {
        super(context, i2, str);
        this.f15042a = 16777216;
        this.f15044b = 16777216;
        this.f15046c = 16777216;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    protected String mo14541a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    protected boolean mo14543a() {
        if (!C4300j.m15680a()) {
            return false;
        }
        Resources resources = m14548a().getResources();
        String packageName = m14548a().getPackageName();
        return (m14546a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || m14546a(resources, "title", "id", packageName) == 0 || m14546a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    /* renamed from: b */
    public NotificationBuilderC4175dw m14555b(String str) {
        if (m14576b() && !TextUtils.isEmpty(str)) {
            try {
                this.f15042a = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC4022b.m13347a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: b */
    protected String mo14545b() {
        return "notification_colorful_copy";
    }

    /* renamed from: c */
    public NotificationBuilderC4175dw m14556c(String str) {
        if (m14576b() && !TextUtils.isEmpty(str)) {
            try {
                this.f15046c = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC4022b.m13347a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    /* renamed from: a */
    public NotificationBuilderC4175dw m14554a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m14576b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f15047c = charSequence;
            this.f15043a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    public NotificationBuilderC4175dw mo14540a(String str) {
        if (m14576b() && !TextUtils.isEmpty(str)) {
            try {
                this.f15044b = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC4022b.m13347a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    public NotificationBuilderC4175dw setLargeIcon(Bitmap bitmap) {
        if (m14576b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f15045b = bitmap;
            } else {
                AbstractC4022b.m13347a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx, com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    public void mo14542a() {
        if (m14576b()) {
            super.mo14542a();
            Resources resources = m14548a().getResources();
            String packageName = m14548a().getPackageName();
            int m14546a = m14546a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (((AbstractNotificationBuilderC4176dx) this).f15049a == null) {
                m14571a(m14546a);
            } else {
                m14567a().setImageViewBitmap(m14546a, ((AbstractNotificationBuilderC4176dx) this).f15049a);
            }
            int m14546a2 = m14546a(resources, "title", "id", packageName);
            int m14546a3 = m14546a(resources, "content", "id", packageName);
            m14567a().setTextViewText(m14546a2, ((AbstractNotificationBuilderC4176dx) this).f15051a);
            m14567a().setTextViewText(m14546a3, ((AbstractNotificationBuilderC4176dx) this).f15057b);
            if (!TextUtils.isEmpty(this.f15047c)) {
                int m14546a4 = m14546a(resources, "buttonContainer", "id", packageName);
                int m14546a5 = m14546a(resources, "button", "id", packageName);
                int m14546a6 = m14546a(resources, "buttonBg", "id", packageName);
                m14567a().setViewVisibility(m14546a4, 0);
                m14567a().setTextViewText(m14546a5, this.f15047c);
                m14567a().setOnClickPendingIntent(m14546a4, this.f15043a);
                if (this.f15044b != 16777216) {
                    int m14565a = m14565a(70.0f);
                    int m14565a2 = m14565a(29.0f);
                    m14567a().setImageViewBitmap(m14546a6, C4402x.m16300a(m14552a(this.f15044b, m14565a, m14565a2, m14565a2 / 2.0f)));
                    m14567a().setTextColor(m14546a5, m14573a(this.f15044b) ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            int m14546a7 = m14546a(resources, "bg", "id", packageName);
            int m14546a8 = m14546a(resources, "container", "id", packageName);
            if (this.f15042a != 16777216) {
                if (C4300j.m15673a(m14548a()) >= 10) {
                    m14567a().setImageViewBitmap(m14546a7, C4402x.m16300a(m14552a(this.f15042a, 984, 192, 30.0f)));
                } else {
                    m14567a().setImageViewBitmap(m14546a7, C4402x.m16300a(m14552a(this.f15042a, 984, 192, 0.0f)));
                }
                m14553a(m14567a(), m14546a8, m14546a2, m14546a3, m14573a(this.f15042a));
            } else if (this.f15045b != null) {
                if (C4300j.m15673a(m14548a()) >= 10) {
                    m14567a().setImageViewBitmap(m14546a7, m14566a(this.f15045b, 30.0f));
                } else {
                    m14567a().setImageViewBitmap(m14546a7, this.f15045b);
                }
                Map<String, String> map = ((AbstractNotificationBuilderC4176dx) this).f15054a;
                if (map != null && this.f15046c == 16777216) {
                    m14556c(map.get("notification_image_text_color"));
                }
                int i2 = this.f15046c;
                m14553a(m14567a(), m14546a8, m14546a2, m14546a3, i2 == 16777216 || !m14573a(i2));
            } else if (Build.VERSION.SDK_INT >= 24) {
                m14567a().setViewVisibility(m14546a, 8);
                m14567a().setViewVisibility(m14546a7, 8);
                try {
                    C4094aw.m13822a((Object) this, "setStyle", C4309r.m15716a(m14548a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    AbstractC4022b.m13347a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m14567a());
            return;
        }
        m14575b();
    }

    /* renamed from: a */
    private void m14553a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        int m14565a = m14565a(6.0f);
        remoteViews.setViewPadding(i2, m14565a, 0, m14565a, 0);
        if (z) {
            remoteViews.setTextColor(i3, -1);
            remoteViews.setTextColor(i4, -1);
        } else {
            remoteViews.setTextColor(i3, ViewCompat.MEASURED_STATE_MASK);
            remoteViews.setTextColor(i4, ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* renamed from: a */
    private Drawable m14552a(int i2, int i3, int i4, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(i4);
        return shapeDrawable;
    }
}
