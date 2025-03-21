package ui.presenter;

import android.app.Activity;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import ui.callview.IndustryAddView;
import ui.model.ModelPresent;
import util.b1;

/* loaded from: classes2.dex */
public class IndustrysPresenter extends ModelPresent<IndustryAddView> {
    public IndustrysPresenter(Activity activity, IndustryAddView industryAddView) {
        super(activity, industryAddView);
    }

    private void timeStampHttp(HashMap<String, String> hashMap) {
        updateUserHttp(hashMap);
    }

    private void updateUserHttp(HashMap<String, String> hashMap) {
    }

    public void getIndustry() {
    }

    public void updateUserIndustry(String str) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", accountId);
        hashMap.put("profession", str + "");
        timeStampHttp(hashMap);
    }
}
