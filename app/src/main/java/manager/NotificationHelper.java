package manager;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import d.c.a.b.a.a;
import ui.activity.MainActivity;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHelper {
    public static final String CHANEL_NAME = "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3";
    private static final String CHANNEL_ID = "appid";
    public static int NOTICE_ID = 1;

    @TargetApi(19)
    public static boolean isNotificationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 26 && ((NotificationManager) context.getSystemService("notification")).getImportance() == 0) {
            return false;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Notification showNotification(Context context) {
        Notification.Builder builder;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, "appid");
            NotificationChannel notificationChannel = new NotificationChannel("appid", CHANEL_NAME, 4);
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        } else {
            builder = new Notification.Builder(context);
        }
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.putExtra(p1.f15012d, "10010");
        intent.putExtra(p1.Q, "https://www.baidu.com");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        intent.addFlags(a.B1);
        intent.addFlags(CommonNetImpl.FLAG_SHARE);
        Notification notificationBuild = builder.setContentTitle("\u901a\u77e5\u680f\u6807\u9898").setContentText("\u6253\u51fb\u9632\u8303\u7f51\u7edc\u8bc8\u9a97").setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).setTicker(CHANEL_NAME).setAutoCancel(false).setContentIntent(PendingIntent.getActivity(context, 0, intent, 0)).build();
        notificationManager.notify(NOTICE_ID, notificationBuild);
        return notificationBuild;
    }

    public static boolean isNotificationEnabled(Context context, String str, String str2) {
        if (!isNotificationEnabled(context)) {
            return false;
        }
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean zAreNotificationsEnabled = notificationManagerCompatFrom.areNotificationsEnabled();
        if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(str, str2, 4));
                notificationChannel = notificationManager.getNotificationChannel(str);
            }
            return zAreNotificationsEnabled && notificationChannel.getImportance() != 0;
        }
        if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
            return true;
        }
        return zAreNotificationsEnabled;
    }
}
