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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalsView;
import ui.model.ModelPresent;
import ui.presenter.CriminalsPresenter;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalsPresenter extends ModelPresent<CriminalsView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<CriminalBean> mCriminalBeans;
    private h.a.u0.c mDisposable;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b */
            public View f14309b;

            /* JADX INFO: renamed from: c */
            public View f14310c;

            /* JADX INFO: renamed from: d */
            public TextView f14311d;

            /* JADX INFO: renamed from: e */
            public TextView f14312e;

            /* JADX INFO: renamed from: f */
            public TextView f14313f;

            /* JADX INFO: renamed from: g */
            public TextView f14314g;

            /* JADX INFO: renamed from: h */
            public ImageView f14315h;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14309b = view.findViewById(R.id.ll_phone_type);
                this.f14311d = (TextView) view.findViewById(R.id.tv_phone_num);
                this.f14310c = view.findViewById(R.id.ll_society_type);
                this.f14312e = (TextView) view.findViewById(R.id.tv_social_acc);
                this.f14313f = (TextView) view.findViewById(R.id.tv_audio_count);
                this.f14314g = (TextView) view.findViewById(R.id.tv_picture_count);
                this.f14315h = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        static /* synthetic */ void a(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, final int i2) {
            CriminalBean criminalBean;
            if (CriminalsPresenter.this.mCriminalBeans.size() > 0 && (criminalBean = (CriminalBean) CriminalsPresenter.this.mCriminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    aVar.f14311d.setText("0\u4e2a");
                } else {
                    aVar.f14311d.setText(mobiles.size() + "\u4e2a");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    aVar.f14312e.setText("0\u4e2a");
                } else {
                    aVar.f14312e.setText(socialAccounts.size() + "\u4e2a");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    aVar.f14313f.setText("0\u4e2a");
                } else {
                    aVar.f14313f.setText(audios.size() + "\u4e2a");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    aVar.f14314g.setText("0\u5f20");
                } else {
                    aVar.f14314g.setText(printscreens.size() + "\u5f20");
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CriminalsPresenter.HolderAdapte.a(view);
                }
            });
            aVar.f14315h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CriminalsPresenter.this.mCriminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_crimina_list, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ((CriminalsView) CriminalsPresenter.this.mvpView).onItemDelet(i2);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* JADX INFO: renamed from: ui.presenter.CriminalsPresenter$a$a */
        class C0301a extends com.google.gson.d0.a<List<CriminalBean>> {
            C0301a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0301a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(4, null);
            }
        }
    }

    public CriminalsPresenter(Activity activity, String str, CriminalsView criminalsView) {
        super(activity, criminalsView);
        this.mCriminalBeans = new ArrayList();
        this.caseInfoId = str;
    }

    public void deleteReportCriminal(String str) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u540e...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.t1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        deleteReportCriminal(strB, map, new b());
    }

    public void getCriminalList(String str) {
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.p1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getCriminalList(strB, map, new a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<CriminalBean> list) {
        if (list != null) {
            this.mCriminalBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
