package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static bl a(UserInfoBean userInfoBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        bl blVar = new bl();
        blVar.a = userInfoBean.f6139e;
        blVar.f6505e = userInfoBean.f6144j;
        blVar.f6504d = userInfoBean.f6137c;
        blVar.f6503c = userInfoBean.f6138d;
        blVar.f6507g = com.tencent.bugly.crashreport.common.info.a.b().i();
        blVar.f6508h = userInfoBean.o == 1;
        int i2 = userInfoBean.f6136b;
        if (i2 == 1) {
            blVar.f6502b = (byte) 1;
        } else if (i2 == 2) {
            blVar.f6502b = (byte) 4;
        } else if (i2 == 3) {
            blVar.f6502b = (byte) 2;
        } else if (i2 == 4) {
            blVar.f6502b = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                an.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f6136b));
                return null;
            }
            blVar.f6502b = (byte) i2;
        }
        blVar.f6506f = new HashMap();
        if (userInfoBean.p >= 0) {
            blVar.f6506f.put("C01", "" + userInfoBean.p);
        }
        if (userInfoBean.q >= 0) {
            blVar.f6506f.put("C02", "" + userInfoBean.q);
        }
        Map<String, String> map = userInfoBean.r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                blVar.f6506f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                blVar.f6506f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = blVar.f6506f;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.f6146l);
        map3.put("A36", sb.toString());
        blVar.f6506f.put("F02", "" + userInfoBean.f6141g);
        blVar.f6506f.put("F03", "" + userInfoBean.f6142h);
        blVar.f6506f.put("F04", "" + userInfoBean.f6144j);
        blVar.f6506f.put("F05", "" + userInfoBean.f6143i);
        blVar.f6506f.put("F06", "" + userInfoBean.f6147m);
        blVar.f6506f.put("F10", "" + userInfoBean.f6145k);
        an.c("summary type %d vm:%d", Byte.valueOf(blVar.f6502b), Integer.valueOf(blVar.f6506f.size()));
        return blVar;
    }

    public static bm a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarB;
        if (list == null || list.size() == 0 || (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        aVarB.t();
        bm bmVar = new bm();
        bmVar.f6511b = aVarB.f6176e;
        bmVar.f6512c = aVarB.h();
        ArrayList<bl> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            bl blVarA = a(it.next(), aVarB);
            if (blVarA != null) {
                arrayList.add(blVarA);
            }
        }
        bmVar.f6513d = arrayList;
        bmVar.f6514e = new HashMap();
        bmVar.f6514e.put("A7", "" + aVarB.f6183l);
        bmVar.f6514e.put("A6", "" + aVarB.s());
        bmVar.f6514e.put("A5", "" + aVarB.r());
        bmVar.f6514e.put("A2", "" + aVarB.p());
        bmVar.f6514e.put("A1", "" + aVarB.p());
        bmVar.f6514e.put("A24", "" + aVarB.f6185n);
        bmVar.f6514e.put("A17", "" + aVarB.q());
        bmVar.f6514e.put("A15", "" + aVarB.w());
        bmVar.f6514e.put("A13", "" + aVarB.x());
        bmVar.f6514e.put("F08", "" + aVarB.C);
        bmVar.f6514e.put("F09", "" + aVarB.D);
        Map<String, String> mapG = aVarB.G();
        if (mapG != null && mapG.size() > 0) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                bmVar.f6514e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                an.e("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            bmVar.a = (byte) 2;
        } else {
            bmVar.a = (byte) 1;
        }
        return bmVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                tNewInstance.a(kVar);
                return tNewInstance;
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bh a(Context context, int i2, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (aVarB != null && strategyBeanC != null) {
            try {
                bh bhVar = new bh();
                synchronized (aVarB) {
                    bhVar.a = aVarB.f6174c;
                    bhVar.f6465b = aVarB.f();
                    bhVar.f6466c = aVarB.f6175d;
                    bhVar.f6467d = aVarB.p;
                    bhVar.f6468e = aVarB.s;
                    bhVar.f6469f = aVarB.f6181j;
                    bhVar.f6470g = i2;
                    bhVar.f6471h = bArr == null ? "".getBytes() : bArr;
                    bhVar.f6472i = aVarB.f6184m;
                    bhVar.f6473j = aVarB.f6185n;
                    bhVar.f6474k = new HashMap();
                    bhVar.f6475l = aVarB.e();
                    bhVar.f6476m = strategyBeanC.p;
                    bhVar.o = aVarB.h();
                    bhVar.p = com.tencent.bugly.crashreport.common.info.b.f(context);
                    bhVar.q = System.currentTimeMillis();
                    bhVar.r = "" + aVarB.k();
                    bhVar.s = aVarB.j();
                    bhVar.t = "" + aVarB.m();
                    bhVar.u = aVarB.l();
                    bhVar.v = "" + aVarB.n();
                    bhVar.w = bhVar.p;
                    aVarB.getClass();
                    bhVar.f6477n = "com.tencent.bugly";
                    bhVar.f6474k.put("A26", "" + aVarB.y());
                    bhVar.f6474k.put("A60", "" + aVarB.z());
                    bhVar.f6474k.put("A61", "" + aVarB.A());
                    bhVar.f6474k.put("A62", "" + aVarB.R());
                    bhVar.f6474k.put("A63", "" + aVarB.S());
                    bhVar.f6474k.put("F11", "" + aVarB.H);
                    bhVar.f6474k.put("F12", "" + aVarB.G);
                    bhVar.f6474k.put("G1", "" + aVarB.u());
                    bhVar.f6474k.put("A64", "" + aVarB.T());
                    if (aVarB.L) {
                        bhVar.f6474k.put("G2", "" + aVarB.L());
                        bhVar.f6474k.put("G3", "" + aVarB.M());
                        bhVar.f6474k.put("G4", "" + aVarB.N());
                        bhVar.f6474k.put("G5", "" + aVarB.O());
                        bhVar.f6474k.put("G6", "" + aVarB.P());
                        bhVar.f6474k.put("G7", "" + Long.toString(aVarB.Q()));
                    }
                    bhVar.f6474k.put("D3", "" + aVarB.r);
                    if (com.tencent.bugly.b.f5994b != null) {
                        for (com.tencent.bugly.a aVar : com.tencent.bugly.b.f5994b) {
                            if (aVar.versionKey != null && aVar.version != null) {
                                bhVar.f6474k.put(aVar.versionKey, aVar.version);
                            }
                        }
                    }
                    bhVar.f6474k.put("G15", aq.c("G15", ""));
                    bhVar.f6474k.put("D4", aq.c("D4", "0"));
                }
                ak akVarA = ak.a();
                if (akVarA != null && !akVarA.f6377b && bArr != null) {
                    bhVar.f6471h = aq.a(bhVar.f6471h, 2, 1, strategyBeanC.u);
                    if (bhVar.f6471h == null) {
                        an.e("reqPkg sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                Map<String, String> mapF = aVarB.F();
                if (mapF != null) {
                    for (Map.Entry<String, String> entry : mapF.entrySet()) {
                        bhVar.f6474k.put(entry.getKey(), entry.getValue());
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
            eVar.a("detail", obj);
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
                Object objB = eVar.b("detail", new bi());
                bi biVar = bi.class.isInstance(objB) ? (bi) bi.class.cast(objB) : null;
                if (!z && biVar != null && biVar.f6481c != null && biVar.f6481c.length > 0) {
                    an.c("resp buf %d", Integer.valueOf(biVar.f6481c.length));
                    biVar.f6481c = aq.b(biVar.f6481c, 2, 1, StrategyBean.f6192d);
                    if (biVar.f6481c == null) {
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
