package p388ui.presenter;

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
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.ManualAlreadyDetailActivity;
import p388ui.callview.ManualListCallView;
import p388ui.model.ModelPresent;
import p388ui.presenter.ManualListPresenter;
import util.C7292k1;

/* loaded from: classes2.dex */
public class ManualListPresenter extends ModelPresent<ManualListCallView> {
    private HolderAdapte mAdapter;
    private List<ManualListBean> mList;

    public class HolderAdapte extends RecyclerView.Adapter<C7024a> {

        /* renamed from: a */
        private Context f24150a;

        /* renamed from: ui.presenter.ManualListPresenter$HolderAdapte$a */
        class C7024a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public TextView f24152a;

            /* renamed from: b */
            public TextView f24153b;

            /* renamed from: c */
            public TextView f24154c;

            /* renamed from: d */
            public TextView f24155d;

            /* renamed from: e */
            public TextView f24156e;

            /* renamed from: f */
            public ImageView f24157f;

            public C7024a(View view) {
                super(view);
                this.f24152a = (TextView) view.findViewById(C2113R.id.tv_manual_title);
                this.f24153b = (TextView) view.findViewById(C2113R.id.tv_name);
                this.f24154c = (TextView) view.findViewById(C2113R.id.tv_id_type);
                this.f24155d = (TextView) view.findViewById(C2113R.id.tv_id);
                this.f24156e = (TextView) view.findViewById(C2113R.id.tv_time);
                this.f24157f = (ImageView) view.findViewById(C2113R.id.iv_tag);
            }
        }

        public HolderAdapte(Context context) {
            this.f24150a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7024a c7024a, int i2) {
            if (ManualListPresenter.this.mList.size() > 0) {
                final ManualListBean manualListBean = (ManualListBean) ManualListPresenter.this.mList.get(i2);
                if (manualListBean != null) {
                    c7024a.f24152a.setText(manualListBean.getTitle());
                    c7024a.f24153b.setText(manualListBean.getUasename());
                    c7024a.f24154c.setText("证件号 (" + manualListBean.getDocumentType() + ")  ");
                    c7024a.f24155d.setText(manualListBean.getIdnumber());
                    c7024a.f24156e.setText(manualListBean.getApplytime());
                    if (manualListBean.getAuditstatus() == Integer.parseInt("1")) {
                        c7024a.f24157f.setImageResource(C2113R.mipmap.ic_manual_aduopt);
                    } else if (manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                        c7024a.f24157f.setImageResource(C2113R.mipmap.ic_manual_reject);
                    }
                }
                c7024a.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ManualListPresenter.HolderAdapte.this.m25638a(manualListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ManualListPresenter.this.mList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7024a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7024a(LayoutInflater.from(this.f24150a).inflate(C2113R.layout.item_manual_list, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25638a(ManualListBean manualListBean, View view) {
            if (manualListBean.getAuditstatus() == Integer.parseInt("1") || manualListBean.getAuditstatus() == Integer.parseInt("3")) {
                return;
            }
            Intent intent = new Intent(ManualListPresenter.this.mActivity, (Class<?>) ManualAlreadyDetailActivity.class);
            intent.putExtra(C7292k1.f25391c, manualListBean.getId());
            ManualListPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.ManualListPresenter$a */
    class C7025a extends MiddleSubscriber<APIresult<PageBean<ManualListBean>>> {

        /* renamed from: ui.presenter.ManualListPresenter$a$a */
        class a extends C2049a<PageBean<ManualListBean>> {
            a() {
            }
        }

        C7025a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
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
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("page", Integer.valueOf(i2));
        hashMap.put("rows", Integer.valueOf(i3));
        hashMap.put("sort", "createtime");
        hashMap.put("order", SocialConstants.PARAM_APP_DESC);
        manualList(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f17007H0), hashMap, new C7025a());
    }

    public void setListData(List<ManualListBean> list) {
        if (list != null) {
            this.mList = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
