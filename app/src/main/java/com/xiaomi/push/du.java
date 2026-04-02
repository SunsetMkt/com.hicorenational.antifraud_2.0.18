package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class du extends dx {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f8912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f8913c;

    public du(Context context, String str) {
        super(context, str);
        this.a = 16777216;
    }

    @Override // com.xiaomi.push.dx, android.app.Notification.Builder
    /* JADX INFO: renamed from: a */
    public dx setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    protected String mo365a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected boolean mo359a() {
        if (!j.m624a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(a()) < 9) ? false : true;
    }

    public du b(Bitmap bitmap) {
        if (m368b() && bitmap != null) {
            this.f8913c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    protected String b() {
        return null;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public du setLargeIcon(Bitmap bitmap) {
        if (m368b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f8912b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m48a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public du mo360a(String str) {
        if (m368b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m48a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo358a() {
        if (m368b() && this.f8912b != null) {
            super.mo358a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "bg", "id", packageName);
            if (j.a(a()) >= 10) {
                m364a().setImageViewBitmap(iA, a(this.f8912b, 30.0f));
            } else {
                m364a().setImageViewBitmap(iA, this.f8912b);
            }
            int iA2 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (this.f8913c != null) {
                m364a().setImageViewBitmap(iA2, this.f8913c);
            } else {
                a(iA2);
            }
            int iA3 = a(resources, "title", "id", packageName);
            m364a().setTextViewText(iA3, ((dx) this).f409a);
            Map<String, String> map = ((dx) this).f412a;
            if (map != null && this.a == 16777216) {
                mo360a(map.get("notification_image_text_color"));
            }
            RemoteViews remoteViewsM364a = m364a();
            int i2 = this.a;
            remoteViewsM364a.setTextColor(iA3, (i2 == 16777216 || !m366a(i2)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            setCustomContentView(m364a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m367b();
    }
}
