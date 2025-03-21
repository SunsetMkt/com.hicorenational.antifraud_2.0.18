package p388ui.presenter;

import android.app.Activity;
import bean.RelationBean;
import bean.RelationPlatBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.RelationView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class RelationPresenter extends ModelPresent<RelationView> {

    /* renamed from: ui.presenter.RelationPresenter$a */
    class C7054a extends MiddleSubscriber<APIresult<List<RelationBean>>> {

        /* renamed from: ui.presenter.RelationPresenter$a$a */
        class a extends C2049a<List<RelationBean>> {
            a() {
            }
        }

        C7054a() {
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
        protected void onNextMiddle(APIresult<List<RelationBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.RelationPresenter$b */
    class C7055b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ int f24218a;

        C7055b(int i2) {
            this.f24218a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onItemDelet(this.f24218a);
            }
        }
    }

    /* renamed from: ui.presenter.RelationPresenter$c */
    class C7056c extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: ui.presenter.RelationPresenter$c$a */
        class a extends C2049a<String> {
            a() {
            }
        }

        C7056c() {
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
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RelationView) RelationPresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    /* renamed from: ui.presenter.RelationPresenter$d */
    class C7057d extends MiddleSubscriber<APIresult<List<RelationPlatBean>>> {

        /* renamed from: ui.presenter.RelationPresenter$d$a */
        class a extends C2049a<List<RelationPlatBean>> {
            a() {
            }
        }

        C7057d() {
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
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f16999E1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getRelationList(m16395a, hashMap, new C7054a());
    }

    public void getRelationPlatList() {
        getRelationPlatList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17008H1), new HashMap<>(), new C7057d());
    }

    public void removeRelationtel(String str, String str2, int i2) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17005G1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        hashMap.put("linkTelInfoID", str2);
        removeRelationtel(m16395a, hashMap, new C7055b(i2));
    }

    public void saveRelationTel(RelationBean relationBean) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        saveRelationTel(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17002F1), JNIHandStamp.getInstance().pamramToMap(relationBean), new C7056c());
    }
}
