package ui.presenter;

import android.app.Activity;
import bean.RelationBean;
import bean.RelationPlatBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.RelationView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class RelationPresenter extends ModelPresent<RelationView> {

    class a extends MiddleSubscriber<APIresult<List<RelationBean>>> {

        /* JADX INFO: renamed from: ui.presenter.RelationPresenter$a$a */
        class C0310a extends com.google.gson.d0.a<List<RelationBean>> {
            C0310a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0310a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RelationBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onItemDelet(this.a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<String>> {

        class a extends com.google.gson.d0.a<String> {
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
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<List<RelationPlatBean>>> {

        class a extends com.google.gson.d0.a<List<RelationPlatBean>> {
            a() {
            }
        }

        d() {
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
        protected void onNextMiddle(APIresult<List<RelationPlatBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public RelationPresenter(Activity activity, RelationView relationView) {
        super(activity, relationView);
    }

    public void getRelationList(String str) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.F1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getRelationList(strB, map, new a());
    }

    public void getRelationPlatList() {
        getRelationPlatList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.I1), new HashMap<>(), new d());
    }

    public void removeRelationtel(String str, String str2, int i2) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.H1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("linkTelInfoID", str2);
        removeRelationtel(strB, map, new b(i2));
    }

    public void saveRelationTel(RelationBean relationBean) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        saveRelationTel(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.G1), JNIHandStamp.getInstance().pamramToMap(relationBean), new c());
    }
}
