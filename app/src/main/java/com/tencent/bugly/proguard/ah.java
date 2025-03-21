package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ah {
    public static bl a(UserInfoBean userInfoBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        bl blVar = new bl();
        blVar.f9361a = userInfoBean.f8931e;
        blVar.f9365e = userInfoBean.f8936j;
        blVar.f9364d = userInfoBean.f8929c;
        blVar.f9363c = userInfoBean.f8930d;
        blVar.f9367g = com.tencent.bugly.crashreport.common.info.a.b().i();
        blVar.f9368h = userInfoBean.o == 1;
        int i2 = userInfoBean.f8928b;
        if (i2 == 1) {
            blVar.f9362b = (byte) 1;
        } else if (i2 == 2) {
            blVar.f9362b = (byte) 4;
        } else if (i2 == 3) {
            blVar.f9362b = (byte) 2;
        } else if (i2 == 4) {
            blVar.f9362b = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                an.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f8928b));
                return null;
            }
            blVar.f9362b = (byte) i2;
        }
        blVar.f9366f = new HashMap();
        if (userInfoBean.p >= 0) {
            blVar.f9366f.put("C01", "" + userInfoBean.p);
        }
        if (userInfoBean.q >= 0) {
            blVar.f9366f.put("C02", "" + userInfoBean.q);
        }
        Map<String, String> map = userInfoBean.r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                blVar.f9366f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                blVar.f9366f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = blVar.f9366f;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.f8938l);
        map3.put("A36", sb.toString());
        blVar.f9366f.put("F02", "" + userInfoBean.f8933g);
        blVar.f9366f.put("F03", "" + userInfoBean.f8934h);
        blVar.f9366f.put("F04", "" + userInfoBean.f8936j);
        blVar.f9366f.put("F05", "" + userInfoBean.f8935i);
        blVar.f9366f.put("F06", "" + userInfoBean.f8939m);
        blVar.f9366f.put("F10", "" + userInfoBean.f8937k);
        an.c("summary type %d vm:%d", Byte.valueOf(blVar.f9362b), Integer.valueOf(blVar.f9366f.size()));
        return blVar;
    }

    public static bm a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a b2;
        if (list == null || list.size() == 0 || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b2.t();
        bm bmVar = new bm();
        bmVar.f9372b = b2.f8978e;
        bmVar.f9373c = b2.h();
        ArrayList<bl> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            bl a2 = a(it.next(), b2);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        bmVar.f9374d = arrayList;
        bmVar.f9375e = new HashMap();
        bmVar.f9375e.put("A7", "" + b2.f8985l);
        bmVar.f9375e.put("A6", "" + b2.s());
        bmVar.f9375e.put("A5", "" + b2.r());
        bmVar.f9375e.put("A2", "" + b2.p());
        bmVar.f9375e.put("A1", "" + b2.p());
        bmVar.f9375e.put("A24", "" + b2.n);
        bmVar.f9375e.put("A17", "" + b2.q());
        bmVar.f9375e.put("A15", "" + b2.w());
        bmVar.f9375e.put("A13", "" + b2.x());
        bmVar.f9375e.put("F08", "" + b2.C);
        bmVar.f9375e.put("F09", "" + b2.D);
        Map<String, String> G = b2.G();
        if (G != null && G.size() > 0) {
            for (Map.Entry<String, String> entry : G.entrySet()) {
                bmVar.f9375e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                an.e("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            bmVar.f9371a = (byte) 2;
        } else {
            bmVar.f9371a = (byte) 1;
        }
        return bmVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                newInstance.a(kVar);
                return newInstance;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bh a(Context context, int i2, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b2 != null && c2 != null) {
            try {
                bh bhVar = new bh();
                synchronized (b2) {
                    bhVar.f9322a = b2.f8976c;
                    bhVar.f9323b = b2.f();
                    bhVar.f9324c = b2.f8977d;
                    bhVar.f9325d = b2.p;
                    bhVar.f9326e = b2.s;
                    bhVar.f9327f = b2.f8983j;
                    bhVar.f9328g = i2;
                    bhVar.f9329h = bArr == null ? "".getBytes() : bArr;
                    bhVar.f9330i = b2.f8986m;
                    bhVar.f9331j = b2.n;
                    bhVar.f9332k = new HashMap();
                    bhVar.f9333l = b2.e();
                    bhVar.f9334m = c2.p;
                    bhVar.o = b2.h();
                    bhVar.p = com.tencent.bugly.crashreport.common.info.b.f(context);
                    bhVar.q = System.currentTimeMillis();
                    bhVar.r = "" + b2.k();
                    bhVar.s = b2.j();
                    bhVar.t = "" + b2.m();
                    bhVar.u = b2.l();
                    bhVar.v = "" + b2.n();
                    bhVar.w = bhVar.p;
                    b2.getClass();
                    bhVar.n = "com.tencent.bugly";
                    bhVar.f9332k.put("A26", "" + b2.y());
                    bhVar.f9332k.put("A60", "" + b2.z());
                    bhVar.f9332k.put("A61", "" + b2.A());
                    bhVar.f9332k.put("A62", "" + b2.R());
                    bhVar.f9332k.put("A63", "" + b2.S());
                    bhVar.f9332k.put("F11", "" + b2.H);
                    bhVar.f9332k.put("F12", "" + b2.G);
                    bhVar.f9332k.put("G1", "" + b2.u());
                    bhVar.f9332k.put("A64", "" + b2.T());
                    if (b2.L) {
                        bhVar.f9332k.put("G2", "" + b2.L());
                        bhVar.f9332k.put("G3", "" + b2.M());
                        bhVar.f9332k.put("G4", "" + b2.N());
                        bhVar.f9332k.put("G5", "" + b2.O());
                        bhVar.f9332k.put("G6", "" + b2.P());
                        bhVar.f9332k.put("G7", "" + Long.toString(b2.Q()));
                    }
                    bhVar.f9332k.put("D3", "" + b2.r);
                    if (com.tencent.bugly.b.f8758b != null) {
                        for (com.tencent.bugly.a aVar : com.tencent.bugly.b.f8758b) {
                            if (aVar.versionKey != null && aVar.version != null) {
                                bhVar.f9332k.put(aVar.versionKey, aVar.version);
                            }
                        }
                    }
                    bhVar.f9332k.put("G15", aq.c("G15", ""));
                    bhVar.f9332k.put("D4", aq.c("D4", "0"));
                }
                ak a2 = ak.a();
                if (a2 != null && !a2.f9215b && bArr != null) {
                    bhVar.f9329h = aq.a(bhVar.f9329h, 2, 1, c2.u);
                    if (bhVar.f9329h == null) {
                        an.e("reqPkg sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                Map<String, String> F = b2.F();
                if (F != null) {
                    for (Map.Entry<String, String> entry : F.entrySet()) {
                        bhVar.f9332k.put(entry.getKey(), entry.getValue());
                    }
                }
                return bhVar;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        an.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.a(1);
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", (String) obj);
            return eVar.a();
        } catch (Throwable th) {
            if (an.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static bi a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b2 = eVar.b("detail", new bi());
                bi biVar = bi.class.isInstance(b2) ? (bi) bi.class.cast(b2) : null;
                if (!z && biVar != null && biVar.f9339c != null && biVar.f9339c.length > 0) {
                    an.c("resp buf %d", Integer.valueOf(biVar.f9339c.length));
                    biVar.f9339c = aq.b(biVar.f9339c, 2, 1, StrategyBean.f8995d);
                    if (biVar.f9339c == null) {
                        an.e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return biVar;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            return lVar.b();
        } catch (Throwable th) {
            if (an.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
