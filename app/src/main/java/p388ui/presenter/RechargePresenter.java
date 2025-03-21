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
import bean.RechargeBean;
import bean.RechargePlatBean;
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
import p388ui.callview.RechargeView;
import p388ui.model.ModelPresent;
import p388ui.presenter.RechargePresenter;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class RechargePresenter extends ModelPresent<RechargeView> {
    private List<RechargeBean> arrayListBean;
    private boolean isOnlySee;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<C7041a> {

        /* renamed from: a */
        private Context f24186a;

        /* renamed from: ui.presenter.RechargePresenter$HolderAdapte$a */
        class C7041a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public TextView f24188a;

            /* renamed from: b */
            public TextView f24189b;

            /* renamed from: c */
            public TextView f24190c;

            /* renamed from: d */
            public TextView f24191d;

            /* renamed from: e */
            public ImageView f24192e;

            /* renamed from: f */
            public ImageView f24193f;

            /* renamed from: g */
            public View f24194g;

            /* renamed from: h */
            public View f24195h;

            public C7041a(View view) {
                super(view);
                this.f24188a = (TextView) view.findViewById(C2113R.id.tv_recharge_plat);
                this.f24189b = (TextView) view.findViewById(C2113R.id.tv_recharge_phone);
                this.f24190c = (TextView) view.findViewById(C2113R.id.tv_recharge_sum);
                this.f24191d = (TextView) view.findViewById(C2113R.id.tv_recharge_time);
                this.f24192e = (ImageView) view.findViewById(C2113R.id.iv_edit);
                this.f24193f = (ImageView) view.findViewById(C2113R.id.iv_clear);
                this.f24195h = view.findViewById(C2113R.id.iv_arrow);
                this.f24194g = view.findViewById(C2113R.id.v_line);
                if (RechargePresenter.this.isOnlySee) {
                    this.f24192e.setVisibility(8);
                    this.f24193f.setVisibility(8);
                    this.f24194g.setVisibility(8);
                    this.f24195h.setVisibility(0);
                }
            }
        }

        public HolderAdapte(Context context) {
            this.f24186a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7041a c7041a, final int i2) {
            RechargeBean rechargeBean = (RechargeBean) RechargePresenter.this.arrayListBean.get(i2);
            if (rechargeBean != null) {
                c7041a.f24188a.setText(rechargeBean.getPlatformText());
                c7041a.f24189b.setText(rechargeBean.getSuspectMobile());
                c7041a.f24190c.setText(rechargeBean.getAmount() + "元");
                c7041a.f24191d.setText(rechargeBean.getChargeTime());
                rechargeBean.getChargeTime();
            }
            c7041a.f24192e.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RechargePresenter.HolderAdapte.this.m25646a(i2, view);
                }
            });
            c7041a.f24193f.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RechargePresenter.HolderAdapte.this.m25648b(i2, view);
                }
            });
            c7041a.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RechargePresenter.HolderAdapte.this.m25649c(i2, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m25648b(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemDelet(i2);
        }

        /* renamed from: c */
        public /* synthetic */ void m25649c(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RechargePresenter.this.arrayListBean.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7041a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7041a(LayoutInflater.from(this.f24186a).inflate(C2113R.layout.recyclerview_recharge_criminal, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25646a(int i2, View view) {
            ((RechargeView) RechargePresenter.this.mvpView).onItemEdit(i2);
        }
    }

    /* renamed from: ui.presenter.RechargePresenter$a */
    class C7042a extends MiddleSubscriber<APIresult<List<RechargeBean>>> {

        /* renamed from: ui.presenter.RechargePresenter$a$a */
        class a extends C2049a<List<RechargeBean>> {
            a() {
            }
        }

        C7042a() {
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
        protected void onNextMiddle(APIresult<List<RechargeBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessList(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.RechargePresenter$b */
    class C7043b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ int f24199a;

        C7043b(int i2) {
            this.f24199a = i2;
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
                RechargePresenter.this.removeListData(this.f24199a);
                C7331w1.m26688a("删除成功");
            }
        }
    }

    /* renamed from: ui.presenter.RechargePresenter$c */
    class C7044c extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: ui.presenter.RechargePresenter$c$a */
        class a extends C2049a<String> {
            a() {
            }
        }

        C7044c() {
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
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((RechargeView) RechargePresenter.this.mvpView).onSuccessSave();
            }
        }
    }

    /* renamed from: ui.presenter.RechargePresenter$d */
    class C7045d extends MiddleSubscriber<APIresult<List<RechargePlatBean>>> {

        /* renamed from: ui.presenter.RechargePresenter$d$a */
        class a extends C2049a<List<RechargePlatBean>> {
            a() {
            }
        }

        C7045d() {
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
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f16993C1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        hashMap.put("chargeTelInfoID", str2);
        removeRechargetel(m16395a, hashMap, new C7043b(i2));
    }

    public void getPlatList() {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        getReChargePlatList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f16996D1), new HashMap<>(), new C7045d());
    }

    public void getReChargeList(String str) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f16987A1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getReChargeList(m16395a, hashMap, new C7042a());
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
        C7257b1.m26193a(this.mActivity, "请稍等...");
        saveRechargeTel(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f16990B1), JNIHandStamp.getInstance().pamramToMap(rechargeBean), new C7044c());
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
