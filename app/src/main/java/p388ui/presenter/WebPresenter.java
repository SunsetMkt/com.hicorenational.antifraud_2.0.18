package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.APIH5Bean;
import bean.ShareConfigBean;
import bean.WebArticleBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.StatisticsShareHttp;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.WebShareView;
import p388ui.model.ModelPresent;
import p388ui.p391f.DialogC6827c;
import util.C7257b1;

/* loaded from: classes2.dex */
public class WebPresenter extends ModelPresent<WebShareView> {
    private ShareConfigBean shareBean;
    private DialogC6827c shareDialog;

    /* renamed from: ui.presenter.WebPresenter$a */
    class C7119a extends MiddleSubscriber<APIresult<APIH5Bean>> {
        C7119a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                return;
            }
            ((WebShareView) WebPresenter.this.mvpView).onSuccessShareConfig(aPIresult.getData());
        }
    }

    /* renamed from: ui.presenter.WebPresenter$b */
    class C7120b extends MiddleSubscriber<APIresult<WebArticleBean>> {
        C7120b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return WebArticleBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<WebArticleBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                WebPresenter.this.onSuccRequest(aPIresult);
            }
        }
    }

    public WebPresenter(Activity activity, WebShareView webShareView) {
        super(activity, webShareView);
        this.shareBean = new ShareConfigBean();
    }

    public void doShare(final String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.shareDialog = new DialogC6827c(this.mActivity, this.shareBean, 2, new DialogC6827c.b() { // from class: ui.presenter.d0
            @Override // p388ui.p391f.DialogC6827c.b
            /* renamed from: a */
            public final void mo25436a() {
                StatisticsShareHttp.getInstance().shareArticleHttp(str);
            }
        });
        this.shareDialog.show();
    }

    public void onSuccRequest(APIresult<WebArticleBean> aPIresult) {
        WebArticleBean data = aPIresult.getData();
        if (data != null) {
            this.shareBean.downloadUrl = data.getContent();
            this.shareBean.title = data.getTitle();
            this.shareBean.iconUrl = data.getIcon();
            this.shareBean.description = data.getDescription();
            doShare(data.getId());
        }
    }

    public void requestAticleInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2)) {
            return;
        }
        C7257b1.m26203a("加载中...", true, this.mActivity);
        String str3 = str + C4445b.f16985A;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("informationID", str2);
        requessArticInfo(str3, hashMap, new C7120b());
    }

    public void requestShareConfig() {
        C7257b1.m26203a("请稍等...", true, this.mActivity);
        String str = C4440a.f16881c + C4445b.f17099k;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykey", "ExamShare");
        requestAppConfig(hashMap, str, new C7119a());
    }
}
