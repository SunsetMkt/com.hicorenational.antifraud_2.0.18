package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: classes.dex */
public class SubscribeResult extends Result {

    /* renamed from: a */
    private String f7739a;

    /* renamed from: b */
    private List<SubscribedItem> f7740b;

    public String getErrorMsg() {
        return this.f7739a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f7740b;
    }

    public void setErrorMsg(String str) {
        this.f7739a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f7740b = list;
    }
}
