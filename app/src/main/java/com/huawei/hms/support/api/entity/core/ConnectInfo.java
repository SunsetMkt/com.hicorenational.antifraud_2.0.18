package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConnectInfo implements IMessageEntity {

    @Packed
    private List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f4930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Packed
    private String f4931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Packed
    private String f4932d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.a;
    }

    public String getFingerprint() {
        return this.f4931c;
    }

    public List<Scope> getScopeList() {
        return this.f4930b;
    }

    public String getSubAppID() {
        return this.f4932d;
    }

    public void setApiNameList(List<String> list) {
        this.a = list;
    }

    public void setFingerprint(String str) {
        this.f4931c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f4930b = list;
    }

    public void setSubAppID(String str) {
        this.f4932d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.a = list;
        this.f4930b = list2;
        this.f4931c = str;
        this.f4932d = str2;
    }
}
