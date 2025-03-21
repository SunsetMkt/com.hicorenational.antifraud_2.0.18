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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.Map;

/* renamed from: com.xiaomi.push.du */
/* loaded from: classes2.dex */
public class NotificationBuilderC4173du extends AbstractNotificationBuilderC4176dx {

    /* renamed from: a */
    private int f15038a;

    /* renamed from: b */
    private Bitmap f15039b;

    /* renamed from: c */
    private Bitmap f15040c;

    public NotificationBuilderC4173du(Context context, String str) {
        super(context, str);
        this.f15038a = 16777216;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx, android.app.Notification.Builder
    /* renamed from: a */
    public AbstractNotificationBuilderC4176dx setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    protected String mo14541a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    protected boolean mo14543a() {
        if (!C4300j.m15680a()) {
            return false;
        }
        Resources resources = m14548a().getResources();
        String packageName = m14548a().getPackageName();
        return (m14546a(m14548a().getResources(), "bg", "id", m14548a().getPackageName()) == 0 || m14546a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || m14546a(resources, "title", "id", packageName) == 0 || C4300j.m15673a(m14548a()) < 9) ? false : true;
    }

    /* renamed from: b */
    public NotificationBuilderC4173du m14544b(Bitmap bitmap) {
        if (m14576b() && bitmap != null) {
            this.f15040c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: b */
    protected String mo14545b() {
        return null;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx
    /* renamed from: a */
    public NotificationBuilderC4173du setLargeIcon(Bitmap bitmap) {
        if (m14576b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f15039b = bitmap;
            } else {
                AbstractC4022b.m13347a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    public NotificationBuilderC4173du mo14540a(String str) {
        if (m14576b() && !TextUtils.isEmpty(str)) {
            try {
                this.f15038a = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC4022b.m13347a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC4176dx, com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    public void mo14542a() {
        if (m14576b() && this.f15039b != null) {
            super.mo14542a();
            Resources resources = m14548a().getResources();
            String packageName = m14548a().getPackageName();
            int m14546a = m14546a(resources, "bg", "id", packageName);
            if (C4300j.m15673a(m14548a()) >= 10) {
                m14567a().setImageViewBitmap(m14546a, m14566a(this.f15039b, 30.0f));
            } else {
                m14567a().setImageViewBitmap(m14546a, this.f15039b);
            }
            int m14546a2 = m14546a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (this.f15040c != null) {
                m14567a().setImageViewBitmap(m14546a2, this.f15040c);
            } else {
                m14571a(m14546a2);
            }
            int m14546a3 = m14546a(resources, "title", "id", packageName);
            m14567a().setTextViewText(m14546a3, ((AbstractNotificationBuilderC4176dx) this).f15051a);
            Map<String, String> map = ((AbstractNotificationBuilderC4176dx) this).f15054a;
            if (map != null && this.f15038a == 16777216) {
                mo14540a(map.get("notification_image_text_color"));
            }
            RemoteViews m14567a = m14567a();
            int i2 = this.f15038a;
            m14567a.setTextColor(m14546a3, (i2 == 16777216 || !m14573a(i2)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            setCustomContentView(m14567a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m14575b();
    }
}
