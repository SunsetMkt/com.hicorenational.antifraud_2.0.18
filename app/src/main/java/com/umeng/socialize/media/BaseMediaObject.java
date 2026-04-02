package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMediaObject implements UMediaObject {
    protected String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f8272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Map<String, Object> f8273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f8274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected UMImage f8275e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.a = "";
        this.f8272b = "";
        this.f8273c = new HashMap();
        this.f8274d = "";
    }

    public String getDescription() {
        return this.f8274d;
    }

    public UMImage getThumbImage() {
        return this.f8275e;
    }

    public String getTitle() {
        return this.f8272b;
    }

    public Map<String, Object> getmExtra() {
        return this.f8273c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.a);
    }

    public void setDescription(String str) {
        this.f8274d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f8275e = uMImage;
    }

    public void setTitle(String str) {
        this.f8272b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f8273c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.a + ", qzone_title=" + this.f8272b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.a = "";
        this.f8272b = "";
        this.f8273c = new HashMap();
        this.f8274d = "";
        this.a = str;
    }

    protected BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.a = "";
        this.f8272b = "";
        this.f8273c = new HashMap();
        this.f8274d = "";
        if (parcel != null) {
            this.a = parcel.readString();
            this.f8272b = parcel.readString();
        }
    }
}
