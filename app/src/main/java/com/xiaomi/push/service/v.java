package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private static a a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1085a;

    public interface a {
        Map<String, String> a(Context context, hb hbVar);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        void m748a(Context context, hb hbVar);

        void a(Context context, hb hbVar, he heVar);

        boolean a(Context context, hb hbVar, boolean z);
    }

    public interface b {
        void a(hb hbVar);

        void a(String str);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m749a(hb hbVar);
    }

    public static void a(Context context, hb hbVar, he heVar) {
        a aVar = a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, hbVar, heVar);
        }
    }

    public static boolean a(Context context, hb hbVar, boolean z) {
        a aVar = a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("pepa judement listener or container is null");
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m746a(Context context, hb hbVar) {
        a aVar = a;
        if (aVar != null && hbVar != null) {
            aVar.m748a(context, hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m48a("handle msg wrong");
        }
    }

    public static Map<String, String> a(Context context, hb hbVar) {
        a aVar = a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("pepa listener or container is null");
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m747a(hb hbVar) {
        b bVar = f1085a;
        if (bVar != null && hbVar != null) {
            return bVar.m749a(hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(hb hbVar) {
        b bVar = f1085a;
        if (bVar != null && hbVar != null) {
            bVar.a(hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m48a("pepa clearMessage is null");
        }
    }

    public static void a(String str) {
        b bVar = f1085a;
        if (bVar != null && str != null) {
            bVar.a(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m48a("pepa clearMessage is null");
        }
    }
}
