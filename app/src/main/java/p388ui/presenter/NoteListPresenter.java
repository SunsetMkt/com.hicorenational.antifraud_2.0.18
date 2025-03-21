package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.NoteListBean;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import com.hihonor.honorid.core.data.UserLoginInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.NoteDetailActivity;
import p388ui.callview.NoteListView;
import p388ui.model.ModelPresent;
import p388ui.presenter.NoteListPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class NoteListPresenter extends ModelPresent<NoteListView> {
    private List<NoteListBean> NoteListBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<C7032a> {

        /* renamed from: a */
        private Context f24169a;

        /* renamed from: ui.presenter.NoteListPresenter$HolderAdapte$a */
        class C7032a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public TextView f24171a;

            /* renamed from: b */
            public TextView f24172b;

            /* renamed from: c */
            public TextView f24173c;

            /* renamed from: d */
            public TextView f24174d;

            public C7032a(View view) {
                super(view);
                this.f24172b = (TextView) view.findViewById(C2113R.id.tv_note_them);
                this.f24173c = (TextView) view.findViewById(C2113R.id.tv_time);
                this.f24171a = (TextView) view.findViewById(C2113R.id.tv_num_red);
                this.f24174d = (TextView) view.findViewById(C2113R.id.desc);
            }
        }

        public HolderAdapte(Context context) {
            this.f24169a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7032a c7032a, int i2) {
            if (NoteListPresenter.this.NoteListBeans.size() > 0) {
                final NoteListBean noteListBean = (NoteListBean) NoteListPresenter.this.NoteListBeans.get(i2);
                if (noteListBean.isRead()) {
                    c7032a.f24171a.setVisibility(4);
                } else {
                    c7032a.f24171a.setVisibility(0);
                }
                c7032a.f24172b.setText(NoteListPresenter.this.subTitle(noteListBean.getTitle()));
                c7032a.f24173c.setText(noteListBean.getVaildStartTime());
                c7032a.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NoteListPresenter.HolderAdapte.this.m25643a(noteListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NoteListPresenter.this.NoteListBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7032a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7032a(LayoutInflater.from(this.f24169a).inflate(C2113R.layout.item_note_list, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25643a(NoteListBean noteListBean, View view) {
            Intent intent = new Intent(NoteListPresenter.this.mActivity, (Class<?>) NoteDetailActivity.class);
            intent.putExtra(C7292k1.f25391c, noteListBean);
            NoteListPresenter.this.mActivity.startActivity(intent);
            noteListBean.setRead(true);
            notifyDataSetChanged();
            NoteListPresenter.this.getNoteItem(noteListBean.getId());
        }
    }

    /* renamed from: ui.presenter.NoteListPresenter$a */
    class C7033a extends MiddleSubscriber<APIresult<List<NoteListBean>>> {

        /* renamed from: ui.presenter.NoteListPresenter$a$a */
        class a extends C2049a<List<NoteListBean>> {
            a() {
            }
        }

        C7033a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            ((NoteListView) NoteListPresenter.this.mvpView).onSuccessRequest(new ArrayList());
            C7331w1.m26688a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<NoteListBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((NoteListView) NoteListPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.NoteListPresenter$b */
    class C7034b extends MiddleSubscriber<APIresult<NoteListBean>> {
        C7034b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return NoteListBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<NoteListBean> aPIresult) {
            if (aPIresult.getCode() == 0) {
                aPIresult.getData();
            }
        }
    }

    public NoteListPresenter(Activity activity, NoteListView noteListView) {
        super(activity, noteListView);
        this.NoteListBeans = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String subTitle(String str) {
        if (str.length() <= 18) {
            return str;
        }
        return ((Object) str.subSequence(0, 18)) + "...";
    }

    public void getNoteItem(String str) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String str2 = C4440a.f16881c + C4445b.f17129u;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("noticeID", str);
        hashMap.put(UserLoginInfo.f6638i, AccountManager.getAccountId());
        getNoteListItem(str2, hashMap, new C7034b());
    }

    public void getNoteList() {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        getNoteList(C4440a.f16881c + C4445b.f17126t, new C7033a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<NoteListBean> list) {
        this.NoteListBeans = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
