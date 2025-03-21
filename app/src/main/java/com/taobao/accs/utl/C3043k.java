package com.taobao.accs.utl;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.k */
/* loaded from: classes2.dex */
public class C3043k {
    /* renamed from: a */
    public static void m9249a(String str, String str2, String str3) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = str;
        alarmObject.modulePoint = str2;
        alarmObject.arg = str3;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
    }

    /* renamed from: a */
    public static void m9251a(String str, String str2, String str3, String str4, String str5) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = str;
        alarmObject.modulePoint = str2;
        alarmObject.arg = str3;
        alarmObject.errorCode = str4;
        alarmObject.errorMsg = str5;
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
    }

    /* renamed from: a */
    public static void m9250a(String str, String str2, String str3, double d2) {
        CountObject countObject = new CountObject();
        countObject.module = str;
        countObject.modulePoint = str2;
        countObject.arg = str3;
        countObject.value = d2;
        AppMonitor.getInstance().commitCount(countObject);
    }
}
