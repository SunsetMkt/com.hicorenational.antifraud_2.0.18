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
import com.hicorenational.antifraud.C2113R;
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
import p388ui.C6813c;
import p388ui.activity.HistoryReportEvdListActivity;
import p388ui.activity.IDVarfyListActivity;
import p388ui.activity.MainActivity;
import p388ui.activity.PromosWebDetActivity;
import p388ui.activity.ReportRecordsActivity;
import p388ui.activity.WebActivity;
import p388ui.activity.WebFullActivity;
import p388ui.activity.WelcomeActivity;
import util.C7257b1;
import util.C7292k1;
import util.C7298m1;
import util.C7301n1;
import util.C7325u1;
import util.C7328v1;

/* compiled from: UmengPushMessage.java */
/* renamed from: receiver.e */
/* loaded from: classes2.dex */
public class C6088e {

    /* renamed from: a */
    public static String f21713a = "";

    /* renamed from: b */
    static Dialog f21714b = null;

    /* renamed from: c */
    static PushAgent f21715c = null;

    /* renamed from: d */
    public static String f21716d = "10007";

    /* renamed from: e */
    static UmengNotificationClickHandler f21717e = new b();

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$a */
    static class a implements UPushRegisterCallback {
        a() {
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onFailure(String str, String str2) {
            C7301n1.m26457b("hsc", "注册失败：-------->s:" + str + ",s1:" + str2);
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onSuccess(String str) {
            C7301n1.m26459c("hsc", "注册成功：deviceToken：-------->" + str);
            C6088e.f21713a = str;
        }
    }

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$b */
    static class b extends UmengNotificationClickHandler {
        b() {
        }

        @Override // com.umeng.message.UmengNotificationClickHandler
        public void launchApp(Context context, UMessage uMessage) {
            HashMap hashMap;
            super.launchApp(context, uMessage);
            if (uMessage == null || (hashMap = (HashMap) uMessage.extra) == null || hashMap.size() <= 0) {
                return;
            }
            String str = hashMap.containsKey("type") ? (String) hashMap.get("type") : "";
            String str2 = hashMap.containsKey("url") ? (String) hashMap.get("url") : "";
            String str3 = hashMap.containsKey("title") ? (String) hashMap.get("title") : "";
            String str4 = hashMap.containsKey("id") ? (String) hashMap.get("id") : "";
            PushEntity.ExtraBean extraBean = new PushEntity.ExtraBean();
            extraBean.setType(str);
            extraBean.setId(str4);
            extraBean.setTitle(str3);
            extraBean.setUrl(str2);
            C6088e.m25180a(extraBean, context);
        }
    }

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$c */
    static class c implements IUmengCallback {
        c() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "关闭通知失败s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$d */
    static class d implements IUmengCallback {
        d() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "打开通知失败s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$e */
    static class e implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f21718a;

        e(Activity activity) {
            this.f21718a = activity;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            C7325u1.m26631b(C7325u1.f25623A, true);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7328v1.m26673k(this.f21718a);
        }
    }

    /* renamed from: a */
    public static void m25181a(final List<String> list) {
        if (f21715c == null) {
            return;
        }
        List<String> tags = AccountManager.getAccountInfo().getTags();
        if (tags == null || tags.size() <= 0) {
            m25187b(list);
        } else {
            f21715c.getTagManager().deleteTags(new UPushTagCallback() { // from class: receiver.d
                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean z, Object obj) {
                    C6088e.m25182a(list, z, (ITagManager.Result) obj);
                }
            }, (String[]) tags.toArray(new String[tags.size()]));
        }
    }

    /* renamed from: b */
    public static void m25186b(Application application, String str) {
        UMConfigure.preInit(application, C7298m1.f25474u.m26444l(), str);
    }

    /* renamed from: c */
    public static void m25188c(Activity activity) {
        PushAgent.getInstance(activity).onAppStart();
        PushAgent.getInstance(activity).enable(new d());
    }

    /* renamed from: d */
    public static boolean m25189d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26 || !((Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) && C7325u1.m26623a(C7325u1.f25625B, false))) {
            return m25184a(activity, UPushNotificationChannel.PRIMARY_CHANNEL);
        }
        return true;
    }

