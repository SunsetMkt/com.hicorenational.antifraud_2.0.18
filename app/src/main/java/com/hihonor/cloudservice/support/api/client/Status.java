package com.hihonor.cloudservice.support.api.client;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends com.hihonor.cloudservice.support.api.client.a implements Parcelable {

    /* JADX INFO: renamed from: b */
    private PendingIntent f4028b;

    /* JADX INFO: renamed from: c */
    private Intent f4029c;

    /* JADX INFO: renamed from: d */
    private int f4030d;

    /* JADX INFO: renamed from: e */
    private String f4031e;

    /* JADX INFO: renamed from: f */
    public static final Status f4019f = new Status(0);

    /* JADX INFO: renamed from: g */
    public static final Status f4020g = new Status(1);

    /* JADX INFO: renamed from: h */
    @Deprecated
    public static final Status f4021h = new Status(16);

    /* JADX INFO: renamed from: i */
    @Deprecated
    public static final Status f4022i = new Status(18);

    /* JADX INFO: renamed from: j */
    @Deprecated
    public static final Status f4023j = new Status(8);

    /* JADX INFO: renamed from: k */
    @Deprecated
    public static final Status f4024k = new Status(14);

    /* JADX INFO: renamed from: l */
    @Deprecated
    public static final Status f4025l = new Status(15);

    /* JADX INFO: renamed from: m */
    public static final Status f4026m = new Status(TinkerReport.KEY_LOADED_SUCC_COST_OTHER);

    /* JADX INFO: renamed from: n */
    public static final Status f4027n = new Status(500);
    public static final Parcelable.Creator<Status> CREATOR = new a();

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public Status[] newArray(int i2) {
            return new Status[i2];
        }
    }

    public Status(int i2) {
        this(i2, null);
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // com.hihonor.cloudservice.support.api.client.a
    public Status a() {
        return this;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(": ");
        sb.append(d() != null ? d() : "");
        return sb.toString();
    }

    public int c() {
        return this.f4030d;
    }

    public String d() {
        return this.f4031e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f4030d <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4030d == status.f4030d && a(this.f4031e, status.f4031e) && a(this.f4028b, status.f4028b);
    }

    public int hashCode() {
        Object[] objArr = new Object[3];
        Object[] objArr2 = new Object[0];
        objArr2[0] = Integer.valueOf(this.f4030d);
        objArr2[1] = this.f4031e;
        objArr[2] = this.f4028b;
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return "{statusCode: " + this.f4030d + ", statusMessage: " + this.f4031e + ", pendingIntent: " + this.f4028b + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4030d);
        parcel.writeString(this.f4031e);
        PendingIntent pendingIntent = this.f4028b;
        if (pendingIntent != null) {
            pendingIntent.writeToParcel(parcel, i2);
        }
        PendingIntent.writePendingIntentOrNullToParcel(this.f4028b, parcel);
        if (this.f4029c != null) {
            writeToParcel(parcel, i2);
        }
    }

    public Status(int i2, String str) {
        this.f4030d = i2;
        this.f4031e = str;
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this.f4030d = i2;
        this.f4031e = str;
        this.f4028b = pendingIntent;
    }
}
