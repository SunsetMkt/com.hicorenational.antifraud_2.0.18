package com.hihonor.cloudservice.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.huawei.hms.push.AttributionReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.a.a.c.a.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSignInOptions implements c.a.InterfaceC0267a, Parcelable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final PermissionInfo f4034m = new PermissionInfo().a("com.hihonor.account.getUID");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Scope f4035n = new Scope("profile");
    public static final Scope o = new Scope(NotificationCompat.CATEGORY_EMAIL);
    public static final Scope p = new Scope("openid");
    public final ArrayList<Scope> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<PermissionInfo> f4036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f4037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f4038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f4039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f4040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f4041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f4042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f4043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f4044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f4045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f4046l;

    public AbstractSignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        this.f4037c = "";
        this.f4038d = "";
        this.f4039e = "";
        this.a = arrayList;
        this.f4036b = arrayList2;
        this.f4037c = str;
        this.f4038d = str2;
        this.f4039e = str3;
        this.f4040f = z;
        this.f4041g = z2;
        this.f4042h = z3;
        this.f4043i = z4;
        this.f4044j = z5;
        this.f4045k = str4;
        this.f4046l = str5;
    }

    public String a() {
        return this.f4046l;
    }

    public String b() {
        return this.f4037c;
    }

    public String c() {
        return this.f4038d;
    }

    public List<PermissionInfo> d() {
        return this.f4036b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4039e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractSignInOptions)) {
            return false;
        }
        AbstractSignInOptions abstractSignInOptions = (AbstractSignInOptions) obj;
        return a(this.a, abstractSignInOptions.a) && a(this.f4036b, abstractSignInOptions.f4036b);
    }

    public List<Scope> f() {
        return this.a;
    }

    public Scope[] g() {
        ArrayList<Scope> arrayList = this.a;
        if (arrayList == null) {
            return null;
        }
        return (Scope[]) arrayList.toArray();
    }

    public String h() {
        return this.f4045k;
    }

    public int hashCode() {
        ArrayList<Scope> arrayList = this.a;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f4036b;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public boolean i() {
        return this.f4040f;
    }

    public boolean j() {
        return this.f4041g;
    }

    public boolean k() {
        return this.f4042h;
    }

    public boolean l() {
        return this.f4044j;
    }

    public boolean m() {
        return this.f4043i;
    }

    public String n() {
        return o().toString();
    }

    public JSONObject o() throws JSONException {
        new JSONObject();
        JSONObject jSONObject = new JSONObject();
        if (this.a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Scope> it = this.a.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            jSONObject.put("scopeArrayList", jSONArray);
        }
        if (this.f4036b != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<PermissionInfo> it2 = this.f4036b.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(a(it2.next()));
            }
            jSONObject.put("permissionArrayList", jSONArray2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.a);
        parcel.writeList(this.f4036b);
    }

    public static Scope b(JSONObject jSONObject) {
        return new Scope(jSONObject.optString("mScopeUri", null));
    }

    public <T> boolean a(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        return arrayList.containsAll(arrayList2);
    }

    public static PermissionInfo a(JSONObject jSONObject) {
        return new PermissionInfo().a(jSONObject.optString(AttributionReporter.SYSTEM_PERMISSION, null));
    }

    public JSONObject a(PermissionInfo permissionInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (permissionInfo.a() != null) {
            jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, permissionInfo.a());
        }
        return jSONObject;
    }

    public JSONObject a(Scope scope) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (scope.a() != null) {
            jSONObject.put("mScopeUri", scope.a());
        }
        return jSONObject;
    }

    public AbstractSignInOptions(Parcel parcel) {
        this.f4037c = "";
        this.f4038d = "";
        this.f4039e = "";
        this.a = parcel.createTypedArrayList(Scope.CREATOR);
        this.f4036b = parcel.createTypedArrayList(PermissionInfo.CREATOR);
    }
}
