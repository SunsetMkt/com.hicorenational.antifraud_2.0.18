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
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.SignCriminalDetialActivity;
import ui.callview.SignCommitCriminalView;
import ui.model.ModelPresent;
import util.e2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class SignCommitCriminalPresenter extends ModelPresent<SignCommitCriminalView> {
    private String caseInfoId;
    private List<CriminalBean> criminalBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b */
            public View f14424b;

            /* JADX INFO: renamed from: c */
            public View f14425c;

            /* JADX INFO: renamed from: d */
            public TextView f14426d;

            /* JADX INFO: renamed from: e */
            public TextView f14427e;

            /* JADX INFO: renamed from: f */
            public TextView f14428f;

            /* JADX INFO: renamed from: g */
            public TextView f14429g;

            /* JADX INFO: renamed from: h */
            public ImageView f14430h;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14424b = view.findViewById(R.id.ll_phone_type);
                this.f14426d = (TextView) view.findViewById(R.id.tv_phone_num);
                this.f14425c = view.findViewById(R.id.ll_society_type);
                this.f14427e = (TextView) view.findViewById(R.id.tv_social_acc);
                this.f14428f = (TextView) view.findViewById(R.id.tv_audio_count);
                this.f14429g = (TextView) view.findViewById(R.id.tv_picture_count);
                this.f14430h = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, final int i2) {
            CriminalBean criminalBean;
            if (SignCommitCriminalPresenter.this.criminalBeans.size() > 0 && (criminalBean = (CriminalBean) SignCommitCriminalPresenter.this.criminalBeans.get(i2)) != null) {
                List<CallCriminalBean> mobiles = criminalBean.getMobiles();
                if (mobiles == null || mobiles.size() <= 0) {
                    aVar.f14426d.setText("0\u4e2a");
                } else {
                    aVar.f14426d.setText(mobiles.size() + "\u4e2a");
                }
                List<SocialCriminalBean> socialAccounts = criminalBean.getSocialAccounts();
                if (socialAccounts == null || socialAccounts.size() <= 0) {
                    aVar.f14427e.setText("0\u4e2a");
                } else {
                    aVar.f14427e.setText(socialAccounts.size() + "\u4e2a");
                }
                List<UploadFileBean> audios = criminalBean.getAudios();
                if (audios == null || audios.size() <= 0) {
                    aVar.f14428f.setText("0\u4e2a");
                } else {
                    aVar.f14428f.setText(audios.size() + "\u4e2a");
                }
                List<UploadFileBean> printscreens = criminalBean.getPrintscreens();
                if (printscreens == null || printscreens.size() <= 0) {
                    aVar.f14429g.setText("0\u5f20");
                } else {
                    aVar.f14429g.setText(printscreens.size() + "\u5f20");
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitCriminalPresenter.this.criminalBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_crimina_list_preview, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(SignCommitCriminalPresenter.this.mActivity, (Class<?>) SignCriminalDetialActivity.class);
            intent.putExtra(p1.C0, SignCommitCriminalPresenter.this.caseInfoId);
            intent.putExtra(p1.f15011c, (Serializable) SignCommitCriminalPresenter.this.criminalBeans.get(i2));
            SignCommitCriminalPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<CriminalBean>>> {

        /* JADX INFO: renamed from: ui.presenter.SignCommitCriminalPresenter$a$a */
        class C0315a extends com.google.gson.d0.a<List<CriminalBean>> {
            C0315a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0315a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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
            this.criminalBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
