package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class a implements Runnable {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseNotifyClick f5948b;

    a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f5948b = baseNotifyClick;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent;
        Intent intent2 = null;
        try {
            if (this.a != null) {
                String msgByThirdPush = this.f5948b.parseMsgByThirdPush(this.a);
                if (TextUtils.isEmpty(msgByThirdPush) || TextUtils.isEmpty(this.f5948b.msgSource)) {
                    ALog.e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", this.f5948b.msgSource);
                    intent = null;
                } else {
                    if (this.f5948b.notifyManager == null) {
                        this.f5948b.notifyManager = new NotifManager();
                    }
                    if (this.f5948b.agooFactory == null) {
                        this.f5948b.agooFactory = new AgooFactory();
                        this.f5948b.agooFactory.init(this.f5948b.context, this.f5948b.notifyManager, null);
                    }
                    Bundle bundleMsgReceiverPreHandler = this.f5948b.agooFactory.msgReceiverPreHandler(msgByThirdPush.getBytes("UTF-8"), this.f5948b.msgSource, null, false);
                    String string = bundleMsgReceiverPreHandler.getString("body");
                    ALog.i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                    String encryptedMsg = AgooFactory.parseEncryptedMsg(string);
                    if (TextUtils.isEmpty(encryptedMsg)) {
                        ALog.e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                    } else {
                        bundleMsgReceiverPreHandler.putString("body", encryptedMsg);
                    }
                    intent = new Intent();
                    try {
                        intent.putExtras(bundleMsgReceiverPreHandler);
                        this.f5948b.agooFactory.saveMsg(msgByThirdPush.getBytes("UTF-8"), "2");
                        this.f5948b.reportClickNotifyMsg(intent);
                    } catch (Throwable th) {
                        intent2 = intent;
                        th = th;
                        try {
                            ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                            try {
                                this.f5948b.onMessage(intent2);
                                return;
                            } catch (Throwable th2) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th2, new Object[0]);
                                return;
                            }
                        } catch (Throwable th3) {
                            try {
                                this.f5948b.onMessage(intent2);
                            } catch (Throwable th4) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                            }
                            throw th3;
                        }
                    }
                }
            } else {
                intent = null;
            }
            try {
                this.f5948b.onMessage(intent);
            } catch (Throwable th5) {
                ALog.e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
