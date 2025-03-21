package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.p162d.p163a.C2167d;

/* loaded from: classes.dex */
public class ChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<ChildrenInfo> CREATOR = new C2154a();

    /* renamed from: h */
    public static final String f6493h = "childrenUserId";

    /* renamed from: i */
    public static final String f6494i = "birthDate";

    /* renamed from: j */
    public static final String f6495j = "uniquelyNickname";

    /* renamed from: k */
    public static final String f6496k = "headPictureUrl";

    /* renamed from: l */
    public static final String f6497l = "accountname";

    /* renamed from: m */
    public static final String f6498m = "nickName";

    /* renamed from: n */
    public static final String f6499n = "loginUserName";

    /* renamed from: o */
    public static final String f6500o = "children";

    /* renamed from: p */
    public static final String f6501p = "childrenList";

    /* renamed from: a */
    private String f6502a;

    /* renamed from: b */
    private String f6503b;

    /* renamed from: c */
    private String f6504c;

    /* renamed from: d */
    private String f6505d;

    /* renamed from: e */
    private String f6506e;

    /* renamed from: f */
    private String f6507f;

    /* renamed from: g */
    private String f6508g;

    /* renamed from: com.hihonor.honorid.core.data.ChildrenInfo$a */
    class C2154a implements Parcelable.Creator<ChildrenInfo> {
        C2154a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChildrenInfo createFromParcel(Parcel parcel) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.f6502a = parcel.readString();
            childrenInfo.f6503b = parcel.readString();
            childrenInfo.f6504c = parcel.readString();
            childrenInfo.f6505d = parcel.readString();
            childrenInfo.f6506e = parcel.readString();
            childrenInfo.f6507f = parcel.readString();
            childrenInfo.f6508g = parcel.readString();
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
        return "{'childrenUserId':" + C2167d.m6309a(this.f6502a) + ",'birthDate':" + this.f6503b + ",'uniquelyNickname':" + this.f6504c + ",'headPictureUrl':" + C2167d.m6309a(this.f6506e) + ",'accountName':" + this.f6505d + this.f6507f + C2167d.m6309a(this.f6508g) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6502a);
        parcel.writeString(this.f6503b);
        parcel.writeString(this.f6504c);
        parcel.writeString(this.f6505d);
        parcel.writeString(this.f6506e);
        parcel.writeString(this.f6507f);
        parcel.writeString(this.f6508g);
    }
}
