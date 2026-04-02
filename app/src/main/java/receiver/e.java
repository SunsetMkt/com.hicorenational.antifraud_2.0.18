package receiver;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import bean.PushEntity;
import com.hicorenational.antifraud.R;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IClickListener;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import org.android.agoo.honor.HonorRegister;
import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.oppo.OppoRegister;
import org.android.agoo.vivo.VivoRegister;
import org.android.agoo.xiaomi.MiPushRegistar;
import ui.activity.HistoryReportEvdListActivity;
import ui.activity.IDVarfyListActivity;
import ui.activity.MainActivity;
import ui.activity.NoteListActivity;
import ui.activity.PromosWebDetActivity;
import ui.activity.ReportRecordsActivity;
import ui.activity.WebActivity;
import ui.activity.WebFullActivity;
import ui.activity.WelcomeActivity;
import util.c2;
import util.d2;
import util.f1;
import util.p1;
import util.r1;
import util.s1;

/* JADX INFO: compiled from: UmengPushMessage.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static String a = "";

    /* JADX INFO: renamed from: b */
    static Dialog f13024b = null;

    /* JADX INFO: renamed from: c */
    static PushAgent f13025c = null;

    /* JADX INFO: renamed from: d */
    public static String f13026d = "10007";

    /* JADX INFO: renamed from: e */
    static UmengNotificationClickHandler f13027e = new b();

    /* JADX INFO: compiled from: UmengPushMessage.java */
    static class a implements UPushRegisterCallback {
        a() {
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onFailure(String str, String str2) {
            s1.b("hsc", "\u6ce8\u518c\u5931\u8d25\uff1a-------->s:" + str + ",s1:" + str2);
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onSuccess(String str) {
            s1.c("hsc", "\u6ce8\u518c\u6210\u529f\uff1adeviceToken\uff1a-------->" + str);
            e.a = str;
        }
    }

    /* JADX INFO: compiled from: UmengPushMessage.java */
    static class b extends UmengNotificationClickHandler {
        b() {
        }

        @Override // com.umeng.message.UmengNotificationClickHandler
        public void launchApp(Context context, UMessage uMessage) {
            HashMap map;
            super.launchApp(context, uMessage);
            if (uMessage == null || (map = (HashMap) uMessage.extra) == null || map.size() <= 0) {
                return;
            }
            String str = map.containsKey("type") ? (String) map.get("type") : "";
            String str2 = map.containsKey("url") ? (String) map.get("url") : "";
            String str3 = map.containsKey("title") ? (String) map.get("title") : "";
            String str4 = map.containsKey("id") ? (String) map.get("id") : "";
            PushEntity.ExtraBean extraBean = new PushEntity.ExtraBean();
            extraBean.setType(str);
            extraBean.setId(str4);
            extraBean.setTitle(str3);
            extraBean.setUrl(str2);
            e.a(extraBean, context);
        }
    }

    /* JADX INFO: compiled from: UmengPushMessage.java */
    static class c implements IUmengCallback {
        c() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "\u5173\u95ed\u901a\u77e5\u5931\u8d25s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: compiled from: UmengPushMessage.java */
    static class d implements IUmengCallback {
        d() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "\u6253\u5f00\u901a\u77e5\u5931\u8d25s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: receiver.e$e */
    /* JADX INFO: compiled from: UmengPushMessage.java */
    static class C0281e implements IClickListener {
        final /* synthetic */ Activity a;

        C0281e(Activity activity) {
            this.a = activity;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            c2.b(c2.A, true);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            d2.k(this.a);
        }
    }

    public static void a(final List<String> list) {
        if (f13025c == null) {
            return;
        }
        List<String> tags = AccountManager.getAccountInfo().getTags();
        if (tags == null || tags.size() <= 0) {
            b(list);
        } else {
            f13025c.getTagManager().deleteTags(new UPushTagCallback() { // from class: receiver.d
                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean z, Object obj) {
                    e.a(list, z, (ITagManager.Result) obj);
                }
            }, (String[]) tags.toArray(new String[tags.size()]));
        }
    }

    public static void b(Application application, String str) {
        UMConfigure.preInit(application, r1.u.l(), str);
    }

    public static void c(Activity activity) {
        PushAgent.getInstance(activity).onAppStart();
        PushAgent.getInstance(activity).enable(new d());
    }

    public static boolean d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26 || !((Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) && c2.a(c2.B, false))) {
            return a(activity, UPushNotificationChannel.PRIMARY_CHANNEL);
        }
        return true;
    }

    public static void e(Activity activity) {
        if (!c2.a(c2.B, false)) {
            f(activity);
        }
        if (Build.VERSION.SDK_INT < 26) {
            if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
                c2.b(c2.B, true);
            }
        }
    }

    private static void f(Activity activity) {
        Dialog dialog = f13024b;
        if (dialog == null || !dialog.isShowing()) {
            f13024b = f1.b(activity, R.drawable.iv_flow_primiss, "\u5f00\u542f\u5ba3\u4f20\u53ca\u529f\u80fd\u6d88\u606f\u63a8\u9001", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "\u53ef\u81f3\u201d\u8bbe\u7f6e-\u901a\u77e5\u680f\u4e0e\u72b6\u6001\u201c\u4e2d\u5f00\u542f\u201d\u5141\u8bb8\u901a\u77e5\u3001\u7c7b\u522b\u901a\u77e5\u201c\u6743\u9650" : "\u53ef\u81f3\u201d\u8bbe\u7f6e-\u901a\u77e5\u680f\u4e0e\u72b6\u6001\u201c\u4e2d\u5f00\u542f\u201d\u5141\u8bb8\u901a\u77e5\u3001\u66f4\u591a\u901a\u77e5\u201c\u6743\u9650", "\u4e0d\u5141\u8bb8", "\u5141\u8bb8", new C0281e(activity));
        }
    }

    private static void b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        f13025c.getTagManager().addTags(new UPushTagCallback() { // from class: receiver.c
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z, Object obj) {
                s1.a("hsc", "\u6dfb\u52a0\u6807\u7b7e==" + z);
            }
        }, (String[]) list.toArray(new String[list.size()]));
    }

    public static void b(Activity activity) {
        PushAgent.getInstance(activity).disable(new c());
    }

    static /* synthetic */ void a(List list, boolean z, ITagManager.Result result) {
        s1.a("hsc", "\u5220\u9664\u6807\u7b7e==" + z);
        b((List<String>) list);
    }

    public static void a(Application application, String str) {
        try {
            UMConfigure.init(application, r1.u.l(), str, 1, r1.u.m());
            f13025c = PushAgent.getInstance(application);
            f13025c.register(new a());
            f13025c.setDisplayNotificationNumber(10);
            f13025c.setNotificationClickHandler(f13027e);
            MiPushRegistar.register(application, r1.u.n(), r1.u.o());
            HuaWeiRegister.register(application);
            OppoRegister.register(application, r1.u.p(), r1.u.q());
            VivoRegister.register(application);
            HonorRegister.register(application);
        } catch (Exception unused) {
        }
    }

    public static void a(PushEntity.ExtraBean extraBean, Context context) {
        if (extraBean == null) {
            return;
        }
        s1.a("bean.getType()==" + extraBean.getType() + " bean.getTitle()==" + extraBean.getTitle() + " bean.getUrl()==" + extraBean.getUrl());
        if (extraBean.getType().equalsIgnoreCase("10001")) {
            Intent intent = new Intent(context, (Class<?>) IDVarfyListActivity.class);
            intent.setFlags(805306368);
            context.startActivity(intent);
        }
        if (extraBean.getType().equalsIgnoreCase("10002")) {
            Intent intent2 = new Intent(context, (Class<?>) PromosWebDetActivity.class);
            intent2.putExtra(p1.P, extraBean.getTitle());
            intent2.putExtra(p1.Q, extraBean.getUrl());
            intent2.putExtra(p1.T, extraBean.getId());
            intent2.putExtra(p1.U, 2);
            intent2.setFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent2);
            return;
        }
        if (!extraBean.getType().equalsIgnoreCase("10004") && !extraBean.getType().equalsIgnoreCase("10005")) {
            if (extraBean.getType().equalsIgnoreCase("10006")) {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(extraBean.getUrl()));
                intent3.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent3);
                return;
            }
            if (extraBean.getType().equalsIgnoreCase(f13026d)) {
                ui.c.i().f();
                Intent intent4 = new Intent(context, (Class<?>) WelcomeActivity.class);
                intent4.putExtra(p1.f15012d, extraBean.getType());
                intent4.putExtra(p1.Q, extraBean.getUrl());
                intent4.setFlags(CommonNetImpl.FLAG_AUTH);
                MainActivity.getPushIntent(intent4);
                context.startActivity(intent4);
                return;
            }
            if (extraBean.getType().equalsIgnoreCase("10008")) {
                Intent intent5 = new Intent(context, (Class<?>) HistoryReportEvdListActivity.class);
                intent5.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent5);
                return;
            }
            if (extraBean.getType().equalsIgnoreCase("10009")) {
                Intent intent6 = new Intent(context, (Class<?>) ReportRecordsActivity.class);
                intent6.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent6);
                return;
            } else {
                if (extraBean.getType().equalsIgnoreCase("10010")) {
                    Intent intent7 = new Intent(context, (Class<?>) WebFullActivity.class);
                    intent7.putExtra(p1.Q, extraBean.getUrl());
                    intent7.setFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent7);
                    return;
                }
                if (extraBean.getType().equalsIgnoreCase("10011")) {
                    Intent intent8 = new Intent(context, (Class<?>) NoteListActivity.class);
                    intent8.setFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent8);
                    return;
                }
                return;
            }
        }
        String title = extraBean.getTitle();
        Intent intent9 = new Intent(context, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent9.putExtra(p1.P, title);
        intent9.putExtra(p1.Q, extraBean.getUrl());
        intent9.setFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent9);
    }

    public static void a(Activity activity) {
        if (d(activity) || c2.a(c2.A, false)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 && (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) {
            c2.b(c2.A, true);
        }
        f(activity);
    }

    private static boolean a(Context context, String str) {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean zAreNotificationsEnabled = notificationManagerCompatFrom.areNotificationsEnabled();
        if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(str, a(context), 4));
                notificationChannel = notificationManager.getNotificationChannel(str);
            }
            return zAreNotificationsEnabled && notificationChannel.getImportance() != 0;
        }
        if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
            return false;
        }
        return zAreNotificationsEnabled;
    }

    private static String a(Context context) {
        String notificationChannelName = PushAgent.getInstance(context).getNotificationChannelName();
        return TextUtils.isEmpty(notificationChannelName) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : notificationChannelName;
    }
}
