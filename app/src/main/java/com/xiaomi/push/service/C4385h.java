package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4221fo;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4219fm;
import com.xiaomi.push.C4220fn;
import com.xiaomi.push.C4223fq;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.service.C4361am;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.h */
/* loaded from: classes2.dex */
public class C4385h {

    /* renamed from: a */
    private C4399u f16708a = new C4399u();

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public void m16102a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (C4300j.m15689c()) {
                intent.addFlags(16777216);
            }
            AbstractC4022b.m13347a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public void m16105a(Context context, C4361am.b bVar, boolean z, int i2, String str) {
        if ("5".equalsIgnoreCase(bVar.f16563g)) {
            this.f16708a.m16256a(context, bVar, z, i2, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f16553a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f16563g);
        intent.putExtra(AbstractC4362an.f16617s, bVar.f16557b);
        intent.putExtra(AbstractC4362an.f16590J, bVar.f16565i);
        AbstractC4022b.m13347a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.f16563g, bVar.f16553a, Boolean.valueOf(z), Integer.valueOf(i2)));
        m16099a(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public void m16103a(Context context, C4361am.b bVar, int i2) {
        if ("5".equalsIgnoreCase(bVar.f16563g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f16553a);
        intent.putExtra(AbstractC4362an.f16620v, bVar.f16563g);
        intent.putExtra("ext_reason", i2);
        intent.putExtra(AbstractC4362an.f16617s, bVar.f16557b);
        intent.putExtra(AbstractC4362an.f16590J, bVar.f16565i);
        if (bVar.f16547a != null && "9".equals(bVar.f16563g)) {
            try {
                bVar.f16547a.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                bVar.f16547a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str = bVar.f16557b;
                sb.append(str.substring(str.lastIndexOf(64)));
                AbstractC4022b.m13347a(sb.toString());
                return;
            }
        }
        AbstractC4022b.m13347a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.f16563g, bVar.f16553a, Integer.valueOf(i2)));
        m16099a(context, intent, bVar);
    }

    /* renamed from: a */
    public void m16107a(XMPushService xMPushService, String str, AbstractC4221fo abstractC4221fo) {
        String str2;
        C4361am.b m16101a = m16101a(abstractC4221fo);
        if (m16101a == null) {
            AbstractC4022b.m13361d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f16708a.m16258a(xMPushService, abstractC4221fo, m16101a);
            return;
        }
        String str3 = m16101a.f16553a;
        if (abstractC4221fo instanceof C4220fn) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (abstractC4221fo instanceof C4219fm) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(abstractC4221fo instanceof C4223fq)) {
                AbstractC4022b.m13361d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", abstractC4221fo.mo14827a());
        intent.putExtra(AbstractC4362an.f16590J, m16101a.f16565i);
        intent.putExtra(AbstractC4362an.f16582B, m16101a.f16564h);
        AbstractC4022b.m13347a(String.format("[Bcst] notify packet arrival. %s,%s,%s", m16101a.f16563g, m16101a.f16553a, abstractC4221fo.m14864j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(AbstractC4362an.f16621w, abstractC4221fo.f15349a);
            intent.putExtra(AbstractC4362an.f16622x, System.currentTimeMillis());
        }
        m16099a(xMPushService, intent, m16101a);
    }

    /* renamed from: a */
    public void m16106a(XMPushService xMPushService, String str, C4197er c4197er) {
        C4361am.b m16100a = m16100a(c4197er);
        if (m16100a == null) {
            AbstractC4022b.m13361d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f16708a.m16257a(xMPushService, c4197er, m16100a);
            return;
        }
        String str2 = m16100a.f16553a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", c4197er.m14697a(m16100a.f16564h));
        intent.putExtra(AbstractC4362an.f16590J, m16100a.f16565i);
        intent.putExtra(AbstractC4362an.f16582B, m16100a.f16564h);
        if (AbstractC4382e.m16077a(c4197er)) {
            intent.putExtra("ext_downward_pkt_id", c4197er.m14709e());
        }
        if (m16100a.f16547a != null) {
            try {
                m16100a.f16547a.send(Message.obtain(null, 17, intent));
                AbstractC4022b.m13347a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                m16100a.f16547a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = m16100a.f16557b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                AbstractC4022b.m13347a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        AbstractC4022b.m13347a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", m16100a.f16563g, m16100a.f16553a, c4197er.m14709e()));
        if (AbstractC4382e.m16077a(c4197er)) {
            C4368at.m16002a().m16005a(c4197er.m14709e(), SystemClock.elapsedRealtime());
        }
        m16099a(xMPushService, intent, m16100a);
    }

    /* renamed from: a */
    C4361am.b m16101a(AbstractC4221fo abstractC4221fo) {
        Collection<C4361am.b> m15956a = C4361am.m15951a().m15956a(abstractC4221fo.m14865k());
        if (m15956a.isEmpty()) {
            return null;
        }
        Iterator<C4361am.b> it = m15956a.iterator();
        if (m15956a.size() == 1) {
            return it.next();
        }
        String m14869m = abstractC4221fo.m14869m();
        String m14867l = abstractC4221fo.m14867l();
        while (it.hasNext()) {
            C4361am.b next = it.next();
            if (TextUtils.equals(m14869m, next.f16557b) || TextUtils.equals(m14867l, next.f16557b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    C4361am.b m16100a(C4197er c4197er) {
        Collection<C4361am.b> m15956a = C4361am.m15951a().m15956a(Integer.toString(c4197er.m14683a()));
        if (m15956a.isEmpty()) {
            return null;
        }
        Iterator<C4361am.b> it = m15956a.iterator();
        if (m15956a.size() == 1) {
            return it.next();
        }
        String m14711g = c4197er.m14711g();
        while (it.hasNext()) {
            C4361am.b next = it.next();
            if (TextUtils.equals(m14711g, next.f16557b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m16104a(Context context, C4361am.b bVar, String str, String str2) {
        if (bVar == null) {
            AbstractC4022b.m13361d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.f16563g)) {
            AbstractC4022b.m13361d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f16553a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f16563g);
        intent.putExtra(AbstractC4362an.f16617s, bVar.f16557b);
        intent.putExtra(AbstractC4362an.f16590J, bVar.f16565i);
        AbstractC4022b.m13347a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.f16563g, bVar.f16553a, str2));
        m16099a(context, intent, bVar);
    }

    /* renamed from: a */
    private static void m16099a(Context context, Intent intent, C4361am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, m16098a(bVar));
        }
    }

    /* renamed from: a */
    public static String m16098a(C4361am.b bVar) {
        if (!"9".equals(bVar.f16563g)) {
            return bVar.f16553a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f16553a + ".permission.MIMC_RECEIVE";
    }
}
