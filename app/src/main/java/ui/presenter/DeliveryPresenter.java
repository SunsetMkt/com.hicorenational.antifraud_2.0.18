package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.DeliveryView;
import ui.model.OSSModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class DeliveryPresenter extends OSSModelPresent<DeliveryView> {
    private List<DeliveryBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;
    List<OssFileInfo> ossFiles;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public TextView a;

            /* JADX INFO: renamed from: b */
            public TextView f14318b;

            /* JADX INFO: renamed from: c */
            public TextView f14319c;

            /* JADX INFO: renamed from: d */
            public TextView f14320d;

            /* JADX INFO: renamed from: e */
            public TextView f14321e;

            /* JADX INFO: renamed from: f */
            public TextView f14322f;

            /* JADX INFO: renamed from: g */
            public TextView f14323g;

            /* JADX INFO: renamed from: h */
            public ImageView f14324h;

            /* JADX INFO: renamed from: i */
            public ImageView f14325i;

            /* JADX INFO: renamed from: j */
            public View f14326j;

            /* JADX INFO: renamed from: k */
            public View f14327k;

            public a(View view) {
                super(view);
                this.a = (TextView) view.findViewById(R.id.tv_delivery_plat);
                this.f14318b = (TextView) view.findViewById(R.id.tv_delivery_num);
                this.f14322f = (TextView) view.findViewById(R.id.tv_delivery_address);
                this.f14320d = (TextView) view.findViewById(R.id.tv_delivery_sender);
                this.f14319c = (TextView) view.findViewById(R.id.tv_delivery_wp);
                this.f14321e = (TextView) view.findViewById(R.id.tv_delivery_phone);
                this.f14323g = (TextView) view.findViewById(R.id.tv_delivery_time);
                this.f14324h = (ImageView) view.findViewById(R.id.iv_edit);
                this.f14325i = (ImageView) view.findViewById(R.id.iv_clear);
                this.f14326j = view.findViewById(R.id.iv_arrow);
                this.f14327k = view.findViewById(R.id.v_line);
                if (DeliveryPresenter.this.isOnlySee) {
                    this.f14324h.setVisibility(8);
                    this.f14325i.setVisibility(8);
                    this.f14327k.setVisibility(8);
                    this.f14326j.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, final int i2) {
            DeliveryBean deliveryBean = (DeliveryBean) DeliveryPresenter.this.arrayListBean.get(i2);
            if (deliveryBean != null) {
                aVar.a.setText(deliveryBean.getDeliveryPlat());
                aVar.f14318b.setText(deliveryBean.getDeliveryNum());
                aVar.f14319c.setText(deliveryBean.getDeliveryWp());
                aVar.f14320d.setText(deliveryBean.getDeliveryName());
                aVar.f14321e.setText(deliveryBean.getDeliveryPhone());
                aVar.f14322f.setText(deliveryBean.getDeliveryAddress());
                String deliveryTime = deliveryBean.getDeliveryTime();
                if (deliveryTime.length() > 2) {
                    aVar.f14323g.setText(deliveryTime.substring(0, deliveryTime.length() - 3));
                }
            }
            aVar.f14324h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
            aVar.f14325i.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i2, view);
                }
            });
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemDelet(i2);
        }

        public /* synthetic */ void c(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DeliveryPresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.recycle_delivery_item, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((DeliveryView) ((OSSModelPresent) DeliveryPresenter.this).mvpView).onItemEdit(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<DeliveryBean>>> {

        /* JADX INFO: renamed from: ui.presenter.DeliveryPresenter$a$a */
        class C0302a extends com.google.gson.d0.a<List<DeliveryBean>> {
            C0302a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0302a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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
                DeliveryPresenter.this.removeListData(this.a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<DeliveryBean>> {

        class a extends com.google.gson.d0.a<DeliveryBean> {
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

    class d extends MiddleSubscriber<APIresult<List<DeliveryPlatBean>>> {

        class a extends com.google.gson.d0.a<List<DeliveryPlatBean>> {
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
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.J1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getDeliveryList(strB, map, new a());
    }

    public void getPlatList() {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        getDeliveryPlatList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.M1), new HashMap<>(), new d());
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
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.L1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("mailingTelInfoID", str2);
        removeDelivery(strB, map, new b(i2));
    }

    public void removeListData(int i2) {
        this.arrayListBean.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    public void saveDeliveryTelHttp(DeliveryBean deliveryBean) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        saveDeliveryTel(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.K1), deliveryBean, new c());
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
