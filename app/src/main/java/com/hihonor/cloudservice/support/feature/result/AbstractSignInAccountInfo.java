package com.hihonor.cloudservice.support.feature.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.heytap.mcssdk.constant.b;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSignInAccountInfo implements Parcelable {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<Scope> f4059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<Scope> f4063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4066j;

    public AbstractSignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        this.f4063g = new HashSet();
        this.a = str;
        this.f4058b = str2;
        this.f4059c = set;
        this.f4060d = str3;
        this.f4061e = str4;
        this.f4064h = str5;
    }

    public String a() {
        return this.f4066j;
    }

    public String b() {
        return this.f4060d;
    }

    public Set<Scope> c() {
        return this.f4059c;
    }

    public Uri d() {
        if (TextUtils.isEmpty(this.f4058b)) {
            this.f4058b = "";
        }
        return Uri.parse(this.f4058b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4058b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractSignInAccountInfo) {
            return c().equals(((AbstractSignInAccountInfo) obj).c());
        }
        return false;
    }

    public String f() {
        return this.f4062f;
    }

    public long g() {
        return this.f4065i;
    }

    public Set<Scope> h() {
        return this.f4063g;
    }

    public int hashCode() {
        return k().hashCode();
    }

    public String i() {
        return this.f4064h;
    }

    public String j() {
        return this.a;
    }

    public Set<Scope> k() {
        return new HashSet(this.f4063g);
    }

    public String l() {
        return this.f4061e;
    }

    public boolean m() {
        return this.f4065i > 300 && System.currentTimeMillis() / 1000 >= this.f4065i - 300;
    }

    public String n() {
        return o().toString();
    }

    public JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (j() != null) {
            jSONObject.put("openId", j());
        }
        if (e() != null) {
            jSONObject.put("photoUriString", e());
        }
        if (l() != null) {
            jSONObject.put("unionId", l());
        }
        if (f() != null) {
            jSONObject.put(NotificationCompat.CATEGORY_EMAIL, f());
        }
        if (b() != null) {
            jSONObject.put("serverAuthCode", b());
        }
        if (i() != null) {
            jSONObject.put("idToken", i());
        }
        if (a() != null) {
            jSONObject.put(b.u, a());
        }
        jSONObject.put("expirationTimeSecs", g());
        return a(b(jSONObject));
    }

    public String toString() {
        return "{displayName: photoUriString: " + this.f4058b + ",serviceCountryCode: countryCode: ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4058b);
        parcel.writeString(this.f4060d);
        parcel.writeList(new ArrayList(this.f4059c));
        parcel.writeString(this.f4061e);
        parcel.writeString(this.f4062f);
        parcel.writeString(this.f4064h);
        parcel.writeLong(this.f4065i);
        parcel.writeString(this.f4066j);
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (h() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : h()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.putOpt("extensionScopes", jSONArray);
        }
        return jSONObject;
    }

    public JSONObject b(JSONObject jSONObject) throws JSONException {
        if (c() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : c()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("grantedScopes", jSONArray);
        }
        return jSONObject;
    }

    public void c(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString("openId", null);
        this.f4058b = jSONObject.optString("photoUriString", null);
        this.f4060d = jSONObject.optString("serverAuthCode", null);
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        if (jSONArray != null) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.getJSONObject(i2).optString("mScopeUri", null);
                if (strOptString != null) {
                    hashSet.add(new Scope(strOptString));
                }
            }
            this.f4059c = hashSet;
        }
        this.f4061e = jSONObject.optString("unionId", null);
        this.f4062f = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null);
        this.f4064h = jSONObject.optString("idToken", null);
        this.f4065i = Long.parseLong(jSONObject.getString("expirationTimeSecs"));
        this.f4066j = jSONObject.optString(b.u, null);
    }

    public void d(String str) {
        this.f4064h = str;
    }

    public AbstractSignInAccountInfo(Parcel parcel) {
        this.f4063g = new HashSet();
        this.f4063g = new HashSet();
        a(parcel);
    }

    public void b(String str) {
        this.f4058b = str;
    }

    public void a(Parcel parcel) {
        this.a = parcel.readString();
        this.f4058b = parcel.readString();
        this.f4060d = parcel.readString();
        this.f4059c = new HashSet();
        this.f4061e = parcel.readString();
        this.f4062f = parcel.readString();
        this.f4064h = parcel.readString();
        this.f4065i = parcel.readLong();
        this.f4066j = parcel.readString();
    }

    public AbstractSignInAccountInfo() {
        this.f4063g = new HashSet();
    }

    public void c(String str) {
        this.f4062f = str;
    }

    public AbstractSignInAccountInfo a(List<Scope> list) {
        if (l.a.a.a.b.b(list)) {
            this.f4063g.addAll(list);
        }
        return this;
    }

    public void a(String str) {
        this.f4066j = str;
    }

    public void a(long j2) {
        this.f4065i = j2;
    }

    public void a(Set<Scope> set) {
        this.f4063g = set;
    }
}
