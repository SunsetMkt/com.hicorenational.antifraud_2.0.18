package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* renamed from: com.vivo.push.util.m */
/* loaded from: classes2.dex */
public final class C4002m implements BaseNotifyLayoutAdapter {

    /* renamed from: a */
    private Resources f14258a;

    /* renamed from: b */
    private String f14259b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f14258a.getIdentifier("push_notify", "layout", this.f14259b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (C4003n.f14263d) {
            resources = this.f14258a;
            str = this.f14259b;
            str2 = "notify_icon_rom30";
        } else if (C4003n.f14262c) {
            resources = this.f14258a;
            str = this.f14259b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f14258a;
            str = this.f14259b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i2;
        try {
            i2 = ((Integer) C3990ag.m13210a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            return this.f14258a.getColor(i2);
        }
        if (C4003n.f14263d) {
            return -1;
        }
        if (!C4003n.f14262c) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (C4003n.f14263d) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f14259b = context.getPackageName();
        this.f14258a = context.getResources();
    }
}
