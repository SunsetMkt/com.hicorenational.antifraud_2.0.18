package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import network.HistoryDetailInfo;

/* loaded from: classes.dex */
public class ReportDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    public Typeface f292a;

    /* renamed from: b */
    private final Context f293b;

    /* renamed from: c */
    private final List<HistoryDetailInfo> f294c;

    /* renamed from: d */
    private List<List<DetailBean>> f295d;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public int f296a;

        /* renamed from: b */
        public TextView f297b;

        /* renamed from: c */
        public TextView f298c;

        /* renamed from: d */
        public View f299d;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.f296a = i2;
            this.f297b = (TextView) view.findViewById(C2113R.id.group_report);
            this.f298c = (TextView) view.findViewById(C2113R.id.group_report_count);
            this.f299d = view.findViewById(C2113R.id.item_line);
        }
    }

    public ReportDetailsAdapter(Typeface typeface, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f293b = context;
        this.f292a = typeface;
        this.f294c = list;
        this.f295d = list2;
    }

    /* renamed from: a */
    private void m270a(RecyclerViewHolder recyclerViewHolder, int i2) {
        recyclerViewHolder.f299d.setVisibility(8);
        String title = this.f294c.get(i2).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f297b.setText(title);
        }
        List<List<DetailBean>> list = this.f295d;
        if (list == null || list.get(i2) == null) {
            recyclerViewHolder.f298c.setText("0个");
            return;
        }
        recyclerViewHolder.f298c.setText(this.f295d.get(i2).size() + "个");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f294c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        m270a((RecyclerViewHolder) viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2113R.layout.recyclerview_report_list, viewGroup, false), i2);
    }
}
