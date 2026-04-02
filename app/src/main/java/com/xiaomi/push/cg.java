package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.Constants;
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

/* JADX INFO: loaded from: classes2.dex */
public class cg {
    protected static Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cg f255a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f8804d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private cf f258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected b f259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<String, cd> f261a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f262b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f263b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private long f264c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Map<String, cc> f8802b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected static boolean f256a = false;

    public interface a {
        cg a(Context context, cf cfVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    protected cg(Context context, cf cfVar, b bVar, String str) {
        this(context, cfVar, bVar, str, null, null);
    }

    public static synchronized cg a() {
        if (f255a == null) {
            throw new IllegalStateException("the host manager is not initialized yet.");
        }
        return f255a;
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public cc b(String str) {
        return a(str, true);
    }

    protected String b() {
        return "resolver.msg.xiaomi.net";
    }

    protected cc c(String str) {
        cd cdVar;
        cc ccVarA;
        synchronized (this.f261a) {
            m231a();
            cdVar = this.f261a.get(str);
        }
        if (cdVar == null || (ccVarA = cdVar.a()) == null) {
            return null;
        }
        return ccVarA;
    }

    public cc d(String str) {
        cc ccVar;
        synchronized (f8802b) {
            ccVar = f8802b.get(str);
        }
        return ccVar;
    }

    protected cc e(String str) {
        if (System.currentTimeMillis() - this.f264c <= this.f257a * 60 * 1000) {
            return null;
        }
        this.f264c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        cc ccVar = a(arrayList).get(0);
        if (ccVar != null) {
            this.f257a = 0L;
            return ccVar;
        }
        long j2 = this.f257a;
        if (j2 >= 15) {
            return null;
        }
        this.f257a = j2 + 1;
        return null;
    }

    protected cg(Context context, cf cfVar, b bVar, String str, String str2, String str3) {
        this.f261a = new HashMap();
        this.f260a = "0";
        this.f257a = 0L;
        this.f262b = 15L;
        this.f264c = 0L;
        this.f263b = "isp_prov_city_country_ip";
        this.f259a = bVar;
        if (cfVar == null) {
            this.f258a = new cf() { // from class: com.xiaomi.push.cg.1
                @Override // com.xiaomi.push.cf
                public boolean a(String str4) {
                    return true;
                }
            };
        } else {
            this.f258a = cfVar;
        }
        this.f260a = str;
        f8803c = str2 == null ? context.getPackageName() : str2;
        f8804d = str3 == null ? g() : str3;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m232b() {
        ArrayList<String> arrayList;
        synchronized (this.f261a) {
            m231a();
            arrayList = new ArrayList<>(this.f261a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cd cdVar = this.f261a.get(arrayList.get(size));
                if (cdVar != null && cdVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cc> arrayListA = a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayListA.get(i2) != null) {
                a(arrayList.get(i2), arrayListA.get(i2));
            }
        }
    }

    public static synchronized void a(a aVar) {
        f254a = aVar;
        f255a = null;
    }

    protected String d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(a.getFilesDir(), f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        try {
            if (file.isFile()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        String str = new String(h.a(m226a(), w.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                        com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                }
            } else {
                w.a((Closeable) null);
                w.a((Closeable) null);
                return null;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("load host exception " + th.getMessage());
            return null;
        } finally {
            w.a((Closeable) bufferedInputStream);
            w.a((Closeable) fileInputStream);
        }
    }

    public static synchronized void a(Context context, cf cfVar, b bVar, String str, String str2, String str3) {
        a = context.getApplicationContext();
        if (a == null) {
            a = context;
        }
        if (f255a == null) {
            if (f254a == null) {
                f255a = new cg(context, cfVar, bVar, str, str2, str3);
            } else {
                f255a = f254a.a(context, cfVar, bVar, str);
            }
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f261a) {
            for (Map.Entry<String, cd> entry : this.f261a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    protected String e() {
        if ("com.xiaomi.xmsf".equals(f8803c)) {
            return f8803c;
        }
        return f8803c + ":pushservice";
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m236e() {
        String next;
        synchronized (this.f261a) {
            Iterator<cd> it = this.f261a.values().iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f261a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f261a.get(next).m221a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f261a.remove(next);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    static String m225a() {
        if (a == null) {
            return "unknown";
        }
        try {
            av avVarM142a = au.m142a();
            if (avVarM142a == null) {
                return "unknown";
            }
            if (avVarM142a.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return avVarM142a.m152a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + avVarM142a.m154b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    protected void m233b(String str) {
        synchronized (this.f261a) {
            this.f261a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        cd cdVarA = new cd().a(jSONArrayOptJSONArray.getJSONObject(i2));
                        this.f261a.put(cdVarA.m220a(), cdVarA);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("reserved");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i3);
                        String strOptString = jSONObject2.optString(com.taobao.accs.common.Constants.KEY_HOST);
                        if (!TextUtils.isEmpty(strOptString)) {
                            try {
                                cc ccVarA = new cc(strOptString).a(jSONObject2);
                                f8802b.put(ccVarA.f251b, ccVarA);
                                com.xiaomi.channel.commonutils.logger.b.m48a("load local reserved host for " + ccVarA.f251b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m48a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public cc m227a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m234c() {
        FileOutputStream fileOutputStreamOpenFileOutput;
        synchronized (this.f261a) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    String string = m228a().toString();
                    com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = " + string);
                    if (TextUtils.isEmpty(string)) {
                        fileOutputStreamOpenFileOutput = null;
                    } else {
                        fileOutputStreamOpenFileOutput = a.openFileOutput(f(), 0);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStreamOpenFileOutput);
                            try {
                                bufferedOutputStream2.write(h.b(m226a(), string.getBytes(StandardCharsets.UTF_8)));
                                bufferedOutputStream2.flush();
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Exception e2) {
                                e = e2;
                                bufferedOutputStream = bufferedOutputStream2;
                                com.xiaomi.channel.commonutils.logger.b.m48a("persist bucket failure: " + e.getMessage());
                                w.a(bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                w.a(bufferedOutputStream);
                                w.a(fileOutputStreamOpenFileOutput);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                    w.a(bufferedOutputStream);
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStreamOpenFileOutput = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStreamOpenFileOutput = null;
                }
                w.a(fileOutputStreamOpenFileOutput);
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m235d() {
        String strE = e();
        try {
            File file = new File(a.getFilesDir(), strE);
            if (file.exists()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(strE);
                sb.append(zDelete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.b.m48a(sb.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + strE + " does not exist.");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Delete old host fallbacks file " + strE + " error: " + e2.getMessage());
        }
    }

    public cc a(String str, boolean z) {
        cc ccVarE;
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f258a.a(str)) {
                return null;
            }
            final cc ccVarC = c(str);
            return (ccVarC == null || !ccVarC.b()) ? (z && au.m149a(a) && (ccVarE = e(str)) != null) ? ccVarE : new cc(str) { // from class: com.xiaomi.push.cg.2
                cc a;

                {
                    cc ccVar = ccVarC;
                    this.a = ccVar;
                    ((cc) this).f251b = ((cc) this).f251b;
                    if (ccVar != null) {
                        this.f8797f = ccVar.f8797f;
                    }
                }

                @Override // com.xiaomi.push.cc
                public synchronized ArrayList<String> a(boolean z2) {
                    ArrayList<String> arrayList;
                    arrayList = new ArrayList<>();
                    if (this.a != null) {
                        arrayList.addAll(this.a.a(true));
                    }
                    synchronized (cg.f8802b) {
                        cc ccVar = cg.f8802b.get(((cc) this).f251b);
                        if (ccVar != null) {
                            for (String str2 : ccVar.a(true)) {
                                if (arrayList.indexOf(str2) == -1) {
                                    arrayList.add(str2);
                                }
                            }
                            arrayList.remove(((cc) this).f251b);
                            arrayList.add(((cc) this).f251b);
                        }
                    }
                    return arrayList;
                }

                @Override // com.xiaomi.push.cc
                public boolean b() {
                    return false;
                }

                @Override // com.xiaomi.push.cc
                public synchronized void a(String str2, cb cbVar) {
                    if (this.a != null) {
                        this.a.a(str2, cbVar);
                    }
                }
            } : ccVarC;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private ArrayList<cc> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m236e();
        synchronized (this.f261a) {
            m231a();
            for (String str : this.f261a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        synchronized (f8802b) {
            for (Object obj : f8802b.values().toArray()) {
                cc ccVar = (cc) obj;
                if (!ccVar.b()) {
                    f8802b.remove(ccVar.f251b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cc> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = au.d(a) ? UtilityImpl.NET_TYPE_WIFI : "wap";
            String strA = a(arrayList, str2, this.f260a, true);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject3 = new JSONObject(strA);
                com.xiaomi.channel.commonutils.logger.b.b(strA);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString(UserInfo.PROVINCE);
                    String string2 = jSONObject4.getString(UserInfo.CITY);
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString(com.umeng.analytics.pro.bh.O);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray jSONArrayOptJSONArray = jSONObject5.optJSONArray(str3);
                        if (jSONArrayOptJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cc ccVar2 = new cc(str3);
                            int i4 = 0;
                            while (i4 < jSONArrayOptJSONArray.length()) {
                                String string6 = jSONArrayOptJSONArray.getString(i4);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    ccVar2.a(new cj(string6, jSONArrayOptJSONArray.length() - i4));
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, ccVar2);
                            ccVar2.f8798g = string5;
                            ccVar2.f8794c = string;
                            ccVar2.f8796e = string3;
                            ccVar2.f8797f = string4;
                            ccVar2.f8795d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                ccVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                ccVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                ccVar2.a(((long) jSONObject4.getInt(RemoteMessageConst.TTL)) * 1000);
                            }
                            m230a(ccVar2.a());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject("reserved");
                    if (jSONObjectOptJSONObject != null) {
                        long j2 = jSONObject4.has("reserved-ttl") ? ((long) jSONObject4.getInt("reserved-ttl")) * 1000 : 604800000L;
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m48a("no bucket found for " + next);
                            } else {
                                cc ccVar3 = new cc(next);
                                ccVar3.a(j2);
                                for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                                    String string7 = jSONArrayOptJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        ccVar3.a(new cj(string7, jSONArrayOptJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (f8802b) {
                                    if (this.f258a.a(next)) {
                                        f8802b.put(next, ccVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            cc ccVar4 = arrayList2.get(i6);
            if (ccVar4 != null) {
                a(arrayList.get(i6), ccVar4);
            }
        }
        m234c();
        return arrayList2;
    }

    protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<at> arrayList3 = new ArrayList();
        arrayList3.add(new ar("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new ar("conpt", a(au.m145a(a))));
        }
        if (z) {
            arrayList3.add(new ar("reserved", "1"));
        }
        arrayList3.add(new ar("uuid", str2));
        arrayList3.add(new ar("list", bb.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new ar("countrycode", com.xiaomi.push.service.b.a(a).b()));
        arrayList3.add(new ar("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String strB = b();
        cc ccVarC = c(strB);
        String str3 = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", strB);
        if (ccVarC == null) {
            arrayList2.add(str3);
            synchronized (f8802b) {
                cc ccVar = f8802b.get(strB);
                if (ccVar != null) {
                    Iterator<String> it = ccVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = ccVarC.a(str3);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder builderBuildUpon = Uri.parse(it2.next()).buildUpon();
            for (at atVar : arrayList3) {
                builderBuildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            try {
                if (this.f259a == null) {
                    return au.a(a, new URL(builderBuildUpon.toString()));
                }
                return this.f259a.a(builderBuildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("network exception: " + e2.getMessage());
        throw e2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m229a() {
        synchronized (this.f261a) {
            this.f261a.clear();
        }
    }

    public void a(String str, cc ccVar) {
        if (!TextUtils.isEmpty(str) && ccVar != null) {
            if (this.f258a.a(str)) {
                synchronized (this.f261a) {
                    m231a();
                    if (this.f261a.containsKey(str)) {
                        this.f261a.get(str).a(ccVar);
                    } else {
                        cd cdVar = new cd(str);
                        cdVar.a(ccVar);
                        this.f261a.put(str, cdVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + ccVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected boolean m231a() {
        synchronized (this.f261a) {
            if (f256a) {
                return true;
            }
            f256a = true;
            this.f261a.clear();
            try {
                String strD = d();
                if (!TextUtils.isEmpty(strD)) {
                    m233b(strD);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m48a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public static void a(String str, String str2) {
        cc ccVar = f8802b.get(str);
        synchronized (f8802b) {
            if (ccVar == null) {
                cc ccVar2 = new cc(str);
                ccVar2.a(604800000L);
                ccVar2.m218a(str2);
                f8802b.put(str, ccVar2);
            } else {
                ccVar.m218a(str2);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private byte[] m226a() {
        return ba.m174a(a.getPackageName() + "_key_salt");
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & com.umeng.analytics.pro.cw.f7205m) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m230a(String str) {
        this.f263b = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected JSONObject m228a() {
        JSONObject jSONObject;
        synchronized (this.f261a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<cd> it = this.f261a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m222a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<cc> it2 = f8802b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m217a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
