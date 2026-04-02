package receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.AppVirusBean;
import bean.SearchVirusAppBean;
import bean.SearchVirusAppResultBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppHttp;
import ui.callview.VirusKillingCallView;
import ui.d.a;
import ui.presenter.VirusKillingPresenter;
import ui.presenter.WelocmPresenter;
import util.c2;
import util.d2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class AppReceiver extends BroadcastReceiver implements a.InterfaceC0288a {
    private AppInfoBean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f13017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ui.d.a f13018c = null;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppReceiver appReceiver = AppReceiver.this;
            appReceiver.a = x1.c(appReceiver.f13017b).a(this.a);
            if (AppReceiver.this.a != null) {
                AppReceiver appReceiver2 = AppReceiver.this;
                appReceiver2.a(appReceiver2.a);
            }
        }
    }

    class b implements SearchVirusAppHttp.Callback {
        b() {
        }

        @Override // network.http.SearchVirusAppHttp.Callback
        public void principalResult(@j.c.a.e AppInfoBean appInfoBean, @j.c.a.e List<SearchVirusAppResultBean> list) {
            if (appInfoBean == null || list == null || list.size() <= 0) {
                return;
            }
            SearchVirusAppResultBean searchVirusAppResultBean = list.get(0);
            int riskLevel = searchVirusAppResultBean.getRiskLevel();
            if (riskLevel == 1) {
                if (appInfoBean.getVirusLevel() != 1) {
                    appInfoBean.setVirusLevel(2);
                }
                AppReceiver.this.a(appInfoBean, searchVirusAppResultBean);
            } else if (riskLevel == 2) {
                appInfoBean.setVirusLevel(1);
                AppReceiver.this.a(appInfoBean, searchVirusAppResultBean);
            } else if (riskLevel == 3) {
                appInfoBean.setVirusLevel(2);
                AppReceiver.this.a(appInfoBean, searchVirusAppResultBean);
            }
            String str = "getVirusLevel==" + appInfoBean.getVirusLevel();
            if (appInfoBean.getVirusLevel() == 1) {
                String str2 = "\u65b0\u4e0b\u8f7d\u7684\u201c" + appInfoBean.getName() + "\u201d\n\u7ecf\u68c0\u9a8c\u4e3a\u9ad8\u98ce\u9669\u8bc8\u9a97APP\uff0c\u8bf7\u8c28\u614e\u4f7f\u7528";
                AppReceiver appReceiver = AppReceiver.this;
                appReceiver.a(appReceiver.f13017b, str2);
                return;
            }
            if (appInfoBean.getVirusLevel() == 2) {
                String str3 = "\u65b0\u4e0b\u8f7d\u7684\u201c" + appInfoBean.getName() + "\u201d\n\u7ecf\u68c0\u9a8c\u8be5APP\u5b58\u5728\u98ce\u9669\uff0c\u8bf7\u8c28\u614e\u4f7f\u7528";
                AppReceiver appReceiver2 = AppReceiver.this;
                appReceiver2.a(appReceiver2.f13017b, str3);
            }
        }
    }

    class c implements VirusKillingCallView {
        final /* synthetic */ TextView a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AppReceiver.this.f13018c == null || !AppReceiver.this.f13018c.isShowing()) {
                    return;
                }
                AppReceiver.this.f13018c.dismiss();
            }
        }

        c(TextView textView) {
            this.a = textView;
        }

        @Override // ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            TextView textView;
            if (AppReceiver.this.f13018c != null && AppReceiver.this.f13018c.isShowing() && (textView = this.a) != null) {
                textView.setText("\u5df2\u63d0\u4ea4");
                this.a.setEnabled(false);
                this.a.setTextColor(AppReceiver.this.f13017b.getResources().getColor(R.color.colorGray));
                this.a.setBackgroundResource(R.drawable.button_bg_gray);
            }
            new Handler().postDelayed(new a(), 3000L);
        }
    }

    @Override // ui.d.a.InterfaceC0288a
    public void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (c2.a(c2.H, false) && !TextUtils.equals(WelocmPresenter.VIRAPWARN, "0")) {
            this.f13017b = context;
            String action = intent.getAction();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                String str = "onReceive    app is added-----------------   " + schemeSpecificPart;
                new Thread(new a(schemeSpecificPart)).start();
            }
        }
    }

    private void b(TextView textView) {
        ArrayList arrayList = new ArrayList();
        AppVirusBean appVirusBean = new AppVirusBean();
        appVirusBean.setAppName(this.a.getName());
        appVirusBean.setFileMd5(this.a.getAppMD5());
        appVirusBean.setVersionCode(this.a.getVersionCode() + "");
        appVirusBean.setPkgName(this.a.getPkgName());
        appVirusBean.setSignHash(this.a.getSignHash());
        appVirusBean.setFindTime(d2.a(System.currentTimeMillis()));
        appVirusBean.setVirusDescription(this.a.getVirusDescription());
        appVirusBean.setVirusName(this.a.getVirusName());
        int virusLevel = this.a.getVirusLevel();
        if (virusLevel == 1) {
            appVirusBean.setVirusLevel(1);
            appVirusBean.setIllegalType("\u75c5\u6bd2");
        } else if (virusLevel == 2 || virusLevel == 3) {
            appVirusBean.setVirusLevel(2);
            appVirusBean.setIllegalType("\u98ce\u9669");
        }
        arrayList.add(appVirusBean);
        new VirusKillingPresenter((Activity) null, (VirusKillingCallView) new c(textView)).appealApp(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SearchVirusAppBean(appInfoBean.getName(), appInfoBean.getPkgName(), appInfoBean.getPkgPath(), appInfoBean.getAppMD5()));
        SearchVirusAppHttp.Companion.getInstance().principalHttp(appInfoBean, arrayList, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean, SearchVirusAppResultBean searchVirusAppResultBean) {
        String str;
        String virusName = appInfoBean.getVirusName();
        String str2 = "";
        if (TextUtils.isEmpty(virusName)) {
            virusName = "";
        }
        String virusName2 = searchVirusAppResultBean.getVirusName();
        if (TextUtils.isEmpty(virusName2)) {
            str = "";
        } else {
            str = AppInfoBean.API_TAG_VIRUS_NAME + virusName2;
        }
        appInfoBean.setVirusName(virusName + str);
        String virusDescription = appInfoBean.getVirusDescription();
        if (TextUtils.isEmpty(virusDescription)) {
            virusDescription = "";
        }
        String virusDesc = searchVirusAppResultBean.getVirusDesc();
        if (!TextUtils.isEmpty(virusDesc)) {
            str2 = AppInfoBean.API_TAG_VIRUS_DISCRIPTION + virusDesc;
        }
        appInfoBean.setVirusDescription(virusDescription + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        this.f13018c = new ui.d.a(context);
        this.f13018c.show();
        this.f13018c.a(str);
        this.f13018c.setOnBtnClickListener(this);
    }

    @Override // ui.d.a.InterfaceC0288a
    public void a(TextView textView) {
        b(textView);
    }
}
