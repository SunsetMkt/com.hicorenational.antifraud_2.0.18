package com.umeng.message;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.d;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.aq;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.x;
import com.umeng.socialize.a.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MessageSharedPrefs {

    /* JADX INFO: renamed from: d */
    private static volatile MessageSharedPrefs f7877d;
    public final Context a;

    /* JADX INFO: renamed from: b */
    public final aq f7878b = new aq("push");

    /* JADX INFO: renamed from: c */
    public Boolean f7879c = null;

    private MessageSharedPrefs(Context context) {
        this.a = context.getApplicationContext();
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f7877d == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f7877d == null) {
                    f7877d = new MessageSharedPrefs(context);
                }
            }
        }
        return f7877d;
    }

    private void setMessageAppKey(String str) {
        if (f.b(this.a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "appkey is empty!");
            } else {
                this.f7878b.a("appkey", str);
            }
        }
    }

    private void setMessageAppSecret(String str) {
        if (f.b(this.a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "message secret is empty!");
            } else {
                this.f7878b.a("message_secret", str);
            }
        }
    }

    private void setMessageChannel(String str) {
        if (f.b(this.a)) {
            this.f7878b.a("channel", str);
        }
    }

    public final boolean a() {
        Throwable th;
        long jB;
        try {
            jB = this.f7878b.b(d.p, 0L);
            if (jB > 0) {
                try {
                    UPLog.d("Prefs", "today first start:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(jB)));
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.e("Prefs", th);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            jB = 0;
        }
        return f.a(jB);
    }

    public final int b() {
        return this.f7878b.b("notification_number", 1);
    }

    public final String c() {
        return this.f7878b.b("appkey", "");
    }

    public final int d() {
        return this.f7878b.b("tag_remain", 64);
    }

    public final String e() {
        String strB = this.f7878b.b("service_class", "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                Class.forName(strB);
                return strB;
            } catch (Throwable unused) {
                UPLog.e("Prefs", "custom service not exist:", strB, "if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    public final String f() {
        return this.f7878b.b("last_click_msg_id", "");
    }

    public final int g() {
        return this.f7878b.b("mute_duration", 60);
    }

    public final int h() {
        return this.f7878b.b("notification_vibrate", 0);
    }

    public final int i() {
        return this.f7878b.b("notification_light", 0);
    }

    public final int j() {
        return this.f7878b.b("notification_sound", 0);
    }

    public final String k() {
        return this.f7878b.b(RemoteMessageConst.DEVICE_TOKEN, "");
    }

    public final boolean l() {
        return this.f7878b.b("l_u_e", false);
    }

    public final long m() {
        return this.f7878b.b(a.f8166d, 0L);
    }

    public final int n() {
        return this.f7878b.b("re_pop_cfg", 0);
    }

    public final int o() {
        Calendar calendar = Calendar.getInstance();
        String str = String.format(Locale.getDefault(), "%d.%d.", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        String strB = this.f7878b.b("re_pop_times", "");
        if (strB.startsWith(str)) {
            try {
                return Integer.parseInt(strB.replace(str, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final void b(String str) {
        this.f7878b.a(str + bh.aX);
        this.f7878b.a(str + "ts");
    }

    public final void c(String str) {
        this.f7878b.a("last_click_msg_id", str);
    }

    public final void a(String str, String str2, int i2, long j2) {
        Cursor cursorQuery = null;
        try {
            Application applicationA = x.a();
            try {
                this.a.getContentResolver().delete(h.a(this.a), "type=?", new String[]{str2});
            } catch (Exception e2) {
                UPLog.e("Prefs", e2);
            }
            String[] strArr = {str, str2, String.valueOf(i2)};
            cursorQuery = applicationA.getContentResolver().query(h.a(applicationA), null, "alias=? and type=? and exclusive=?", strArr, "time desc");
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(RemoteMessageConst.TTL, Long.valueOf(j2));
            contentValues.put("type", str2);
            contentValues.put("alias", str);
            contentValues.put("exclusive", Integer.valueOf(i2));
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                this.a.getContentResolver().update(h.a(applicationA), contentValues, "alias=? and type=? and exclusive=?", strArr);
            } else {
                this.a.getContentResolver().insert(h.a(applicationA), contentValues);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable th) {
                UPLog.e("Prefs", th);
            }
        }
    }

    public final String a(int i2, String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = this.a.getContentResolver().query(h.a(this.a), new String[]{"alias"}, "type=? and exclusive=?", new String[]{str, String.valueOf(i2)}, "time desc");
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursorQuery != null) {
            try {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("alias"));
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable th2) {
                                UPLog.e("Prefs", th2);
                            }
                        }
                        return string;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorQuery;
                }
            } catch (Exception e3) {
                e = e3;
                UPLog.e("Prefs", e);
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        UPLog.e("Prefs", th4);
                    }
                }
                return null;
            }
            th = th3;
            cursor = cursorQuery;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th5) {
                    UPLog.e("Prefs", th5);
                }
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable th6) {
                UPLog.e("Prefs", th6);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i2, String str, String str2) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor;
        int count;
        try {
            try {
                String[] strArr = {str2, str, String.valueOf(i2)};
                UPLog.i("Prefs", "type", str2, "alias", str, "exclusive", Integer.valueOf(i2));
                cursorQuery = this.a.getContentResolver().query(h.a(this.a), null, "type=? and alias=? and exclusive=?", strArr, null);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } catch (Throwable th3) {
            UPLog.e("Prefs", th3);
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th4) {
                    UPLog.e("Prefs", th4);
                }
            }
            return false;
        }
        try {
            count = cursorQuery.getCount();
            UPLog.i("Prefs", "count", Integer.valueOf(count));
        } catch (Exception e3) {
            e = e3;
            cursor = cursorQuery;
            try {
                UPLog.e("Prefs", e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                cursorQuery = cursor;
                if (cursorQuery == null) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th6) {
                        UPLog.e("Prefs", th6);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            if (cursorQuery == null) {
            }
        }
        if (count <= 0) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th8) {
                    UPLog.e("Prefs", th8);
                }
            }
            return false;
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("type"));
        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("alias"));
        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex(RemoteMessageConst.TTL));
        boolean z = Math.abs(System.currentTimeMillis() - cursorQuery.getLong(cursorQuery.getColumnIndex("time"))) < 1000 * j2;
        UPLog.i("Prefs", "type", string, "alias", string2, "alive", Boolean.valueOf(z), RemoteMessageConst.TTL, Long.valueOf(j2));
        if (z && TextUtils.equals(string, str2)) {
            if (TextUtils.equals(str, string2)) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th9) {
                        UPLog.e("Prefs", th9);
                    }
                }
                return true;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
        return false;
    }

    public final void a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        Set<String> setB = this.f7878b.b(SocializeProtocolConstants.TAGS, new HashSet());
        setB.addAll(Arrays.asList(strArr));
        this.f7878b.a(SocializeProtocolConstants.TAGS, setB);
    }

    public final void a(String str, long j2) {
        this.f7878b.a(str + bh.aX, j2);
        this.f7878b.a(str + "ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long jB = this.f7878b.b(str + bh.aX, 0L);
        if (jB <= 0) {
            return true;
        }
        aq aqVar = this.f7878b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - aqVar.b(sb.toString(), 0L)) / 1000 >= jB;
    }

    public final void a(int i2) {
        this.f7878b.a("tag_remain", i2);
    }
}
