package com.tencent.p208mm.opensdk.channel;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.p208mm.opensdk.channel.p209a.C3232a;
import com.tencent.p208mm.opensdk.constants.Build;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;
import com.tencent.p208mm.opensdk.utils.C3240b;
import com.tencent.p208mm.opensdk.utils.Log;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public int launchMode = 2;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(Context context, Args args) {
        String str;
        if (context == null || args == null) {
            str = "send fail, invalid argument";
        } else if (C3240b.m10372b(args.targetPkgName)) {
            str = "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName;
        } else {
            if (C3240b.m10372b(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
            }
            Log.m10363d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName + ", launchMode = " + args.launchMode);
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            Bundle bundle = args.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, args.content);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C3232a.m10351a(args.content, Build.SDK_INT, packageName));
            intent.putExtra(ConstantsAPI.TOKEN, args.token);
            int i2 = args.flags;
            if (i2 == -1) {
                intent.addFlags(CommonNetImpl.FLAG_AUTH).addFlags(AbstractC1191a.f2490C1);
            } else {
                intent.setFlags(i2);
            }
            try {
                if (Build.VERSION.SDK_INT < 29 || args.launchMode != 2) {
                    context.startActivity(intent);
                } else {
                    sendUsingPendingIntent(context, intent);
                }
                Log.m10363d(TAG, "send mm message, intent=" + intent);
                return true;
            } catch (Exception e2) {
                str = "send fail, ex = " + e2.getMessage();
            }
        }
        Log.m10364e(TAG, str);
        return false;
    }

    private static void sendUsingPendingIntent(Context context, Intent intent) {
        try {
            Log.m10365i(TAG, "sendUsingPendingIntent");
            PendingIntent.getActivity(context, 3, intent, AbstractC1191a.f2490C1).send(context, 4, null, new PendingIntent.OnFinished() { // from class: com.tencent.mm.opensdk.channel.MMessageActV2.1
                @Override // android.app.PendingIntent.OnFinished
                public void onSendFinished(PendingIntent pendingIntent, Intent intent2, int i2, String str, Bundle bundle) {
                    Log.m10365i(MMessageActV2.TAG, "sendUsingPendingIntent onSendFinished resultCode: " + i2 + ", resultData: " + str);
                }
            }, null);
        } catch (Exception e2) {
            Log.m10364e(TAG, "sendUsingPendingIntent fail, ex = " + e2.getMessage());
            context.startActivity(intent);
        }
    }
}
