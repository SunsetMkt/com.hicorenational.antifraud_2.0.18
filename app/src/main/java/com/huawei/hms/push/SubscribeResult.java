package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubscribeResult extends Result {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SubscribedItem> f4879b;

    public String getErrorMsg() {
        return this.a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f4879b;
    }

    public void setErrorMsg(String str) {
        this.a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f4879b = list;
    }
}
