package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: DefaultNotifyLayoutAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements BaseNotifyLayoutAdapter {
    private Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8678b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.f8678b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (n.f8681d) {
            resources = this.a;
            str = this.f8678b;
            str2 = "notify_icon_rom30";
        } else if (n.f8680c) {
            resources = this.a;
            str = this.f8678b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = this.f8678b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int iIntValue;
        try {
            iIntValue = ((Integer) ag.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return this.a.getColor(iIntValue);
        }
        if (n.f8681d) {
            return -1;
        }
        if (!n.f8680c) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (n.f8681d) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f8678b = context.getPackageName();
        this.a = context.getResources();
    }
}
