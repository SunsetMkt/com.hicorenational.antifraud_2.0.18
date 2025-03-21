package com.umeng.ut.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.Config;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f11919a;

    /* renamed from: a, reason: collision with other field name */
    private Context f65a;

    /* renamed from: c, reason: collision with root package name */
    private String f11921c = null;

    /* renamed from: d, reason: collision with root package name */
    private long f11922d = -1;

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f11920b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a, reason: collision with other field name */
    private static final Object f64a = new Object();

    private d(Context context) {
        this.f65a = context.getApplicationContext();
        com.umeng.ut.a.a.a().a(this.f65a);
    }

    public static d a(Context context) {
        if (context != null && f11919a == null) {
            synchronized (f64a) {
                if (f11919a == null) {
                    f11919a = new d(context);
                }
            }
        }
        return f11919a;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f11920b.matcher(str).find();
        }
        return false;
    }

    private long c() {
        long j2;
        try {
            j2 = a("um_push_ut").getLong("v_i", 604800L);
        } catch (Throwable unused) {
            j2 = 0;
        }
        if (j2 < 600) {
            j2 = 600;
        } else if (j2 > 7776000) {
            j2 = 7776000;
        }
        return j2 * 1000;
    }

    @SuppressLint({"ApplySharedPref"})
    private void e() {
        try {
            a("um_push_ut").edit().remove("v_r").commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:2|3|(8:8|(2:10|(2:18|(3:22|23|24))(3:14|15|16))|25|26|(5:28|(1:30)|31|32|33)|35|36|37)|40|(0)|25|26|(0)|35|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:10:0x0017, B:12:0x0025, B:14:0x002d, B:18:0x0031, B:20:0x003f, B:22:0x0047, B:26:0x0050, B:28:0x0056, B:30:0x0064, B:31:0x0067, B:39:0x006c), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056 A[Catch: Exception -> 0x006b, all -> 0x0072, TryCatch #1 {Exception -> 0x006b, blocks: (B:26:0x0050, B:28:0x0056, B:30:0x0064, B:31:0x0067), top: B:25:0x0050, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.lang.String j() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.m47c()     // Catch: java.lang.Throwable -> L72
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r4.f65a     // Catch: java.lang.Throwable -> L72
            boolean r0 = com.umeng.ut.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L72
            if (r0 != 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            if (r0 == 0) goto L50
            java.lang.String r3 = r4.l()     // Catch: java.lang.Throwable -> L72
            r4.f11921c = r3     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L31
            java.lang.String r3 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            boolean r3 = r4.b(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L31
            java.lang.String r0 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L31:
            java.lang.String r3 = r4.k()     // Catch: java.lang.Throwable -> L72
            r4.f11921c = r3     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            boolean r3 = com.umeng.ut.b.a.a.d.isEmpty(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 != 0) goto L50
            java.lang.String r3 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            boolean r3 = r4.b(r3)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L50
            java.lang.String r0 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            r4.a(r0, r1)     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r4.f11921c     // Catch: java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L50:
            byte[] r1 = r4.a()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            if (r1 == 0) goto L6f
            r3 = 2
            java.lang.String r1 = com.umeng.ut.b.a.a.a.a(r1, r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            r4.f11921c = r1     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            java.lang.String r1 = r4.f11921c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            r4.a(r1, r2)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            if (r0 != 0) goto L67
            r4.e()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
        L67:
            java.lang.String r0 = r4.f11921c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L72
            monitor-exit(r4)
            return r0
        L6b:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L72
        L6f:
            r0 = 0
            monitor-exit(r4)
            return r0
        L72:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.b.b.d.j():java.lang.String");
    }

    private String k() {
        try {
            SharedPreferences a2 = a(Config.PREFERENCES);
            String string = a2.getString("deviceId", null);
            if (string == null || string.length() <= 0) {
                return null;
            }
            String string2 = a2.getString("utdid", null);
            if (string2 != null) {
                try {
                    if (string2.length() == 0) {
                    }
                } catch (Throwable unused) {
                }
                return string2;
            }
            return a(Constants.SP_FILE_NAME).getString("utdid", null);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String l() {
        try {
            return a("um_push_ut").getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    boolean d() {
        try {
            return a("um_push_ut").getBoolean("t_f", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    void f() {
        try {
            a("um_push_ut").edit().remove("t_id").remove("t_f").commit();
        } catch (Throwable unused) {
        }
    }

    synchronized String getValue() {
        if (this.f11921c != null) {
            return this.f11921c;
        }
        return j();
    }

    String m() {
        String str;
        try {
            str = a("um_push_ut").getString("t_id", null);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
            return str;
        }
        return null;
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m47c() {
        try {
            return a("um_push_ut").getBoolean("v_r", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    private void a(String str, boolean z) {
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                b(str, z);
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean b() {
        try {
            SharedPreferences a2 = a("um_push_ut");
            if (this.f11922d == -1) {
                this.f11922d = a2.getLong("v_ts", 0L);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f11922d) >= c()) {
                this.f11922d = currentTimeMillis;
                a2.edit().putLong("v_ts", currentTimeMillis).commit();
                com.umeng.ut.a.c.e.m44a("UTUtdid", "req valid");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private byte[] a() throws Exception {
        String str;
        com.umeng.ut.a.c.e.m44a("UTUtdid", "generate UTDid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = com.umeng.ut.b.a.a.b.getBytes(currentTimeMillis);
        byte[] bytes2 = com.umeng.ut.b.a.a.b.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.umeng.ut.b.a.a.c.f();
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(str)), 0, 4);
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"ApplySharedPref"})
    private void b(String str, boolean z) {
        try {
            a("um_push_ut").edit().putString("d_id", str).putBoolean("t_f", z).commit();
        } catch (Throwable unused) {
        }
    }

    private static String a(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.umeng.ut.a.c.d.b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.umeng.ut.b.a.a.a.a(mac.doFinal(bArr), 2);
    }

    @SuppressLint({"ApplySharedPref"})
    void a(String str, long j2) {
        boolean z;
        try {
            SharedPreferences.Editor edit = a("um_push_ut").edit();
            if (j2 > 0) {
                edit.putLong("v_i", j2);
                edit.putLong("v_ts", System.currentTimeMillis());
                z = true;
            } else {
                z = false;
            }
            if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
                edit.putString("t_id", str);
                edit.putBoolean("v_r", false);
                z = true;
            }
            if (z) {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private SharedPreferences a(String str) {
        return this.f65a.getSharedPreferences(str, 0);
    }
}
