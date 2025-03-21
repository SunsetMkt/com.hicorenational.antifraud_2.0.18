package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.v */
/* loaded from: classes2.dex */
public class C4400v {

    /* renamed from: a */
    private static a f16796a;

    /* renamed from: a */
    private static b f16797a;

    /* renamed from: com.xiaomi.push.service.v$a */
    public interface a {
        /* renamed from: a */
        Map<String, String> m16266a(Context context, C4262hb c4262hb);

        /* renamed from: a */
        void m16267a(Context context, C4262hb c4262hb);

        /* renamed from: a */
        void m16268a(Context context, C4262hb c4262hb, C4265he c4265he);

        /* renamed from: a */
        boolean m16269a(Context context, C4262hb c4262hb, boolean z);
    }

    /* renamed from: com.xiaomi.push.service.v$b */
    public interface b {
        /* renamed from: a */
        void m16270a(C4262hb c4262hb);

        /* renamed from: a */
        void m16271a(String str);

        /* renamed from: a */
        boolean m16272a(C4262hb c4262hb);
    }

    /* renamed from: a */
    public static void m16261a(Context context, C4262hb c4262hb, C4265he c4265he) {
        a aVar = f16796a;
        if (aVar == null) {
            AbstractC4022b.m13361d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.m16268a(context, c4262hb, c4265he);
        }
    }

    /* renamed from: a */
    public static boolean m16264a(Context context, C4262hb c4262hb, boolean z) {
        a aVar = f16796a;
        if (aVar != null && c4262hb != null) {
            return aVar.m16269a(context, c4262hb, z);
        }
        AbstractC4022b.m13347a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a */
    public static void m16260a(Context context, C4262hb c4262hb) {
        a aVar = f16796a;
        if (aVar != null && c4262hb != null) {
            aVar.m16267a(context, c4262hb);
        } else {
            AbstractC4022b.m13347a("handle msg wrong");
        }
    }

    /* renamed from: a */
    public static Map<String, String> m16259a(Context context, C4262hb c4262hb) {
        a aVar = f16796a;
        if (aVar != null && c4262hb != null) {
            return aVar.m16266a(context, c4262hb);
        }
        AbstractC4022b.m13347a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a */
    public static boolean m16265a(C4262hb c4262hb) {
        b bVar = f16797a;
        if (bVar != null && c4262hb != null) {
            return bVar.m16272a(c4262hb);
        }
        AbstractC4022b.m13347a("pepa handleReceiveMessage is null");
        return false;
    }

    /* renamed from: a */
    public static void m16262a(C4262hb c4262hb) {
        b bVar = f16797a;
        if (bVar != null && c4262hb != null) {
            bVar.m16270a(c4262hb);
        } else {
            AbstractC4022b.m13347a("pepa clearMessage is null");
        }
    }

    /* renamed from: a */
    public static void m16263a(String str) {
        b bVar = f16797a;
        if (bVar != null && str != null) {
            bVar.m16271a(str);
        } else {
            AbstractC4022b.m13347a("pepa clearMessage is null");
        }
    }
}
