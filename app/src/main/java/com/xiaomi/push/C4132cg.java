package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3393cw;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4375b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cg */
/* loaded from: classes2.dex */
public class C4132cg {

    /* renamed from: a */
    protected static Context f14719a;

    /* renamed from: a */
    private static a f14720a;

    /* renamed from: a */
    private static C4132cg f14721a;

    /* renamed from: c */
    private static String f14724c;

    /* renamed from: d */
    private static String f14725d;

    /* renamed from: a */
    private long f14726a;

    /* renamed from: a */
    private InterfaceC4131cf f14727a;

    /* renamed from: a */
    protected b f14728a;

    /* renamed from: a */
    private String f14729a;

    /* renamed from: a */
    protected final Map<String, C4129cd> f14730a;

    /* renamed from: b */
    private final long f14731b;

    /* renamed from: b */
    private String f14732b;

    /* renamed from: c */
    private long f14733c;

    /* renamed from: b */
    protected static final Map<String, C4128cc> f14723b = new HashMap();

    /* renamed from: a */
    protected static boolean f14722a = false;

    /* renamed from: com.xiaomi.push.cg$a */
    public interface a {
        /* renamed from: a */
        C4132cg mo14097a(Context context, InterfaceC4131cf interfaceC4131cf, b bVar, String str);
    }

    /* renamed from: com.xiaomi.push.cg$b */
    public interface b {
        /* renamed from: a */
        String mo14098a(String str);
    }

    protected C4132cg(Context context, InterfaceC4131cf interfaceC4131cf, b bVar, String str) {
        this(context, interfaceC4131cf, bVar, str, null, null);
    }

