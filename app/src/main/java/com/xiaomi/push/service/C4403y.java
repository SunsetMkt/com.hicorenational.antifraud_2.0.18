package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4100bb;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.xiaomi.push.service.y */
/* loaded from: classes2.dex */
public class C4403y {

    /* renamed from: a */
    private static Object f16816a = new Object();

    /* renamed from: a */
    private static Map<String, Queue<String>> f16817a = new HashMap();

    /* renamed from: a */
    public static boolean m16342a(XMPushService xMPushService, String str, String str2) {
        synchronized (f16816a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f16817a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                f16817a.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String m13881a = C4100bb.m13881a(queue, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, m13881a);
            edit.commit();
            return false;
        }
    }
}
