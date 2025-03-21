package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.MinePersonalAddView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7301n1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class MinePersonalAddPresenter extends ModelPresent<MinePersonalAddView> {

    /* renamed from: ui.presenter.MinePersonalAddPresenter$a */
    class C7029a extends MiddleSubscriber<APIresult<Double>> {

        /* renamed from: a */
        final /* synthetic */ int f24165a;

        C7029a(int i2) {
            this.f24165a = i2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Double.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Double> aPIresult) {
            C7301n1.m26454a("register", "-->onNext");
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            ((MinePersonalAddView) MinePersonalAddPresenter.this.mvpView).onSuccUpdateRequest(this.f24165a);
            if (aPIresult.getData().doubleValue() > 0.0d) {
                C7331w1.m26688a("恭喜，添加成功");
            } else {
                C7331w1.m26688a("修改成功");
            }
        }
    }

    public MinePersonalAddPresenter(Activity activity, MinePersonalAddView minePersonalAddView) {
        super(activity, minePersonalAddView);
    }

    private void timeStampHttp(HashMap<String, String> hashMap, int i2) {
        updateUserHttp(i2, hashMap);
    }

    private void updateUserHttp(int i2, HashMap<String, String> hashMap) {
        String str = "";
        if (i2 == 1) {
            str = C4440a.m16395a("", 1, C4445b.f17015K);
        } else if (i2 == 11) {
            str = C4440a.m16395a("", 1, C4445b.f17018L);
        }
        updateUserInfo(hashMap, str, new C7029a(i2));
    }

    public void updateUserAddres(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        C7257b1.m26203a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", accountId);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("region", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("addr", str2);
        }
        timeStampHttp(hashMap, i2);
    }

    public void updateUserContact(int i2, String str, String str2, String str3) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        C7257b1.m26203a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", accountId);
        hashMap.put("qq", str);
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, str2);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str3);
        timeStampHttp(hashMap, i2);
    }

    public void updateUserEmerg(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        C7257b1.m26203a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", accountId);
        hashMap.put("urgentContactname", str);
        hashMap.put("urgentContactmob", str2);
        timeStampHttp(hashMap, i2);
    }
}
