package ui.presenter;

import android.app.Activity;
import bean.AIInspectRecordBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import org.json.JSONObject;
import ui.callview.AIInspectRecordCallView;
import ui.model.ModelPresent;

/* JADX INFO: loaded from: classes2.dex */
public class AIInspectRecordPresenter extends ModelPresent<AIInspectRecordCallView> {
    private boolean mCurrentState;

    class a extends MiddleSubscriber<APIresult<AIInspectRecordBean>> {

        /* JADX INFO: renamed from: ui.presenter.AIInspectRecordPresenter$a$a */
        class C0293a extends com.google.gson.d0.a<AIInspectRecordBean> {
            C0293a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0293a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIInspectRecordCallView) AIInspectRecordPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AIInspectRecordBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getEncodeStr() == null || aPIresult.getEncodeStr().length() <= 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            try {
                AIInspectRecordBean aIInspectRecordBean = (AIInspectRecordBean) new com.google.gson.e().a(new JSONObject(aPIresult.getEncodeStr()).optString("data"), AIInspectRecordBean.class);
                if (aIInspectRecordBean == null || aIInspectRecordBean.getRows() == null || aIInspectRecordBean.getRows().size() <= 0) {
                    AIInspectRecordBean aIInspectRecordBean2 = new AIInspectRecordBean();
                    aIInspectRecordBean2.setTotal(100);
                    ((AIInspectRecordCallView) AIInspectRecordPresenter.this.mvpView).onSuccessRequest(aIInspectRecordBean2);
                } else {
                    ((AIInspectRecordCallView) AIInspectRecordPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                onErrorMiddle(APIException.getApiExcept("\u8bf7\u6c42\u6570\u636e\u53d1\u751f\u5f02\u5e38"));
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    public AIInspectRecordPresenter(Activity activity, AIInspectRecordCallView aIInspectRecordCallView) {
        super(activity, aIInspectRecordCallView);
        this.mCurrentState = false;
    }

    public void getVerifyList(int i2, int i3) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("page", Integer.valueOf(i2));
        map.put("rows", Integer.valueOf(i3));
        getAIIdentifyLists(map, e.a.f10139c + f.b.n2, new a());
    }
}
