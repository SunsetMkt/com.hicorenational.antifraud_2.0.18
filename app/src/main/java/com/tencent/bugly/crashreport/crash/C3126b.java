package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C3072b;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC3188m;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3144ag;
import com.tencent.bugly.proguard.C3145ah;
import com.tencent.bugly.proguard.C3148ak;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3167bc;
import com.tencent.bugly.proguard.C3169be;
import com.tencent.bugly.proguard.C3170bf;
import com.tencent.bugly.proguard.C3171bg;
import com.tencent.bugly.proguard.C3172bh;
import com.tencent.bugly.proguard.C3173bi;
import com.tencent.bugly.proguard.InterfaceC3141ad;
import com.tencent.bugly.proguard.InterfaceC3147aj;
import com.umeng.analytics.pro.C3355bl;
import com.umeng.socialize.tracker.C3773a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.b */
/* loaded from: classes2.dex */
public class C3126b {

    /* renamed from: a */
    public static int f10351a;

    /* renamed from: b */
    protected final Context f10352b;

    /* renamed from: c */
    protected final C3148ak f10353c;

    /* renamed from: d */
    protected final C3142ae f10354d;

    /* renamed from: e */
    protected final C3116a f10355e;

    /* renamed from: f */
    protected InterfaceC3130f f10356f;

    /* renamed from: g */
    protected BuglyStrategy.C3070a f10357g;

    public C3126b(int i2, Context context, C3148ak c3148ak, C3142ae c3142ae, C3116a c3116a, BuglyStrategy.C3070a c3070a, InterfaceC3130f interfaceC3130f) {
        f10351a = i2;
        this.f10352b = context;
        this.f10353c = c3148ak;
        this.f10354d = c3142ae;
        this.f10355e = c3116a;
        this.f10357g = c3070a;
        this.f10356f = interfaceC3130f;
    }

