package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ManualListBean;
import bean.PageBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ManualAlreadyDetailActivity;
import ui.callview.ManualListCallView;
import ui.model.ModelPresent;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class ManualListPresenter extends ModelPresent<ManualListCallView> {
    private HolderAdapte mAdapter;
    private List<ManualListBean> mList;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public TextView a;

            /* JADX INFO: renamed from: b */
            public TextView f14348b;

            /* JADX INFO: renamed from: c */
            public TextView f14349c;

            /* JADX INFO: renamed from: d */
            public TextView f14350d;

            /* JADX INFO: renamed from: e */
            public TextView f14351e;

            /* JADX INFO: renamed from: f */
            public ImageView f14352f;

            public a(View view) {
                super(view);
                this.a = (TextView) view.findViewById(R.id.tv_manual_title);
                this.f14348b = (TextView) view.findViewById(R.id.tv_name);
                this.f14349c = (TextView) view.findViewById(R.id.tv_id_type);
                this.f14350d = (TextView) view.findViewById(R.id.tv_id);
                this.f14351e = (TextView) view.findViewById(R.id.tv_time);
                this.f14352f = (ImageView) view.findViewById(R.id.iv_tag);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, int i2) {
            if (ManualListPresenter.this.mList.size() > 0) {
                final ManualListBean manualListBean = (ManualListBean) ManualListPresenter.this.mList.get(i2);
                if (manualListBean != null) {
                    aVar.a.setText(manualListBean.getTitle());
                    aVar.f14348b.setText(manualListBean.getUasename());
                    aVar.f14349c.setText("\u8bc1\u4ef6\u53f7 (" + manualListBean.getDocumentType() + ")  ");
                    aVar.f14350d.setText(manualListBean.getIdnumber());
                    aVar.f14351e.setText(manualListBean.getApplytime());
                    if (manualListBean.getAuditstatus() == Integer.parseInt("1")) {
                        aVar.f14352f.setImageResource(R.mipmap.ic_manual_aduopt);
                    } else if (manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                        aVar.f14352f.setImageResource(R.mipmap.ic_manual_reject);
                    }
                }
                aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.a(manualListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ManualListPresenter.this.mList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_manual_list, viewGroup, false));
        }

        public /* synthetic */ void a(ManualListBean manualListBean, View view) {
            if (manualListBean.getAuditstatus() == Integer.parseInt("1") || manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                return;
            }
            Intent intent = new Intent(ManualListPresenter.this.mActivity, (Class<?>) ManualAlreadyDetailActivity.class);
            intent.putExtra(p1.f15011c, manualListBean.getId());
            ManualListPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<PageBean<ManualListBean>>> {

        /* JADX INFO: renamed from: ui.presenter.ManualListPresenter$a$a */
        class C0306a extends com.google.gson.d0.a<PageBean<ManualListBean>> {
            C0306a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0306a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ManualListCallView) ManualListPresenter.this.mvpView).onSuccess(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<PageBean<ManualListBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ManualListCallView) ManualListPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public ManualListPresenter(Activity activity, ManualListCallView manualListCallView) {
        super(activity, manualListCallView);
        this.mList = new ArrayList();
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void manualListData(int i2, int i3) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", Integer.valueOf(i2));
        map.put("rows", Integer.valueOf(i3));
        map.put("sort", "createtime");
        map.put("order", SocialConstants.PARAM_APP_DESC);
        manualList(e.a.b(ModuelConfig.MODEL_MANUAL, 8, f.b.I0), map, new a());
    }

    public void setListData(List<ManualListBean> list) {
        if (list != null) {
            this.mList = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
