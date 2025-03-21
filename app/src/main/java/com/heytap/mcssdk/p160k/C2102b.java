package com.heytap.mcssdk.p160k;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.constant.C2085b;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.heytap.mcssdk.k.b */
/* loaded from: classes.dex */
public class C2102b {

    /* renamed from: a */
    private static final String f6240a = "type";

    /* renamed from: b */
    private static final String f6241b = "count";

    /* renamed from: c */
    private static final String f6242c = "list";

    /* renamed from: d */
    private static final int f6243d = 1017;

    /* renamed from: a */
    public static void m5855a(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        m5857a(context, linkedList);
    }

    /* renamed from: a */
    private static boolean m5856a(Context context) {
        String m5702a = C2080a.m5698w().m5702a(context);
        return C2103c.m5867c(context, m5702a) && C2103c.m5860a(context, m5702a) >= 1017;
    }

    /* renamed from: a */
    public static boolean m5857a(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        C2107g.m5884b("isSupportStatisticByMcs:" + m5856a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !m5856a(context)) {
            return false;
        }
        return m5858b(context, linkedList);
    }

    /* renamed from: b */
    private static boolean m5858b(Context context, List<MessageStat> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(C2080a.m5698w().m5716b(context));
            intent.setPackage(C2080a.m5698w().m5702a(context));
            intent.putExtra(C2085b.f6164e, context.getPackageName());
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_STATISTIC);
            intent.putExtra(f6241b, list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<MessageStat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toJsonObject());
            }
            intent.putStringArrayListExtra(f6242c, arrayList);
            context.startService(intent);
            return true;
        } catch (Exception e2) {
            C2107g.m5896e("statisticMessage--Exception" + e2.getMessage());
            return false;
        }
    }
}
