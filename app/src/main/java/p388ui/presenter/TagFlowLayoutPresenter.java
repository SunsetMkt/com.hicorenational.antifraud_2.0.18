package p388ui.presenter;

import android.app.Activity;
import bean.ReportZPBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.TagFlowLayoutCallView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class TagFlowLayoutPresenter extends ModelPresent<TagFlowLayoutCallView> {

    /* renamed from: ui.presenter.TagFlowLayoutPresenter$a */
    class C7098a extends MiddleSubscriber<APIresult<List<ReportZPBean>>> {

        /* renamed from: ui.presenter.TagFlowLayoutPresenter$a$a */
        class a extends C2049a<List<ReportZPBean>> {
            a() {
            }
        }

        C7098a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReportZPBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            List<ReportZPBean> data = aPIresult.getData();
            if (data == null || data.size() <= 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((TagFlowLayoutCallView) TagFlowLayoutPresenter.this.mvpView).onSuccessRequest(data);
            }
        }
    }

    public TagFlowLayoutPresenter(Activity activity, TagFlowLayoutCallView tagFlowLayoutCallView) {
        super(activity, tagFlowLayoutCallView);
    }

    public void getReportMarkData(int i2) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17054X);
        if (i2 == 2) {
            m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17052W0);
        }
        getReportMarkData(m16395a, new C7098a());
    }
}
