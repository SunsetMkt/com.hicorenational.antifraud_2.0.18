package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes.dex */
public class OaidResp extends AbstractMessageEntity {

    /* renamed from: id */
    @Packed
    private String f7849id;

    @Packed
    private boolean isTrackLimited;

    @Packed
    private PendingIntent settingIntent;

    public String getId() {
        return this.f7849id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String str) {
        this.f7849id = str;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z) {
        this.isTrackLimited = z;
    }
}
