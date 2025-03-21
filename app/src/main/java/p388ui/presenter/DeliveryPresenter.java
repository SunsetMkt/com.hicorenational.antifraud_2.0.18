package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.OssFileInfo;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.DeliveryView;
import p388ui.model.OSSModelPresent;
import p388ui.presenter.DeliveryPresenter;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class DeliveryPresenter extends OSSModelPresent<DeliveryView> {
    private List<DeliveryBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;
    List<OssFileInfo> ossFiles;

    public class HolderAdapte extends RecyclerView.Adapter<C6974a> {

        /* renamed from: a */
        private Context f24066a;

        /* renamed from: ui.presenter.DeliveryPresenter$HolderAdapte$a */
        class C6974a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public TextView f24068a;

            /* renamed from: b */
            public TextView f24069b;

            /* renamed from: c */
            public TextView f24070c;

            /* renamed from: d */
            public TextView f24071d;

            /* renamed from: e */
            public TextView f24072e;

            /* renamed from: f */
            public TextView f24073f;

            /* renamed from: g */
            public TextView f24074g;

            /* renamed from: h */
            public ImageView f24075h;

            /* renamed from: i */
            public ImageView f24076i;

            /* renamed from: j */
            public View f24077j;

            /* renamed from: k */
            public View f24078k;

            public C6974a(View view) {
                super(view);
                this.f24068a = (TextView) view.findViewById(C2113R.id.tv_delivery_plat);
                this.f24069b = (TextView) view.findViewById(C2113R.id.tv_delivery_num);
                this.f24073f = (TextView) view.findViewById(C2113R.id.tv_delivery_address);
                this.f24071d = (TextView) view.findViewById(C2113R.id.tv_delivery_sender);
                this.f24070c = (TextView) view.findViewById(C2113R.id.tv_delivery_wp);
                this.f24072e = (TextView) view.findViewById(C2113R.id.tv_delivery_phone);
                this.f24074g = (TextView) view.findViewById(C2113R.id.tv_delivery_time);
                this.f24075h = (ImageView) view.findViewById(C2113R.id.iv_edit);
                this.f24076i = (ImageView) view.findViewById(C2113R.id.iv_clear);
                this.f24077j = view.findViewById(C2113R.id.iv_arrow);
                this.f24078k = view.findViewById(C2113R.id.v_line);
                if (DeliveryPresenter.this.isOnlySee) {
                    this.f24075h.setVisibility(8);
                    this.f24076i.setVisibility(8);
                    this.f24078k.setVisibility(8);
                    this.f24077j.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.f24066a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C6974a c6974a, final int i2) {
            DeliveryBean deliveryBean = (DeliveryBean) DeliveryPresenter.this.arrayListBean.get(i2);
            if (deliveryBean != null) {
                c6974a.f24068a.setText(deliveryBean.getDeliveryPlat());
                c6974a.f24069b.setText(deliveryBean.getDeliveryNum());
                c6974a.f24070c.setText(deliveryBean.getDeliveryWp());
                c6974a.f24071d.setText(deliveryBean.getDeliveryName());
                c6974a.f24072e.setText(deliveryBean.getDeliveryPhone());
                c6974a.f24073f.setText(deliveryBean.getDeliveryAddress());
                String deliveryTime = deliveryBean.getDeliveryTime();
                if (deliveryTime.length() > 2) {
                    c6974a.f24074g.setText(deliveryTime.substring(0, deliveryTime.length() - 3));
                }
            }
            c6974a.f24075h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeliveryPresenter.HolderAdapte.this.m25631a(i2, view);
                }
            });
            c6974a.f24076i.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeliveryPresenter.HolderAdapte.this.m25633b(i2, view);
                }
            });
            c6974a.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeliveryPresenter.HolderAdapte.this.m25634c(i2, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m25633b(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemDelet(i2);
        }

        /* renamed from: c */
        public /* synthetic */ void m25634c(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DeliveryPresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C6974a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C6974a(LayoutInflater.from(this.f24066a).inflate(C2113R.layout.recycle_delivery_item, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25631a(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }
    }

    /* renamed from: ui.presenter.DeliveryPresenter$a */
    class C6975a extends MiddleSubscriber<APIresult<List<DeliveryBean>>> {

        /* renamed from: ui.presenter.DeliveryPresenter$a$a */
        class a extends C2049a<List<DeliveryBean>> {
            a() {
            }
        }

        C6975a() {
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
        protected void onNextMiddle(APIresult<List<DeliveryBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.DeliveryPresenter$b */
    class C6976b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ int f24082a;

        C6976b(int i2) {
            this.f24082a = i2;
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
                DeliveryPresenter.this.removeListData(this.f24082a);
            }
        }
    }

    /* renamed from: ui.presenter.DeliveryPresenter$c */
    class C6977c extends MiddleSubscriber<APIresult<DeliveryBean>> {

        /* renamed from: ui.presenter.DeliveryPresenter$c$a */
        class a extends C2049a<DeliveryBean> {
            a() {
            }
        }

        C6977c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessSaveFail(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<DeliveryBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessSave(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.DeliveryPresenter$d */
    class C6978d extends MiddleSubscriber<APIresult<List<DeliveryPlatBean>>> {

        /* renamed from: ui.presenter.DeliveryPresenter$d$a */
        class a extends C2049a<List<DeliveryPlatBean>> {
            a() {
            }
        }

        C6978d() {
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
        protected void onNextMiddle(APIresult<List<DeliveryPlatBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public DeliveryPresenter(Activity activity, DeliveryView deliveryView) {
        super(activity, deliveryView);
        this.arrayListBean = new ArrayList();
        this.isOnlySee = false;
    }

    public void getDeliveryList(String str) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17011I1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getDeliveryList(m16395a, hashMap, new C6975a());
    }

    public void getPlatList() {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        getDeliveryPlatList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17020L1), new HashMap<>(), new C6978d());
    }

    public void initRecycle(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void isOnlySee(boolean z) {
        this.isOnlySee = z;
    }

    public void removeDelivery(String str, String str2, int i2) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17017K1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        hashMap.put("mailingTelInfoID", str2);
        removeDelivery(m16395a, hashMap, new C6976b(i2));
    }

    public void removeListData(int i2) {
        this.arrayListBean.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    public void saveDeliveryTelHttp(DeliveryBean deliveryBean) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        saveDeliveryTel(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17014J1), deliveryBean, new C6977c());
    }

    public void setListData(List<DeliveryBean> list) {
        this.arrayListBean = list;
        this.mAdapter.notifyDataSetChanged();
    }

    public void updateListData(int i2, DeliveryBean deliveryBean) {
        this.arrayListBean.set(i2, deliveryBean);
        this.mAdapter.notifyItemChanged(i2);
    }
}
