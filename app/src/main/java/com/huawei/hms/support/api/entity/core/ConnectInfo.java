package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: classes.dex */
public class ConnectInfo implements IMessageEntity {

    /* renamed from: a */
    @Packed
    private List<String> f7845a;

    /* renamed from: b */
    @Packed
    private List<Scope> f7846b;

    /* renamed from: c */
    @Packed
    private String f7847c;

    /* renamed from: d */
    @Packed
    private String f7848d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f7845a;
    }

    public String getFingerprint() {
        return this.f7847c;
    }

    public List<Scope> getScopeList() {
        return this.f7846b;
    }

    public String getSubAppID() {
        return this.f7848d;
    }

    public void setApiNameList(List<String> list) {
        this.f7845a = list;
    }

    public void setFingerprint(String str) {
        this.f7847c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f7846b = list;
    }

    public void setSubAppID(String str) {
        this.f7848d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f7845a = list;
        this.f7846b = list2;
        this.f7847c = str;
        this.f7848d = str2;
    }
}
