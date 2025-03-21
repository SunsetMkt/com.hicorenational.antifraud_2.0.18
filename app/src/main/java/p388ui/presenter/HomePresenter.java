package p388ui.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import bean.VerifyHomePointBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.google.gson.p152d0.C2049a;
import com.tencent.open.SocialConstants;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.IVerifyListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.BannerInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import org.greenrobot.eventbus.C6049c;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.activity.IDVarfyAceptListActivity;
import p388ui.callview.HomeCallView;
import p388ui.fragment.HomeFragment;
import p388ui.model.ModelPresent;
import p388ui.presenter.HomePresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7307p1;
import util.C7337y1;
import util.C7340z1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class HomePresenter extends ModelPresent<HomeCallView> {

    /* renamed from: bean, reason: collision with root package name */
    private VerifyHomePointBean f25906bean;
    private Dialog verifyDlg;

    /* renamed from: ui.presenter.HomePresenter$a */
    class C6999a extends MiddleSubscriber<APIresult<List<BannerInfo>>> {

        /* renamed from: ui.presenter.HomePresenter$a$a */
        class a extends C2049a<List<BannerInfo>> {
            a() {
            }
        }

        C6999a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onBannerSuccRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<BannerInfo>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((HomeCallView) HomePresenter.this.mvpView).onBannerSuccRequest(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.HomePresenter$b */
    class C7000b implements InterfaceC4514i0<List<HomeNewCaseBean.RowsBean>> {

        /* renamed from: a */
        final /* synthetic */ int f24116a;

        /* renamed from: b */
        final /* synthetic */ int f24117b;

        /* renamed from: c */
        final /* synthetic */ boolean f24118c;

        C7000b(int i2, int i3, boolean z) {
            this.f24116a = i2;
            this.f24117b = i3;
            this.f24118c = z;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<HomeNewCaseBean.RowsBean> list) {
            if (list != null || list.size() > 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onNewCaseRequest(list);
            } else {
                onError(null);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            HomePresenter.this.getNewCaseApi(this.f24116a, this.f24117b, this.f24118c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        }
    }

    /* renamed from: ui.presenter.HomePresenter$c */
    class C7001c extends MiddleSubscriber<APIresult<HomeNewCaseBean>> {

        /* renamed from: a */
        final /* synthetic */ boolean f24120a;

        C7001c(boolean z) {
            this.f24120a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HomeNewCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onNewCaseFail(this.f24120a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HomeNewCaseBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((HomeCallView) HomePresenter.this.mvpView).onNewCaseRequest(aPIresult.getData().getRows());
            }
        }
    }

    /* renamed from: ui.presenter.HomePresenter$d */
    class C7002d extends MiddleSubscriber<APIresult<Boolean>> {

        /* renamed from: a */
        final /* synthetic */ boolean f24122a;

        C7002d(boolean z) {
            this.f24122a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(false, this.f24122a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Boolean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(aPIresult.getData().booleanValue(), this.f24122a);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    /* renamed from: ui.presenter.HomePresenter$e */
    class C7003e extends MiddleSubscriber<APIresult<VerifyHomePointBean>> {

        /* renamed from: a */
        final /* synthetic */ IOneClickListener f24124a;

        C7003e(IOneClickListener iOneClickListener) {
            this.f24124a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return VerifyHomePointBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            HomePresenter.this.f25906bean = null;
            HomePresenter.this.notifyVerifyHomePointBean();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<VerifyHomePointBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HomePresenter.this.f25906bean = aPIresult.getData();
            HomePresenter.this.notifyVerifyHomePointBean();
            IOneClickListener iOneClickListener = this.f24124a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
        }
    }

    /* renamed from: ui.presenter.HomePresenter$f */
    class C7004f implements IOneClickListener {
        C7004f() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            HomePresenter.this.showIDVerifyDlg();
        }
    }

    /* renamed from: ui.presenter.HomePresenter$g */
    class C7005g implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ String f24127a;

        C7005g(String str) {
            this.f24127a = str;
        }

        /* renamed from: a */
        public /* synthetic */ void m25636a() {
            if (TextUtils.isEmpty(HomePresenter.this.f25906bean.getVerificationPath())) {
                HomePresenter.this.mActivity.startActivity(new Intent(HomePresenter.this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
            } else {
                HomePresenter homePresenter = HomePresenter.this;
                C7292k1.m26393a(homePresenter.mActivity, homePresenter.f25906bean.getVerificationPath());
            }
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            C7307p1.m26479a("update_home", this.f24127a);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7340z1.m26805a(HomePresenter.this.mActivity).m26811a(15, new IVerifyListener() { // from class: ui.presenter.f
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    HomePresenter.C7005g.this.m25636a();
                }
            });
        }
    }

    /* renamed from: ui.presenter.HomePresenter$h */
    class C7006h extends MiddleSubscriber<APIresult<NoteDlgBean>> {
        C7006h() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return NoteDlgBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onNoteDlgRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<NoteDlgBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onNoteDlgRequest(aPIresult.getData());
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public HomePresenter(Activity activity, HomeCallView homeCallView) {
        super(activity, homeCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewCaseApi(int i2, int i3, boolean z) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_LOCALNEWS, 8, C4445b.f16988B);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Page", i2 + "");
        hashMap.put("Rows", i3 + "");
        hashMap.put("Sort", "releasetime");
        hashMap.put("Order", SocialConstants.PARAM_APP_DESC);
        getNewCaseList(m16395a, hashMap, new C7001c(z));
    }

    private String getOssPath() {
        RegionMudelBean m16408j = C4440a.m16408j();
        return (m16408j == null || !TextUtils.equals(C4440a.m16398b(ModuelConfig.MODEL_LOCALNEWS), "1")) ? C4440a.f16879a : m16408j.getOssPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showIDVerifyDlg() {
        VerifyHomePointBean verifyHomePointBean = this.f25906bean;
        if (verifyHomePointBean == null || verifyHomePointBean.getToVerificationCount() <= 0) {
            return;
        }
        Dialog dialog = this.verifyDlg;
        if ((dialog == null || !dialog.isShowing()) && HomeFragment.mIsVisibleToUser) {
            String m26477a = C7307p1.m26477a("update_home");
            String m26775d = C7337y1.m26775d("yyyy-MM-dd");
            if (TextUtils.equals(m26477a, m26775d)) {
                return;
            }
            this.verifyDlg = C7257b1.m26174a(this.mActivity, new C7005g(m26775d));
        }
    }

    public void changeBottomView(RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            C6049c.m24987f().m25000d(new C7265a(221, regionMudelBean.getLocal()));
        }
    }

    public void checkPolice(boolean z) {
        getAccHasPwd(C4440a.m16395a("", 8, C4445b.f17042T), new C7002d(z));
    }

    public void getBanner() {
        getBanner(C4440a.f16881c + C4445b.f17093i, new C6999a());
    }

    public void getNewCase(int i2, int i3, boolean z, boolean z2) {
        if (z) {
            getNewCaseOss(i2, i3, z2);
        } else {
            ((HomeCallView) this.mvpView).onNewCaseFail(false);
        }
    }

    public void getNewCaseOss(int i2, int i3, boolean z) {
        String str;
        if (i2 == 1) {
            str = getOssPath() + "h5/news/index/index-1.json";
        } else {
            if (i2 != 2) {
                ((HomeCallView) this.mvpView).onNewCaseRequest(null);
                return;
            }
            str = getOssPath() + "h5/news/index/index-2.json";
        }
        getNewCaseListOss(str, new C7000b(i2, i3, z));
    }

    public void getVerifyHomePoint(IOneClickListener iOneClickListener) {
        getVerifyHomePoint(C4440a.f16881c + C4445b.f17115p0, new C7003e(iOneClickListener));
    }

    public void getVerifyPoint() {
        if (AccountManager.isLogin()) {
            getVerifyHomePoint(new C7004f());
        }
    }

    public VerifyHomePointBean getVerifyPointBean() {
        return this.f25906bean;
    }

    public void notifyVerifyHomePointBean() {
        VerifyHomePointBean verifyHomePointBean = this.f25906bean;
        if (verifyHomePointBean != null) {
            ((HomeCallView) this.mvpView).onRedDotStatus(verifyHomePointBean.getToVerificationCount() > 0 || this.f25906bean.getPendingVerificationCount() > 0);
        } else {
            ((HomeCallView) this.mvpView).onRedDotStatus(false);
        }
    }

    public void requestNoteDlg() {
        requestNewNote(C4440a.f16881c + C4445b.f17123s, new C7006h());
    }
}
