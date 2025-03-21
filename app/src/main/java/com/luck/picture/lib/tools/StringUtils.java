package com.luck.picture.lib.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.luck.picture.lib.C2639R;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.regex.Pattern;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class StringUtils {
    @SuppressLint({"StringFormatMatches"})
    public static String getMsg(Context context, String str, int i2) {
        return TextUtils.isEmpty(str) ? "数量限制无效选择" : PictureMimeType.eqVideo(str) ? context.getString(C2639R.string.picture_message_video_max_num, Integer.valueOf(i2)) : PictureMimeType.eqAudio(str) ? context.getString(C2639R.string.picture_message_audio_max_num, Integer.valueOf(i2)) : context.getString(C2639R.string.picture_message_max_num, Integer.valueOf(i2));
    }

    public static String rename(String str) {
        return str.substring(0, str.lastIndexOf(".")) + AbstractC1191a.f2606s1 + DateUtils.getCreateFileName() + str.substring(str.lastIndexOf("."));
    }

    public static String renameSuffix(String str, String str2) {
        return str.substring(0, str.lastIndexOf(".")) + str2;
    }

    public static int stringToInt(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return Integer.valueOf(str).intValue();
        }
        return 0;
    }

    public static void tempTextFont(TextView textView, int i2) {
        String trim = textView.getText().toString().trim();
        String string = i2 == PictureMimeType.ofAudio() ? textView.getContext().getString(C2639R.string.picture_empty_audio_title) : textView.getContext().getString(C2639R.string.picture_empty_title);
        String str = string + trim;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), string.length(), str.length(), 33);
        textView.setText(spannableString);
    }
}
