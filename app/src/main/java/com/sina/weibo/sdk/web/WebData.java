package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

/* loaded from: classes.dex */
public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new Parcelable.Creator<WebData>() { // from class: com.sina.weibo.sdk.web.WebData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebData createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebData[] newArray(int i2) {
            return new WebData[i2];
        }
    };
    private static final long serialVersionUID = -4038177938155795889L;

    /* renamed from: av */
    protected AuthInfo f9351av;

    /* renamed from: aw */
    protected String f9352aw;

    /* renamed from: i */
    protected String f9353i;
    protected int type;

    public WebData(AuthInfo authInfo, int i2, String str, String str2) {
        this.f9351av = authInfo;
        this.type = i2;
        this.f9353i = str;
        this.f9352aw = str2;
    }

    /* renamed from: a */
    public final AuthInfo m8891a() {
        return this.f9351av;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.f9353i;
    }

    /* renamed from: r */
    public final String m8892r() {
        return this.f9352aw;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f9351av, i2);
        parcel.writeInt(this.type);
        parcel.writeString(this.f9353i);
        parcel.writeString(this.f9352aw);
    }

    protected WebData(Parcel parcel) {
        this.f9351av = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.f9353i = parcel.readString();
        this.f9352aw = parcel.readString();
    }
}
