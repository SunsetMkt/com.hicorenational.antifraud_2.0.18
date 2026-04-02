package ui.presenter;

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
import com.hicorenational.antifraud.R;
import com.hihonor.honorid.core.data.UserLoginInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.NoteDetailActivity;
import ui.callview.NoteListView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class NoteListPresenter extends ModelPresent<NoteListView> {
    private List<NoteListBean> NoteListBeans;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public TextView a;

            /* JADX INFO: renamed from: b */
            public TextView f14357b;

            /* JADX INFO: renamed from: c */
            public TextView f14358c;

            /* JADX INFO: renamed from: d */
            public TextView f14359d;

            public a(View view) {
                super(view);
                this.f14357b = (TextView) view.findViewById(R.id.tv_note_them);
                this.f14358c = (TextView) view.findViewById(R.id.tv_time);
                this.a = (TextView) view.findViewById(R.id.tv_num_red);
                this.f14359d = (TextView) view.findViewById(R.id.desc);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, int i2) {
            if (NoteListPresenter.this.NoteListBeans.size() > 0) {
                final NoteListBean noteListBean = (NoteListBean) NoteListPresenter.this.NoteListBeans.get(i2);
                if (noteListBean.isRead()) {
                    aVar.a.setVisibility(4);
                } else {
                    aVar.a.setVisibility(0);
                }
                aVar.f14357b.setText(NoteListPresenter.this.subTitle(noteListBean.getTitle()));
                aVar.f14358c.setText(noteListBean.getVaildStartTime());
                aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.a(noteListBean, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NoteListPresenter.this.NoteListBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_note_list, viewGroup, false));
        }

        public /* synthetic */ void a(NoteListBean noteListBean, View view) {
            Intent intent = new Intent(NoteListPresenter.this.mActivity, (Class<?>) NoteDetailActivity.class);
            intent.putExtra(p1.f15011c, noteListBean);
            NoteListPresenter.this.mActivity.startActivity(intent);
            noteListBean.setRead(true);
            notifyDataSetChanged();
            NoteListPresenter.this.getNoteItem(noteListBean.getId(), noteListBean.getType());
        }
    }

    class a extends MiddleSubscriber<APIresult<List<NoteListBean>>> {

        /* JADX INFO: renamed from: ui.presenter.NoteListPresenter$a$a */
        class C0307a extends com.google.gson.d0.a<List<NoteListBean>> {
            C0307a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0307a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            ((NoteListView) NoteListPresenter.this.mvpView).onSuccessRequest(new ArrayList());
            e2.a(aPIException.getMessage());
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

    class b extends MiddleSubscriber<APIresult<NoteListBean>> {
        b() {
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

    public String subTitle(String str) {
        if (str.length() <= 18) {
            return str;
        }
        return ((Object) str.subSequence(0, 18)) + "...";
    }

    public void getNoteItem(String str, String str2) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String str3 = e.a.f10139c + f.b.v;
        HashMap<String, String> map = new HashMap<>();
        map.put("noticeID", str);
        map.put(UserLoginInfo.f4187i, AccountManager.getAccountId());
        map.put("type", str2);
        getNoteListItem(str3, map, new b());
    }

    public void getNoteList() {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        getNoteList(e.a.f10139c + f.b.u, new a());
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
