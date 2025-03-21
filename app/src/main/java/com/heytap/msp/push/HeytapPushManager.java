package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.p160k.C2102b;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.notification.PushNotificationManager;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HeytapPushManager {
    public static void cancelNotification(JSONObject jSONObject) {
        C2080a.m5698w().mo5728d(jSONObject);
    }

    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        C2080a.m5698w().mo5721b(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        C2080a.m5698w().mo5715a(jSONObject);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        C2080a.m5698w().mo5710a(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        C2080a.m5698w().mo5720b(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        C2080a.m5698w().mo5709a(iGetAppNotificationCallBackService);
    }

    public static String getMcsPackageName(Context context) {
        return C2080a.m5698w().m5702a(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        C2080a.m5698w().mo5731e(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return C2080a.m5698w().m5745n();
    }

    public static PushNotificationManager getPushNotificationManager() {
        return PushNotificationManager.getInstance();
    }

    public static void getPushStatus() {
        C2080a.m5698w().m5748q();
    }

    public static int getPushVersionCode() {
        return C2080a.m5698w().m5749r();
    }

    public static String getPushVersionName() {
        return C2080a.m5698w().m5750s();
    }

    public static String getReceiveSdkAction(Context context) {
        return C2080a.m5698w().m5716b(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        C2080a.m5698w().mo5739i(jSONObject);
    }

    public static String getRegisterID() {
        return C2080a.m5698w().mo5727d();
    }

    public static int getSDKVersionCode() {
        return C2080a.m5699x();
    }

    public static String getSDKVersionName() {
        return C2080a.m5700y();
    }

    public static void init(Context context, boolean z) {
        C2080a.m5698w().m5701a(context, z);
    }

    public static boolean isSupportPush(Context context) {
        return C2080a.m5698w().m5729d(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        C2080a.m5698w().mo5733f(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        C2080a.m5698w().mo5735g(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        C2080a.m5698w().mo5707a(context, str, str2, jSONObject, iCallBackResultService);
    }

    @Deprecated
    public static void requestNotificationPermission() {
        C2080a.m5698w().mo5730e();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        C2080a.m5698w().mo5724c(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        C2080a.m5698w().m5712a(str, str2);
    }

    public static void setNotificationType(int i2) {
        setNotificationType(i2, null);
    }

    public static void setNotificationType(int i2, JSONObject jSONObject) {
        C2080a.m5698w().mo5705a(i2, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        C2080a.m5698w().m5708a(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5) {
        setPushTime(list, i2, i3, i4, i5, null);
    }

    public static void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        C2080a.m5698w().mo5714a(list, i2, i3, i4, i5, jSONObject);
    }

    public static void setRegisterID(String str) {
        C2080a.m5698w().mo5711a(str);
    }

    public static void statisticEvent(Context context, String str, DataMessage dataMessage) {
        StatisticUtils.statisticEvent(context, str, dataMessage);
    }

    @Deprecated
    public static void statisticMessage(Context context, MessageStat messageStat) {
        C2102b.m5855a(context, messageStat);
    }

    @Deprecated
    public static void statisticMessage(Context context, List<MessageStat> list) {
        C2102b.m5857a(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        C2080a.m5698w().m5719b(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        C2080a.m5698w().mo5737h(jSONObject);
    }
}
