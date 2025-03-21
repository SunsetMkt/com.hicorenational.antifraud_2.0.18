package org.android.agoo.xiaomi;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import org.android.agoo.control.AgooFactory;

/* loaded from: classes2.dex */
public class MiPushBroadcastReceiver extends PushMessageReceiver {
    public static final String MI_TOKEN = "MI_TOKEN";
    public static final String TAG = "MiPushBroadcastReceiver";
    public AgooFactory agooFactory;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        try {
            String content = miPushMessage.getContent();
            ALog.m9183i(TAG, "onReceivePassThroughMessage", "msg", content);
            if (this.agooFactory == null) {
                AgooFactory agooFactory = new AgooFactory();
                this.agooFactory = agooFactory;
                agooFactory.init(context, null, null);
            }
            this.agooFactory.msgRecevie(content.getBytes("UTF-8"), "xiaomi");
        } catch (Throwable th) {
            ALog.m9181e(TAG, "onReceivePassThroughMessage", th, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[Catch: Exception -> 0x0066, TRY_LEAVE, TryCatch #0 {Exception -> 0x0066, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0016, B:8:0x001e, B:10:0x0028, B:13:0x0043, B:15:0x0054, B:20:0x0033), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceiveRegisterResult(android.content.Context r13, com.xiaomi.mipush.sdk.MiPushCommandMessage r14) {
        /*
            r12 = this;
            java.lang.String r0 = "onReceiveRegisterResult"
            java.lang.String r1 = "MiPushBroadcastReceiver"
            r2 = 0
            java.lang.String r3 = r14.getCommand()     // Catch: java.lang.Exception -> L66
            java.util.List r4 = r14.getCommandArguments()     // Catch: java.lang.Exception -> L66
            r5 = 0
            if (r4 == 0) goto L1d
            int r6 = r4.size()     // Catch: java.lang.Exception -> L66
            if (r6 <= 0) goto L1d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Exception -> L66
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L66
            goto L1e
        L1d:
            r4 = r5
        L1e:
            java.lang.String r6 = "register"
            boolean r3 = r6.equals(r3)     // Catch: java.lang.Exception -> L66
            r6 = 1
            r7 = 2
            if (r3 == 0) goto L42
            long r8 = r14.getResultCode()     // Catch: java.lang.Exception -> L66
            r10 = 0
            int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r14 != 0) goto L33
            goto L43
        L33:
            java.lang.Object[] r14 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = "ErrorCode"
            r14[r2] = r3     // Catch: java.lang.Exception -> L66
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L66
            r14[r6] = r3     // Catch: java.lang.Exception -> L66
            com.taobao.accs.utl.ALog.m9183i(r1, r0, r14)     // Catch: java.lang.Exception -> L66
        L42:
            r4 = r5
        L43:
            java.lang.Object[] r14 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = "regId"
            r14[r2] = r3     // Catch: java.lang.Exception -> L66
            r14[r6] = r4     // Catch: java.lang.Exception -> L66
            com.taobao.accs.utl.ALog.m9183i(r1, r0, r14)     // Catch: java.lang.Exception -> L66
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L66
            if (r14 != 0) goto L6c
            org.android.agoo.control.NotifManager r14 = new org.android.agoo.control.NotifManager     // Catch: java.lang.Exception -> L66
            r14.<init>()     // Catch: java.lang.Exception -> L66
            android.content.Context r13 = r13.getApplicationContext()     // Catch: java.lang.Exception -> L66
            r14.init(r13)     // Catch: java.lang.Exception -> L66
            java.lang.String r13 = "MI_TOKEN"
            r14.reportThirdPushToken(r4, r13)     // Catch: java.lang.Exception -> L66
            goto L6c
        L66:
            r13 = move-exception
            java.lang.Object[] r14 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.m9181e(r1, r0, r13, r14)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.xiaomi.MiPushBroadcastReceiver.onReceiveRegisterResult(android.content.Context, com.xiaomi.mipush.sdk.MiPushCommandMessage):void");
    }
}
