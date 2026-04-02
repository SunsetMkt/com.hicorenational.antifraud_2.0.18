package network.http;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.AddressBean;
import bean.BaseAddressBean;
import c.a.a.d.d;
import c.a.a.d.k;
import c.a.a.e.a;
import com.google.gson.d0.a;
import com.google.gson.e;
import com.hicorenational.antifraud.R;
import f.b;
import h.a.i0;
import h.a.u0.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.g2;
import util.j1;
import util.u1;

/* JADX INFO: loaded from: classes2.dex */
public class AddressHttp extends ModelPresent {
    private static final String ADDRESS_FILE_NAME = "address.txt";
    private static final int MODE_DIALOG = 10;
    private static final int MODE_JUST_DATA = 11;
    private static final int REQUEST_TYPE_SILENCE = 1;
    public static final int REQUEST_TYPE_TIP = 2;
    private static Activity mActivity;
    private static ArrayList<k> mProvinceListData = new ArrayList<>();
    private static AddressHttp addressHttp = null;
    private static boolean notNeedRequest = false;

    /* JADX INFO: renamed from: network.http.AddressHttp$1 */
    class AnonymousClass1 extends MiddleSubscriber<APIresult<BaseAddressBean>> {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        AnonymousClass1(int i2, int i3, boolean z, MyPicker myPicker) {
            i = i2;
            i = i3;
            z = z;
            myPicker = myPicker;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return BaseAddressBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            AddressHttp.this.getAPIData(i, i, z, myPicker);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            BaseAddressBean data = aPIresult.getData();
            if (data.getIsRenew() != 1 || TextUtils.isEmpty(data.getOssPath())) {
                AddressHttp.this.rearCallBack(i, i, z, myPicker);
            } else {
                AddressHttp.this.getOSSArea(data.getOssPath(), data.getAreaVersion(), i, i, z, myPicker);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(c cVar) {
            if (i == 2) {
                f1.a("\u52a0\u8f7d\u4e2d...", true, AddressHttp.mActivity);
            }
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$2 */
    class AnonymousClass2 implements i0<List<AddressBean>> {
        final /* synthetic */ int val$addressJsonVertion;
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        AnonymousClass2(int i2, int i3, int i4, boolean z, MyPicker myPicker) {
            i = i2;
            i = i3;
            i = i4;
            z = z;
            myPicker = myPicker;
        }

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            AddressHttp.this.getAPIData(i, i, z, myPicker);
        }

        @Override // h.a.i0
        public void onSubscribe(c cVar) {
        }

        @Override // h.a.i0
        public void onNext(List<AddressBean> list) {
            AddressHttp.this.successRequest();
            if (list == null || list.size() <= 0) {
                onError(APIException.getApiExcept());
                return;
            }
            AddressHttp.saveAddressJson(i, new e().a(list));
            ArrayList unused = AddressHttp.mProvinceListData = AddressBean.gainRegionData(list);
            AddressHttp.this.rearCallBack(i, i, z, myPicker);
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$3 */
    class AnonymousClass3 extends MiddleSubscriber<APIresult<BaseAddressBean>> {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ int val$mode;
        final /* synthetic */ int val$requestType;
        final /* synthetic */ boolean val$showClear;

        AnonymousClass3(int i2, int i3, boolean z, MyPicker myPicker) {
            i = i2;
            i = i3;
            z = z;
            myPicker = myPicker;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return BaseAddressBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            AddressHttp.this.rearCallBack(i, i, z, myPicker);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                AddressHttp.this.successArea(aPIresult, i, i, z, myPicker);
            }
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$4 */
    class AnonymousClass4 extends a<List<AddressBean>> {
        AnonymousClass4() {
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$5 */
    class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ MyPicker val$callback;
        final /* synthetic */ c.a.a.e.a val$picker;

        AnonymousClass5(c.a.a.e.a aVar, MyPicker myPicker) {
            aVar = aVar;
            myPicker = myPicker;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            aVar.a();
            myPicker.onClear();
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$6 */
    class AnonymousClass6 implements a.e {
        final /* synthetic */ MyPicker val$callback;

        AnonymousClass6(MyPicker myPicker) {
            myPicker = myPicker;
        }

        @Override // c.a.a.e.a.e
        public void onAddressPicked(k kVar, d dVar, c.a.a.d.e eVar) {
            if (myPicker == null || kVar == null || dVar == null || eVar == null || TextUtils.isEmpty(kVar.getAreaId()) || TextUtils.isEmpty(dVar.getAreaId()) || TextUtils.isEmpty(eVar.getAreaId())) {
                return;
            }
            myPicker.onAddressPicked(kVar, dVar, eVar);
        }
    }

    /* JADX INFO: renamed from: network.http.AddressHttp$7 */
    static class AnonymousClass7 extends com.google.gson.d0.a<List<AddressBean>> {
        AnonymousClass7() {
        }
    }

    public static class MyPicker implements a.e {
        @Override // c.a.a.e.a.e
        public void onAddressPicked(k kVar, d dVar, c.a.a.d.e eVar) {
        }

        public void onClear() {
        }

        public void onData(ArrayList<k> arrayList) {
        }
    }

    private AddressHttp() {
        super((Activity) null, (BaseView) null);
    }

    public void getAPIData(int i2, int i3, boolean z, MyPicker myPicker) {
        String str = e.a.f10139c + b.f10188g;
        HashMap<String, String> map = new HashMap<>();
        map.put("areaVersion", getMaxAddressVersion() + "");
        regionHttp(map, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.3
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ int val$mode;
            final /* synthetic */ int val$requestType;
            final /* synthetic */ boolean val$showClear;

            AnonymousClass3(int i22, int i32, boolean z2, MyPicker myPicker2) {
                i = i22;
                i = i32;
                z = z2;
                myPicker = myPicker2;
            }

            @Override // network.MiddleSubscriber
            protected Type getType() {
                return BaseAddressBean.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                AddressHttp.this.rearCallBack(i, i, z, myPicker);
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                if (aPIresult == null || aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept());
                } else {
                    AddressHttp.this.successArea(aPIresult, i, i, z, myPicker);
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
        return u1.a(u1.f15085h);
    }

    public static ArrayList<k> getAddressList(String str) {
        ArrayList arrayList = (ArrayList) new e().a(str, new com.google.gson.d0.a<List<AddressBean>>() { // from class: network.http.AddressHttp.7
            AnonymousClass7() {
            }
        }.getType());
        if (arrayList != null && arrayList.size() > 0) {
            return AddressBean.gainRegionData(arrayList);
        }
        e2.a("\u6570\u636e\u5f02\u5e38");
        return new ArrayList<>();
    }

    public static int getMaxAddressVersion() {
        return Math.max(1, u1.a(u1.f15086i, 1));
    }

    public void getOSSArea(String str, int i2, int i3, int i4, boolean z, MyPicker myPicker) {
        getAreaListOss(str, new i0<List<AddressBean>>() { // from class: network.http.AddressHttp.2
            final /* synthetic */ int val$addressJsonVertion;
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ int val$mode;
            final /* synthetic */ int val$requestType;
            final /* synthetic */ boolean val$showClear;

            AnonymousClass2(int i22, int i32, int i42, boolean z2, MyPicker myPicker2) {
                i = i22;
                i = i32;
                i = i42;
                z = z2;
                myPicker = myPicker2;
            }

            @Override // h.a.i0
            public void onComplete() {
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                AddressHttp.this.getAPIData(i, i, z, myPicker);
            }

            @Override // h.a.i0
            public void onSubscribe(c cVar) {
            }

            @Override // h.a.i0
            public void onNext(List<AddressBean> list) {
                AddressHttp.this.successRequest();
                if (list == null || list.size() <= 0) {
                    onError(APIException.getApiExcept());
                    return;
                }
                AddressHttp.saveAddressJson(i, new e().a(list));
                ArrayList unused = AddressHttp.mProvinceListData = AddressBean.gainRegionData(list);
                AddressHttp.this.rearCallBack(i, i, z, myPicker);
            }
        });
    }

    public static void initAddressJson() {
        int iA = u1.a(u1.f15086i, 1);
        String addressJson = getAddressJson();
        if (1 > iA || (1 == iA && TextUtils.isEmpty(addressJson))) {
            u1.a(u1.f15085h, j1.c(ADDRESS_FILE_NAME));
        }
    }

    private boolean isNotNeedRequest() {
        return notNeedRequest;
    }

    private boolean isToday() {
        return TextUtils.equals(u1.a(u1.f15087j), g2.d("yyyy-MM-dd"));
    }

    public void rearCallBack(int i2, int i3, boolean z, MyPicker myPicker) {
        ArrayList<k> arrayList;
        ArrayList<k> arrayList2 = mProvinceListData;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            mProvinceListData = getAddressList(getAddressJson());
        }
        if (i2 == 2 && ((arrayList = mProvinceListData) == null || (arrayList != null && arrayList.size() <= 0))) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_system));
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
            String str = e.a.f10139c + b.f10189h;
            HashMap<String, String> map = new HashMap<>();
            map.put("areaVersion", getMaxAddressVersion() + "");
            regionHttp(map, str, new MiddleSubscriber<APIresult<BaseAddressBean>>() { // from class: network.http.AddressHttp.1
                final /* synthetic */ MyPicker val$callback;
                final /* synthetic */ int val$mode;
                final /* synthetic */ int val$requestType;
                final /* synthetic */ boolean val$showClear;

                AnonymousClass1(int i22, int i32, boolean z2, MyPicker myPicker2) {
                    i = i22;
                    i = i32;
                    z = z2;
                    myPicker = myPicker2;
                }

                @Override // network.MiddleSubscriber
                protected Type getType() {
                    return BaseAddressBean.class;
                }

                @Override // network.MiddleSubscriber
                protected void onErrorMiddle(APIException aPIException) {
                    AddressHttp.this.getAPIData(i, i, z, myPicker);
                }

                @Override // network.MiddleSubscriber
                protected void onNextMiddle(APIresult<BaseAddressBean> aPIresult) {
                    if (aPIresult == null || aPIresult.getCode() != 0) {
                        onErrorMiddle(APIException.getApiExcept());
                        return;
                    }
                    BaseAddressBean data = aPIresult.getData();
                    if (data.getIsRenew() != 1 || TextUtils.isEmpty(data.getOssPath())) {
                        AddressHttp.this.rearCallBack(i, i, z, myPicker);
                    } else {
                        AddressHttp.this.getOSSArea(data.getOssPath(), data.getAreaVersion(), i, i, z, myPicker);
                    }
                }

                @Override // network.MiddleSubscriber
                protected void onStartMiddle(c cVar) {
                    if (i == 2) {
                        f1.a("\u52a0\u8f7d\u4e2d...", true, AddressHttp.mActivity);
                    }
                }
            });
            return;
        }
        if (myPicker2 != null) {
            ArrayList<k> arrayList = mProvinceListData;
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
        u1.b(u1.f15086i, i2);
        u1.a(u1.f15085h, str);
    }

    public void successArea(APIresult<BaseAddressBean> aPIresult, int i2, int i3, boolean z, MyPicker myPicker) {
        successRequest();
        BaseAddressBean data = aPIresult.getData();
        if (data != null && data.getIsRenew() == 1 && data.getProvinceList() != null) {
            String string = data.getProvinceList().toString();
            ArrayList arrayList = (ArrayList) new e().a(string, new com.google.gson.d0.a<List<AddressBean>>() { // from class: network.http.AddressHttp.4
                AnonymousClass4() {
                }
            }.getType());
            if (arrayList != null && arrayList.size() > 0) {
                saveAddressJson(data.getAreaVersion(), string);
                mProvinceListData = getAddressList(string);
            }
        }
        rearCallBack(i2, i3, z, myPicker);
    }

    public void successRequest() {
        notNeedRequest = true;
    }

    private void updateDay() {
        u1.a(u1.f15087j, g2.d("yyyy-MM-dd"));
    }

    public ArrayList<k> getPickData() {
        ArrayList<k> arrayList = mProvinceListData;
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
        c.a.a.e.a aVar = new c.a.a.e.a(mActivity, mProvinceListData);
        aVar.p(false);
        aVar.o(false);
        TextView textView = new TextView(aVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView.setText("\u6e05\u7a7a");
        textView.setGravity(17);
        textView.setTextColor(mActivity.getResources().getColor(R.color.black));
        textView.setOnClickListener(new View.OnClickListener() { // from class: network.http.AddressHttp.5
            final /* synthetic */ MyPicker val$callback;
            final /* synthetic */ c.a.a.e.a val$picker;

            AnonymousClass5(c.a.a.e.a aVar2, MyPicker myPicker2) {
                aVar = aVar2;
                myPicker = myPicker2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.a();
                myPicker.onClear();
            }
        });
        aVar2.e(textView);
        aVar2.A(mActivity.getResources().getColor(R.color.colorGray));
        aVar2.k(mActivity.getResources().getColor(R.color.black));
        aVar2.g(mActivity.getResources().getColor(R.color.colorGray));
        aVar2.u(mActivity.getResources().getColor(R.color.colorGray));
        aVar2.a(0.25f, 0.5f, 0.25f);
        aVar2.setOnAddressPickListener(new a.e() { // from class: network.http.AddressHttp.6
            final /* synthetic */ MyPicker val$callback;

            AnonymousClass6(MyPicker myPicker2) {
                myPicker = myPicker2;
            }

            @Override // c.a.a.e.a.e
            public void onAddressPicked(k kVar, d dVar, c.a.a.d.e eVar) {
                if (myPicker == null || kVar == null || dVar == null || eVar == null || TextUtils.isEmpty(kVar.getAreaId()) || TextUtils.isEmpty(dVar.getAreaId()) || TextUtils.isEmpty(eVar.getAreaId())) {
                    return;
                }
                myPicker.onAddressPicked(kVar, dVar, eVar);
            }
        });
        aVar2.m();
    }

    public void getPickData(MyPicker myPicker) {
        ArrayList<k> arrayList = mProvinceListData;
        if (arrayList != null && arrayList.size() > 0) {
            myPicker.onData(mProvinceListData);
        } else {
            regionHttp(2, 11, false, myPicker);
        }
    }
}
