package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import bean.GxButtonRedDotHintBean;
import bean.module.ModuelConfig;
import interfaces.IVerifyListener;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.ReportNumHttp;
import ui.Hicore;
import ui.callview.MainCallview;
import ui.model.ModelPresent;
import ui.view.BottomBar;
import util.h2;

/* JADX INFO: loaded from: classes2.dex */
public class MainPagePresenter extends ModelPresent<MainCallview> {

    class a extends MiddleSubscriber<APIresult<GxButtonRedDotHintBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return GxButtonRedDotHintBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<GxButtonRedDotHintBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                return;
            }
            ((MainCallview) MainPagePresenter.this.mvpView).isHindGxButtonRedDot(aPIresult.getData().isRedPoint());
        }
    }

    public MainPagePresenter(Activity activity, MainCallview mainCallview) {
        super(activity, mainCallview);
    }

    public /* synthetic */ void a() {
        ReportNumHttp.getInstance().principalHttp(new k0(this));
    }

    public void getH5SchmeData(BottomBar bottomBar) {
        util.o2.a aVarA = util.o2.c.a(Hicore.schemeString);
        if (aVarA.c()) {
            Hicore.schemeString = "";
            return;
        }
        String strB = aVarA.b(ConnType.PK_OPEN);
        if (TextUtils.equals("1", strB)) {
            bottomBar.setCurrentItem(1);
        } else if (TextUtils.equals("2", strB)) {
            h2.a(this.mActivity).a(1011, new IVerifyListener() { // from class: ui.presenter.g
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.a.a();
                }
            });
        }
        Hicore.schemeString = "";
    }

    public void gxButtonRedDotHind() {
        gxButtonRedDotHid(e.a.b(ModuelConfig.MODEL_WARN, 8, f.b.h2), new a());
    }
}
