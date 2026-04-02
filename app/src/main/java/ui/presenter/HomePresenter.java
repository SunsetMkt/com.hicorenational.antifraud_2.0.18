package ui.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import bean.VerifyHomePointBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
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
import ui.activity.IDVarfyAceptListActivity;
import ui.callview.HomeCallView;
import ui.fragment.HomeFragment;
import ui.model.ModelPresent;
import util.f1;
import util.g2;
import util.h2;
import util.p1;
import util.u1;

/* JADX INFO: loaded from: classes2.dex */
public class HomePresenter extends ModelPresent<HomeCallView> {

    /* JADX INFO: renamed from: bean */
    private VerifyHomePointBean f14337bean;
    private Dialog verifyDlg;

    class a extends MiddleSubscriber<APIresult<List<BannerInfo>>> {

        /* JADX INFO: renamed from: ui.presenter.HomePresenter$a$a */
        class C0304a extends com.google.gson.d0.a<List<BannerInfo>> {
            C0304a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0304a().getType();
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

    class b implements h.a.i0<List<HomeNewCaseBean.RowsBean>> {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f14338b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f14339c;

        b(int i2, int i3, boolean z) {
            this.a = i2;
            this.f14338b = i3;
            this.f14339c = z;
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a */
        public void onNext(List<HomeNewCaseBean.RowsBean> list) {
            if (list != null || list.size() > 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onNewCaseRequest(list);
            } else {
                onError(null);
            }
        }

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            HomePresenter.this.getNewCaseApi(this.a, this.f14338b, this.f14339c);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
        }
    }

    class c extends MiddleSubscriber<APIresult<HomeNewCaseBean>> {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HomeNewCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onNewCaseFail(this.a);
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

    class d extends MiddleSubscriber<APIresult<Boolean>> {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(false, this.a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Boolean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(aPIresult.getData().booleanValue(), this.a);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    class e extends MiddleSubscriber<APIresult<VerifyHomePointBean>> {
        final /* synthetic */ IOneClickListener a;

        e(IOneClickListener iOneClickListener) {
            this.a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return VerifyHomePointBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            HomePresenter.this.f14337bean = null;
            HomePresenter.this.notifyVerifyHomePointBean();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<VerifyHomePointBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HomePresenter.this.f14337bean = aPIresult.getData();
            HomePresenter.this.notifyVerifyHomePointBean();
            IOneClickListener iOneClickListener = this.a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
        }
    }

    class f implements IOneClickListener {
        f() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            HomePresenter.this.showIDVerifyDlg();
        }
    }

    class g implements IClickListener {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        public /* synthetic */ void a() {
            if (TextUtils.isEmpty(HomePresenter.this.f14337bean.getVerificationPath())) {
                HomePresenter.this.mActivity.startActivity(new Intent(HomePresenter.this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
            } else {
                HomePresenter homePresenter = HomePresenter.this;
                p1.a(homePresenter.mActivity, homePresenter.f14337bean.getVerificationPath());
            }
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            u1.a("update_home", this.a);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            h2.a(HomePresenter.this.mActivity).a(15, new IVerifyListener() { // from class: ui.presenter.f
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.a.a();
                }
            });
        }
    }

    class h extends MiddleSubscriber<APIresult<NoteDlgBean>> {
        h() {
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

    public void getNewCaseApi(int i2, int i3, boolean z) {
        String strB = e.a.b(ModuelConfig.MODEL_LOCALNEWS, 8, f.b.C);
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", i2 + "");
        map.put("Rows", i3 + "");
        map.put("Sort", "releasetime");
        map.put("Order", SocialConstants.PARAM_APP_DESC);
        getNewCaseList(strB, map, new c(z));
    }

    private String getOssPath() {
        RegionMudelBean regionMudelBeanJ = e.a.j();
        return (regionMudelBeanJ == null || !TextUtils.equals(e.a.b(ModuelConfig.MODEL_LOCALNEWS), "1")) ? e.a.a : regionMudelBeanJ.getOssPath();
    }

    public void showIDVerifyDlg() {
        VerifyHomePointBean verifyHomePointBean = this.f14337bean;
        if (verifyHomePointBean == null || verifyHomePointBean.getToVerificationCount() <= 0) {
            return;
        }
        Dialog dialog = this.verifyDlg;
        if ((dialog == null || !dialog.isShowing()) && HomeFragment.mIsVisibleToUser) {
            String strA = u1.a("update_home");
            String strD = g2.d("yyyy-MM-dd");
            if (TextUtils.equals(strA, strD)) {
                return;
            }
            this.verifyDlg = f1.a(this.mActivity, new g(strD));
        }
    }

    public void changeBottomView(RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(221, regionMudelBean.getLocal()));
        }
    }

    public void checkPolice(boolean z) {
        getAccHasPwd(e.a.b("", 8, f.b.U), new d(z));
    }

    public void getBanner() {
        getBanner(e.a.f10139c + f.b.f10190i, new a());
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
        getNewCaseListOss(str, new b(i2, i3, z));
    }

    public void getVerifyHomePoint(IOneClickListener iOneClickListener) {
        getVerifyHomePoint(e.a.f10139c + f.b.q0, new e(iOneClickListener));
    }

    public void getVerifyPoint() {
        if (AccountManager.isLogin()) {
            getVerifyHomePoint(new f());
        }
    }

    public VerifyHomePointBean getVerifyPointBean() {
        return this.f14337bean;
    }

    public void notifyVerifyHomePointBean() {
        VerifyHomePointBean verifyHomePointBean = this.f14337bean;
        if (verifyHomePointBean != null) {
            ((HomeCallView) this.mvpView).onRedDotStatus(verifyHomePointBean.getToVerificationCount() > 0 || this.f14337bean.getPendingVerificationCount() > 0);
        } else {
            ((HomeCallView) this.mvpView).onRedDotStatus(false);
        }
    }

    public void requestNoteDlg() {
        requestNewNote(e.a.f10139c + f.b.t, new h());
    }
}
