package ui.presenter;

import android.app.Activity;
import bean.ReportZPBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.TagFlowLayoutCallView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class TagFlowLayoutPresenter extends ModelPresent<TagFlowLayoutCallView> {

    class a extends MiddleSubscriber<APIresult<List<ReportZPBean>>> {

        /* JADX INFO: renamed from: ui.presenter.TagFlowLayoutPresenter$a$a, reason: collision with other inner class name */
        class C0318a extends com.google.gson.d0.a<List<ReportZPBean>> {
            C0318a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0318a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.e(aPIException.getMessage());
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
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        String strB = e.a.b(ModuelConfig.MODEL_REPORT, 5, f.b.Y);
        if (i2 == 2) {
            strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.X0);
        }
        getReportMarkData(strB, new a());
    }
}
