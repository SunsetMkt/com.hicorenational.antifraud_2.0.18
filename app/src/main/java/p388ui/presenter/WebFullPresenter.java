package p388ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.SurveyToH5Bean;
import interfaces.PermissionsListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ObjectTypeAdapter;
import p245d.C4440a;
import p388ui.activity.CallRecordNewActivity;
import p388ui.activity.SmsRecordSelectActivity;
import p388ui.callview.WebFullCallView;
import p388ui.model.OSSModelPresent;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class WebFullPresenter extends OSSModelPresent<WebFullCallView> {

    /* renamed from: ui.presenter.WebFullPresenter$a */
    class C7116a implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ int f24368a;

        C7116a(int i2) {
            this.f24368a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f23201h, 1);
            intent.putExtra("extra_select_can", this.f24368a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.WebFullPresenter$b */
    class C7117b implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ int f24370a;

        C7117b(int i2) {
            this.f24370a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", this.f24370a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.WebFullPresenter$c */
    class C7118c extends MiddleSubscriber<APIresult<SurveyToH5Bean>> {

        /* renamed from: a */
        final /* synthetic */ String f24372a;

        /* renamed from: b */
        final /* synthetic */ String f24373b;

        C7118c(String str, String str2) {
            this.f24372a = str;
            this.f24373b = str2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SurveyToH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f24373b, "\"errorMsg\":\"" + aPIException.getMessage() + "\"", false);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SurveyToH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (this.f24372a.contains("getxccasecategorysv2")) {
                ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f24373b, "\"response\":" + aPIresult.getEncodeStr(), true);
                return;
            }
            ((WebFullCallView) ((OSSModelPresent) WebFullPresenter.this).mvpView).onSurveyBeanRequest(this.f24373b, "\"response\":" + aPIresult.getEncodeStr(), false);
        }
    }

    public WebFullPresenter(Activity activity, WebFullCallView webFullCallView) {
        super(activity, webFullCallView);
    }

    private void callPermission(int i2) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25533l}, new C7117b(i2));
    }

    private void smsPermission(int i2) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25544w, C7308a.f25543v}, new C7116a(i2));
    }

    public void SurveyH5Http(String str, Map<String, Object> map, String str2) {
        SurveyH5Param(map, str2, new C7118c(str2, str));
    }

    public void SurveyH5Param(String str) {
        SurveyH5Bean surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().m5569a(str, SurveyH5Bean.class);
        if (surveyH5Bean != null) {
            Map<String, Object> hashMap = new HashMap<>();
            if (surveyH5Bean.getParams() != null) {
                hashMap = surveyH5Bean.getParams();
            }
            if (TextUtils.equals(SurveyH5Bean.POST, surveyH5Bean.getType())) {
                SurveyH5Http(str, hashMap, C4440a.m16401c(surveyH5Bean.getTransChannel()) + surveyH5Bean.getApiUrl());
                return;
            }
            if (TextUtils.equals("audio", surveyH5Bean.getType())) {
                return;
            }
            if (TextUtils.equals("event", surveyH5Bean.getType())) {
                ((WebFullCallView) ((OSSModelPresent) this).mvpView).eventH5Action(str, hashMap);
                return;
            }
            if (TextUtils.equals("call", surveyH5Bean.getType())) {
                if (hashMap.containsKey(SurveyH5Bean.SELECTNUM)) {
                    callPermission(Integer.parseInt(hashMap.get(SurveyH5Bean.SELECTNUM).toString()));
                }
            } else if (!TextUtils.equals(SurveyH5Bean.SMS, surveyH5Bean.getType())) {
                ((WebFullCallView) ((OSSModelPresent) this).mvpView).eventH5Action(str, hashMap);
            } else if (hashMap.containsKey(SurveyH5Bean.SELECTNUM)) {
                smsPermission(Integer.parseInt(hashMap.get(SurveyH5Bean.SELECTNUM).toString()));
            }
        }
    }
}
