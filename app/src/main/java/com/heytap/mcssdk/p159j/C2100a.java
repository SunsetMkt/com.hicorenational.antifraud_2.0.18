package com.heytap.mcssdk.p159j;

import android.content.Context;
import com.heytap.mcssdk.p160k.C2102b;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.heytap.mcssdk.j.a */
/* loaded from: classes.dex */
public class C2100a {
    /* renamed from: a */
    public static boolean m5851a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessageStat(context.getPackageName(), str));
        return C2102b.m5857a(context, arrayList);
    }

    /* renamed from: a */
    public static boolean m5852a(Context context, String str, DataMessage dataMessage) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new MessageStat(packageName, str) : new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return C2102b.m5857a(context, arrayList);
    }

    /* renamed from: a */
    public static boolean m5853a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MessageStat(packageName, it.next()));
            }
        }
        return C2102b.m5857a(context, arrayList);
    }
}
