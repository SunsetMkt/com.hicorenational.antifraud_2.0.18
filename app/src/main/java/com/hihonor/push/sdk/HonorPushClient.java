package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
public class HonorPushClient {

    /* renamed from: a */
    public static final HonorPushClient f6742a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return f6742a;
    }

    public boolean checkSupportHonorPush(Context context) {
        return C2214l.f6798e.m6395a(context);
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2202g(c2214l, honorPushCallback), honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2205h(c2214l, honorPushCallback), honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2199f(c2214l, honorPushCallback, false), honorPushCallback);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2212k(c2214l, honorPushCallback), honorPushCallback);
    }

    public void init(Context context, boolean z) {
        C2214l c2214l = C2214l.f6798e;
        C2234v c2234v = new C2234v();
        c2234v.f6840a = context.getApplicationContext();
        c2234v.f6841b = z;
        C2188b1.m6373a(new RunnableC2196e(c2214l, c2234v));
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2210j(c2214l, honorPushCallback), honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        C2214l c2214l = C2214l.f6798e;
        c2214l.m6394a(new RunnableC2208i(c2214l, honorPushCallback), honorPushCallback);
    }
}
