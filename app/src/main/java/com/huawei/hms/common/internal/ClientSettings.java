package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class ClientSettings {

    /* renamed from: a */
    private String f7266a;

    /* renamed from: b */
    private String f7267b;

    /* renamed from: c */
    private List<Scope> f7268c;

    /* renamed from: d */
    private String f7269d;

    /* renamed from: e */
    private List<String> f7270e;

    /* renamed from: f */
    private String f7271f;

    /* renamed from: g */
    private SubAppInfo f7272g;

    /* renamed from: h */
    private WeakReference<Activity> f7273h;

    /* renamed from: i */
    private boolean f7274i;

    /* renamed from: j */
    private String f7275j;

    /* renamed from: k */
    private boolean f7276k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f7266a = str;
        this.f7267b = str2;
        this.f7268c = list;
        this.f7269d = str3;
        this.f7270e = list2;
    }

    public List<String> getApiName() {
        return this.f7270e;
    }

    public String getAppID() {
        return this.f7269d;
    }

    public String getClientClassName() {
        return this.f7267b;
    }

    public String getClientPackageName() {
        return this.f7266a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f7273h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f7271f;
    }

    public String getInnerHmsPkg() {
        return this.f7275j;
    }

    public List<Scope> getScopes() {
        return this.f7268c;
    }

    public SubAppInfo getSubAppID() {
        return this.f7272g;
    }

    public boolean isHasActivity() {
        return this.f7274i;
    }

    public boolean isUseInnerHms() {
        return this.f7276k;
    }

    public void setApiName(List<String> list) {
        this.f7270e = list;
    }

    public void setAppID(String str) {
        this.f7269d = str;
    }

    public void setClientClassName(String str) {
        this.f7267b = str;
    }

    public void setClientPackageName(String str) {
        this.f7266a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f7273h = new WeakReference<>(activity);
        this.f7274i = true;
    }

    public void setCpID(String str) {
        this.f7271f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f7275j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f7268c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f7272g = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.f7276k = z;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f7272g = subAppInfo;
    }
}
