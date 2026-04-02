package ui.presenter;

import android.app.Activity;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.AIVerifyCountCallView;
import ui.model.ModelPresent;

/* JADX INFO: loaded from: classes2.dex */
public class AiVerifyCountPresenter extends ModelPresent<AIVerifyCountCallView> {

    class a extends MiddleSubscriber<APIresult<Object>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIVerifyCountCallView) AiVerifyCountPresenter.this.mvpView).onError(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Object> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((AIVerifyCountCallView) AiVerifyCountPresenter.this.mvpView).onSuccess(aPIresult.getEncodeStr());
            } else {
                ((AIVerifyCountCallView) AiVerifyCountPresenter.this.mvpView).onError(aPIresult.getMsg());
            }
        }
    }

    public AiVerifyCountPresenter(Activity activity, AIVerifyCountCallView aIVerifyCountCallView) {
        super(activity, aIVerifyCountCallView);
    }

    public void checkAiVerifyCount() {
        String str = e.a.f10139c + f.b.o2;
        HashMap map = new HashMap();
        map.put("checkType", 0);
        checkVerifyCurrentCount(str, map, new a());
    }
}
