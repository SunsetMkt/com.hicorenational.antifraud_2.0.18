package p388ui.presenter;

import android.app.Activity;
import bean.SocialTypeBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.SocialTagsCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class TradAccEditPresenter extends ModelPresent<SocialTagsCallView> {

    /* renamed from: ui.presenter.TradAccEditPresenter$a */
    class C7099a extends MiddleSubscriber<APIresult<List<SocialTypeBean>>> {

        /* renamed from: ui.presenter.TradAccEditPresenter$a$a */
        class a extends C2049a<List<SocialTypeBean>> {
            a() {
            }
        }

        C7099a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((SocialTagsCallView) TradAccEditPresenter.this.mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SocialTypeBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((SocialTagsCallView) TradAccEditPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public TradAccEditPresenter(Activity activity, SocialTagsCallView socialTagsCallView) {
        super(activity, socialTagsCallView);
    }

    public void getSocialTags() {
        getSocialTags(C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17060Z), new C7099a());
    }
}
