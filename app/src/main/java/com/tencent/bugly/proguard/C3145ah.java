package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.AbstractC3071a;
import com.tencent.bugly.C3072b;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ah */
/* loaded from: classes2.dex */
public class C3145ah {
    /* renamed from: a */
    public static C3176bl m9851a(UserInfoBean userInfoBean, C3113a c3113a) {
        if (userInfoBean == null) {
            return null;
        }
        C3176bl c3176bl = new C3176bl();
        c3176bl.f10713a = userInfoBean.f10084e;
        c3176bl.f10717e = userInfoBean.f10089j;
        c3176bl.f10716d = userInfoBean.f10082c;
        c3176bl.f10715c = userInfoBean.f10083d;
        c3176bl.f10719g = C3113a.m9532b().m9576i();
        c3176bl.f10720h = userInfoBean.f10094o == 1;
        int i2 = userInfoBean.f10081b;
        if (i2 == 1) {
            c3176bl.f10714b = (byte) 1;
        } else if (i2 == 2) {
            c3176bl.f10714b = (byte) 4;
        } else if (i2 == 3) {
            c3176bl.f10714b = (byte) 2;
        } else if (i2 == 4) {
            c3176bl.f10714b = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                C3151an.m9923e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f10081b));
                return null;
            }
            c3176bl.f10714b = (byte) i2;
        }
        c3176bl.f10718f = new HashMap();
        if (userInfoBean.f10095p >= 0) {
            c3176bl.f10718f.put("C01", "" + userInfoBean.f10095p);
        }
        if (userInfoBean.f10096q >= 0) {
            c3176bl.f10718f.put("C02", "" + userInfoBean.f10096q);
        }
        Map<String, String> map = userInfoBean.f10097r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f10097r.entrySet()) {
                c3176bl.f10718f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.f10098s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f10098s.entrySet()) {
                c3176bl.f10718f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = c3176bl.f10718f;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.f10091l);
        map3.put("A36", sb.toString());
        c3176bl.f10718f.put("F02", "" + userInfoBean.f10086g);
        c3176bl.f10718f.put("F03", "" + userInfoBean.f10087h);
        c3176bl.f10718f.put("F04", "" + userInfoBean.f10089j);
        c3176bl.f10718f.put("F05", "" + userInfoBean.f10088i);
        c3176bl.f10718f.put("F06", "" + userInfoBean.f10092m);
        c3176bl.f10718f.put("F10", "" + userInfoBean.f10090k);
        C3151an.m9921c("summary type %d vm:%d", Byte.valueOf(c3176bl.f10714b), Integer.valueOf(c3176bl.f10718f.size()));
        return c3176bl;
    }

    /* renamed from: a */
    public static C3177bm m9852a(List<UserInfoBean> list, int i2) {
        C3113a m9532b;
        if (list == null || list.size() == 0 || (m9532b = C3113a.m9532b()) == null) {
            return null;
        }
        m9532b.m9587t();
        C3177bm c3177bm = new C3177bm();
        c3177bm.f10724b = m9532b.f10197e;
        c3177bm.f10725c = m9532b.m9575h();
        ArrayList<C3176bl> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            C3176bl m9851a = m9851a(it.next(), m9532b);
            if (m9851a != null) {
                arrayList.add(m9851a);
            }
        }
        c3177bm.f10726d = arrayList;
        c3177bm.f10727e = new HashMap();
        c3177bm.f10727e.put("A7", "" + m9532b.f10204l);
        c3177bm.f10727e.put("A6", "" + m9532b.m9586s());
        c3177bm.f10727e.put("A5", "" + m9532b.m9585r());
        c3177bm.f10727e.put("A2", "" + m9532b.m9583p());
        c3177bm.f10727e.put("A1", "" + m9532b.m9583p());
        c3177bm.f10727e.put("A24", "" + m9532b.f10206n);
        c3177bm.f10727e.put("A17", "" + m9532b.m9584q());
        c3177bm.f10727e.put("A15", "" + m9532b.m9590w());
        c3177bm.f10727e.put("A13", "" + m9532b.m9591x());
        c3177bm.f10727e.put("F08", "" + m9532b.f10136C);
        c3177bm.f10727e.put("F09", "" + m9532b.f10137D);
        Map<String, String> m9541G = m9532b.m9541G();
        if (m9541G != null && m9541G.size() > 0) {
            for (Map.Entry<String, String> entry : m9541G.entrySet()) {
                c3177bm.f10727e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                C3151an.m9923e("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            c3177bm.f10723a = (byte) 2;
        } else {
            c3177bm.f10723a = (byte) 1;
        }
        return c3177bm;
    }

    /* renamed from: a */
    public static <T extends AbstractC3188m> T m9853a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C3186k c3186k = new C3186k(bArr);
                c3186k.m10074a("utf-8");
                newInstance.mo9793a(c3186k);
                return newInstance;
            } catch (Throwable th) {
                if (!C3151an.m9919b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C3172bh m9849a(Context context, int i2, byte[] bArr) {
        C3113a m9532b = C3113a.m9532b();
        StrategyBean m9644c = C3116a.m9635a().m9644c();
        if (m9532b != null && m9644c != null) {
            try {
                C3172bh c3172bh = new C3172bh();
                synchronized (m9532b) {
                    c3172bh.f10661a = m9532b.f10195c;
                    c3172bh.f10662b = m9532b.m9571f();
                    c3172bh.f10663c = m9532b.f10196d;
                    c3172bh.f10664d = m9532b.f10208p;
                    c3172bh.f10665e = m9532b.f10211s;
                    c3172bh.f10666f = m9532b.f10202j;
                    c3172bh.f10667g = i2;
                    c3172bh.f10668h = bArr == null ? "".getBytes() : bArr;
                    c3172bh.f10669i = m9532b.f10205m;
                    c3172bh.f10670j = m9532b.f10206n;
                    c3172bh.f10671k = new HashMap();
                    c3172bh.f10672l = m9532b.m9569e();
                    c3172bh.f10673m = m9644c.f10239p;
                    c3172bh.f10675o = m9532b.m9575h();
                    c3172bh.f10676p = C3114b.m9606f(context);
                    c3172bh.f10677q = System.currentTimeMillis();
                    c3172bh.f10678r = "" + m9532b.m9578k();
                    c3172bh.f10679s = m9532b.m9577j();
                    c3172bh.f10680t = "" + m9532b.m9580m();
                    c3172bh.f10681u = m9532b.m9579l();
                    c3172bh.f10682v = "" + m9532b.m9581n();
                    c3172bh.f10683w = c3172bh.f10676p;
                    m9532b.getClass();
                    c3172bh.f10674n = "com.tencent.bugly";
                    c3172bh.f10671k.put("A26", "" + m9532b.m9592y());
                    c3172bh.f10671k.put("A60", "" + m9532b.m9593z());
                    c3172bh.f10671k.put("A61", "" + m9532b.m9535A());
                    c3172bh.f10671k.put("A62", "" + m9532b.m9552R());
                    c3172bh.f10671k.put("A63", "" + m9532b.m9553S());
                    c3172bh.f10671k.put("F11", "" + m9532b.f10141H);
                    c3172bh.f10671k.put("F12", "" + m9532b.f10140G);
                    c3172bh.f10671k.put("G1", "" + m9532b.m9588u());
                    c3172bh.f10671k.put("A64", "" + m9532b.m9554T());
                    if (m9532b.f10145L) {
                        c3172bh.f10671k.put("G2", "" + m9532b.m9546L());
                        c3172bh.f10671k.put("G3", "" + m9532b.m9547M());
                        c3172bh.f10671k.put("G4", "" + m9532b.m9548N());
                        c3172bh.f10671k.put("G5", "" + m9532b.m9549O());
                        c3172bh.f10671k.put("G6", "" + m9532b.m9550P());
                        c3172bh.f10671k.put("G7", "" + Long.toString(m9532b.m9551Q()));
                    }
                    c3172bh.f10671k.put("D3", "" + m9532b.f10210r);
                    if (C3072b.f9833b != null) {
                        for (AbstractC3071a abstractC3071a : C3072b.f9833b) {
                            if (abstractC3071a.versionKey != null && abstractC3071a.version != null) {
                                c3172bh.f10671k.put(abstractC3071a.versionKey, abstractC3071a.version);
                            }
                        }
                    }
                    c3172bh.f10671k.put("G15", C3154aq.m9993c("G15", ""));
                    c3172bh.f10671k.put("D4", C3154aq.m9993c("D4", "0"));
                }
                C3148ak m9863a = C3148ak.m9863a();
                if (m9863a != null && !m9863a.f10517b && bArr != null) {
                    c3172bh.f10668h = C3154aq.m9976a(c3172bh.f10668h, 2, 1, m9644c.f10244u);
                    if (c3172bh.f10668h == null) {
                        C3151an.m9923e("reqPkg sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                Map<String, String> m9540F = m9532b.m9540F();
                if (m9540F != null) {
                    for (Map.Entry<String, String> entry : m9540F.entrySet()) {
                        c3172bh.f10671k.put(entry.getKey(), entry.getValue());
                    }
                }
                return c3172bh;
            } catch (Throwable th) {
                if (!C3151an.m9919b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        C3151an.m9923e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static byte[] m9855a(Object obj) {
        try {
            C3180e c3180e = new C3180e();
            c3180e.mo10035b();
            c3180e.mo10028a("utf-8");
            c3180e.m10036a(1);
            c3180e.m10039b("RqdServer");
            c3180e.m10040c("sync");
            c3180e.mo10029a("detail", (String) obj);
            return c3180e.mo10031a();
        } catch (Throwable th) {
            if (C3151an.m9919b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C3173bi m9850a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                C3180e c3180e = new C3180e();
                c3180e.mo10035b();
                c3180e.mo10028a("utf-8");
                c3180e.mo10030a(bArr);
                Object m10034b = c3180e.m10034b("detail", new C3173bi());
                C3173bi c3173bi = C3173bi.class.isInstance(m10034b) ? (C3173bi) C3173bi.class.cast(m10034b) : null;
                if (!z && c3173bi != null && c3173bi.f10689c != null && c3173bi.f10689c.length > 0) {
                    C3151an.m9921c("resp buf %d", Integer.valueOf(c3173bi.f10689c.length));
                    c3173bi.f10689c = C3154aq.m9990b(c3173bi.f10689c, 2, 1, StrategyBean.f10227d);
                    if (c3173bi.f10689c == null) {
                        C3151an.m9923e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return c3173bi;
            } catch (Throwable th) {
                if (!C3151an.m9919b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m9854a(AbstractC3188m abstractC3188m) {
        try {
            C3187l c3187l = new C3187l();
            c3187l.m10096a("utf-8");
            abstractC3188m.mo9794a(c3187l);
            return c3187l.m10119b();
        } catch (Throwable th) {
            if (C3151an.m9919b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