    /* renamed from: a */
    public static synchronized C4132cg m14066a() {
        C4132cg c4132cg;
        synchronized (C4132cg.class) {
            if (f14721a == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            c4132cg = f14721a;
        }
        return c4132cg;
    }

    /* renamed from: f */
    private String m14074f() {
        return "host_fallbacks";
    }

    /* renamed from: g */
    private String m14075g() {
        try {
            PackageInfo packageInfo = f14719a.getPackageManager().getPackageInfo(f14719a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: b */
    public C4128cc m14084b(String str) {
        return m14077a(str, true);
    }

    /* renamed from: b */
    protected String m14085b() {
        return "resolver.msg.xiaomi.net";
    }

    /* renamed from: c */
    protected C4128cc m14088c(String str) {
        C4129cd c4129cd;
        C4128cc m14054a;
        synchronized (this.f14730a) {
            m14083a();
            c4129cd = this.f14730a.get(str);
        }
        if (c4129cd == null || (m14054a = c4129cd.m14054a()) == null) {
            return null;
        }
        return m14054a;
    }

    /* renamed from: d */
    public C4128cc m14091d(String str) {
        C4128cc c4128cc;
        synchronized (f14723b) {
            c4128cc = f14723b.get(str);
        }
        return c4128cc;
    }

    /* renamed from: e */
    protected C4128cc m14094e(String str) {
        if (System.currentTimeMillis() - this.f14733c <= this.f14726a * 60 * 1000) {
            return null;
        }
        this.f14733c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        C4128cc c4128cc = m14069a(arrayList).get(0);
        if (c4128cc != null) {
            this.f14726a = 0L;
            return c4128cc;
        }
        long j2 = this.f14726a;
        if (j2 >= 15) {
            return null;
        }
        this.f14726a = j2 + 1;
        return null;
    }

    protected C4132cg(Context context, InterfaceC4131cf interfaceC4131cf, b bVar, String str, String str2, String str3) {
        this.f14730a = new HashMap();
        this.f14729a = "0";
        this.f14726a = 0L;
        this.f14731b = 15L;
        this.f14733c = 0L;
        this.f14732b = "isp_prov_city_country_ip";
        this.f14728a = bVar;
        if (interfaceC4131cf == null) {
            this.f14727a = new InterfaceC4131cf() { // from class: com.xiaomi.push.cg.1
                @Override // com.xiaomi.push.InterfaceC4131cf
                /* renamed from: a */
                public boolean mo14065a(String str4) {
                    return true;
                }
            };
        } else {
            this.f14727a = interfaceC4131cf;
        }
        this.f14729a = str;
        f14724c = str2 == null ? context.getPackageName() : str2;
        f14725d = str3 == null ? m14075g() : str3;
    }

    /* renamed from: b */
    public void m14086b() {
        ArrayList<String> arrayList;
        synchronized (this.f14730a) {
            m14083a();
            arrayList = new ArrayList<>(this.f14730a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C4129cd c4129cd = this.f14730a.get(arrayList.get(size));
                if (c4129cd != null && c4129cd.m14054a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<C4128cc> m14069a = m14069a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (m14069a.get(i2) != null) {
                m14082a(arrayList.get(i2), m14069a.get(i2));
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m14071a(a aVar) {
        synchronized (C4132cg.class) {
            f14720a = aVar;
            f14721a = null;
        }
    }

    /* renamed from: d */
    protected String m14092d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(f14719a.getFilesDir(), m14074f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (file.isFile()) {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    String str = new String(C4260h.m15241a(m14073a(), C4408w.m16361a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                    AbstractC4022b.m13356b("load host fallbacks = " + str);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        AbstractC4022b.m13347a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        C4408w.m16356a((Closeable) bufferedInputStream);
                        C4408w.m16356a((Closeable) fileInputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } else {
            C4408w.m16356a((Closeable) null);
            C4408w.m16356a((Closeable) null);
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized void m14070a(Context context, InterfaceC4131cf interfaceC4131cf, b bVar, String str, String str2, String str3) {
        synchronized (C4132cg.class) {
            f14719a = context.getApplicationContext();
            if (f14719a == null) {
                f14719a = context;
            }
            if (f14721a == null) {
                if (f14720a == null) {
                    f14721a = new C4132cg(context, interfaceC4131cf, bVar, str, str2, str3);
                } else {
                    f14721a = f14720a.mo14097a(context, interfaceC4131cf, bVar, str);
                }
            }
        }
    }

    /* renamed from: c */
    public String m14089c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f14730a) {
            for (Map.Entry<String, C4129cd> entry : this.f14730a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    protected String m14095e() {
        if ("com.xiaomi.xmsf".equals(f14724c)) {
            return f14724c;
        }
        return f14724c + ":pushservice";
    }

    /* renamed from: e */
    public void m14096e() {
        String next;
        synchronized (this.f14730a) {
            Iterator<C4129cd> it = this.f14730a.values().iterator();
            while (it.hasNext()) {
                it.next().m14060a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f14730a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f14730a.get(next).m14057a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f14730a.remove(next);
            }
        }
    }

    /* renamed from: a */
    static String m14067a() {
        if (f14719a == null) {
            return "unknown";
        }
        try {
            C4093av m13784a = C4092au.m13784a();
            if (m13784a == null) {
                return "unknown";
            }
            if (m13784a.m13811a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return m13784a.m13814a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m13784a.m13817b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* renamed from: b */
    protected void m14087b(String str) {
        synchronized (this.f14730a) {
            this.f14730a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        C4129cd m14055a = new C4129cd().m14055a(optJSONArray.getJSONObject(i2));
                        this.f14730a.put(m14055a.m14056a(), m14055a);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                        String optString = jSONObject2.optString(com.taobao.accs.common.Constants.KEY_HOST);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                C4128cc m14032a = new C4128cc(optString).m14032a(jSONObject2);
                                f14723b.put(m14032a.f14706b, m14032a);
                                AbstractC4022b.m13347a("load local reserved host for " + m14032a.f14706b);
                            } catch (JSONException unused) {
                                AbstractC4022b.m13347a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* renamed from: a */
    public C4128cc m14076a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return m14077a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* renamed from: c */
    public void m14090c() {
        FileOutputStream fileOutputStream;
        synchronized (this.f14730a) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    String jSONObject = m14079a().toString();
                    AbstractC4022b.m13356b("persist host fallbacks = " + jSONObject);
                    if (TextUtils.isEmpty(jSONObject)) {
                        fileOutputStream = null;
                    } else {
                        fileOutputStream = f14719a.openFileOutput(m14074f(), 0);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                            try {
                                bufferedOutputStream2.write(C4260h.m15242b(m14073a(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                                bufferedOutputStream2.flush();
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Exception e2) {
                                e = e2;
                                bufferedOutputStream = bufferedOutputStream2;
                                AbstractC4022b.m13347a("persist bucket failure: " + e.getMessage());
                                C4408w.m16356a(bufferedOutputStream);
                                C4408w.m16356a(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                C4408w.m16356a(bufferedOutputStream);
                                C4408w.m16356a(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                    C4408w.m16356a(bufferedOutputStream);
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                C4408w.m16356a(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: d */
    public void m14093d() {
        String m14095e = m14095e();
        try {
            File file = new File(f14719a.getFilesDir(), m14095e);
            if (file.exists()) {
                boolean delete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(m14095e);
                sb.append(delete ? " successful." : " failed.");
                AbstractC4022b.m13347a(sb.toString());
            } else {
                AbstractC4022b.m13356b("Old host fallbacks file " + m14095e + " does not exist.");
            }
        } catch (Exception e2) {
            AbstractC4022b.m13347a("Delete old host fallbacks file " + m14095e + " error: " + e2.getMessage());
        }
    }

    /* renamed from: a */
    public C4128cc m14077a(String str, boolean z) {
        C4128cc m14094e;
        AbstractC4022b.m13358b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f14727a.mo14065a(str)) {
                return null;
            }
            final C4128cc m14088c = m14088c(str);
            return (m14088c == null || !m14088c.mo14052b()) ? (z && C4092au.m13799a(f14719a) && (m14094e = m14094e(str)) != null) ? m14094e : new C4128cc(str) { // from class: com.xiaomi.push.cg.2

                /* renamed from: a */
                C4128cc f14735a;

                {
                    C4128cc c4128cc = m14088c;
                    this.f14735a = c4128cc;
                    ((C4128cc) this).f14706b = ((C4128cc) this).f14706b;
                    if (c4128cc != null) {
                        this.f14710f = c4128cc.f14710f;
                    }
                }

                @Override // com.xiaomi.push.C4128cc
                /* renamed from: a */
                public synchronized ArrayList<String> mo14036a(boolean z2) {
                    ArrayList<String> arrayList;
                    arrayList = new ArrayList<>();
                    if (this.f14735a != null) {
                        arrayList.addAll(this.f14735a.mo14036a(true));
                    }
                    synchronized (C4132cg.f14723b) {
                        C4128cc c4128cc = C4132cg.f14723b.get(((C4128cc) this).f14706b);
                        if (c4128cc != null) {
                            Iterator<String> it = c4128cc.mo14036a(true).iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                if (arrayList.indexOf(next) == -1) {
                                    arrayList.add(next);
                                }
                            }
                            arrayList.remove(((C4128cc) this).f14706b);
                            arrayList.add(((C4128cc) this).f14706b);
                        }
                    }
                    return arrayList;
                }

                @Override // com.xiaomi.push.C4128cc
                /* renamed from: b */
                public boolean mo14052b() {
                    return false;
                }

                @Override // com.xiaomi.push.C4128cc
                /* renamed from: a */
                public synchronized void mo14045a(String str2, C4127cb c4127cb) {
                    if (this.f14735a != null) {
                        this.f14735a.mo14045a(str2, c4127cb);
                    }
                }
            } : m14088c;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* renamed from: a */
    private ArrayList<C4128cc> m14069a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m14096e();
        synchronized (this.f14730a) {
            m14083a();
            for (String str : this.f14730a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        synchronized (f14723b) {
            for (Object obj : f14723b.values().toArray()) {
                C4128cc c4128cc = (C4128cc) obj;
                if (!c4128cc.mo14052b()) {
                    f14723b.remove(c4128cc.f14706b);
                }
            }
        }
        if (!arrayList.contains(m14085b())) {
            arrayList.add(m14085b());
        }
        ArrayList<C4128cc> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = C4092au.m13803d(f14719a) ? UtilityImpl.NET_TYPE_WIFI : "wap";
            String mo14078a = mo14078a(arrayList, str2, this.f14729a, true);
            if (!TextUtils.isEmpty(mo14078a)) {
                JSONObject jSONObject3 = new JSONObject(mo14078a);
                AbstractC4022b.m13356b(mo14078a);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString(UserInfo.PROVINCE);
                    String string2 = jSONObject4.getString(UserInfo.CITY);
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString(C3351bh.f11563O);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    AbstractC4022b.m13359c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            AbstractC4022b.m13347a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            C4128cc c4128cc2 = new C4128cc(str3);
                            int i4 = 0;
                            while (i4 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i4);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    c4128cc2.m14040a(new C4135cj(string6, optJSONArray.length() - i4));
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, c4128cc2);
                            c4128cc2.f14711g = string5;
                            c4128cc2.f14707c = string;
                            c4128cc2.f14709e = string3;
                            c4128cc2.f14710f = string4;
                            c4128cc2.f14708d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                c4128cc2.m14038a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                c4128cc2.m14049b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                c4128cc2.m14039a(jSONObject4.getInt(RemoteMessageConst.TTL) * 1000);
                            }
                            m14081a(c4128cc2.m14033a());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j2 = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                AbstractC4022b.m13347a("no bucket found for " + next);
                            } else {
                                C4128cc c4128cc3 = new C4128cc(next);
                                c4128cc3.m14039a(j2);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        c4128cc3.m14040a(new C4135cj(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (f14723b) {
                                    if (this.f14727a.mo14065a(next)) {
                                        f14723b.put(next, c4128cc3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            AbstractC4022b.m13347a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            C4128cc c4128cc4 = arrayList2.get(i6);
            if (c4128cc4 != null) {
                m14082a(arrayList.get(i6), c4128cc4);
            }
        }
        m14090c();
        return arrayList2;
    }

    /* renamed from: a */
    protected String mo14078a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<InterfaceC4091at> arrayList3 = new ArrayList();
        arrayList3.add(new C4089ar("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new C4089ar("conpt", m14068a(C4092au.m13789a(f14719a))));
        }
        if (z) {
            arrayList3.add(new C4089ar("reserved", "1"));
        }
        arrayList3.add(new C4089ar("uuid", str2));
        arrayList3.add(new C4089ar("list", C4100bb.m13881a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new C4089ar("countrycode", C4375b.m16045a(f14719a).m16050b()));
        arrayList3.add(new C4089ar("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String m14085b = m14085b();
        C4128cc m14088c = m14088c(m14085b);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", m14085b);
        if (m14088c == null) {
            arrayList2.add(format);
            synchronized (f14723b) {
                C4128cc c4128cc = f14723b.get(m14085b);
                if (c4128cc != null) {
                    Iterator<String> it = c4128cc.mo14036a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = m14088c.m14035a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (InterfaceC4091at interfaceC4091at : arrayList3) {
                buildUpon.appendQueryParameter(interfaceC4091at.mo13777a(), interfaceC4091at.mo13778b());
            }
            try {
                if (this.f14728a == null) {
                    return C4092au.m13790a(f14719a, new URL(buildUpon.toString()));
                }
                return this.f14728a.mo14098a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        AbstractC4022b.m13347a("network exception: " + e2.getMessage());
        throw e2;
    }

    /* renamed from: a */
    public void m14080a() {
        synchronized (this.f14730a) {
            this.f14730a.clear();
        }
    }

    /* renamed from: a */
    public void m14082a(String str, C4128cc c4128cc) {
        if (!TextUtils.isEmpty(str) && c4128cc != null) {
            if (this.f14727a.mo14065a(str)) {
                synchronized (this.f14730a) {
                    m14083a();
                    if (this.f14730a.containsKey(str)) {
                        this.f14730a.get(str).m14059a(c4128cc);
                    } else {
                        C4129cd c4129cd = new C4129cd(str);
                        c4129cd.m14059a(c4128cc);
                        this.f14730a.put(str, c4129cd);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + c4128cc);
    }

    /* renamed from: a */
    protected boolean m14083a() {
        synchronized (this.f14730a) {
            if (f14722a) {
                return true;
            }
            f14722a = true;
            this.f14730a.clear();
            try {
                String m14092d = m14092d();
                if (!TextUtils.isEmpty(m14092d)) {
                    m14087b(m14092d);
                    AbstractC4022b.m13356b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                AbstractC4022b.m13347a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    /* renamed from: a */
    public static void m14072a(String str, String str2) {
        C4128cc c4128cc = f14723b.get(str);
        synchronized (f14723b) {
            if (c4128cc == null) {
                C4128cc c4128cc2 = new C4128cc(str);
                c4128cc2.m14039a(604800000L);
                c4128cc2.m14041a(str2);
                f14723b.put(str, c4128cc2);
            } else {
                c4128cc.m14041a(str2);
            }
        }
    }

    /* renamed from: a */
    private byte[] m14073a() {
        return C4099ba.m13876a(f14719a.getPackageName() + "_key_salt");
    }

    /* renamed from: a */
    static String m14068a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & C3393cw.f11873m) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public void m14081a(String str) {
        this.f14732b = str;
    }

    /* renamed from: a */
    protected JSONObject m14079a() {
        JSONObject jSONObject;
        synchronized (this.f14730a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<C4129cd> it = this.f14730a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m14058a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<C4128cc> it2 = f14723b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m14037a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
