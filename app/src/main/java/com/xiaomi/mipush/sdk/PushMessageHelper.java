package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4269hi;
import java.util.List;

/* loaded from: classes2.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j2, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j2);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(C4269hi c4269hi, C4252gs c4252gs, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(c4269hi.m15439a());
        if (!TextUtils.isEmpty(c4269hi.m15448d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(c4269hi.m15448d());
        } else if (!TextUtils.isEmpty(c4269hi.m15446c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(c4269hi.m15446c());
        } else if (TextUtils.isEmpty(c4269hi.m15452f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(c4269hi.m15452f());
        }
        miPushMessage.setCategory(c4269hi.m15450e());
        if (c4269hi.m15438a() != null) {
            miPushMessage.setContent(c4269hi.m15438a().m15070c());
        }
        if (c4252gs != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(c4252gs.m15096a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(c4252gs.m15106b());
            }
            miPushMessage.setDescription(c4252gs.m15118d());
            miPushMessage.setTitle(c4252gs.m15114c());
            miPushMessage.setNotifyType(c4252gs.m15089a());
            miPushMessage.setNotifyId(c4252gs.m15111c());
            miPushMessage.setPassThrough(c4252gs.m15103b());
            miPushMessage.setExtra(c4252gs.m15097a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(1);
            } else {
                setPushMode(2);
            }
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i2) {
        pushMode = i2;
    }

    public static C4252gs generateMessage(MiPushMessage miPushMessage) {
        C4252gs c4252gs = new C4252gs();
        c4252gs.m15094a(miPushMessage.getMessageId());
        c4252gs.m15105b(miPushMessage.getTopic());
        c4252gs.m15117d(miPushMessage.getDescription());
        c4252gs.m15113c(miPushMessage.getTitle());
        c4252gs.m15112c(miPushMessage.getNotifyId());
        c4252gs.m15093a(miPushMessage.getNotifyType());
        c4252gs.m15104b(miPushMessage.getPassThrough());
        c4252gs.m15095a(miPushMessage.getExtra());
        return c4252gs;
    }
}
