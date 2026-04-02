package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class TrafficsMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f5892d;
    private Map<String, List<a>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f5890b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", Constants.DEFAULT_UIN);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5891c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5893e = "";

    /* JADX INFO: compiled from: Taobao */
    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f5892d = context;
    }

    private void b() {
        String str;
        boolean z;
        synchronized (this.a) {
            String strA = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f5893e) || this.f5893e.equals(strA)) {
                str = strA;
                z = false;
            } else {
                str = this.f5893e;
                z = true;
            }
            Iterator<String> it = this.a.keySet().iterator();
            while (it.hasNext()) {
                for (a aVar : this.a.get(it.next())) {
                    if (aVar != null) {
                        com.taobao.accs.b.a.a(this.f5892d).a(aVar.f5897e, aVar.f5895c, this.f5890b.get(aVar.f5895c), aVar.f5896d, aVar.f5898f, str);
                    }
                }
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.a.toString(), new Object[0]);
            }
            if (z) {
                this.a.clear();
                c();
            } else if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f5893e + " currday:" + strA, new Object[0]);
            }
            this.f5893e = strA;
            this.f5891c = 0;
        }
    }

    private void c() {
        List<a> listA = com.taobao.accs.b.a.a(this.f5892d).a(false);
        if (listA == null) {
            return;
        }
        try {
            for (a aVar : listA) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.f5894b;
                    statTrafficMonitor.date = aVar.a;
                    statTrafficMonitor.host = aVar.f5897e;
                    statTrafficMonitor.isBackground = aVar.f5896d;
                    statTrafficMonitor.size = aVar.f5898f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.b.a.a(this.f5892d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        boolean z;
        if (aVar == null || aVar.f5897e == null || aVar.f5898f <= 0) {
            return;
        }
        aVar.f5895c = TextUtils.isEmpty(aVar.f5895c) ? "accsSelf" : aVar.f5895c;
        synchronized (this.a) {
            String str = this.f5890b.get(aVar.f5895c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            aVar.f5894b = str;
            ALog.isPrintLog(ALog.Level.D);
            List<a> arrayList = this.a.get(str);
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    a next = it.next();
                    if (next.f5896d == aVar.f5896d && next.f5897e != null && next.f5897e.equals(aVar.f5897e)) {
                        next.f5898f += aVar.f5898f;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(aVar);
                }
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(aVar);
            }
            this.a.put(str, arrayList);
            this.f5891c++;
            if (this.f5891c >= 10) {
                b();
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f5895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5896d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f5897e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f5898f;

        public a(String str, boolean z, String str2, long j2) {
            this.f5895c = str;
            this.f5896d = z;
            this.f5897e = str2;
            this.f5898f = j2;
        }

        public String toString() {
            return "date:" + this.a + d.c.a.b.a.a.f10074g + "bizId:" + this.f5894b + d.c.a.b.a.a.f10074g + "serviceId:" + this.f5895c + d.c.a.b.a.a.f10074g + "host:" + this.f5897e + d.c.a.b.a.a.f10074g + "isBackground:" + this.f5896d + d.c.a.b.a.a.f10074g + "size:" + this.f5898f;
        }

        public a(String str, String str2, String str3, boolean z, String str4, long j2) {
            this.a = str;
            this.f5894b = str2;
            this.f5895c = str3;
            this.f5896d = z;
            this.f5897e = str4;
            this.f5898f = j2;
        }
    }

    public void a() {
        try {
            synchronized (this.a) {
                this.a.clear();
            }
            List<a> listA = com.taobao.accs.b.a.a(this.f5892d).a(true);
            if (listA == null) {
                return;
            }
            Iterator<a> it = listA.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e2) {
            ALog.w("TrafficsMonitor", e2.toString(), new Object[0]);
        }
    }
}
