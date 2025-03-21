package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.Map;

@SuppressLint({"NewApi"})
/* renamed from: com.xiaomi.push.dv */
/* loaded from: classes2.dex */
public class NotificationBuilderC4174dv extends Notification.Builder {

    /* renamed from: a */
    private Context f15041a;

    public NotificationBuilderC4174dv(Context context) {
        super(context);
        this.f15041a = context;
    }

    /* renamed from: a */
    protected Context m14548a() {
        return this.f15041a;
    }

    /* renamed from: a */
    public NotificationBuilderC4174dv mo14551a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a */
    protected void mo14542a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo14542a();
        return super.build();
    }

    /* renamed from: a */
    public int m14546a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    /* renamed from: a */
    public final int m14547a(String str) {
        return m14546a(m14548a().getResources(), str, "id", m14548a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationBuilderC4174dv addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationBuilderC4174dv setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a */
    public NotificationBuilderC4174dv mo14540a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                C4094aw.m13822a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e2) {
                AbstractC4022b.m13361d("fail to set color. " + e2);
            }
        }
        return this;
    }
}
