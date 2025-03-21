package com.hihonor.cloudservice.support.account.result;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p358k.p359a.p360a.p361a.C5848b;

/* loaded from: classes.dex */
public class SignInAccountInfo extends AbstractSignInAccountInfo {
    public static final Parcelable.Creator<SignInAccountInfo> CREATOR = new C2132a();

    /* renamed from: k */
    public int f6375k;

    /* renamed from: com.hihonor.cloudservice.support.account.result.SignInAccountInfo$a */
    class C2132a implements Parcelable.Creator<SignInAccountInfo> {
        C2132a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInAccountInfo createFromParcel(Parcel parcel) {
            return new SignInAccountInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInAccountInfo[] newArray(int i2) {
            return new SignInAccountInfo[i2];
        }
    }

    public SignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        super(str, str2, set, str3, str4, str5);
    }

    /* renamed from: a */
    public static SignInAccountInfo m5998a(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        return new SignInAccountInfo(str, str2, set, str3, str4, str5);
    }

    /* renamed from: d */
    public static SignInAccountInfo m5999d(JSONObject jSONObject) {
        SignInAccountInfo signInAccountInfo = new SignInAccountInfo();
        signInAccountInfo.mo6004c(jSONObject);
        return signInAccountInfo;
    }

    /* renamed from: e */
    public static SignInAccountInfo m6000e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new JSONException("invalid json format");
        }
        return m5999d(new JSONObject(str));
    }

    /* renamed from: r */
    public static SignInAccountInfo m6001r() {
        return m5998a(null, null, new HashSet(), null, null, null);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    /* renamed from: c */
    public void mo6004c(JSONObject jSONObject) {
        super.mo6004c(jSONObject);
        this.f6375k = jSONObject.optInt("accountFlag", 0);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SignInAccountInfo) {
            return m6048c().equals(((SignInAccountInfo) obj).m6048c());
        }
        return false;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public int hashCode() {
        return m6058k().hashCode();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    /* renamed from: o */
    public JSONObject mo6005o() {
        JSONObject jSONObject = new JSONObject();
        if (m6057j() != null) {
            jSONObject.put("openId", m6057j());
        }
        if (m6052e() != null) {
            jSONObject.put("photoUriString", m6052e());
        }
        if (m6045b() != null) {
            jSONObject.put("serverAuthCode", m6045b());
        }
        if (m6059l() != null) {
            jSONObject.put("unionId", m6059l());
        }
        if (m6053f() != null) {
            jSONObject.put(NotificationCompat.CATEGORY_EMAIL, m6053f());
        }
        if (m6056i() != null) {
            jSONObject.put("idToken", m6056i());
        }
        jSONObject.put("expirationTimeSecs", m6054g());
        jSONObject.put("accountFlag", m6007q());
        return m6041a(m6046b(jSONObject));
    }

    /* renamed from: p */
    public Account m6006p() {
        if (TextUtils.isEmpty(this.f6428f)) {
            return null;
        }
        return new Account(this.f6428f, "com.hihonor");
    }

    /* renamed from: q */
    public int m6007q() {
        return this.f6375k;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public String toString() {
        return "{photoUriString: " + this.f6424b + ",accountFlag" + this.f6375k + '}';
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f6375k);
    }

    public SignInAccountInfo(Parcel parcel) {
        mo6003a(parcel);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    /* renamed from: a */
    public void mo6003a(Parcel parcel) {
        super.mo6003a(parcel);
        this.f6375k = parcel.readInt();
    }

    public SignInAccountInfo() {
        this.f6425c = new HashSet();
        this.f6375k = 0;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    /* renamed from: a */
    public /* bridge */ /* synthetic */ AbstractSignInAccountInfo mo6002a(List list) {
        return mo6002a((List<Scope>) list);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    /* renamed from: a */
    public SignInAccountInfo mo6002a(List<Scope> list) {
        if (C5848b.m24626b(list)) {
            this.f6429g.addAll(list);
        }
        return this;
    }
}
