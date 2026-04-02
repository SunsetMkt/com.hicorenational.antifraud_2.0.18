package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.MinePersonalAddView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class MinePersonalAddPresenter extends ModelPresent<MinePersonalAddView> {

    class a extends MiddleSubscriber<APIresult<Double>> {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Double.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Double> aPIresult) {
            s1.a("register", "-->onNext");
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            ((MinePersonalAddView) MinePersonalAddPresenter.this.mvpView).onSuccUpdateRequest(this.a);
            if (aPIresult.getData().doubleValue() > 0.0d) {
                e2.a("\u606d\u559c\uff0c\u6dfb\u52a0\u6210\u529f");
            } else {
                e2.a("\u4fee\u6539\u6210\u529f");
            }
        }
    }

    public MinePersonalAddPresenter(Activity activity, MinePersonalAddView minePersonalAddView) {
        super(activity, minePersonalAddView);
    }

    private void timeStampHttp(HashMap<String, String> map, int i2) {
        updateUserHttp(i2, map);
    }

    private void updateUserHttp(int i2, HashMap<String, String> map) {
        String strB = "";
        if (i2 == 1) {
            strB = e.a.b("", 1, f.b.L);
        } else if (i2 == 11) {
            strB = e.a.b("", 1, f.b.M);
        }
        updateUserInfo(map, strB, new a(i2));
    }

    public void updateUserAddres(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        f1.a("\u63d0\u4ea4\u4e2d...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        if (!TextUtils.isEmpty(str)) {
            map.put("region", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("addr", str2);
        }
        timeStampHttp(map, i2);
    }

    public void updateUserContact(int i2, String str, String str2, String str3) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        f1.a("\u63d0\u4ea4\u4e2d...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("qq", str);
        map.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, str2);
        map.put(NotificationCompat.CATEGORY_EMAIL, str3);
        timeStampHttp(map, i2);
    }

    public void updateUserEmerg(int i2, String str, String str2) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        f1.a("\u63d0\u4ea4\u4e2d...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("urgentContactname", str);
        map.put("urgentContactmob", str2);
        timeStampHttp(map, i2);
    }
}
