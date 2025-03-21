package com.hihonor.cloudservice.support.feature.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.heytap.mcssdk.constant.C2085b;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p358k.p359a.p360a.p361a.C5848b;

/* loaded from: classes.dex */
public abstract class AbstractSignInAccountInfo implements Parcelable {

    /* renamed from: a */
    public String f6423a;

    /* renamed from: b */
    public String f6424b;

    /* renamed from: c */
    public Set<Scope> f6425c;

    /* renamed from: d */
    public String f6426d;

    /* renamed from: e */
    public String f6427e;

    /* renamed from: f */
    public String f6428f;

    /* renamed from: g */
    public Set<Scope> f6429g;

    /* renamed from: h */
    public String f6430h;

    /* renamed from: i */
    public long f6431i;

    /* renamed from: j */
    public String f6432j;

    public AbstractSignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        this.f6429g = new HashSet();
        this.f6423a = str;
        this.f6424b = str2;
        this.f6425c = set;
        this.f6426d = str3;
        this.f6427e = str4;
        this.f6430h = str5;
    }

    /* renamed from: a */
    public String m6040a() {
        return this.f6432j;
    }

    /* renamed from: b */
    public String m6045b() {
        return this.f6426d;
    }

    /* renamed from: c */
    public Set<Scope> m6048c() {
        return this.f6425c;
    }

    /* renamed from: d */
    public Uri m6050d() {
        if (TextUtils.isEmpty(this.f6424b)) {
            this.f6424b = "";
        }
        return Uri.parse(this.f6424b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m6052e() {
        return this.f6424b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractSignInAccountInfo) {
            return m6048c().equals(((AbstractSignInAccountInfo) obj).m6048c());
        }
        return false;
    }

    /* renamed from: f */
    public String m6053f() {
        return this.f6428f;
    }

    /* renamed from: g */
    public long m6054g() {
        return this.f6431i;
    }

    /* renamed from: h */
    public Set<Scope> m6055h() {
        return this.f6429g;
    }

    public int hashCode() {
        return m6058k().hashCode();
    }

    /* renamed from: i */
    public String m6056i() {
        return this.f6430h;
    }

    /* renamed from: j */
    public String m6057j() {
        return this.f6423a;
    }

    /* renamed from: k */
    public Set<Scope> m6058k() {
        return new HashSet(this.f6429g);
    }

    /* renamed from: l */
    public String m6059l() {
        return this.f6427e;
    }

    /* renamed from: m */
    public boolean m6060m() {
        return this.f6431i > 300 && System.currentTimeMillis() / 1000 >= this.f6431i - 300;
    }

    /* renamed from: n */
    public String m6061n() {
        return mo6005o().toString();
    }

    /* renamed from: o */
    public JSONObject mo6005o() {
        JSONObject jSONObject = new JSONObject();
        if (m6057j() != null) {
            jSONObject.put("openId", m6057j());
        }
        if (m6052e() != null) {
            jSONObject.put("photoUriString", m6052e());
        }
        if (m6059l() != null) {
            jSONObject.put("unionId", m6059l());
        }
        if (m6053f() != null) {
            jSONObject.put(NotificationCompat.CATEGORY_EMAIL, m6053f());
        }
        if (m6045b() != null) {
            jSONObject.put("serverAuthCode", m6045b());
        }
        if (m6056i() != null) {
            jSONObject.put("idToken", m6056i());
        }
        if (m6040a() != null) {
            jSONObject.put(C2085b.f6180u, m6040a());
        }
        jSONObject.put("expirationTimeSecs", m6054g());
        return m6041a(m6046b(jSONObject));
    }

    public String toString() {
        return "{displayName: photoUriString: " + this.f6424b + ",serviceCountryCode: countryCode: ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6423a);
        parcel.writeString(this.f6424b);
        parcel.writeString(this.f6426d);
        parcel.writeList(new ArrayList(this.f6425c));
        parcel.writeString(this.f6427e);
        parcel.writeString(this.f6428f);
        parcel.writeString(this.f6430h);
        parcel.writeLong(this.f6431i);
        parcel.writeString(this.f6432j);
    }

    /* renamed from: a */
    public JSONObject m6041a(JSONObject jSONObject) {
        if (m6055h() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : m6055h()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.m6019a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.putOpt("extensionScopes", jSONArray);
        }
        return jSONObject;
    }

    /* renamed from: b */
    public JSONObject m6046b(JSONObject jSONObject) {
        if (m6048c() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : m6048c()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.m6019a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("grantedScopes", jSONArray);
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo6004c(JSONObject jSONObject) {
        this.f6423a = jSONObject.optString("openId", null);
        this.f6424b = jSONObject.optString("photoUriString", null);
        this.f6426d = jSONObject.optString("serverAuthCode", null);
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        if (jSONArray != null) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.getJSONObject(i2).optString("mScopeUri", null);
                if (optString != null) {
                    hashSet.add(new Scope(optString));
                }
            }
            this.f6425c = hashSet;
        }
        this.f6427e = jSONObject.optString("unionId", null);
        this.f6428f = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null);
        this.f6430h = jSONObject.optString("idToken", null);
        this.f6431i = Long.parseLong(jSONObject.getString("expirationTimeSecs"));
        this.f6432j = jSONObject.optString(C2085b.f6180u, null);
    }

    /* renamed from: d */
    public void m6051d(String str) {
        this.f6430h = str;
    }

    public AbstractSignInAccountInfo(Parcel parcel) {
        this.f6429g = new HashSet();
        this.f6429g = new HashSet();
        mo6003a(parcel);
    }

    /* renamed from: b */
    public void m6047b(String str) {
        this.f6424b = str;
    }

    /* renamed from: a */
    public void mo6003a(Parcel parcel) {
        this.f6423a = parcel.readString();
        this.f6424b = parcel.readString();
        this.f6426d = parcel.readString();
        this.f6425c = new HashSet();
        this.f6427e = parcel.readString();
        this.f6428f = parcel.readString();
        this.f6430h = parcel.readString();
        this.f6431i = parcel.readLong();
        this.f6432j = parcel.readString();
    }

    public AbstractSignInAccountInfo() {
        this.f6429g = new HashSet();
    }

    /* renamed from: c */
    public void m6049c(String str) {
        this.f6428f = str;
    }

    /* renamed from: a */
    public AbstractSignInAccountInfo mo6002a(List<Scope> list) {
        if (C5848b.m24626b(list)) {
            this.f6429g.addAll(list);
        }
        return this;
    }

    /* renamed from: a */
    public void m6043a(String str) {
        this.f6432j = str;
    }

    /* renamed from: a */
    public void m6042a(long j2) {
        this.f6431i = j2;
    }

    /* renamed from: a */
    public void m6044a(Set<Scope> set) {
        this.f6429g = set;
    }
}
