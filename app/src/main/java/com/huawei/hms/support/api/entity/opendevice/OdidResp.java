package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes.dex */
public class OdidResp extends AbstractMessageEntity {

    /* renamed from: id */
    @Packed
    private String f7850id;

    public String getId() {
        return this.f7850id;
    }

    public void setId(String str) {
        this.f7850id = str;
    }
}