    /* renamed from: f */
    private boolean m9685f(CrashDetailBean crashDetailBean) {
        try {
            C3151an.m9921c("save eup logs", new Object[0]);
            C3113a m9532b = C3113a.m9532b();
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", m9532b.m9571f(), m9532b.f10208p, m9532b.f10202j, crashDetailBean.f10266A, C3154aq.m9958a(new Date(crashDetailBean.f10306r)), crashDetailBean.f10302n, crashDetailBean.f10303o, crashDetailBean.f10305q, crashDetailBean.f10291c);
            String str = null;
            if (C3127c.f10369j != null) {
                File file = new File(C3127c.f10369j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f10352b.getPackageName();
            }
            C3154aq.m9964a(this.f10352b, str + "/euplog.txt", format, C3127c.f10370k);
            return true;
        } catch (Throwable th) {
            C3151an.m9922d("rqdp{  save error} %s", th.toString());
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    protected List<C3119a> m9689a(List<C3119a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C3119a c3119a : list) {
            if (c3119a.f10318d && c3119a.f10316b <= currentTimeMillis - 86400000) {
                arrayList.add(c3119a);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void m9699b(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f10290b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !C3127c.m9705a().m9731q()) {
                    return;
                }
            } else if (!C3127c.m9705a().m9730p()) {
                return;
            }
        } else if (!C3127c.m9705a().m9730p()) {
            return;
        }
        if (this.f10356f != null) {
            C3151an.m9921c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f10356f.m9757b(crashDetailBean.f10290b == 1);
        }
    }

    /* renamed from: c */
    public void m9700c(CrashDetailBean crashDetailBean) {
        int i2;
        long j2;
        String str;
        String str2;
        Map<String, String> map;
        int i3;
        byte[] bArr;
        String str3;
        HashMap hashMap;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f10357g == null && this.f10356f == null) {
            return;
        }
        try {
            switch (crashDetailBean.f10290b) {
                case 0:
                    if (C3127c.m9705a().m9730p()) {
                        i2 = 0;
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (C3127c.m9705a().m9730p()) {
                        i2 = 2;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 4;
                    if (!C3127c.m9705a().m9731q()) {
                        return;
                    }
                    break;
                case 4:
                    i2 = 3;
                    if (!C3127c.m9705a().m9732r()) {
                        return;
                    }
                    break;
                case 5:
                    i2 = 5;
                    if (!C3127c.m9705a().m9733s()) {
                        return;
                    }
                    break;
                case 6:
                    i2 = 6;
                    if (!C3127c.m9705a().m9734t()) {
                        return;
                    }
                    break;
                case 7:
                    i2 = 7;
                    break;
                default:
                    return;
            }
            boolean z = crashDetailBean.f10290b == 1;
            String str4 = crashDetailBean.f10302n;
            String str5 = crashDetailBean.f10304p;
            String str6 = crashDetailBean.f10305q;
            long j3 = crashDetailBean.f10306r;
            byte[] bArr2 = null;
            if (this.f10356f != null) {
                C3151an.m9921c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                this.f10356f.m9753a(z);
                C3151an.m9921c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                j2 = j3;
                str = str5;
                str2 = str6;
                String m9756b = this.f10356f.m9756b(z, str4, str5, str6, -1234567890, j2);
                if (m9756b != null) {
                    hashMap = new HashMap(1);
                    hashMap.put(C3773a.f13774h, m9756b);
                } else {
                    hashMap = null;
                }
                map = hashMap;
            } else {
                j2 = j3;
                str = str5;
                str2 = str6;
                if (this.f10357g != null) {
                    C3151an.m9921c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    map = this.f10357g.onCrashHandleStart(i2, crashDetailBean.f10302n, crashDetailBean.f10303o, crashDetailBean.f10305q);
                } else {
                    map = null;
                }
            }
            if (map != null && map.size() > 0) {
                crashDetailBean.f10281P = new LinkedHashMap(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!C3154aq.m9970a(entry.getKey())) {
                        String key = entry.getKey();
                        if (key.length() > 100) {
                            key = key.substring(0, 100);
                            C3151an.m9922d("setted key length is over limit %d substring to %s", 100, key);
                        }
                        if (C3154aq.m9970a(entry.getValue()) || entry.getValue().length() <= 30000) {
                            str3 = "" + entry.getValue();
                        } else {
                            str3 = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
                            C3151an.m9922d("setted %s value length is over limit %d substring", key, Integer.valueOf(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH));
                        }
                        crashDetailBean.f10281P.put(key, str3);
                        C3151an.m9915a("add setted key %s value size:%d", key, Integer.valueOf(str3.length()));
                    }
                }
            }
            C3151an.m9915a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f10356f != null) {
                C3151an.m9921c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                bArr = this.f10356f.m9755a(z, str4, str, str2, -1234567890, j2);
                i3 = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;
            } else {
                i3 = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;
                if (this.f10357g != null) {
                    C3151an.m9921c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                    bArr2 = this.f10357g.onCrashHandleStart2GetExtraDatas(i2, crashDetailBean.f10302n, crashDetailBean.f10303o, crashDetailBean.f10305q);
                }
                bArr = bArr2;
            }
            crashDetailBean.f10286U = bArr;
            if (bArr != null) {
                if (bArr.length > i3) {
                    C3151an.m9922d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), Integer.valueOf(i3));
                    crashDetailBean.f10286U = Arrays.copyOf(bArr, i3);
                }
                C3151an.m9915a("add extra bytes %d ", Integer.valueOf(bArr.length));
            }
            if (this.f10356f != null) {
                C3151an.m9921c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                if (this.f10356f.m9754a(z, str4, crashDetailBean.f10303o, str, str2, -1234567890, j2, crashDetailBean.f10301m, crashDetailBean.f10293e, crashDetailBean.f10291c, crashDetailBean.f10266A, crashDetailBean.f10267B)) {
                    return;
                }
                C3151an.m9922d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
        } catch (Throwable th) {
            C3151an.m9922d("crash handle callback something wrong! %s", th.getClass().getName());
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    protected ContentValues m9702d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f10289a > 0) {
                contentValues.put(C3355bl.f11732d, Long.valueOf(crashDetailBean.f10289a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f10306r));
            contentValues.put("_s1", crashDetailBean.f10309u);
            int i2 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f10292d ? 1 : 0));
            if (!crashDetailBean.f10298j) {
                i2 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i2));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f10300l));
            contentValues.put("_dt", C3154aq.m9973a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public void m9704e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues m9702d = m9702d(crashDetailBean);
        if (m9702d != null) {
            long m9828a = C3142ae.m9817a().m9828a("t_cr", m9702d, (InterfaceC3141ad) null, true);
            if (m9828a >= 0) {
                C3151an.m9921c("insert %s success!", "t_cr");
                crashDetailBean.f10289a = m9828a;
            }
        }
        if (C3127c.f10368i) {
            m9685f(crashDetailBean);
        }
    }

    /* renamed from: b */
    public List<CrashDetailBean> m9698b(List<C3119a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C3355bl.f11732d);
        sb.append(" in ");
        sb.append("(");
        Iterator<C3119a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f10315a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = C3142ae.m9817a().m9829a("t_cr", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append(C3355bl.f11732d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursor.moveToNext()) {
                    try {
                        CrashDetailBean m9686a = m9686a(cursor);
                        if (m9686a != null) {
                            arrayList.add(m9686a);
                        } else {
                            try {
                                sb.append(cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                C3151an.m9922d("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!C3151an.m9916a(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i2 > 0) {
                    C3151an.m9922d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C3142ae.m9817a().m9827a("t_cr", sb3, (String[]) null, (InterfaceC3141ad) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* renamed from: a */
    protected CrashDetailBean m9687a(List<C3119a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> m9698b;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C3119a c3119a : list) {
            if (c3119a.f10319e) {
                arrayList.add(c3119a);
            }
        }
        if (arrayList.size() > 0 && (m9698b = m9698b(arrayList)) != null && m9698b.size() > 0) {
            Collections.sort(m9698b);
            CrashDetailBean crashDetailBean3 = null;
            for (int i2 = 0; i2 < m9698b.size(); i2++) {
                CrashDetailBean crashDetailBean4 = m9698b.get(i2);
                if (i2 == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else {
                    String str = crashDetailBean4.f10307s;
                    if (str != null && (split = str.split("\n")) != null) {
                        for (String str2 : split) {
                            if (!crashDetailBean3.f10307s.contains("" + str2)) {
                                crashDetailBean3.f10308t++;
                                crashDetailBean3.f10307s += str2 + "\n";
                            }
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f10298j = true;
            crashDetailBean.f10308t = 0;
            crashDetailBean.f10307s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (C3119a c3119a2 : list) {
            if (!c3119a2.f10319e && !c3119a2.f10318d) {
                if (!crashDetailBean2.f10307s.contains("" + c3119a2.f10316b)) {
                    crashDetailBean2.f10308t++;
                    crashDetailBean2.f10307s += c3119a2.f10316b + "\n";
                }
            }
        }
        if (crashDetailBean2.f10306r != crashDetailBean.f10306r) {
            if (!crashDetailBean2.f10307s.contains("" + crashDetailBean.f10306r)) {
                crashDetailBean2.f10308t++;
                crashDetailBean2.f10307s += crashDetailBean.f10306r + "\n";
            }
        }
        return crashDetailBean2;
    }

    /* renamed from: d */
    public void m9703d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append(C3355bl.f11732d);
                    sb.append(" = ");
                    sb.append(crashDetailBean.f10289a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                C3151an.m9921c("deleted %s data %d", "t_cr", Integer.valueOf(C3142ae.m9817a().m9827a("t_cr", sb2, (String[]) null, (InterfaceC3141ad) null, true)));
            } catch (Throwable th) {
                if (C3151an.m9916a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean m9694a(CrashDetailBean crashDetailBean) {
        return m9695a(crashDetailBean, -123456789);
    }

    /* renamed from: b */
    protected C3119a m9696b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3119a c3119a = new C3119a();
            c3119a.f10315a = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
            c3119a.f10316b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3119a.f10317c = cursor.getString(cursor.getColumnIndex("_s1"));
            c3119a.f10318d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c3119a.f10319e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c3119a.f10320f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c3119a;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public boolean m9695a(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = C3127c.f10373n;
        if (str != null && !str.isEmpty()) {
            C3151an.m9921c("Crash filter for crash stack is: %s", C3127c.f10373n);
            if (crashDetailBean.f10305q.contains(C3127c.f10373n)) {
                C3151an.m9922d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = C3127c.f10374o;
        if (str2 != null && !str2.isEmpty()) {
            C3151an.m9921c("Crash regular filter for crash stack is: %s", C3127c.f10374o);
            if (Pattern.compile(C3127c.f10374o).matcher(crashDetailBean.f10305q).find()) {
                C3151an.m9922d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f10290b != 2) {
            C3144ag c3144ag = new C3144ag();
            c3144ag.f10506b = 1;
            c3144ag.f10507c = crashDetailBean.f10266A;
            c3144ag.f10508d = crashDetailBean.f10267B;
            c3144ag.f10509e = crashDetailBean.f10306r;
            this.f10354d.m9840b(1);
            this.f10354d.m9837a(c3144ag);
            C3151an.m9918b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C3151an.m9918b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C3119a> m9697b = m9697b();
        ArrayList arrayList = null;
        if (m9697b != null && m9697b.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(m9689a(m9697b));
            m9697b.removeAll(arrayList);
            if (m9697b.size() > 20) {
                m9690a(5);
            }
            if (!C3072b.f9834c && C3127c.f10363d) {
                boolean z = false;
                for (C3119a c3119a : m9697b) {
                    if (crashDetailBean.f10309u.equals(c3119a.f10317c)) {
                        if (c3119a.f10319e) {
                            z = true;
                        }
                        arrayList2.add(c3119a);
                    }
                }
                if (z || arrayList2.size() >= C3127c.f10362c) {
                    C3151an.m9915a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean m9687a = m9687a(arrayList2, crashDetailBean);
                    for (C3119a c3119a2 : arrayList2) {
                        if (c3119a2.f10315a != m9687a.f10289a) {
                            arrayList.add(c3119a2);
                        }
                    }
                    m9704e(m9687a);
                    m9701c(arrayList);
                    C3151an.m9918b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        m9704e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            m9701c(arrayList);
        }
        C3151an.m9918b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: b */
    public List<C3119a> m9697b() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = C3142ae.m9817a().m9829a("t_cr", new String[]{C3355bl.f11732d, "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(C3355bl.f11732d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursor.moveToNext()) {
                    try {
                        C3119a m9696b = m9696b(cursor);
                        if (m9696b != null) {
                            arrayList.add(m9696b);
                        } else {
                            try {
                                sb.append(cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                C3151an.m9922d("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!C3151an.m9916a(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return arrayList;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                StringBuilder sb2 = sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP))) : sb;
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                if (i2 > 0) {
                    C3151an.m9922d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C3142ae.m9817a().m9827a("t_cr", sb3, (String[]) null, (InterfaceC3141ad) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* renamed from: c */
    public void m9701c(List<C3119a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C3355bl.f11732d);
        sb.append(" in ");
        sb.append("(");
        Iterator<C3119a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f10315a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            C3151an.m9921c("deleted %s data %d", "t_cr", Integer.valueOf(C3142ae.m9817a().m9827a("t_cr", sb3, (String[]) null, (InterfaceC3141ad) null, true)));
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public List<CrashDetailBean> m9688a() {
        StrategyBean m9644c = C3116a.m9635a().m9644c();
        if (m9644c == null) {
            C3151an.m9922d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!m9644c.f10230g) {
            C3151an.m9922d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C3151an.m9918b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long m9978b = C3154aq.m9978b();
        List<C3119a> m9697b = m9697b();
        C3151an.m9921c("Size of crash list loaded from DB: %s", Integer.valueOf(m9697b.size()));
        if (m9697b == null || m9697b.size() <= 0) {
            return null;
        }
        List<C3119a> arrayList = new ArrayList<>();
        arrayList.addAll(m9689a(m9697b));
        m9697b.removeAll(arrayList);
        Iterator<C3119a> it = m9697b.iterator();
        while (it.hasNext()) {
            C3119a next = it.next();
            long j2 = next.f10316b;
            if (j2 < m9978b - C3127c.f10366g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f10318d) {
                if (j2 >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f10319e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f10320f >= 3 && j2 < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            m9701c(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> m9698b = m9698b(m9697b);
        if (m9698b != null && m9698b.size() > 0) {
            String str = C3113a.m9532b().f10208p;
            Iterator<CrashDetailBean> it2 = m9698b.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f10294f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            m9703d(arrayList2);
        }
        return m9698b;
    }

    /* renamed from: a */
    public void m9691a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (C3127c.f10371l) {
            C3151an.m9915a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m9692a(arrayList, j2, z, crashDetailBean.f10290b == 7, z);
        }
    }

    /* renamed from: a */
    public void m9692a(final List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        C3148ak c3148ak;
        if (C3113a.m9531a(this.f10352b).f10200h && (c3148ak = this.f10353c) != null) {
            if (z3 || c3148ak.m9896b(C3127c.f10360a)) {
                StrategyBean m9644c = this.f10355e.m9644c();
                if (!m9644c.f10230g) {
                    C3151an.m9922d("remote report is disable!", new Object[0]);
                    C3151an.m9918b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    String str = this.f10353c.f10517b ? m9644c.f10242s : m9644c.f10243t;
                    String str2 = this.f10353c.f10517b ? StrategyBean.f10226c : StrategyBean.f10224a;
                    int i2 = this.f10353c.f10517b ? 830 : 630;
                    C3171bg m9683a = m9683a(this.f10352b, list, C3113a.m9532b());
                    if (m9683a == null) {
                        C3151an.m9922d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] m9854a = C3145ah.m9854a((AbstractC3188m) m9683a);
                    if (m9854a == null) {
                        C3151an.m9922d("send encode fail!", new Object[0]);
                        return;
                    }
                    C3172bh m9849a = C3145ah.m9849a(this.f10352b, i2, m9854a);
                    if (m9849a == null) {
                        C3151an.m9922d("request package is null.", new Object[0]);
                        return;
                    }
                    InterfaceC3147aj interfaceC3147aj = new InterfaceC3147aj() { // from class: com.tencent.bugly.crashreport.crash.b.1
                        @Override // com.tencent.bugly.proguard.InterfaceC3147aj
                        /* renamed from: a */
                        public void mo9370a(int i3) {
                        }

                        @Override // com.tencent.bugly.proguard.InterfaceC3147aj
                        /* renamed from: a */
                        public void mo9371a(int i3, C3173bi c3173bi, long j3, long j4, boolean z4, String str3) {
                            C3126b.this.m9693a(z4, list);
                        }
                    };
                    if (z) {
                        this.f10353c.m9888a(f10351a, m9849a, str, str2, interfaceC3147aj, j2, z2);
                    } else {
                        this.f10353c.m9889a(f10351a, m9849a, str, str2, interfaceC3147aj, false);
                    }
                } catch (Throwable th) {
                    C3151an.m9923e("req cr error %s", th.toString());
                    if (C3151an.m9919b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m9693a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C3151an.m9921c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C3151an.m9921c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f10291c, Integer.valueOf(crashDetailBean.f10300l), Boolean.valueOf(crashDetailBean.f10292d), Boolean.valueOf(crashDetailBean.f10298j));
                crashDetailBean.f10300l++;
                crashDetailBean.f10292d = z;
                C3151an.m9921c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f10291c, Integer.valueOf(crashDetailBean.f10300l), Boolean.valueOf(crashDetailBean.f10292d), Boolean.valueOf(crashDetailBean.f10298j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                C3127c.m9705a().m9712a(it.next());
            }
            C3151an.m9921c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        C3151an.m9918b("[crash] upload fail.", new Object[0]);
    }

    /* renamed from: a */
    protected CrashDetailBean m9686a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(C3355bl.f11732d));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C3154aq.m9951a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f10289a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public void m9690a(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C3355bl.f11732d);
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append(C3355bl.f11732d);
        sb.append(" FROM ");
        sb.append("t_cr");
        sb.append(" order by ");
        sb.append(C3355bl.f11732d);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            C3151an.m9921c("deleted first record %s data %d", "t_cr", Integer.valueOf(C3142ae.m9817a().m9827a("t_cr", sb2, (String[]) null, (InterfaceC3141ad) null, true)));
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C3170bf m9682a(Context context, CrashDetailBean crashDetailBean, C3113a c3113a) {
        C3169be m9681a;
        C3169be m9681a2;
        C3169be c3169be;
        if (context != null && crashDetailBean != null && c3113a != null) {
            C3170bf c3170bf = new C3170bf();
            int i2 = crashDetailBean.f10290b;
            switch (i2) {
                case 0:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "200" : MessageService.MSG_DB_COMPLETE;
                    break;
                case 1:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "201" : "101";
                    break;
                case 2:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "202" : "102";
                    break;
                case 3:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "203" : "103";
                    break;
                case 4:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "204" : "104";
                    break;
                case 5:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "207" : "107";
                    break;
                case 6:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "206" : "106";
                    break;
                case 7:
                    c3170bf.f10636a = crashDetailBean.f10298j ? "208" : "108";
                    break;
                default:
                    C3151an.m9923e("crash type error! %d", Integer.valueOf(i2));
                    break;
            }
            c3170bf.f10637b = crashDetailBean.f10306r;
            c3170bf.f10638c = crashDetailBean.f10302n;
            c3170bf.f10639d = crashDetailBean.f10303o;
            c3170bf.f10640e = crashDetailBean.f10304p;
            c3170bf.f10642g = crashDetailBean.f10305q;
            c3170bf.f10643h = crashDetailBean.f10314z;
            c3170bf.f10644i = crashDetailBean.f10291c;
            c3170bf.f10645j = null;
            c3170bf.f10647l = crashDetailBean.f10301m;
            c3170bf.f10648m = crashDetailBean.f10293e;
            c3170bf.f10641f = crashDetailBean.f10267B;
            c3170bf.f10655t = C3113a.m9532b().m9576i();
            c3170bf.f10649n = null;
            Map<String, PlugInBean> map = crashDetailBean.f10297i;
            if (map != null && map.size() > 0) {
                c3170bf.f10650o = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f10297i.entrySet()) {
                    C3167bc c3167bc = new C3167bc();
                    c3167bc.f10616a = entry.getValue().f10130a;
                    c3167bc.f10618c = entry.getValue().f10132c;
                    c3167bc.f10620e = entry.getValue().f10131b;
                    c3167bc.f10617b = c3113a.m9585r();
                    c3170bf.f10650o.add(c3167bc);
                }
            }
            Map<String, PlugInBean> map2 = crashDetailBean.f10296h;
            if (map2 != null && map2.size() > 0) {
                c3170bf.f10651p = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry2 : crashDetailBean.f10296h.entrySet()) {
                    C3167bc c3167bc2 = new C3167bc();
                    c3167bc2.f10616a = entry2.getValue().f10130a;
                    c3167bc2.f10618c = entry2.getValue().f10132c;
                    c3167bc2.f10620e = entry2.getValue().f10131b;
                    c3170bf.f10651p.add(c3167bc2);
                }
            }
            if (crashDetailBean.f10298j) {
                c3170bf.f10646k = crashDetailBean.f10308t;
                String str = crashDetailBean.f10307s;
                if (str != null && str.length() > 0) {
                    if (c3170bf.f10652q == null) {
                        c3170bf.f10652q = new ArrayList<>();
                    }
                    try {
                        c3170bf.f10652q.add(new C3169be((byte) 1, "alltimes.txt", crashDetailBean.f10307s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        c3170bf.f10652q = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(c3170bf.f10646k);
                ArrayList<C3169be> arrayList = c3170bf.f10652q;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                C3151an.m9921c("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.f10311w != null) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                try {
                    c3170bf.f10652q.add(new C3169be((byte) 1, "log.txt", crashDetailBean.f10311w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    c3170bf.f10652q = null;
                }
            }
            if (crashDetailBean.f10312x != null) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                try {
                    c3170bf.f10652q.add(new C3169be((byte) 1, "jniLog.txt", crashDetailBean.f10312x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    c3170bf.f10652q = null;
                }
            }
            if (!C3154aq.m9970a(crashDetailBean.f10287V)) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                try {
                    c3169be = new C3169be((byte) 1, "crashInfos.txt", crashDetailBean.f10287V.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    c3169be = null;
                }
                if (c3169be != null) {
                    C3151an.m9921c("attach crash infos", new Object[0]);
                    c3170bf.f10652q.add(c3169be);
                }
            }
            if (crashDetailBean.f10288W != null) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                C3169be m9681a3 = m9681a("backupRecord.zip", context, crashDetailBean.f10288W);
                if (m9681a3 != null) {
                    C3151an.m9921c("attach backup record", new Object[0]);
                    c3170bf.f10652q.add(m9681a3);
                }
            }
            byte[] bArr = crashDetailBean.f10313y;
            if (bArr != null && bArr.length > 0) {
                C3169be c3169be2 = new C3169be((byte) 2, "buglylog.zip", bArr);
                C3151an.m9921c("attach user log", new Object[0]);
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                c3170bf.f10652q.add(c3169be2);
            }
            if (crashDetailBean.f10290b == 3) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                C3151an.m9921c("crashBean.userDatas:%s", crashDetailBean.f10281P);
                Map<String, String> map3 = crashDetailBean.f10281P;
                if (map3 != null && map3.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.f10281P.get("BUGLY_CR_01"))) {
                            c3170bf.f10652q.add(new C3169be((byte) 1, "anrMessage.txt", crashDetailBean.f10281P.get("BUGLY_CR_01").getBytes("utf-8")));
                            C3151an.m9921c("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                        c3170bf.f10652q = null;
                    }
                    crashDetailBean.f10281P.remove("BUGLY_CR_01");
                }
                String str2 = crashDetailBean.f10310v;
                if (str2 != null && (m9681a2 = m9681a("trace.zip", context, str2)) != null) {
                    C3151an.m9921c("attach traces", new Object[0]);
                    c3170bf.f10652q.add(m9681a2);
                }
            }
            if (crashDetailBean.f10290b == 1) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                String str3 = crashDetailBean.f10310v;
                if (str3 != null && (m9681a = m9681a("tomb.zip", context, str3)) != null) {
                    C3151an.m9921c("attach tombs", new Object[0]);
                    c3170bf.f10652q.add(m9681a);
                }
            }
            List<String> list = c3113a.f10146M;
            if (list != null && !list.isEmpty()) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = c3113a.f10146M.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                try {
                    c3170bf.f10652q.add(new C3169be((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                    C3151an.m9921c("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e7) {
                    e7.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.f10286U;
            if (bArr2 != null && bArr2.length > 0) {
                if (c3170bf.f10652q == null) {
                    c3170bf.f10652q = new ArrayList<>();
                }
                c3170bf.f10652q.add(new C3169be((byte) 1, "userExtraByteData", crashDetailBean.f10286U));
                C3151an.m9921c("attach extraData", new Object[0]);
            }
            c3170bf.f10653r = new HashMap();
            c3170bf.f10653r.put("A9", "" + crashDetailBean.f10268C);
            c3170bf.f10653r.put("A11", "" + crashDetailBean.f10269D);
            c3170bf.f10653r.put("A10", "" + crashDetailBean.f10270E);
            c3170bf.f10653r.put("A23", "" + crashDetailBean.f10294f);
            c3170bf.f10653r.put("A7", "" + c3113a.f10204l);
            c3170bf.f10653r.put("A6", "" + c3113a.m9586s());
            c3170bf.f10653r.put("A5", "" + c3113a.m9585r());
            c3170bf.f10653r.put("A22", "" + c3113a.m9575h());
            c3170bf.f10653r.put("A2", "" + crashDetailBean.f10272G);
            c3170bf.f10653r.put("A1", "" + crashDetailBean.f10271F);
            c3170bf.f10653r.put("A24", "" + c3113a.f10206n);
            c3170bf.f10653r.put("A17", "" + crashDetailBean.f10273H);
            c3170bf.f10653r.put("A3", "" + c3113a.m9578k());
            c3170bf.f10653r.put("A16", "" + c3113a.m9580m());
            c3170bf.f10653r.put("A25", "" + c3113a.m9581n());
            c3170bf.f10653r.put("A14", "" + c3113a.m9579l());
            c3170bf.f10653r.put("A15", "" + c3113a.m9590w());
            c3170bf.f10653r.put("A13", "" + c3113a.m9591x());
            c3170bf.f10653r.put("A34", "" + crashDetailBean.f10266A);
            if (c3113a.f10138E != null) {
                c3170bf.f10653r.put("productIdentify", "" + c3113a.f10138E);
            }
            try {
                c3170bf.f10653r.put("A26", "" + URLEncoder.encode(crashDetailBean.f10274I, "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            if (crashDetailBean.f10290b == 1) {
                c3170bf.f10653r.put("A27", "" + crashDetailBean.f10277L);
                c3170bf.f10653r.put("A28", "" + crashDetailBean.f10276K);
                c3170bf.f10653r.put("A29", "" + crashDetailBean.f10299k);
            }
            c3170bf.f10653r.put("A30", "" + crashDetailBean.f10278M);
            c3170bf.f10653r.put("A18", "" + crashDetailBean.f10279N);
            Map<String, String> map4 = c3170bf.f10653r;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(!crashDetailBean.f10280O);
            map4.put("A36", sb2.toString());
            c3170bf.f10653r.put("F02", "" + c3113a.f10216x);
            c3170bf.f10653r.put("F03", "" + c3113a.f10217y);
            c3170bf.f10653r.put("F04", "" + c3113a.m9569e());
            c3170bf.f10653r.put("F05", "" + c3113a.f10218z);
            c3170bf.f10653r.put("F06", "" + c3113a.f10215w);
            c3170bf.f10653r.put("F08", "" + c3113a.f10136C);
            c3170bf.f10653r.put("F09", "" + c3113a.f10137D);
            c3170bf.f10653r.put("F10", "" + c3113a.f10134A);
            if (crashDetailBean.f10282Q >= 0) {
                c3170bf.f10653r.put("C01", "" + crashDetailBean.f10282Q);
            }
            if (crashDetailBean.f10283R >= 0) {
                c3170bf.f10653r.put("C02", "" + crashDetailBean.f10283R);
            }
            Map<String, String> map5 = crashDetailBean.f10284S;
            if (map5 != null && map5.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.f10284S.entrySet()) {
                    c3170bf.f10653r.put("C03_" + entry3.getKey(), entry3.getValue());
                }
            }
            Map<String, String> map6 = crashDetailBean.f10285T;
            if (map6 != null && map6.size() > 0) {
                for (Map.Entry<String, String> entry4 : crashDetailBean.f10285T.entrySet()) {
                    c3170bf.f10653r.put("C04_" + entry4.getKey(), entry4.getValue());
                }
            }
            c3170bf.f10654s = null;
            Map<String, String> map7 = crashDetailBean.f10281P;
            if (map7 != null && map7.size() > 0) {
                c3170bf.f10654s = crashDetailBean.f10281P;
                C3151an.m9915a("setted message size %d", Integer.valueOf(c3170bf.f10654s.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.f10302n;
            objArr2[1] = crashDetailBean.f10291c;
            objArr2[2] = c3113a.m9569e();
            objArr2[3] = Long.valueOf((crashDetailBean.f10306r - crashDetailBean.f10279N) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.f10299k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.f10280O);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f10298j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f10290b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.f10308t);
            objArr2[9] = crashDetailBean.f10307s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f10292d);
            objArr2[11] = Integer.valueOf(c3170bf.f10653r.size());
            C3151an.m9921c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return c3170bf;
        }
        C3151an.m9922d("enExp args == null", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static C3171bg m9683a(Context context, List<CrashDetailBean> list, C3113a c3113a) {
        if (context != null && list != null && list.size() != 0 && c3113a != null) {
            C3171bg c3171bg = new C3171bg();
            c3171bg.f10658a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c3171bg.f10658a.add(m9682a(context, it.next(), c3113a));
            }
            return c3171bg;
        }
        C3151an.m9922d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static C3169be m9681a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            C3151an.m9921c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!C3154aq.m9968a(file, file2, 5000)) {
                C3151an.m9922d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C3151an.m9921c("read bytes :%d", Integer.valueOf(byteArray.length));
                C3169be c3169be = new C3169be((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!C3151an.m9916a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    C3151an.m9921c("del tmp", new Object[0]);
                    file2.delete();
                }
                return c3169be;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!C3151an.m9916a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C3151an.m9921c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            if (!C3151an.m9916a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C3151an.m9921c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        C3151an.m9922d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static void m9684a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C3113a m9532b = C3113a.m9532b();
        if (m9532b == null) {
            return;
        }
        C3151an.m9923e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C3151an.m9923e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C3151an.m9923e("# PKG NAME: %s", m9532b.f10196d);
        C3151an.m9923e("# APP VER: %s", m9532b.f10208p);
        C3151an.m9923e("# SDK VER: %s", m9532b.f10202j);
        C3151an.m9923e("# LAUNCH TIME: %s", C3154aq.m9958a(new Date(C3113a.m9532b().f10160a)));
        C3151an.m9923e("# CRASH TYPE: %s", str);
        C3151an.m9923e("# CRASH TIME: %s", str2);
        C3151an.m9923e("# CRASH PROCESS: %s", str3);
        C3151an.m9923e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C3151an.m9923e("# REPORT ID: %s", crashDetailBean.f10291c);
            Object[] objArr = new Object[2];
            objArr[0] = m9532b.f10205m;
            objArr[1] = m9532b.m9591x().booleanValue() ? "ROOTED" : "UNROOT";
            C3151an.m9923e("# CRASH DEVICE: %s %s", objArr);
            C3151an.m9923e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f10268C), Long.valueOf(crashDetailBean.f10269D), Long.valueOf(crashDetailBean.f10270E));
            C3151an.m9923e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f10271F), Long.valueOf(crashDetailBean.f10272G), Long.valueOf(crashDetailBean.f10273H));
            if (!C3154aq.m9970a(crashDetailBean.f10277L)) {
                C3151an.m9923e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f10277L, crashDetailBean.f10276K);
            } else if (crashDetailBean.f10290b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.f10281P == null) {
                    str6 = AbstractC1191a.f2571h;
                } else {
                    str6 = "" + crashDetailBean.f10281P.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                C3151an.m9923e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!C3154aq.m9970a(str5)) {
            C3151an.m9923e("# CRASH STACK: ", new Object[0]);
            C3151an.m9923e(str5, new Object[0]);
        }
        C3151an.m9923e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
