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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.SignCriminalDetialActivity;
import p388ui.callview.SignCommitCriminalView;
import p388ui.model.ModelPresent;
import p388ui.presenter.SignCommitCriminalPresenter;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SignCommitCriminalPresenter extends ModelPresent<SignCommitCriminalView> {
    private String caseInfoId;
    private List<CriminalBean> criminalBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<C7084a> {

        /* renamed from: a */
        private Context f24309a;

        /* renamed from: ui.presenter.SignCommitCriminalPresenter$HolderAdapte$a */
        class C7084a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24311a;

            /* renamed from: b */
            public View f24312b;

            /* renamed from: c */
            public View f24313c;

            /* renamed from: d */
            public TextView f24314d;

            /* renamed from: e */
            public TextView f24315e;

            /* renamed from: f */
            public TextView f24316f;

            /* renamed from: g */
            public TextView f24317g;

            /* renamed from: h */
            public ImageView f24318h;

            public C7084a(View view) {
                super(view);
                this.f24311a = view.findViewById(C2113R.id.fl_view);
                this.f24312b = view.findViewById(C2113R.id.ll_phone_type);
                this.f24314d = (TextView) view.findViewById(C2113R.id.tv_phone_num);
                this.f24313c = view.findViewById(C2113R.id.ll_society_type);
                this.f24315e = (TextView) view.findViewById(C2113R.id.tv_social_acc);
                this.f24316f = (TextView) view.findViewById(C2113R.id.tv_audio_count);
                this.f24317g = (TextView) view.findViewById(C2113R.id.tv_picture_count);
                this.f24318h = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24309a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7084a c7084a, final int i2) {
            CriminalBean criminalBean;
            if (SignCommitCriminalPresenter.this.criminalBeans.size() > 0 && (criminalBean = (CriminalBean) SignCommitCriminalPresenter.this.criminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    c7084a.f24314d.setText("0个");
                } else {
                    c7084a.f24314d.setText(mobiles.size() + "个");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    c7084a.f24315e.setText("0个");
                } else {
                    c7084a.f24315e.setText(socialAccounts.size() + "个");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    c7084a.f24316f.setText("0个");
                } else {
                    c7084a.f24316f.setText(audios.size() + "个");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    c7084a.f24317g.setText("0张");
                } else {
                    c7084a.f24317g.setText(printscreens.size() + "张");
                }
            }
            c7084a.f24311a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SignCommitCriminalPresenter.HolderAdapte.this.m25667a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitCriminalPresenter.this.criminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7084a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7084a(LayoutInflater.from(this.f24309a).inflate(C2113R.layout.item_crimina_list_preview, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25667a(int i2, View view) {
            Intent intent = new Intent(SignCommitCriminalPresenter.this.mActivity, (Class<?>) SignCriminalDetialActivity.class);
            intent.putExtra(C7292k1.f25338C0, SignCommitCriminalPresenter.this.caseInfoId);
            intent.putExtra(C7292k1.f25391c, (Serializable) SignCommitCriminalPresenter.this.criminalBeans.get(i2));
            SignCommitCriminalPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.SignCommitCriminalPresenter$a */
    class C7085a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* renamed from: ui.presenter.SignCommitCriminalPresenter$a$a */
        class a extends C2049a<List<CriminalBean>> {
            a() {
            }
        }

        C7085a() {
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
                ((SignCommitCriminalView) SignCommitCriminalPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((SignCommitCriminalView) SignCommitCriminalPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    public SignCommitCriminalPresenter(Activity activity, String str, SignCommitCriminalView signCommitCriminalView) {
        super(activity, signCommitCriminalView);
        this.criminalBeans = new ArrayList();
        this.caseInfoId = str;
    }

    public void getCriminalList(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17113o1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getCriminalList(m16395a, hashMap, new C7085a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<CriminalBean> list) {
        if (list != null) {
            this.criminalBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
