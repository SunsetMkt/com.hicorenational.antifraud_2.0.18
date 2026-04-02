package ui.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTextView extends AppCompatTextView {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Pattern f14530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Matcher f14531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LinkedList<String> f14532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LinkedList<b> f14533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14536h;

    class a extends ClickableSpan {
        private String a;

        public a(String str) {
            this.a = str;
            HttpTextView.this.f14536h = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Toast.makeText(view.getContext(), this.a, 0).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-11436114);
            textPaint.setUnderlineText(false);
        }
    }

    class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14538b;

        b() {
        }
    }

    public HttpTextView(Context context) {
        this(context, null);
    }

    public boolean getIsNeedToRegionUrl() {
        return this.f14535g;
    }

    public String getUrlText() {
        String str = this.f14536h;
        if (str == null) {
            return null;
        }
        return str;
    }

    public void setOpenRegionUrl(boolean z) {
        this.f14535g = z;
    }

    public void setUrlText(CharSequence charSequence) {
        if (!this.f14535g) {
            super.setText(charSequence);
        } else {
            super.setText(a(charSequence));
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public HttpTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private w a(CharSequence charSequence) {
        CharSequence charSequenceSubSequence;
        this.f14532d.clear();
        this.f14533e.clear();
        if (charSequence == null) {
            charSequence = "";
        }
        w wVar = new w(charSequence);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) wVar.getSpans(0, charSequence.length(), ClickableSpan.class);
        if (clickableSpanArr.length > 0) {
            int spanEnd = 0;
            int spanStart = 0;
            for (ClickableSpan clickableSpan : clickableSpanArr) {
                spanStart = wVar.getSpanStart(clickableSpanArr[0]);
                spanEnd = wVar.getSpanEnd(clickableSpan);
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(spanEnd, charSequence.length());
            charSequenceSubSequence = charSequence.subSequence(spanStart, spanEnd);
            charSequence = charSequenceSubSequence2;
        } else {
            charSequenceSubSequence = null;
        }
        this.f14531c = this.f14530b.matcher(charSequence);
        while (this.f14531c.find()) {
            b bVar = new b();
            bVar.a = this.f14531c.start();
            bVar.f14538b = this.f14531c.end();
            this.f14532d.add(this.f14531c.group());
            this.f14533e.add(bVar);
        }
        return a(charSequenceSubSequence, charSequence);
    }

    public HttpTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
        this.f14530b = Pattern.compile(this.a);
        this.f14534f = 33;
        this.f14535g = true;
        this.f14532d = new LinkedList<>();
        this.f14533e = new LinkedList<>();
    }

    private w a(CharSequence charSequence, CharSequence charSequence2) {
        w wVar;
        if (charSequence != null) {
            wVar = new w(charSequence);
        } else {
            wVar = new w();
        }
        if (this.f14532d.size() > 0) {
            if (this.f14532d.size() == 1) {
                wVar.append((CharSequence) charSequence2.toString().substring(0, this.f14533e.get(0).a));
                String str = this.f14532d.get(0);
                wVar.append((CharSequence) str, (Object) new a(str), this.f14534f);
                wVar.append((CharSequence) charSequence2.toString().substring(this.f14533e.get(0).f14538b));
            } else {
                for (int i2 = 0; i2 < this.f14532d.size(); i2++) {
                    if (i2 == 0) {
                        wVar.append((CharSequence) charSequence2.toString().substring(0, this.f14533e.get(0).a));
                    }
                    if (i2 == this.f14532d.size() - 1) {
                        wVar.append((CharSequence) this.f14532d.get(i2), (Object) new a(this.f14532d.get(i2)), this.f14534f);
                        wVar.append((CharSequence) charSequence2.toString().substring(this.f14533e.get(i2).f14538b));
                    }
                    if (i2 != this.f14532d.size() - 1) {
                        wVar.append((CharSequence) this.f14532d.get(i2), (Object) new a(this.f14532d.get(i2)), this.f14534f);
                        wVar.append((CharSequence) charSequence2.toString().substring(this.f14533e.get(i2).f14538b, this.f14533e.get(i2 + 1).a));
                    }
                }
            }
        } else {
            wVar.append(charSequence2);
        }
        return wVar;
    }
}
