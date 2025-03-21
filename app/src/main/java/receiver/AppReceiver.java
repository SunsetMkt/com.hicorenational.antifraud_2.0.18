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
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppHttp;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.VirusKillingCallView;
import p388ui.p389d.DialogC6818a;
import p388ui.presenter.VirusKillingPresenter;
import p388ui.presenter.WelocmPresenter;
import util.C7316r1;
import util.C7325u1;
import util.C7328v1;

/* loaded from: classes2.dex */
public class AppReceiver extends BroadcastReceiver implements DialogC6818a.a {

    /* renamed from: a */
    private AppInfoBean f21695a;

    /* renamed from: b */
    private Context f21696b;

    /* renamed from: c */
    private DialogC6818a f21697c = null;

    /* renamed from: receiver.AppReceiver$a */
    class RunnableC6079a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21698a;

        RunnableC6079a(String str) {
            this.f21698a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppReceiver appReceiver = AppReceiver.this;
            appReceiver.f21695a = C7316r1.m26548c(appReceiver.f21696b).m26556a(this.f21698a);
            if (AppReceiver.this.f21695a != null) {
                AppReceiver appReceiver2 = AppReceiver.this;
                appReceiver2.m25163a(appReceiver2.f21695a);
            }
        }
    }

    /* renamed from: receiver.AppReceiver$b */
    class C6080b implements SearchVirusAppHttp.Callback {
        C6080b() {
        }

        @Override // network.http.SearchVirusAppHttp.Callback
        public void principalResult(@InterfaceC5817e AppInfoBean appInfoBean, @InterfaceC5817e List<SearchVirusAppResultBean> list) {
            if (appInfoBean == null || list == null || list.size() <= 0) {
                return;
            }
            SearchVirusAppResultBean searchVirusAppResultBean = list.get(0);
            int riskLevel = searchVirusAppResultBean.getRiskLevel();
            if (riskLevel == 1) {
                if (appInfoBean.getVirusLevel() != 1) {
                    appInfoBean.setVirusLevel(2);
                }
                AppReceiver.this.m25164a(appInfoBean, searchVirusAppResultBean);
            } else if (riskLevel == 2) {
                appInfoBean.setVirusLevel(1);
                AppReceiver.this.m25164a(appInfoBean, searchVirusAppResultBean);
            }
            String str = "getVirusLevel==" + appInfoBean.getVirusLevel();
            if (appInfoBean.getVirusLevel() == 1 || appInfoBean.getVirusLevel() == 2) {
                AppReceiver appReceiver = AppReceiver.this;
                appReceiver.m25162a(appReceiver.f21696b, appInfoBean.getName());
            }
        }
    }

    /* renamed from: receiver.AppReceiver$c */
    class C6081c implements VirusKillingCallView {

        /* renamed from: a */
        final /* synthetic */ TextView f21701a;

        /* renamed from: receiver.AppReceiver$c$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AppReceiver.this.f21697c == null || !AppReceiver.this.f21697c.isShowing()) {
                    return;
                }
                AppReceiver.this.f21697c.dismiss();
            }
        }

        C6081c(TextView textView) {
            this.f21701a = textView;
        }

        @Override // p388ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            TextView textView;
            if (AppReceiver.this.f21697c != null && AppReceiver.this.f21697c.isShowing() && (textView = this.f21701a) != null) {
                textView.setText("已提交");
                this.f21701a.setEnabled(false);
                this.f21701a.setTextColor(AppReceiver.this.f21696b.getResources().getColor(C2113R.color.colorGray));
                this.f21701a.setBackgroundResource(C2113R.drawable.button_bg_gray);
            }
            new Handler().postDelayed(new a(), 3000L);
        }
    }

    @Override // p388ui.p389d.DialogC6818a.a
    /* renamed from: a */
    public void mo25171a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C7325u1.m26623a(C7325u1.f25637H, false) && !TextUtils.equals(WelocmPresenter.VIRAPWARN, "0")) {
            this.f21696b = context;
            String action = intent.getAction();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                String str = "onReceive    app is added-----------------   " + schemeSpecificPart;
                new Thread(new RunnableC6079a(schemeSpecificPart)).start();
            }
        }
    }

    /* renamed from: b */
    private void m25168b(TextView textView) {
        ArrayList arrayList = new ArrayList();
        AppVirusBean appVirusBean = new AppVirusBean();
        appVirusBean.setAppName(this.f21695a.getName());
        appVirusBean.setFileMd5(this.f21695a.getAppMD5());
        appVirusBean.setVersionCode(this.f21695a.getVersionCode() + "");
        appVirusBean.setPkgName(this.f21695a.getPkgName());
        appVirusBean.setSignHash(this.f21695a.getSignHash());
        appVirusBean.setFindTime(C7328v1.m26646a(System.currentTimeMillis()));
        appVirusBean.setVirusDescription(this.f21695a.getVirusDescription());
        appVirusBean.setVirusName(this.f21695a.getVirusName());
        int virusLevel = this.f21695a.getVirusLevel();
        if (virusLevel == 1) {
            appVirusBean.setVirusLevel(1);
            appVirusBean.setIllegalType("病毒");
        } else if (virusLevel == 2) {
            appVirusBean.setVirusLevel(2);
            appVirusBean.setIllegalType("风险");
        }
        arrayList.add(appVirusBean);
        new VirusKillingPresenter((Activity) null, (VirusKillingCallView) new C6081c(textView)).appealApp(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25163a(AppInfoBean appInfoBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SearchVirusAppBean(appInfoBean.getName(), appInfoBean.getPkgName(), appInfoBean.getPkgPath(), appInfoBean.getAppMD5()));
        SearchVirusAppHttp.Companion.getInstance().principalHttp(appInfoBean, arrayList, new C6080b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25164a(AppInfoBean appInfoBean, SearchVirusAppResultBean searchVirusAppResultBean) {
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
    /* renamed from: a */
    public void m25162a(Context context, String str) {
        this.f21697c = new DialogC6818a(context);
        this.f21697c.show();
        this.f21697c.m25476a("新下载的“" + str + "”\n经检测为疑似涉诈APP，请谨慎使用");
        this.f21697c.setOnBtnClickListener(this);
    }

    @Override // p388ui.p389d.DialogC6818a.a
    /* renamed from: a */
    public void mo25172a(TextView textView) {
        m25168b(textView);
    }
}
