package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: classes.dex */
public class Scope implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C2518a();
    private String mScopeUri;

    /* renamed from: com.huawei.hms.support.api.entity.auth.Scope$a */
    class C2518a implements Parcelable.Creator<Scope> {
        C2518a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scope[] newArray(int i2) {
            return new Scope[i2];
        }
    }

    public Scope() {
        this.mScopeUri = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return Objects.equal(this.mScopeUri, ((Scope) obj).mScopeUri);
        }
        return false;
    }

    @Deprecated
    public boolean equeals(Object obj) {
        return equals(obj);
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public final int hashCode() {
        String str = this.mScopeUri;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.mScopeUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mScopeUri);
    }

    public Scope(String str) {
        this.mScopeUri = str;
    }

    protected Scope(Parcel parcel) {
        this.mScopeUri = parcel.readString();
    }
}
