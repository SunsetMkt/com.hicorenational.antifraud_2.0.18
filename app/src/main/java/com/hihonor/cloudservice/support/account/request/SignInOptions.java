package com.hihonor.cloudservice.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public class SignInOptions extends AbstractSignInOptions {

    /* renamed from: q */
    public static final SignInOptions f6374q = new C2131a().m5989c().m5992d().m5981a();
    public static final Parcelable.Creator<SignInOptions> CREATOR = new C2130a();

    /* renamed from: com.hihonor.cloudservice.support.account.request.SignInOptions$a */
    class C2130a implements Parcelable.Creator<SignInOptions> {
        C2130a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInOptions createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInOptions[] newArray(int i2) {
            return new SignInOptions[i2];
        }
    }

    public SignInOptions(Set<Scope> set, Set<PermissionInfo> set2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2), str, str2, str3, z, z2, z3, z4, z5, str4, str5);
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        return m6025a(this.f6399a, signInOptions.f6399a) && m6025a(this.f6400b, signInOptions.f6400b);
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public int hashCode() {
        ArrayList<Scope> arrayList = this.f6399a;
        int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f6400b;
        return hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public SignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        super(arrayList, arrayList2, str, str2, str3, z, z2, z3, z4, z5, str4, str5);
    }
}
