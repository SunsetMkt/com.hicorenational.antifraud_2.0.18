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
import org.json.JSONArray;
import org.json.JSONObject;
import p358k.p359a.p360a.p367c.p368a.C5868c;

/* loaded from: classes.dex */
public abstract class AbstractSignInOptions implements C5868c.a.InterfaceC7434a, Parcelable {

    /* renamed from: m */
    public static final PermissionInfo f6395m = new PermissionInfo().m6017a("com.hihonor.account.getUID");

    /* renamed from: n */
    public static final Scope f6396n = new Scope("profile");

    /* renamed from: o */
    public static final Scope f6397o = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: p */
    public static final Scope f6398p = new Scope("openid");

    /* renamed from: a */
    public final ArrayList<Scope> f6399a;

    /* renamed from: b */
    public ArrayList<PermissionInfo> f6400b;

    /* renamed from: c */
    protected String f6401c;

    /* renamed from: d */
    protected String f6402d;

    /* renamed from: e */
    protected String f6403e;

    /* renamed from: f */
    protected boolean f6404f;

    /* renamed from: g */
    protected boolean f6405g;

    /* renamed from: h */
    protected boolean f6406h;

    /* renamed from: i */
    protected boolean f6407i;

    /* renamed from: j */
    protected boolean f6408j;

    /* renamed from: k */
    protected String f6409k;

    /* renamed from: l */
    protected String f6410l;

    public AbstractSignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        this.f6401c = "";
        this.f6402d = "";
        this.f6403e = "";
        this.f6399a = arrayList;
        this.f6400b = arrayList2;
        this.f6401c = str;
        this.f6402d = str2;
        this.f6403e = str3;
        this.f6404f = z;
        this.f6405g = z2;
        this.f6406h = z3;
        this.f6407i = z4;
        this.f6408j = z5;
        this.f6409k = str4;
        this.f6410l = str5;
    }

    /* renamed from: a */
    public String m6022a() {
        return this.f6410l;
    }

    /* renamed from: b */
    public String m6026b() {
        return this.f6401c;
    }

    /* renamed from: c */
    public String m6027c() {
        return this.f6402d;
    }

    /* renamed from: d */
    public List<PermissionInfo> m6028d() {
        return this.f6400b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m6029e() {
        return this.f6403e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractSignInOptions)) {
            return false;
        }
        AbstractSignInOptions abstractSignInOptions = (AbstractSignInOptions) obj;
        return m6025a(this.f6399a, abstractSignInOptions.f6399a) && m6025a(this.f6400b, abstractSignInOptions.f6400b);
    }

    /* renamed from: f */
    public List<Scope> m6030f() {
        return this.f6399a;
    }

    /* renamed from: g */
    public Scope[] m6031g() {
        ArrayList<Scope> arrayList = this.f6399a;
        if (arrayList == null) {
            return null;
        }
        return (Scope[]) arrayList.toArray();
    }

    /* renamed from: h */
    public String m6032h() {
        return this.f6409k;
    }

    public int hashCode() {
        ArrayList<Scope> arrayList = this.f6399a;
        int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f6400b;
        return hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    /* renamed from: i */
    public boolean m6033i() {
        return this.f6404f;
    }

    /* renamed from: j */
    public boolean m6034j() {
        return this.f6405g;
    }

    /* renamed from: k */
    public boolean m6035k() {
        return this.f6406h;
    }

    /* renamed from: l */
    public boolean m6036l() {
        return this.f6408j;
    }

    /* renamed from: m */
    public boolean m6037m() {
        return this.f6407i;
    }

    /* renamed from: n */
    public String m6038n() {
        return m6039o().toString();
    }

    /* renamed from: o */
    public JSONObject m6039o() {
        new JSONObject();
        JSONObject jSONObject = new JSONObject();
        if (this.f6399a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Scope> it = this.f6399a.iterator();
            while (it.hasNext()) {
                jSONArray.put(m6024a(it.next()));
            }
            jSONObject.put("scopeArrayList", jSONArray);
        }
        if (this.f6400b != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<PermissionInfo> it2 = this.f6400b.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(m6023a(it2.next()));
            }
            jSONObject.put("permissionArrayList", jSONArray2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f6399a);
        parcel.writeList(this.f6400b);
    }

    /* renamed from: b */
    public static Scope m6021b(JSONObject jSONObject) {
        return new Scope(jSONObject.optString("mScopeUri", null));
    }

    /* renamed from: a */
    public <T> boolean m6025a(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        return arrayList.containsAll(arrayList2);
    }

    /* renamed from: a */
    public static PermissionInfo m6020a(JSONObject jSONObject) {
        return new PermissionInfo().m6017a(jSONObject.optString(AttributionReporter.SYSTEM_PERMISSION, null));
    }

    /* renamed from: a */
    public JSONObject m6023a(PermissionInfo permissionInfo) {
        JSONObject jSONObject = new JSONObject();
        if (permissionInfo.m6018a() != null) {
            jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, permissionInfo.m6018a());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public JSONObject m6024a(Scope scope) {
        JSONObject jSONObject = new JSONObject();
        if (scope.m6019a() != null) {
            jSONObject.put("mScopeUri", scope.m6019a());
        }
        return jSONObject;
    }

    public AbstractSignInOptions(Parcel parcel) {
        this.f6401c = "";
        this.f6402d = "";
        this.f6403e = "";
        this.f6399a = parcel.createTypedArrayList(Scope.CREATOR);
        this.f6400b = parcel.createTypedArrayList(PermissionInfo.CREATOR);
    }
}
