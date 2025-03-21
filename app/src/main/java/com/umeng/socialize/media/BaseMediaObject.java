package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* renamed from: a */
    protected String f13632a;

    /* renamed from: b */
    protected String f13633b;

    /* renamed from: c */
    protected Map<String, Object> f13634c;

    /* renamed from: d */
    protected String f13635d;

    /* renamed from: e */
    protected UMImage f13636e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f13632a = "";
        this.f13633b = "";
        this.f13634c = new HashMap();
        this.f13635d = "";
    }

    public String getDescription() {
        return this.f13635d;
    }

    public UMImage getThumbImage() {
        return this.f13636e;
    }

    public String getTitle() {
        return this.f13633b;
    }

    public Map<String, Object> getmExtra() {
        return this.f13634c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f13632a);
    }

    public void setDescription(String str) {
        this.f13635d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f13636e = uMImage;
    }

    public void setTitle(String str) {
        this.f13633b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f13634c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f13632a + ", qzone_title=" + this.f13633b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f13632a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f13632a = "";
        this.f13633b = "";
        this.f13634c = new HashMap();
        this.f13635d = "";
        this.f13632a = str;
    }

    protected BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f13632a = "";
        this.f13633b = "";
        this.f13634c = new HashMap();
        this.f13635d = "";
        if (parcel != null) {
            this.f13632a = parcel.readString();
            this.f13633b = parcel.readString();
        }
    }
}
