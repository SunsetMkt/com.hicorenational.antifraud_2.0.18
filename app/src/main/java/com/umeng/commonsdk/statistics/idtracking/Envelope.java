package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.SocialOperation;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3352bi;
import com.umeng.analytics.pro.C3369bz;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.C3497b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Envelope {
    private static final String dummyID1 = "1234567890987654321";
    private static final String dummyID2 = "02:00:00:00:00:00";
    private byte[] identity;
    private String mAddress;
    private byte[] mEntity;
    private int mLength;
    private int mTimestamp;
    private final byte[] SEED = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int CODEX_ENCRYPT = 1;
    private final int CODEX_NORMAL = 0;
    private String mVersion = "1.0";
    private byte[] mSignature = null;
    private byte[] mGuid = null;
    private byte[] mChecksum = null;
    private int mSerialNo = 0;
    private boolean encrypt = false;

    private Envelope(byte[] bArr, String str, byte[] bArr2) throws Exception {
        this.mAddress = null;
        this.mTimestamp = 0;
        this.mLength = 0;
        this.mEntity = null;
        this.identity = null;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.mAddress = str;
        this.mLength = bArr.length;
        this.mEntity = C3497b.m11809a(bArr);
        this.mTimestamp = (int) (System.currentTimeMillis() / 1000);
        this.identity = bArr2;
    }

    private byte[] genCheckSum() {
        return DataHelper.hash((DataHelper.toHexString(this.mSignature) + this.mSerialNo + this.mTimestamp + this.mLength + DataHelper.toHexString(this.mGuid)).getBytes());
    }

    public static Envelope genEncryptEnvelope(Context context, String str, byte[] bArr) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString(SocialOperation.GAME_SIGNATURE, null);
            int i2 = sharedPreferences.getInt("serial", 1);
            Envelope envelope = new Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setEncrypt(true);
            envelope.setSignature(string);
            envelope.setSerialNumber(i2);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i2 + 1).putString(SocialOperation.GAME_SIGNATURE, envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static Envelope genEnvelope(Context context, String str, byte[] bArr) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString(SocialOperation.GAME_SIGNATURE, null);
            int i2 = sharedPreferences.getInt("serial", 1);
            Envelope envelope = new Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setSignature(string);
            envelope.setSerialNumber(i2);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i2 + 1).putString(SocialOperation.GAME_SIGNATURE, envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    private byte[] genGuid(byte[] bArr, int i2) {
        byte[] hash = DataHelper.hash(this.identity);
        byte[] hash2 = DataHelper.hash(this.mEntity);
        int length = hash.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr2[i4] = hash2[i3];
            bArr2[i4 + 1] = hash[i3];
        }
        for (int i5 = 0; i5 < 2; i5++) {
            bArr2[i5] = bArr[i5];
            bArr2[(bArr2.length - i5) - 1] = bArr[(bArr.length - i5) - 1];
        }
        byte[] bArr3 = {(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) (i2 >>> 24)};
        for (int i6 = 0; i6 < bArr2.length; i6++) {
            bArr2[i6] = (byte) (bArr2[i6] ^ bArr3[i6 % 4]);
        }
        return bArr2;
    }

    private byte[] genSignature() {
        return genGuid(this.SEED, (int) (System.currentTimeMillis() / 1000));
    }

    public static String getSignature(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(SocialOperation.GAME_SIGNATURE, null);
    }

    public void export(Context context) {
        String str = this.mAddress;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", null);
        String hexString = DataHelper.toHexString(this.mSignature);
        byte[] bArr = new byte[16];
        System.arraycopy(this.mSignature, 2, bArr, 0, 16);
        String hexString2 = DataHelper.toHexString(DataHelper.hash(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (imprintProperty != null) {
                jSONObject.put("umid", imprintProperty);
            }
            jSONObject.put(SocialOperation.GAME_SIGNATURE, hexString);
            jSONObject.put("checksum", hexString2);
            File file = new File(context.getFilesDir(), C3336at.m10865b().m10868b(C3336at.f11488b));
            if (!file.exists()) {
                file.mkdir();
            }
            HelperUtils.writeFile(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", UMUtils.getChannel(context));
            if (imprintProperty != null) {
                jSONObject2.put("umid", HelperUtils.getUmengMD5(imprintProperty));
            }
            HelperUtils.writeFile(new File(context.getFilesDir(), C3336at.m10865b().m10868b(C3336at.f11494h)), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void seal() {
        if (this.mSignature == null) {
            this.mSignature = genSignature();
        }
        if (this.encrypt) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.mSignature, 1, bArr, 0, 16);
                this.mEntity = DataHelper.encrypt(this.mEntity, bArr);
            } catch (Exception unused) {
            }
        }
        this.mGuid = genGuid(this.mSignature, this.mTimestamp);
        this.mChecksum = genCheckSum();
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public void setSerialNumber(int i2) {
        this.mSerialNo = i2;
    }

    public void setSignature(String str) {
        this.mSignature = DataHelper.reverseHexString(str);
    }

    public byte[] toBinary() {
        C3352bi c3352bi = new C3352bi();
        c3352bi.m10926a(this.mVersion);
        c3352bi.m10931b(this.mAddress);
        c3352bi.m10935c(DataHelper.toHexString(this.mSignature));
        c3352bi.m10925a(this.mSerialNo);
        c3352bi.m10930b(this.mTimestamp);
        c3352bi.m10934c(this.mLength);
        c3352bi.m10928a(this.mEntity);
        c3352bi.m10938d(this.encrypt ? 1 : 0);
        c3352bi.m10939d(DataHelper.toHexString(this.mGuid));
        c3352bi.m10943e(DataHelper.toHexString(this.mChecksum));
        try {
            return new C3369bz().m11073a(c3352bi);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return String.format("version : %s\n", this.mVersion) + String.format("address : %s\n", this.mAddress) + String.format("signature : %s\n", DataHelper.toHexString(this.mSignature)) + String.format("serial : %s\n", Integer.valueOf(this.mSerialNo)) + String.format("timestamp : %d\n", Integer.valueOf(this.mTimestamp)) + String.format("length : %d\n", Integer.valueOf(this.mLength)) + String.format("guid : %s\n", DataHelper.toHexString(this.mGuid)) + String.format("checksum : %s ", DataHelper.toHexString(this.mChecksum)) + String.format("codex : %d", Integer.valueOf(this.encrypt ? 1 : 0));
    }

    public String getSignature() {
        return DataHelper.toHexString(this.mSignature);
    }
}
