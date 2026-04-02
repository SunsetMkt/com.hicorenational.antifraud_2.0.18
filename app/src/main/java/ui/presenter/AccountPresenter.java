package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.AccountBean;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.AccountCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class AccountPresenter extends ModelPresent<AccountCallView> {

    class a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* JADX INFO: renamed from: ui.presenter.AccountPresenter$a$a */
        class C0296a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            C0296a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0296a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((AccountCallView) AccountPresenter.this.mvpView).onSuccessAccountType(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            if (aPIresult.getCode() != 0) {
                e2.a(aPIresult.getMsg());
                return;
            }
            String data = aPIresult.getData();
            if (TextUtils.isEmpty(data)) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((AccountCallView) AccountPresenter.this.mvpView).onSuccessSave(data);
            }
        }
    }

    public AccountPresenter(Activity activity, AccountCallView accountCallView) {
        super(activity, accountCallView);
    }

    private void savePaymentHttp(HashMap<String, String> map) {
        savexc(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.l1), map, new b());
    }

    public void accountType() {
        surveyCredentType(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.k1), new a());
    }

    public void savePayment(AccountBean accountBean) {
        savePaymentHttp(JNIHandStamp.getInstance().pamramToMap(accountBean));
    }
}
