package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;
import network.HistoryListInfo;

/* JADX INFO: loaded from: classes.dex */
public class ReportDKDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1143h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1144i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f1145j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1146k = 9;
    public Typeface a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HistoryListInfo.RowsBean.DetailsBean f1148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HistoryListInfo.RowsBean f1149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HistoryDetailInfo f1150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<HistoryDetailInfo> f1151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<List<DetailBean>> f1152g;

    public class DefineViewHolder extends RecyclerView.ViewHolder {
        TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f1153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f1154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f1155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f1156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f1157f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f1158g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f1159h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        LinearLayout f1160i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        LinearLayout f1161j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        LinearLayout f1162k;

        public DefineViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_case_type);
            this.f1153b = (TextView) view.findViewById(R.id.casecategory);
            this.f1154c = (TextView) view.findViewById(R.id.tv_report_name);
            this.f1155d = (TextView) view.findViewById(R.id.tv_self);
            this.f1156e = (TextView) view.findViewById(R.id.report_size);
            this.f1157f = (TextView) view.findViewById(R.id.tv_case_num);
            this.f1161j = (LinearLayout) view.findViewById(R.id.ll_report_prog);
            this.f1158g = (ImageView) view.findViewById(R.id.iv_dk_tag);
            this.f1159h = (TextView) view.findViewById(R.id.report_time);
            this.f1160i = (LinearLayout) view.findViewById(R.id.ll_progress);
            this.f1162k = (LinearLayout) view.findViewById(R.id.ll_report_progress);
            this.a.setText("\u4e3e\u62a5\u8be6\u60c5");
            this.f1161j.setVisibility(8);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f1166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f1167e;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.f1164b = i2;
            this.a = (RecyclerView) view.findViewById(R.id.recyclerview);
            this.f1165c = (TextView) view.findViewById(R.id.group_report);
            this.f1166d = (TextView) view.findViewById(R.id.group_report_count);
            this.f1167e = view.findViewById(R.id.item_line);
        }
    }

    public ReportDKDetailsAdapter(Typeface typeface, HistoryListInfo.RowsBean rowsBean, HistoryDetailInfo historyDetailInfo, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f1147b = context;
        this.a = typeface;
        this.f1149d = rowsBean;
        this.f1148c = rowsBean == null ? null : rowsBean.getInfo();
        this.f1150e = historyDetailInfo;
        this.f1151f = list;
        this.f1152g = list2;
    }

    private void a(DefineViewHolder defineViewHolder) {
        HistoryListInfo.RowsBean.DetailsBean detailsBean = this.f1148c;
        if (detailsBean != null) {
            String caseCategoryText = detailsBean.getCaseCategoryText();
            if (TextUtils.isEmpty(caseCategoryText)) {
                caseCategoryText = "\u5176\u4ed6\u8bc8\u9a97";
            }
            defineViewHolder.f1153b.setText(caseCategoryText);
            defineViewHolder.f1156e.setText("(" + this.f1149d.getEvidenceCount() + "\u9879\u4e3e\u62a5\u5185\u5bb9)");
            defineViewHolder.f1159h.setText(this.f1148c.getSubmitTime());
            this.f1148c.getRegion();
            this.f1148c.getCaseDescription();
            defineViewHolder.f1158g.setVisibility(0);
        }
        if (this.f1150e.replys == null) {
            defineViewHolder.f1160i.setVisibility(8);
            return;
        }
        defineViewHolder.f1160i.setVisibility(0);
        for (int i2 = 0; i2 < this.f1150e.replys.size(); i2++) {
            View viewInflate = LayoutInflater.from(this.f1147b).inflate(R.layout.report_reply_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_reply_img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_time);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_content);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_line);
            textView.setTypeface(this.a);
            HistoryDetailInfo.Replay replay = this.f1150e.replys.get(i2);
            int i3 = replay.processType;
            if (i3 == 3) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
            } else if (i3 == 2) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setBackgroundResource(R.color.divide_line);
            } else {
                imageView.setImageResource(R.drawable.iv_gray_default_img);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setVisibility(8);
            }
            if (TextUtils.isEmpty(replay.description)) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
            defineViewHolder.f1162k.addView(viewInflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1151f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f1151f.get(i2).getItemType() == -1) {
            return -1;
        }
        if (this.f1151f.get(i2).getItemType() == 1) {
            return 1;
        }
        if (this.f1151f.get(i2).getItemType() == 8) {
            return 8;
        }
        return this.f1151f.get(i2).getItemType() == 9 ? 9 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof DefineViewHolder) {
            a((DefineViewHolder) viewHolder);
        } else if (viewHolder instanceof RecyclerViewHolder) {
            a((RecyclerViewHolder) viewHolder, i2 - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == -1) {
            return new DefineViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_list_head, viewGroup, false));
        }
        if (i2 == 1 || i2 == 8 || i2 == 9) {
            return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_report_list, viewGroup, false), i2);
        }
        return null;
    }

    private void a(RecyclerViewHolder recyclerViewHolder, int i2) {
        String title = this.f1151f.get(i2 + 1).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f1165c.setText(title);
        }
        List<List<DetailBean>> list = this.f1152g;
        if (list != null && list.get(i2) != null) {
            recyclerViewHolder.f1166d.setText(this.f1152g.get(i2).size() + "\u4e2a");
        } else {
            recyclerViewHolder.f1166d.setText("0\u4e2a");
        }
        if (i2 == 0) {
            recyclerViewHolder.f1167e.setVisibility(8);
        }
    }
}
