package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.AccountBean;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.Hicore;
import p388ui.callview.AccountCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class AccountPresenter extends ModelPresent<AccountCallView> {

    /* renamed from: ui.presenter.AccountPresenter$a */
    class C6921a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: ui.presenter.AccountPresenter$a$a */
        class a extends C2049a<List<CaseDivisonBean>> {
            a() {
            }
        }

        C6921a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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

    /* renamed from: ui.presenter.AccountPresenter$b */
    class C6922b extends MiddleSubscriber<APIresult<String>> {
        C6922b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            if (aPIresult.getCode() != 0) {
                C7331w1.m26688a(aPIresult.getMsg());
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

    private void savePaymentHttp(HashMap<String, String> hashMap) {
        savexc(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17101k1), hashMap, new C6922b());
    }

    public void accountType() {
        surveyCredentType(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17098j1), new C6921a());
    }

    public void savePayment(AccountBean accountBean) {
        savePaymentHttp(JNIHandStamp.getInstance().pamramToMap(accountBean));
    }
}
