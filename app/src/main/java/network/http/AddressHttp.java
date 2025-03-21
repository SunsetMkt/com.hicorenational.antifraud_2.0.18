package network.http;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.AddressBean;
import bean.BaseAddressBean;
import com.google.gson.C2051e;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p023b.p024a.p025a.p027e.C0915a;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.Hicore;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7277f1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class AddressHttp extends ModelPresent {
    private static final String ADDRESS_FILE_NAME = "address.txt";
    private static final int MODE_DIALOG = 10;
    private static final int MODE_JUST_DATA = 11;
    private static final int REQUEST_TYPE_SILENCE = 1;
    public static final int REQUEST_TYPE_TIP = 2;
    private static Activity mActivity;
    private static ArrayList<C0913k> mProvinceListData = new ArrayList<>();
    private static AddressHttp addressHttp = null;
    private static boolean notNeedRequest = false;

    /* renamed from: network.http.AddressHttp$1 */
    class C59571 extends MiddleSubscriber<APIresult<BaseAddressBean>> {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        C59571(int i2, int i3, boolean z, MyPicker myPicker) {
            r2 = i2;
            r3 = i3;
            r4 = z;
            r5 = myPicker;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return BaseAddressBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            AddressHttp.this.getAPIData(r2, r3, r4, r5);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            BaseAddressBean data = aPIresult.getData();
            if (data.getIsRenew() != 1 || TextUtils.isEmpty(data.getOssPath())) {
                AddressHttp.this.rearCallBack(r2, r3, r4, r5);
            } else {
                AddressHttp.this.getOSSArea(data.getOssPath(), data.getAreaVersion(), r2, r3, r4, r5);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            if (r2 == 2) {
                C7257b1.m26203a("加载中...", true, AddressHttp.mActivity);
            }
        }
    }

    /* renamed from: network.http.AddressHttp$2 */
    class C59582 implements InterfaceC4514i0<List<AddressBean>> {
        final /* synthetic */ int val$addressJsonVertion;
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        C59582(int i2, int i3, int i4, boolean z, MyPicker myPicker) {
            r2 = i2;
            r3 = i3;
            r4 = i4;
            r5 = z;
            r6 = myPicker;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            AddressHttp.this.getAPIData(r3, r4, r5, r6);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(List<AddressBean> list) {
            AddressHttp.this.successRequest();
            if (list == null || list.size() <= 0) {
                onError(APIException.getApiExcept());
                return;
            }
            AddressHttp.saveAddressJson(r2, new C2051e().m5572a(list));
            ArrayList unused = AddressHttp.mProvinceListData = AddressBean.gainRegionData(list);
            AddressHttp.this.rearCallBack(r3, r4, r5, r6);
        }
    }

    /* renamed from: network.http.AddressHttp$3 */
    class C59593 extends MiddleSubscriber<APIresult<BaseAddressBean>> {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        C59593(int i2, int i3, boolean z, MyPicker myPicker) {
            r2 = i2;
            r3 = i3;
            r4 = z;
            r5 = myPicker;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return BaseAddressBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            AddressHttp.this.rearCallBack(r2, r3, r4, r5);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                AddressHttp.this.successArea(aPIresult, r2, r3, r4, r5);
            }
        }
    }

    /* renamed from: network.http.AddressHttp$4 */
    class C59604 extends C2049a<List<AddressBean>> {
        C59604() {
        }
    }

    /* renamed from: network.http.AddressHttp$5 */
    class ViewOnClickListenerC59615 implements View.OnClickListener {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ C0915a val$picker;

        ViewOnClickListenerC59615(C0915a c0915a, MyPicker myPicker) {
            r2 = c0915a;
            r3 = myPicker;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r2.m1021a();
            r3.onClear();
        }
    }

    /* renamed from: network.http.AddressHttp$6 */
    class C59626 implements C0915a.e {
        final /* synthetic */ MyPicker val$callback;

        C59626(MyPicker myPicker) {
            r2 = myPicker;
        }

        @Override // p023b.p024a.p025a.p027e.C0915a.e
        public void onAddressPicked(C0913k c0913k, C0906d c0906d, C0907e c0907e) {
            if (r2 == null || c0913k == null || c0906d == null || c0907e == null || TextUtils.isEmpty(c0913k.getAreaId()) || TextUtils.isEmpty(c0906d.getAreaId()) || TextUtils.isEmpty(c0907e.getAreaId())) {
                return;
            }
            r2.onAddressPicked(c0913k, c0906d, c0907e);
        }
    }

    /* renamed from: network.http.AddressHttp$7 */
    static class C59637 extends C2049a<List<AddressBean>> {
        C59637() {
        }
    }

    public static class MyPicker implements C0915a.e {
        @Override // p023b.p024a.p025a.p027e.C0915a.e
        public void onAddressPicked(C0913k c0913k, C0906d c0906d, C0907e c0907e) {
        }

        public void onClear() {
        }

        public void onData(ArrayList<C0913k> arrayList) {
        }
    }

    private AddressHttp() {
        super((Activity) null, (BaseView) null);
    }

    public void getAPIData(int i2, int i3, boolean z, MyPicker myPicker) {
        String str = C4440a.f16881c + C4445b.f17087g;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("areaVersion", getMaxAddressVersion() + "");
        regionHttp(hashMap, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.3
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ int val$mode;
            final /* synthetic */ int val$requestType;
            final /* synthetic */ boolean val$showClear;

            C59593(int i22, int i32, boolean z2, MyPicker myPicker2) {
                r2 = i22;
                r3 = i32;
                r4 = z2;
                r5 = myPicker2;
            }

            @Override // network.MiddleSubscriber
            protected Type getType() {
                return BaseAddressBean.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                AddressHttp.this.rearCallBack(r2, r3, r4, r5);
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                if (aPIresult == null || aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept());
                } else {
                    AddressHttp.this.successArea(aPIresult, r2, r3, r4, r5);
                }
            }
        });
    }

    public static AddressHttp getAddSint(Activity activity) {
        mActivity = activity;
        if (addressHttp == null) {
            synchronized (AddressHttp.class) {
                if (addressHttp == null) {
                    addressHttp = new AddressHttp();
                }
            }
        }
        return addressHttp;
    }

    public static String getAddressJson() {
        return C7307p1.m26477a(C7307p1.f25499h);
    }

    public static ArrayList<C0913k> getAddressList(String str) {
        ArrayList arrayList = (ArrayList) new C2051e().m5570a(str, new C2049a<List<AddressBean>>() { // from class: network.http.AddressHttp.7
            C59637() {
            }
        }.getType());
        if (arrayList != null && arrayList.size() > 0) {
            return AddressBean.gainRegionData(arrayList);
        }
        C7331w1.m26688a("数据异常");
        return new ArrayList<>();
    }

    public static int getMaxAddressVersion() {
        return Math.max(1, C7307p1.m26473a(C7307p1.f25500i, 1));
    }

    public void getOSSArea(String str, int i2, int i3, int i4, boolean z, MyPicker myPicker) {
        getAreaListOss(str, new InterfaceC4514i0<List<AddressBean>>() { // from class: network.http.AddressHttp.2
            final /* synthetic */ int val$addressJsonVertion;
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ int val$mode;
            final /* synthetic */ int val$requestType;
            final /* synthetic */ boolean val$showClear;

            C59582(int i22, int i32, int i42, boolean z2, MyPicker myPicker2) {
                r2 = i22;
                r3 = i32;
                r4 = i42;
                r5 = z2;
                r6 = myPicker2;
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                AddressHttp.this.getAPIData(r3, r4, r5, r6);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(List<AddressBean> list) {
                AddressHttp.this.successRequest();
                if (list == null || list.size() <= 0) {
                    onError(APIException.getApiExcept());
                    return;
                }
                AddressHttp.saveAddressJson(r2, new C2051e().m5572a(list));
                ArrayList unused = AddressHttp.mProvinceListData = AddressBean.gainRegionData(list);
                AddressHttp.this.rearCallBack(r3, r4, r5, r6);
            }
        });
    }

    public static void initAddressJson() {
        int m26473a = C7307p1.m26473a(C7307p1.f25500i, 1);
        String addressJson = getAddressJson();
        if (1 > m26473a || (1 == m26473a && TextUtils.isEmpty(addressJson))) {
            C7307p1.m26479a(C7307p1.f25499h, C7277f1.m26359c(ADDRESS_FILE_NAME));
        }
    }

    private boolean isNotNeedRequest() {
        return notNeedRequest;
    }

    private boolean isToday() {
        return TextUtils.equals(C7307p1.m26477a(C7307p1.f25501j), C7337y1.m26775d("yyyy-MM-dd"));
    }

    public void rearCallBack(int i2, int i3, boolean z, MyPicker myPicker) {
        ArrayList<C0913k> arrayList;
        ArrayList<C0913k> arrayList2 = mProvinceListData;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            mProvinceListData = getAddressList(getAddressJson());
        }
        if (i2 == 2 && ((arrayList = mProvinceListData) == null || (arrayList != null && arrayList.size() <= 0))) {
            C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_system));
            return;
        }
        if (myPicker != null) {
            if (i3 == 10) {
                regionPick(z, myPicker);
            } else {
                if (i3 != 11) {
                    return;
                }
                myPicker.onData(mProvinceListData);
            }
        }
    }

    private void regionHttp(int i2, int i3, boolean z, MyPicker myPicker) {
        if (!isNotNeedRequest()) {
            String str = C4440a.f16881c + C4445b.f17090h;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("areaVersion", getMaxAddressVersion() + "");
            regionHttp(hashMap, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.1
                final /* synthetic */ MyPicker val$callback;
                final /* synthetic */ int val$mode;
                final /* synthetic */ int val$requestType;
                final /* synthetic */ boolean val$showClear;

                C59571(int i22, int i32, boolean z2, MyPicker myPicker2) {
                    r2 = i22;
                    r3 = i32;
                    r4 = z2;
                    r5 = myPicker2;
                }

                @Override // network.MiddleSubscriber
                protected Type getType() {
                    return BaseAddressBean.class;
                }

                @Override // network.MiddleSubscriber
                protected void onErrorMiddle(APIException aPIException) {
                    AddressHttp.this.getAPIData(r2, r3, r4, r5);
                }

                @Override // network.MiddleSubscriber
                protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                    if (aPIresult == null || aPIresult.getCode() != 0) {
                        onErrorMiddle(APIException.getApiExcept());
                        return;
                    }
                    BaseAddressBean data = aPIresult.getData();
                    if (data.getIsRenew() != 1 || TextUtils.isEmpty(data.getOssPath())) {
                        AddressHttp.this.rearCallBack(r2, r3, r4, r5);
                    } else {
                        AddressHttp.this.getOSSArea(data.getOssPath(), data.getAreaVersion(), r2, r3, r4, r5);
                    }
                }

                @Override // network.MiddleSubscriber
                protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
                    if (r2 == 2) {
                        C7257b1.m26203a("加载中...", true, AddressHttp.mActivity);
                    }
                }
            });
            return;
        }
        if (myPicker2 != null) {
            ArrayList<C0913k> arrayList = mProvinceListData;
            if (arrayList == null || arrayList.size() <= 0) {
                mProvinceListData = getAddressList(getAddressJson());
            }
            if (i32 == 10) {
                regionPick(z2, myPicker2);
            } else {
                if (i32 != 11) {
                    return;
                }
                myPicker2.onData(mProvinceListData);
            }
        }
    }

    public static void saveAddressJson(int i2, String str) {
        C7307p1.m26486b(C7307p1.f25500i, i2);
        C7307p1.m26479a(C7307p1.f25499h, str);
    }

    public void successArea(APIresult<BaseAddressBean> aPIresult, int i2, int i3, boolean z, MyPicker myPicker) {
        successRequest();
        BaseAddressBean data = aPIresult.getData();
        if (data != null && data.getIsRenew() == 1 && data.getProvinceList() != null) {
            String obj = data.getProvinceList().toString();
            ArrayList arrayList = (ArrayList) new C2051e().m5570a(obj, new C2049a<List<AddressBean>>() { // from class: network.http.AddressHttp.4
                C59604() {
                }
            }.getType());
            if (arrayList != null && arrayList.size() > 0) {
                saveAddressJson(data.getAreaVersion(), obj);
                mProvinceListData = getAddressList(obj);
            }
        }
        rearCallBack(i2, i3, z, myPicker);
    }

    public void successRequest() {
        notNeedRequest = true;
    }

    private void updateDay() {
        C7307p1.m26479a(C7307p1.f25501j, C7337y1.m26775d("yyyy-MM-dd"));
    }

    public ArrayList<C0913k> getPickData() {
        ArrayList<C0913k> arrayList = mProvinceListData;
        return (arrayList == null || arrayList.size() <= 0) ? getAddressList(getAddressJson()) : mProvinceListData;
    }

    public void regionPick(MyPicker myPicker) {
        regionHttp(1, 10, true, myPicker);
    }

    public void regionPickNoClear(MyPicker myPicker) {
        regionHttp(1, 10, false, myPicker);
    }

    private void regionPick(boolean z, MyPicker myPicker) {
        Activity activity = mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C0915a c0915a = new C0915a(mActivity, mProvinceListData);
        c0915a.m845p(false);
        c0915a.m844o(false);
        TextView textView = new TextView(c0915a.m1032d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView.setText("清空");
        textView.setGravity(17);
        textView.setTextColor(mActivity.getResources().getColor(C2113R.color.black));
        textView.setOnClickListener(new View.OnClickListener() { // from class: network.http.AddressHttp.5
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ C0915a val$picker;

            ViewOnClickListenerC59615(C0915a c0915a2, MyPicker myPicker2) {
                r2 = c0915a2;
                r3 = myPicker2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r2.m1021a();
                r3.onClear();
            }
        });
        c0915a2.m1054e(textView);
        c0915a2.m996A(mActivity.getResources().getColor(C2113R.color.colorGray));
        c0915a2.m1062k(mActivity.getResources().getColor(C2113R.color.black));
        c0915a2.m1056g(mActivity.getResources().getColor(C2113R.color.colorGray));
        c0915a2.m1012u(mActivity.getResources().getColor(C2113R.color.colorGray));
        c0915a2.m945a(0.25f, 0.5f, 0.25f);
        c0915a2.setOnAddressPickListener(new C0915a.e() { // from class: network.http.AddressHttp.6
            final /* synthetic */ MyPicker val$callback;

            C59626(MyPicker myPicker2) {
                r2 = myPicker2;
            }

            @Override // p023b.p024a.p025a.p027e.C0915a.e
            public void onAddressPicked(C0913k c0913k, C0906d c0906d, C0907e c0907e) {
                if (r2 == null || c0913k == null || c0906d == null || c0907e == null || TextUtils.isEmpty(c0913k.getAreaId()) || TextUtils.isEmpty(c0906d.getAreaId()) || TextUtils.isEmpty(c0907e.getAreaId())) {
                    return;
                }
                r2.onAddressPicked(c0913k, c0906d, c0907e);
            }
        });
        c0915a2.m1045m();
    }

    public void getPickData(MyPicker myPicker) {
        ArrayList<C0913k> arrayList = mProvinceListData;
        if (arrayList != null && arrayList.size() > 0) {
            myPicker.onData(mProvinceListData);
        } else {
            regionHttp(2, 11, false, myPicker);
        }
    }
}
