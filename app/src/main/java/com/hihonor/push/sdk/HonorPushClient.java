package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HonorPushClient {
    public static final HonorPushClient a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return a;
    }

    public boolean checkSupportHonorPush(Context context) {
        return l.f4263e.a(context);
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new g(lVar, honorPushCallback), honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new h(lVar, honorPushCallback), honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new f(lVar, honorPushCallback, false), honorPushCallback);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new k(lVar, honorPushCallback), honorPushCallback);
    }

    public void init(Context context, boolean z) {
        l lVar = l.f4263e;
        v vVar = new v();
        vVar.a = context.getApplicationContext();
        vVar.f4285b = z;
        b1.a(new e(lVar, vVar));
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new j(lVar, honorPushCallback), honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.f4263e;
        lVar.a(new i(lVar, honorPushCallback), honorPushCallback);
    }
}
