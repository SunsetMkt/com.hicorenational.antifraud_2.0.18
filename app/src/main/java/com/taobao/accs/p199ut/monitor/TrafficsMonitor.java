package com.taobao.accs.p199ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.p198b.C2966a;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrafficsMonitor {

    /* renamed from: d */
    private Context f9685d;

    /* renamed from: a */
    private Map<String, List<C3032a>> f9682a = new HashMap();

    /* renamed from: b */
    private Map<String, String> f9683b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
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

    /* renamed from: c */
    private int f9684c = 0;

    /* renamed from: e */
    private String f9686e = "";

    /* compiled from: Taobao */
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
        this.f9685d = context;
    }

    /* renamed from: b */
    private void m9176b() {
        String str;
        boolean z;
        synchronized (this.f9682a) {
            String m9195a = UtilityImpl.m9195a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f9686e) || this.f9686e.equals(m9195a)) {
                str = m9195a;
                z = false;
            } else {
                str = this.f9686e;
                z = true;
            }
            Iterator<String> it = this.f9682a.keySet().iterator();
            while (it.hasNext()) {
                for (C3032a c3032a : this.f9682a.get(it.next())) {
                    if (c3032a != null) {
                        C2966a.m8950a(this.f9685d).m8955a(c3032a.f9692e, c3032a.f9690c, this.f9683b.get(c3032a.f9690c), c3032a.f9691d, c3032a.f9693f, str);
                    }
                }
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f9682a.toString(), new Object[0]);
            }
            if (z) {
                this.f9682a.clear();
                m9177c();
            } else if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f9686e + " currday:" + m9195a, new Object[0]);
            }
            this.f9686e = m9195a;
            this.f9684c = 0;
        }
    }

    /* renamed from: c */
    private void m9177c() {
        List<C3032a> m8953a = C2966a.m8950a(this.f9685d).m8953a(false);
        if (m8953a == null) {
            return;
        }
        try {
            for (C3032a c3032a : m8953a) {
                if (c3032a != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = c3032a.f9689b;
                    statTrafficMonitor.date = c3032a.f9688a;
                    statTrafficMonitor.host = c3032a.f9692e;
                    statTrafficMonitor.isBackground = c3032a.f9691d;
                    statTrafficMonitor.size = c3032a.f9693f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            C2966a.m8950a(this.f9685d).m8954a();
        } catch (Throwable th) {
            ALog.m9182e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m9179a(C3032a c3032a) {
        boolean z;
        if (c3032a == null || c3032a.f9692e == null || c3032a.f9693f <= 0) {
            return;
        }
        c3032a.f9690c = TextUtils.isEmpty(c3032a.f9690c) ? "accsSelf" : c3032a.f9690c;
        synchronized (this.f9682a) {
            String str = this.f9683b.get(c3032a.f9690c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c3032a.f9689b = str;
            ALog.isPrintLog(ALog.Level.D);
            List<C3032a> list = this.f9682a.get(str);
            if (list != null) {
                Iterator<C3032a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    C3032a next = it.next();
                    if (next.f9691d == c3032a.f9691d && next.f9692e != null && next.f9692e.equals(c3032a.f9692e)) {
                        next.f9693f += c3032a.f9693f;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    list.add(c3032a);
                }
            } else {
                list = new ArrayList<>();
                list.add(c3032a);
            }
            this.f9682a.put(str, list);
            this.f9684c++;
            if (this.f9684c >= 10) {
                m9176b();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.ut.monitor.TrafficsMonitor$a */
    public static class C3032a {

        /* renamed from: a */
        String f9688a;

        /* renamed from: b */
        String f9689b;

        /* renamed from: c */
        String f9690c;

        /* renamed from: d */
        boolean f9691d;

        /* renamed from: e */
        String f9692e;

        /* renamed from: f */
        long f9693f;

        public C3032a(String str, boolean z, String str2, long j2) {
            this.f9690c = str;
            this.f9691d = z;
            this.f9692e = str2;
            this.f9693f = j2;
        }

        public String toString() {
            return "date:" + this.f9688a + AbstractC1191a.f2568g + "bizId:" + this.f9689b + AbstractC1191a.f2568g + "serviceId:" + this.f9690c + AbstractC1191a.f2568g + "host:" + this.f9692e + AbstractC1191a.f2568g + "isBackground:" + this.f9691d + AbstractC1191a.f2568g + "size:" + this.f9693f;
        }

        public C3032a(String str, String str2, String str3, boolean z, String str4, long j2) {
            this.f9688a = str;
            this.f9689b = str2;
            this.f9690c = str3;
            this.f9691d = z;
            this.f9692e = str4;
            this.f9693f = j2;
        }
    }

    /* renamed from: a */
    public void m9178a() {
        try {
            synchronized (this.f9682a) {
                this.f9682a.clear();
            }
            List<C3032a> m8953a = C2966a.m8950a(this.f9685d).m8953a(true);
            if (m8953a == null) {
                return;
            }
            Iterator<C3032a> it = m8953a.iterator();
            while (it.hasNext()) {
                m9179a(it.next());
            }
        } catch (Exception e2) {
            ALog.m9186w("TrafficsMonitor", e2.toString(), new Object[0]);
        }
    }
}