    /* renamed from: e */
    public static void m25190e(Activity activity) {
        if (!C7325u1.m26623a(C7325u1.f25625B, false)) {
            m25191f(activity);
        }
        if (Build.VERSION.SDK_INT < 26) {
            if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
                C7325u1.m26631b(C7325u1.f25625B, true);
            }
        }
    }

    /* renamed from: f */
    private static void m25191f(Activity activity) {
        Dialog dialog = f21714b;
        if (dialog == null || !dialog.isShowing()) {
            f21714b = C7257b1.m26209b(activity, C2113R.drawable.iv_flow_primiss, "开启宣传及功能消息推送", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "可至”设置-通知栏与状态“中开启”允许通知、类别通知“权限" : "可至”设置-通知栏与状态“中开启”允许通知、更多通知“权限", "不允许", "允许", new e(activity));
        }
    }

    /* renamed from: b */
    private static void m25187b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        f21715c.getTagManager().addTags(new UPushTagCallback() { // from class: receiver.c
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z, Object obj) {
                C7301n1.m26454a("hsc", "添加标签==" + z);
            }
        }, (String[]) list.toArray(new String[list.size()]));
    }

    /* renamed from: b */
    public static void m25185b(Activity activity) {
        PushAgent.getInstance(activity).disable(new c());
    }

    /* renamed from: a */
    static /* synthetic */ void m25182a(List list, boolean z, ITagManager.Result result) {
        C7301n1.m26454a("hsc", "删除标签==" + z);
        m25187b((List<String>) list);
    }

    /* renamed from: a */
    public static void m25179a(Application application, String str) {
        try {
            UMConfigure.init(application, C7298m1.f25474u.m26444l(), str, 1, C7298m1.f25474u.m26445m());
            f21715c = PushAgent.getInstance(application);
            f21715c.register(new a());
            f21715c.setDisplayNotificationNumber(10);
            f21715c.setNotificationClickHandler(f21717e);
            MiPushRegistar.register(application, C7298m1.f25474u.m26446n(), C7298m1.f25474u.m26447o());
            HuaWeiRegister.register(application);
            OppoRegister.register(application, C7298m1.f25474u.m26448p(), C7298m1.f25474u.m26449q());
            VivoRegister.register(application);
            HonorRegister.register(application);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m25180a(PushEntity.ExtraBean extraBean, Context context) {
        if (extraBean == null) {
            return;
        }
        C7301n1.m26453a("bean.getType()==" + extraBean.getType() + " bean.getTitle()==" + extraBean.getTitle() + " bean.getUrl()==" + extraBean.getUrl());
        if (extraBean.getType().equalsIgnoreCase("10001")) {
            Intent intent = new Intent(context, (Class<?>) IDVarfyListActivity.class);
            intent.setFlags(805306368);
            context.startActivity(intent);
        }
        if (extraBean.getType().equalsIgnoreCase("10002")) {
            Intent intent2 = new Intent(context, (Class<?>) PromosWebDetActivity.class);
            intent2.putExtra(C7292k1.f25363P, extraBean.getTitle());
            intent2.putExtra(C7292k1.f25365Q, extraBean.getUrl());
            intent2.putExtra(C7292k1.f25371T, extraBean.getId());
            intent2.putExtra(C7292k1.f25373U, 2);
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
            if (extraBean.getType().equalsIgnoreCase(f21716d)) {
                C6813c.m25437i().m25451f();
                Intent intent4 = new Intent(context, (Class<?>) WelcomeActivity.class);
                intent4.putExtra(C7292k1.f25394d, extraBean.getType());
                intent4.putExtra(C7292k1.f25365Q, extraBean.getUrl());
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
            } else if (extraBean.getType().equalsIgnoreCase("10009")) {
                Intent intent6 = new Intent(context, (Class<?>) ReportRecordsActivity.class);
                intent6.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent6);
                return;
            } else {
                if (extraBean.getType().equalsIgnoreCase("10010")) {
                    Intent intent7 = new Intent(context, (Class<?>) WebFullActivity.class);
                    intent7.putExtra(C7292k1.f25365Q, extraBean.getUrl());
                    intent7.setFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent7);
                    return;
                }
                return;
            }
        }
        String title = extraBean.getTitle();
        Intent intent8 = new Intent(context, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent8.putExtra(C7292k1.f25363P, title);
        intent8.putExtra(C7292k1.f25365Q, extraBean.getUrl());
        intent8.setFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent8);
    }

    /* renamed from: a */
    public static void m25178a(Activity activity) {
        if (m25189d(activity) || C7325u1.m26623a(C7325u1.f25623A, false)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 && (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) {
            C7325u1.m26631b(C7325u1.f25623A, true);
        }
        m25191f(activity);
    }

    /* renamed from: a */
    private static boolean m25184a(Context context, String str) {
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean areNotificationsEnabled = from.areNotificationsEnabled();
        if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(str, m25177a(context), 4));
                notificationChannel = notificationManager.getNotificationChannel(str);
            }
            return areNotificationsEnabled && notificationChannel.getImportance() != 0;
        }
        if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
            return false;
        }
        return areNotificationsEnabled;
    }

    /* renamed from: a */
    private static String m25177a(Context context) {
        String notificationChannelName = PushAgent.getInstance(context).getNotificationChannelName();
        return TextUtils.isEmpty(notificationChannelName) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : notificationChannelName;
    }
}
