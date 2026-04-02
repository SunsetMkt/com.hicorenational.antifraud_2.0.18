package ui.presenter;

import android.app.Activity;
import bean.AccountListBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.Hicore;
import ui.callview.AccountListCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class AccountListPresenter extends ModelPresent<AccountListCallView> {

    class a extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        /* JADX INFO: renamed from: ui.presenter.AccountListPresenter$a$a */
        class C0295a extends com.google.gson.d0.a<List<AccountListBean>> {
            C0295a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0295a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    class b extends MiddleSubscriber<APIresult> {
        final /* synthetic */ AccountListBean a;

        b(AccountListBean accountListBean) {
            this.a = accountListBean;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((AccountListCallView) AccountListPresenter.this.mvpView).onDeleteSuccess(this.a);
            } else {
                e2.a(aPIresult.getMsg());
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<List<AccountListBean>>> {

        class a extends com.google.gson.d0.a<List<AccountListBean>> {
            a() {
            }
        }

        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", accountListBean.getId());
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.i1), map, new b(accountListBean));
    }

    public void getPayment(String str) {
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.h1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getPayment(strB, map, new a());
    }

    public void getStopPayment(String str) {
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.o1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getPayment(strB, map, new c());
    }
}
