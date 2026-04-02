package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bf;
import com.tencent.bugly.proguard.bg;
import com.tencent.bugly.proguard.bh;
import com.tencent.bugly.proguard.bi;
import com.tencent.bugly.proguard.m;
import com.umeng.analytics.pro.bl;
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

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a;

    /* JADX INFO: renamed from: b */
    protected final Context f6257b;

    /* JADX INFO: renamed from: c */
    protected final ak f6258c;

    /* JADX INFO: renamed from: d */
    protected final ae f6259d;

    /* JADX INFO: renamed from: e */
    protected final com.tencent.bugly.crashreport.common.strategy.a f6260e;

    /* JADX INFO: renamed from: f */
    protected f f6261f;

    /* JADX INFO: renamed from: g */
    protected BuglyStrategy.a f6262g;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.crash.b$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements aj {
        final /* synthetic */ List a;

        AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.tencent.bugly.proguard.aj
        public void a(int i2) {
        }

        @Override // com.tencent.bugly.proguard.aj
        public void a(int i2, bi biVar, long j2, long j3, boolean z, String str) {
            b.this.a(z, list);
        }
    }

    public b(int i2, Context context, ak akVar, ae aeVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, f fVar) {
        a = i2;
        this.f6257b = context;
        this.f6258c = akVar;
        this.f6259d = aeVar;
        this.f6260e = aVar;
        this.f6262g = aVar2;
        this.f6261f = fVar;
    }

    private boolean f(CrashDetailBean crashDetailBean) {
        try {
            an.c("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            String str = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", aVarB.f(), aVarB.p, aVarB.f6181j, crashDetailBean.A, aq.a(new Date(crashDetailBean.r)), crashDetailBean.f6228n, crashDetailBean.o, crashDetailBean.q, crashDetailBean.f6217c);
            String absolutePath = null;
            if (c.f6272j != null) {
                File file = new File(c.f6272j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f6257b.getPackageName();
            }
            aq.a(this.f6257b, absolutePath + "/euplog.txt", str, c.f6273k);
            return true;
        } catch (Throwable th) {
            an.d("rqdp{  save error} %s", th.toString());
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    protected List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.f6231d && aVar.f6229b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void b(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f6216b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !c.a().q()) {
                    return;
                }
            } else if (!c.a().p()) {
                return;
            }
        } else if (!c.a().p()) {
            return;
        }
        if (this.f6261f != null) {
            an.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f6261f.b(crashDetailBean.f6216b == 1);
        }
    }

    public void c(CrashDetailBean crashDetailBean) {
        int i2;
        long j2;
        String str;
        String str2;
        Map<String, String> mapOnCrashHandleStart;
        int i3;
        byte[] bArrA;
        String strSubstring;
        HashMap map;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f6262g == null && this.f6261f == null) {
            return;
        }
        try {
            switch (crashDetailBean.f6216b) {
                case 0:
                    if (!c.a().p()) {
                        return;
                    } else {
                        i2 = 0;
                    }
                    break;
                case 1:
                    if (!c.a().p()) {
                        return;
                    } else {
                        i2 = 2;
                    }
                    break;
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 4;
                    if (!c.a().q()) {
                        return;
                    }
                    break;
                case 4:
                    i2 = 3;
                    if (!c.a().r()) {
                        return;
                    }
                    break;
                case 5:
                    i2 = 5;
                    if (!c.a().s()) {
                        return;
                    }
                    break;
                case 6:
                    i2 = 6;
                    if (!c.a().t()) {
                        return;
                    }
                    break;
                case 7:
                    i2 = 7;
                    break;
                default:
                    return;
            }
            boolean z = crashDetailBean.f6216b == 1;
            String str3 = crashDetailBean.f6228n;
            String str4 = crashDetailBean.p;
            String str5 = crashDetailBean.q;
            long j3 = crashDetailBean.r;
            byte[] bArrOnCrashHandleStart2GetExtraDatas = null;
            if (this.f6261f != null) {
                an.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                this.f6261f.a(z);
                an.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                j2 = j3;
                str = str4;
                str2 = str5;
                String strB = this.f6261f.b(z, str3, str4, str5, -1234567890, j2);
                if (strB != null) {
                    map = new HashMap(1);
                    map.put(com.umeng.socialize.tracker.a.f8370h, strB);
                } else {
                    map = null;
                }
                mapOnCrashHandleStart = map;
            } else {
                j2 = j3;
                str = str4;
                str2 = str5;
                if (this.f6262g != null) {
                    an.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    mapOnCrashHandleStart = this.f6262g.onCrashHandleStart(i2, crashDetailBean.f6228n, crashDetailBean.o, crashDetailBean.q);
                } else {
                    mapOnCrashHandleStart = null;
                }
            }
            if (mapOnCrashHandleStart != null && mapOnCrashHandleStart.size() > 0) {
                crashDetailBean.P = new LinkedHashMap(mapOnCrashHandleStart.size());
                for (Map.Entry<String, String> entry : mapOnCrashHandleStart.entrySet()) {
                    if (!aq.a(entry.getKey())) {
                        String key = entry.getKey();
                        if (key.length() > 100) {
                            key = key.substring(0, 100);
                            an.d("setted key length is over limit %d substring to %s", 100, key);
                        }
                        if (aq.a(entry.getValue()) || entry.getValue().length() <= 30000) {
                            strSubstring = "" + entry.getValue();
                        } else {
                            strSubstring = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            an.d("setted %s value length is over limit %d substring", key, Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                        }
                        crashDetailBean.P.put(key, strSubstring);
                        an.a("add setted key %s value size:%d", key, Integer.valueOf(strSubstring.length()));
                    }
                }
            }
            an.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f6261f != null) {
                an.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                bArrA = this.f6261f.a(z, str3, str, str2, -1234567890, j2);
                i3 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            } else {
                i3 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                if (this.f6262g != null) {
                    an.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                    bArrOnCrashHandleStart2GetExtraDatas = this.f6262g.onCrashHandleStart2GetExtraDatas(i2, crashDetailBean.f6228n, crashDetailBean.o, crashDetailBean.q);
                }
                bArrA = bArrOnCrashHandleStart2GetExtraDatas;
            }
            crashDetailBean.U = bArrA;
            if (bArrA != null) {
                if (bArrA.length > i3) {
                    an.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArrA.length), Integer.valueOf(i3));
                    crashDetailBean.U = Arrays.copyOf(bArrA, i3);
                }
                an.a("add extra bytes %d ", Integer.valueOf(bArrA.length));
            }
            if (this.f6261f != null) {
                an.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                if (this.f6261f.a(z, str3, crashDetailBean.o, str, str2, -1234567890, j2, crashDetailBean.f6227m, crashDetailBean.f6219e, crashDetailBean.f6217c, crashDetailBean.A, crashDetailBean.B)) {
                    return;
                }
                an.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
        } catch (Throwable th) {
            an.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected ContentValues d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.a > 0) {
                contentValues.put(bl.f7101d, Long.valueOf(crashDetailBean.a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            int i2 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f6218d ? 1 : 0));
            if (!crashDetailBean.f6224j) {
                i2 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i2));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f6226l));
            contentValues.put("_dt", aq.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesD = d(crashDetailBean);
        if (contentValuesD != null) {
            long jA = ae.a().a("t_cr", contentValuesD, (ad) null, true);
            if (jA >= 0) {
                an.c("insert %s success!", "t_cr");
                crashDetailBean.a = jA;
            }
        }
        if (c.f6271i) {
            f(crashDetailBean);
        }
    }

    public List<CrashDetailBean> b(List<a> list) {
        Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f7101d);
        sb.append(" in ");
        sb.append("(");
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        }
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            cursorA = ae.a().a("t_cr", null, string, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append(bl.f7101d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursorA.moveToNext()) {
                    try {
                        CrashDetailBean crashDetailBeanA = a(cursorA);
                        if (crashDetailBeanA != null) {
                            arrayList.add(crashDetailBeanA);
                        } else {
                            try {
                                sb.append(cursorA.getLong(cursorA.getColumnIndex(bl.f7101d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                an.d("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return null;
                        } finally {
                            if (cursorA != null) {
                                cursorA.close();
                            }
                        }
                    }
                }
                if (sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
                sb.append(")");
                String string2 = sb.toString();
                if (i2 > 0) {
                    an.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string2, (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    protected CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> listB;
        String[] strArrSplit;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.f6232e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (listB = b(arrayList)) != null && listB.size() > 0) {
            Collections.sort(listB);
            CrashDetailBean crashDetailBean3 = null;
            for (int i2 = 0; i2 < listB.size(); i2++) {
                CrashDetailBean crashDetailBean4 = listB.get(i2);
                if (i2 == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else {
                    String str = crashDetailBean4.s;
                    if (str != null && (strArrSplit = str.split("\n")) != null) {
                        for (String str2 : strArrSplit) {
                            if (!crashDetailBean3.s.contains("" + str2)) {
                                crashDetailBean3.t++;
                                crashDetailBean3.s += str2 + "\n";
                            }
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f6224j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!aVar2.f6232e && !aVar2.f6231d) {
                if (!crashDetailBean2.s.contains("" + aVar2.f6229b)) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += aVar2.f6229b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            if (!crashDetailBean2.s.contains("" + crashDetailBean.r)) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append(bl.f7101d);
                    sb.append(" = ");
                    sb.append(crashDetailBean.a);
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    string = string.substring(4);
                }
                sb.setLength(0);
                an.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    protected a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.a = cursor.getLong(cursor.getColumnIndex(bl.f7101d));
            aVar.f6229b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f6230c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.f6231d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.f6232e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f6233f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean a(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = c.f6276n;
        if (str != null && !str.isEmpty()) {
            an.c("Crash filter for crash stack is: %s", c.f6276n);
            if (crashDetailBean.q.contains(c.f6276n)) {
                an.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = c.o;
        if (str2 != null && !str2.isEmpty()) {
            an.c("Crash regular filter for crash stack is: %s", c.o);
            if (Pattern.compile(c.o).matcher(crashDetailBean.q).find()) {
                an.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f6216b != 2) {
            ag agVar = new ag();
            agVar.f6368b = 1;
            agVar.f6369c = crashDetailBean.A;
            agVar.f6370d = crashDetailBean.B;
            agVar.f6371e = crashDetailBean.r;
            this.f6259d.b(1);
            this.f6259d.a(agVar);
            an.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            an.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> listB = b();
        ArrayList arrayList = null;
        if (listB != null && listB.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(a(listB));
            listB.removeAll(arrayList);
            if (listB.size() > 20) {
                a(5);
            }
            if (!com.tencent.bugly.b.f5995c && c.f6266d) {
                boolean z = false;
                for (a aVar : listB) {
                    if (crashDetailBean.u.equals(aVar.f6230c)) {
                        if (aVar.f6232e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= c.f6265c) {
                    an.a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean crashDetailBeanA = a(arrayList2, crashDetailBean);
                    for (a aVar2 : arrayList2) {
                        if (aVar2.a != crashDetailBeanA.a) {
                            arrayList.add(aVar2);
                        }
                    }
                    e(crashDetailBeanA);
                    c(arrayList);
                    an.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        an.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public List<a> b() {
        Cursor cursorA;
        ArrayList arrayList = new ArrayList();
        try {
            cursorA = ae.a().a("t_cr", new String[]{bl.f7101d, "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (cursorA == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(bl.f7101d);
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursorA.moveToNext()) {
                    try {
                        a aVarB = b(cursorA);
                        if (aVarB != null) {
                            arrayList.add(aVarB);
                        } else {
                            try {
                                sb.append(cursorA.getLong(cursorA.getColumnIndex(bl.f7101d)));
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                i2++;
                            } catch (Throwable unused) {
                                an.d("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return arrayList;
                        } finally {
                            if (cursorA != null) {
                                cursorA.close();
                            }
                        }
                    }
                }
                StringBuilder sb2 = sb.toString().contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP))) : sb;
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                if (i2 > 0) {
                    an.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorA = null;
        }
    }

    public void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f7101d);
        sb.append(" in ");
        sb.append("(");
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        sb2.append(")");
        String string = sb2.toString();
        sb2.setLength(0);
        try {
            an.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public List<CrashDetailBean> a() {
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (strategyBeanC == null) {
            an.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanC.f6195g) {
            an.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            an.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = aq.b();
        List<a> listB = b();
        an.c("Size of crash list loaded from DB: %s", Integer.valueOf(listB.size()));
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        List<a> arrayList = new ArrayList<>();
        arrayList.addAll(a(listB));
        listB.removeAll(arrayList);
        Iterator<a> it = listB.iterator();
        while (it.hasNext()) {
            a next = it.next();
            long j2 = next.f6229b;
            if (j2 < jB - c.f6269g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f6231d) {
                if (j2 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f6232e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f6233f >= 3 && j2 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> listB2 = b(listB);
        if (listB2 != null && listB2.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.b().p;
            Iterator<CrashDetailBean> it2 = listB2.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f6220f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return listB2;
    }

    public void a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (c.f6274l) {
            an.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, j2, z, crashDetailBean.f6216b == 7, z);
        }
    }

    public void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        ak akVar;
        if (com.tencent.bugly.crashreport.common.info.a.a(this.f6257b).f6179h && (akVar = this.f6258c) != null) {
            if (z3 || akVar.b(c.a)) {
                StrategyBean strategyBeanC = this.f6260e.c();
                if (!strategyBeanC.f6195g) {
                    an.d("remote report is disable!", new Object[0]);
                    an.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
                    return;
                }
                if (list == null || list.size() == 0) {
                    return;
                }
                try {
                    String str = this.f6258c.f6377b ? strategyBeanC.s : strategyBeanC.t;
                    String str2 = this.f6258c.f6377b ? StrategyBean.f6191c : StrategyBean.a;
                    int i2 = this.f6258c.f6377b ? 830 : 630;
                    bg bgVarA = a(this.f6257b, list, com.tencent.bugly.crashreport.common.info.a.b());
                    if (bgVarA == null) {
                        an.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] bArrA = ah.a((m) bgVarA);
                    if (bArrA == null) {
                        an.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bh bhVarA = ah.a(this.f6257b, i2, bArrA);
                    if (bhVarA == null) {
                        an.d("request package is null.", new Object[0]);
                        return;
                    }
                    AnonymousClass1 anonymousClass1 = new aj() { // from class: com.tencent.bugly.crashreport.crash.b.1
                        final /* synthetic */ List a;

                        AnonymousClass1(List list2) {
                            list = list2;
                        }

                        @Override // com.tencent.bugly.proguard.aj
                        public void a(int i22) {
                        }

                        @Override // com.tencent.bugly.proguard.aj
                        public void a(int i22, bi biVar, long j22, long j3, boolean z4, String str3) {
                            b.this.a(z4, list);
                        }
                    };
                    if (z) {
                        this.f6258c.a(a, bhVarA, str, str2, anonymousClass1, j2, z2);
                    } else {
                        this.f6258c.a(a, bhVarA, str, str2, anonymousClass1, false);
                    }
                } catch (Throwable th) {
                    an.e("req cr error %s", th.toString());
                    if (an.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            an.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                an.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f6217c, Integer.valueOf(crashDetailBean.f6226l), Boolean.valueOf(crashDetailBean.f6218d), Boolean.valueOf(crashDetailBean.f6224j));
                crashDetailBean.f6226l++;
                crashDetailBean.f6218d = z;
                an.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f6217c, Integer.valueOf(crashDetailBean.f6226l), Boolean.valueOf(crashDetailBean.f6218d), Boolean.valueOf(crashDetailBean.f6224j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c.a().a(it.next());
            }
            an.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        an.b("[crash] upload fail.", new Object[0]);
    }

    protected CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex(bl.f7101d));
            CrashDetailBean crashDetailBean = (CrashDetailBean) aq.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bl.f7101d);
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append(bl.f7101d);
        sb.append(" FROM ");
        sb.append("t_cr");
        sb.append(" order by ");
        sb.append(bl.f7101d);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            an.c("deleted first record %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", string, (String[]) null, (ad) null, true)));
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static bf a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        be beVarA;
        be beVarA2;
        be beVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            bf bfVar = new bf();
            int i2 = crashDetailBean.f6216b;
            switch (i2) {
                case 0:
                    bfVar.a = crashDetailBean.f6224j ? "200" : MessageService.MSG_DB_COMPLETE;
                    break;
                case 1:
                    bfVar.a = crashDetailBean.f6224j ? "201" : "101";
                    break;
                case 2:
                    bfVar.a = crashDetailBean.f6224j ? "202" : "102";
                    break;
                case 3:
                    bfVar.a = crashDetailBean.f6224j ? "203" : "103";
                    break;
                case 4:
                    bfVar.a = crashDetailBean.f6224j ? "204" : "104";
                    break;
                case 5:
                    bfVar.a = crashDetailBean.f6224j ? "207" : "107";
                    break;
                case 6:
                    bfVar.a = crashDetailBean.f6224j ? "206" : "106";
                    break;
                case 7:
                    bfVar.a = crashDetailBean.f6224j ? "208" : "108";
                    break;
                default:
                    an.e("crash type error! %d", Integer.valueOf(i2));
                    break;
            }
            bfVar.f6451b = crashDetailBean.r;
            bfVar.f6452c = crashDetailBean.f6228n;
            bfVar.f6453d = crashDetailBean.o;
            bfVar.f6454e = crashDetailBean.p;
            bfVar.f6456g = crashDetailBean.q;
            bfVar.f6457h = crashDetailBean.z;
            bfVar.f6458i = crashDetailBean.f6217c;
            bfVar.f6459j = null;
            bfVar.f6461l = crashDetailBean.f6227m;
            bfVar.f6462m = crashDetailBean.f6219e;
            bfVar.f6455f = crashDetailBean.B;
            bfVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
            bfVar.f6463n = null;
            Map<String, PlugInBean> map = crashDetailBean.f6223i;
            if (map != null && map.size() > 0) {
                bfVar.o = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f6223i.entrySet()) {
                    bc bcVar = new bc();
                    bcVar.a = entry.getValue().a;
                    bcVar.f6443c = entry.getValue().f6172c;
                    bcVar.f6445e = entry.getValue().f6171b;
                    bcVar.f6442b = aVar.r();
                    bfVar.o.add(bcVar);
                }
            }
            Map<String, PlugInBean> map2 = crashDetailBean.f6222h;
            if (map2 != null && map2.size() > 0) {
                bfVar.p = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry2 : crashDetailBean.f6222h.entrySet()) {
                    bc bcVar2 = new bc();
                    bcVar2.a = entry2.getValue().a;
                    bcVar2.f6443c = entry2.getValue().f6172c;
                    bcVar2.f6445e = entry2.getValue().f6171b;
                    bfVar.p.add(bcVar2);
                }
            }
            if (crashDetailBean.f6224j) {
                bfVar.f6460k = crashDetailBean.t;
                String str = crashDetailBean.s;
                if (str != null && str.length() > 0) {
                    if (bfVar.q == null) {
                        bfVar.q = new ArrayList<>();
                    }
                    try {
                        bfVar.q.add(new be((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        bfVar.q = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bfVar.f6460k);
                ArrayList<be> arrayList = bfVar.q;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                an.c("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.w != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    bfVar.q.add(new be((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    bfVar.q = null;
                }
            }
            if (crashDetailBean.x != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    bfVar.q.add(new be((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    bfVar.q = null;
                }
            }
            if (!aq.a(crashDetailBean.V)) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                try {
                    beVar = new be((byte) 1, "crashInfos.txt", crashDetailBean.V.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    beVar = null;
                }
                if (beVar != null) {
                    an.c("attach crash infos", new Object[0]);
                    bfVar.q.add(beVar);
                }
            }
            if (crashDetailBean.W != null) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                be beVarA3 = a("backupRecord.zip", context, crashDetailBean.W);
                if (beVarA3 != null) {
                    an.c("attach backup record", new Object[0]);
                    bfVar.q.add(beVarA3);
                }
            }
            byte[] bArr = crashDetailBean.y;
            if (bArr != null && bArr.length > 0) {
                be beVar2 = new be((byte) 2, "buglylog.zip", bArr);
                an.c("attach user log", new Object[0]);
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                bfVar.q.add(beVar2);
            }
            if (crashDetailBean.f6216b == 3) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                an.c("crashBean.userDatas:%s", crashDetailBean.P);
                Map<String, String> map3 = crashDetailBean.P;
                if (map3 != null && map3.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.P.get("BUGLY_CR_01"))) {
                            bfVar.q.add(new be((byte) 1, "anrMessage.txt", crashDetailBean.P.get("BUGLY_CR_01").getBytes("utf-8")));
                            an.c("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                        bfVar.q = null;
                    }
                    crashDetailBean.P.remove("BUGLY_CR_01");
                }
                String str2 = crashDetailBean.v;
                if (str2 != null && (beVarA2 = a("trace.zip", context, str2)) != null) {
                    an.c("attach traces", new Object[0]);
                    bfVar.q.add(beVarA2);
                }
            }
            if (crashDetailBean.f6216b == 1) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                String str3 = crashDetailBean.v;
                if (str3 != null && (beVarA = a("tomb.zip", context, str3)) != null) {
                    an.c("attach tombs", new Object[0]);
                    bfVar.q.add(beVarA);
                }
            }
            List<String> list = aVar.M;
            if (list != null && !list.isEmpty()) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = aVar.M.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                try {
                    bfVar.q.add(new be((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                    an.c("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e7) {
                    e7.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.U;
            if (bArr2 != null && bArr2.length > 0) {
                if (bfVar.q == null) {
                    bfVar.q = new ArrayList<>();
                }
                bfVar.q.add(new be((byte) 1, "userExtraByteData", crashDetailBean.U));
                an.c("attach extraData", new Object[0]);
            }
            bfVar.r = new HashMap();
            bfVar.r.put("A9", "" + crashDetailBean.C);
            bfVar.r.put("A11", "" + crashDetailBean.D);
            bfVar.r.put("A10", "" + crashDetailBean.E);
            bfVar.r.put("A23", "" + crashDetailBean.f6220f);
            bfVar.r.put("A7", "" + aVar.f6183l);
            bfVar.r.put("A6", "" + aVar.s());
            bfVar.r.put("A5", "" + aVar.r());
            bfVar.r.put("A22", "" + aVar.h());
            bfVar.r.put("A2", "" + crashDetailBean.G);
            bfVar.r.put("A1", "" + crashDetailBean.F);
            bfVar.r.put("A24", "" + aVar.f6185n);
            bfVar.r.put("A17", "" + crashDetailBean.H);
            bfVar.r.put("A3", "" + aVar.k());
            bfVar.r.put("A16", "" + aVar.m());
            bfVar.r.put("A25", "" + aVar.n());
            bfVar.r.put("A14", "" + aVar.l());
            bfVar.r.put("A15", "" + aVar.w());
            bfVar.r.put("A13", "" + aVar.x());
            bfVar.r.put("A34", "" + crashDetailBean.A);
            if (aVar.E != null) {
                bfVar.r.put("productIdentify", "" + aVar.E);
            }
            try {
                bfVar.r.put("A26", "" + URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            if (crashDetailBean.f6216b == 1) {
                bfVar.r.put("A27", "" + crashDetailBean.L);
                bfVar.r.put("A28", "" + crashDetailBean.K);
                bfVar.r.put("A29", "" + crashDetailBean.f6225k);
            }
            bfVar.r.put("A30", "" + crashDetailBean.M);
            bfVar.r.put("A18", "" + crashDetailBean.N);
            Map<String, String> map4 = bfVar.r;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(!crashDetailBean.O);
            map4.put("A36", sb2.toString());
            bfVar.r.put("F02", "" + aVar.x);
            bfVar.r.put("F03", "" + aVar.y);
            bfVar.r.put("F04", "" + aVar.e());
            bfVar.r.put("F05", "" + aVar.z);
            bfVar.r.put("F06", "" + aVar.w);
            bfVar.r.put("F08", "" + aVar.C);
            bfVar.r.put("F09", "" + aVar.D);
            bfVar.r.put("F10", "" + aVar.A);
            if (crashDetailBean.Q >= 0) {
                bfVar.r.put("C01", "" + crashDetailBean.Q);
            }
            if (crashDetailBean.R >= 0) {
                bfVar.r.put("C02", "" + crashDetailBean.R);
            }
            Map<String, String> map5 = crashDetailBean.S;
            if (map5 != null && map5.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.S.entrySet()) {
                    bfVar.r.put("C03_" + entry3.getKey(), entry3.getValue());
                }
            }
            Map<String, String> map6 = crashDetailBean.T;
            if (map6 != null && map6.size() > 0) {
                for (Map.Entry<String, String> entry4 : crashDetailBean.T.entrySet()) {
                    bfVar.r.put("C04_" + entry4.getKey(), entry4.getValue());
                }
            }
            bfVar.s = null;
            Map<String, String> map7 = crashDetailBean.P;
            if (map7 != null && map7.size() > 0) {
                bfVar.s = crashDetailBean.P;
                an.a("setted message size %d", Integer.valueOf(bfVar.s.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.f6228n;
            objArr2[1] = crashDetailBean.f6217c;
            objArr2[2] = aVar.e();
            objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.N) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.f6225k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.O);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f6224j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f6216b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.t);
            objArr2[9] = crashDetailBean.s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f6218d);
            objArr2[11] = Integer.valueOf(bfVar.r.size());
            an.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return bfVar;
        }
        an.d("enExp args == null", new Object[0]);
        return null;
    }

    public static bg a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (context != null && list != null && list.size() != 0 && aVar != null) {
            bg bgVar = new bg();
            bgVar.a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                bgVar.a.add(a(context, it.next(), aVar));
            }
            return bgVar;
        }
        an.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    public static be a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            an.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!aq.a(file, file2, 5000)) {
                an.d("zip fail!", new Object[0]);
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
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                an.c("read bytes :%d", Integer.valueOf(byteArray.length));
                be beVar = new be((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!an.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    an.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return beVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!an.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        an.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            if (!an.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        an.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        an.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return;
        }
        an.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        an.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        an.e("# PKG NAME: %s", aVarB.f6175d);
        an.e("# APP VER: %s", aVarB.p);
        an.e("# SDK VER: %s", aVarB.f6181j);
        an.e("# LAUNCH TIME: %s", aq.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)));
        an.e("# CRASH TYPE: %s", str);
        an.e("# CRASH TIME: %s", str2);
        an.e("# CRASH PROCESS: %s", str3);
        an.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            an.e("# REPORT ID: %s", crashDetailBean.f6217c);
            Object[] objArr = new Object[2];
            objArr[0] = aVarB.f6184m;
            objArr[1] = aVarB.x().booleanValue() ? "ROOTED" : "UNROOT";
            an.e("# CRASH DEVICE: %s %s", objArr);
            an.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            an.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!aq.a(crashDetailBean.L)) {
                an.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.f6216b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.P == null) {
                    str6 = d.c.a.b.a.a.f10075h;
                } else {
                    str6 = "" + crashDetailBean.P.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                an.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!aq.a(str5)) {
            an.e("# CRASH STACK: ", new Object[0]);
            an.e(str5, new Object[0]);
        }
        an.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
