package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.d.a.d;

/* JADX INFO: loaded from: classes.dex */
public class ChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<ChildrenInfo> CREATOR = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4101h = "childrenUserId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4102i = "birthDate";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4103j = "uniquelyNickname";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4104k = "headPictureUrl";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4105l = "accountname";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4106m = "nickName";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4107n = "loginUserName";
    public static final String o = "children";
    public static final String p = "childrenList";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4113g;

    class a implements Parcelable.Creator<ChildrenInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChildrenInfo createFromParcel(Parcel parcel) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.a = parcel.readString();
            childrenInfo.f4108b = parcel.readString();
            childrenInfo.f4109c = parcel.readString();
            childrenInfo.f4110d = parcel.readString();
            childrenInfo.f4111e = parcel.readString();
            childrenInfo.f4112f = parcel.readString();
            childrenInfo.f4113g = parcel.readString();
            return childrenInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChildrenInfo[] newArray(int i2) {
            return new ChildrenInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{'childrenUserId':" + d.a(this.a) + ",'birthDate':" + this.f4108b + ",'uniquelyNickname':" + this.f4109c + ",'headPictureUrl':" + d.a(this.f4111e) + ",'accountName':" + this.f4110d + this.f4112f + d.a(this.f4113g) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4108b);
        parcel.writeString(this.f4109c);
        parcel.writeString(this.f4110d);
        parcel.writeString(this.f4111e);
        parcel.writeString(this.f4112f);
        parcel.writeString(this.f4113g);
    }
}
