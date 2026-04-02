package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ClientSettings {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Scope> f4552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f4554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SubAppInfo f4556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f4557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4560k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.a = str;
        this.f4551b = str2;
        this.f4552c = list;
        this.f4553d = str3;
        this.f4554e = list2;
    }

    public List<String> getApiName() {
        return this.f4554e;
    }

    public String getAppID() {
        return this.f4553d;
    }

    public String getClientClassName() {
        return this.f4551b;
    }

    public String getClientPackageName() {
        return this.a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f4557h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f4555f;
    }

    public String getInnerHmsPkg() {
        return this.f4559j;
    }

    public List<Scope> getScopes() {
        return this.f4552c;
    }

    public SubAppInfo getSubAppID() {
        return this.f4556g;
    }

    public boolean isHasActivity() {
        return this.f4558i;
    }

    public boolean isUseInnerHms() {
        return this.f4560k;
    }

    public void setApiName(List<String> list) {
        this.f4554e = list;
    }

    public void setAppID(String str) {
        this.f4553d = str;
    }

    public void setClientClassName(String str) {
        this.f4551b = str;
    }

    public void setClientPackageName(String str) {
        this.a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f4557h = new WeakReference<>(activity);
        this.f4558i = true;
    }

    public void setCpID(String str) {
        this.f4555f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f4559j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f4552c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f4556g = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.f4560k = z;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f4556g = subAppInfo;
    }
}
