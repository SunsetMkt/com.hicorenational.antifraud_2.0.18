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
import bean.RechargeBean;
import bean.RechargePlatBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.RechargeView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class RechargePresenter extends ModelPresent<RechargeView> {
    private List<RechargeBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public TextView a;

            /* JADX INFO: renamed from: b */
            public TextView f14362b;

            /* JADX INFO: renamed from: c */
            public TextView f14363c;

            /* JADX INFO: renamed from: d */
            public TextView f14364d;

            /* JADX INFO: renamed from: e */
            public ImageView f14365e;

            /* JADX INFO: renamed from: f */
            public ImageView f14366f;

            /* JADX INFO: renamed from: g */
            public View f14367g;

            /* JADX INFO: renamed from: h */
            public View f14368h;

            public a(View view) {
                super(view);
                this.a = (TextView) view.findViewById(R.id.tv_recharge_plat);
                this.f14362b = (TextView) view.findViewById(R.id.tv_recharge_phone);
                this.f14363c = (TextView) view.findViewById(R.id.tv_recharge_sum);
                this.f14364d = (TextView) view.findViewById(R.id.tv_recharge_time);
                this.f14365e = (ImageView) view.findViewById(R.id.iv_edit);
                this.f14366f = (ImageView) view.findViewById(R.id.iv_clear);
                this.f14368h = view.findViewById(R.id.iv_arrow);
                this.f14367g = view.findViewById(R.id.v_line);
                if (RechargePresenter.this.isOnlySee) {
                    this.f14365e.setVisibility(8);
                    this.f14366f.setVisibility(8);
                    this.f14367g.setVisibility(8);
                    this.f14368h.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, final int i2) {
            RechargeBean rechargeBean = (RechargeBean) RechargePresenter.this.arrayListBean.get(i2);
            if (rechargeBean != null) {
                aVar.a.setText(rechargeBean.getPlatformText());
                aVar.f14362b.setText(rechargeBean.getSuspectMobile());
                aVar.f14363c.setText(rechargeBean.getAmount() + "\u5143");
                aVar.f14364d.setText(rechargeBean.getChargeTime());
                rechargeBean.getChargeTime();
            }
            aVar.f14365e.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
            aVar.f14366f.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i2, view);
                }
            });
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemDelet(i2);
        }

        public /* synthetic */ void c(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RechargePresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.recyclerview_recharge_criminal, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<RechargeBean>>> {

        /* JADX INFO: renamed from: ui.presenter.RechargePresenter$a$a */
        class C0309a extends com.google.gson.d0.a<List<RechargeBean>> {
            C0309a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0309a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<RechargeBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessList(aPIresult.getData());
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
                RechargePresenter.this.removeListData(this.a);
                e2.a("\u5220\u9664\u6210\u529f");
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<String>> {

        class a extends com.google.gson.d0.a<String> {
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
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<List<RechargePlatBean>>> {

        class a extends com.google.gson.d0.a<List<RechargePlatBean>> {
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
        protected void onNextMiddle(APIresult<List<RechargePlatBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessPlatList(aPIresult.getData());
            }
        }
    }

    public RechargePresenter(Activity activity, RechargeView rechargeView) {
        super(activity, rechargeView);
        this.arrayListBean = new ArrayList();
        this.isOnlySee = false;
    }

    public void deleteRecharge(String str, String str2, int i2) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.D1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        map.put("chargeTelInfoID", str2);
        removeRechargetel(strB, map, new b(i2));
    }

    public void getPlatList() {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        getReChargePlatList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.E1), new HashMap<>(), new d());
    }

    public void getReChargeList(String str) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.B1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getReChargeList(strB, map, new a());
    }

    public void initRecycle(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void isOnlySee(boolean z) {
        this.isOnlySee = z;
    }

    public void removeListData(int i2) {
        this.arrayListBean.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    public void saveRechargeTel(RechargeBean rechargeBean) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        saveRechargeTel(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.C1), JNIHandStamp.getInstance().pamramToMap(rechargeBean), new c());
    }

    public void setListData(List<RechargeBean> list) {
        this.arrayListBean = list;
        this.mAdapter.notifyDataSetChanged();
    }

    public void updateListData(int i2, RechargeBean rechargeBean) {
        this.arrayListBean.set(i2, rechargeBean);
        this.mAdapter.notifyItemChanged(i2);
    }
}
