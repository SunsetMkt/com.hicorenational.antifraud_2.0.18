package p388ui.presenter;

import android.app.Activity;
import bean.AccountListBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.Hicore;
import p388ui.callview.AccountListCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class AccountListPresenter extends ModelPresent<AccountListCallView> {

    /* renamed from: ui.presenter.AccountListPresenter$a */
    class C6918a extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        /* renamed from: ui.presenter.AccountListPresenter$a$a */
        class a extends C2049a<List<AccountListBean>> {
            a() {
            }
        }

        C6918a() {
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
        protected void onNextMiddle(APIresult<List<AccountListBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.AccountListPresenter$b */
    class C6919b extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ AccountListBean f23954a;

        C6919b(AccountListBean accountListBean) {
            this.f23954a = accountListBean;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onDeleteSuccess(this.f23954a);
            } else {
                C7331w1.m26688a(aPIresult.getMsg());
            }
        }
    }

    /* renamed from: ui.presenter.AccountListPresenter$c */
    class C6920c extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        /* renamed from: ui.presenter.AccountListPresenter$c$a */
        class a extends C2049a<List<AccountListBean>> {
            a() {
            }
        }

        C6920c() {
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
        protected void onNextMiddle(APIresult<List<AccountListBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public AccountListPresenter(Activity activity, AccountListCallView accountListCallView) {
        super(activity, accountListCallView);
    }

    public void deleteAccount(AccountListBean accountListBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", accountListBean.getId());
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17092h1), hashMap, new C6919b(accountListBean));
    }

    public void getPayment(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17089g1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getPayment(m16395a, hashMap, new C6918a());
    }

    public void getStopPayment(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17110n1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getPayment(m16395a, hashMap, new C6920c());
    }
}
