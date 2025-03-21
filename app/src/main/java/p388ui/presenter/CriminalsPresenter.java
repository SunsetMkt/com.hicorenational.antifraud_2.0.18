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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
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
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.CriminalsView;
import p388ui.model.ModelPresent;
import p388ui.presenter.CriminalsPresenter;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalsPresenter extends ModelPresent<CriminalsView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<CriminalBean> mCriminalBeans;
    private InterfaceC4552c mDisposable;

    public class HolderAdapte extends RecyclerView.Adapter<C6971a> {

        /* renamed from: a */
        private Context f24052a;

        /* renamed from: ui.presenter.CriminalsPresenter$HolderAdapte$a */
        class C6971a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24054a;

            /* renamed from: b */
            public View f24055b;

            /* renamed from: c */
            public View f24056c;

            /* renamed from: d */
            public TextView f24057d;

            /* renamed from: e */
            public TextView f24058e;

            /* renamed from: f */
            public TextView f24059f;

            /* renamed from: g */
            public TextView f24060g;

            /* renamed from: h */
            public ImageView f24061h;

            public C6971a(View view) {
                super(view);
                this.f24054a = view.findViewById(C2113R.id.fl_view);
                this.f24055b = view.findViewById(C2113R.id.ll_phone_type);
                this.f24057d = (TextView) view.findViewById(C2113R.id.tv_phone_num);
                this.f24056c = view.findViewById(C2113R.id.ll_society_type);
                this.f24058e = (TextView) view.findViewById(C2113R.id.tv_social_acc);
                this.f24059f = (TextView) view.findViewById(C2113R.id.tv_audio_count);
                this.f24060g = (TextView) view.findViewById(C2113R.id.tv_picture_count);
                this.f24061h = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24052a = context;
        }

        /* renamed from: a */
        static /* synthetic */ void m25628a(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C6971a c6971a, final int i2) {
            CriminalBean criminalBean;
            if (CriminalsPresenter.this.mCriminalBeans.size() > 0 && (criminalBean = (CriminalBean) CriminalsPresenter.this.mCriminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    c6971a.f24057d.setText("0个");
                } else {
                    c6971a.f24057d.setText(mobiles.size() + "个");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    c6971a.f24058e.setText("0个");
                } else {
                    c6971a.f24058e.setText(socialAccounts.size() + "个");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    c6971a.f24059f.setText("0个");
                } else {
                    c6971a.f24059f.setText(audios.size() + "个");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    c6971a.f24060g.setText("0张");
                } else {
                    c6971a.f24060g.setText(printscreens.size() + "张");
                }
            }
            c6971a.f24054a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CriminalsPresenter.HolderAdapte.m25628a(view);
                }
            });
            c6971a.f24061h.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CriminalsPresenter.HolderAdapte.this.m25629a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CriminalsPresenter.this.mCriminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C6971a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C6971a(LayoutInflater.from(this.f24052a).inflate(C2113R.layout.item_crimina_list, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25629a(int i2, View view) {
            ((CriminalsView) CriminalsPresenter.this.mvpView).onItemDelet(i2);
        }
    }

    /* renamed from: ui.presenter.CriminalsPresenter$a */
    class C6972a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* renamed from: ui.presenter.CriminalsPresenter$a$a */
        class a extends C2049a<List<CriminalBean>> {
            a() {
            }
        }

        C6972a() {
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
        protected void onNextMiddle(APIresult<List<CriminalBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalsView) CriminalsPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.CriminalsPresenter$b */
    class C6973b extends MiddleSubscriber<APIresult> {
        C6973b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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
        C7257b1.m26193a(this.mActivity, "请稍后...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17125s1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        deleteReportCriminal(m16395a, hashMap, new C6973b());
    }

    public void getCriminalList(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17113o1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getCriminalList(m16395a, hashMap, new C6972a());
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
