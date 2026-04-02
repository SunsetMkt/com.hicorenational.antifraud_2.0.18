package c.a.a.d;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CarNumberProvince.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements g<b> {
    private String name;

    public c(String str) {
        this.name = str;
    }

    @Override // c.a.a.d.g, c.a.a.d.h
    public Object getId() {
        return this.name;
    }

    @Override // c.a.a.d.l
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0193  */
    @Override // c.a.a.d.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<b> getSeconds() {
        byte b2;
        ArrayList arrayList = new ArrayList();
        String str = this.name;
        switch (str.hashCode()) {
            case 20113:
                b2 = str.equals("\u4e91") ? (byte) 26 : (byte) -1;
                break;
            case 20140:
                if (str.equals("\u4eac")) {
                    b2 = 0;
                    break;
                }
                break;
            case 20864:
                if (str.equals("\u5180")) {
                    b2 = 2;
                    break;
                }
                break;
            case 21513:
                if (str.equals("\u5409")) {
                    b2 = 6;
                    break;
                }
                break;
            case 23425:
                if (str.equals("\u5b81")) {
                    b2 = 21;
                    break;
                }
                break;
            case 24029:
                if (str.equals("\u5ddd")) {
                    b2 = 23;
                    break;
                }
                break;
            case 26032:
                if (str.equals("\u65b0")) {
                    b2 = 30;
                    break;
                }
                break;
            case 26187:
                if (str.equals("\u664b")) {
                    b2 = 3;
                    break;
                }
                break;
            case 26690:
                if (str.equals("\u6842")) {
                    b2 = 19;
                    break;
                }
                break;
            case 27818:
                if (str.equals("\u6caa")) {
                    b2 = 8;
                    break;
                }
                break;
            case 27941:
                if (str.equals("\u6d25")) {
                    b2 = 1;
                    break;
                }
                break;
            case 27993:
                if (str.equals("\u6d59")) {
                    b2 = 10;
                    break;
                }
                break;
            case 28189:
                if (str.equals("\u6e1d")) {
                    b2 = 22;
                    break;
                }
                break;
            case 28248:
                if (str.equals("\u6e58")) {
                    b2 = 17;
                    break;
                }
                break;
            case 29756:
                if (str.equals("\u743c")) {
                    b2 = 20;
                    break;
                }
                break;
            case 29976:
                if (str.equals("\u7518")) {
                    b2 = 28;
                    break;
                }
                break;
            case 30358:
                if (str.equals("\u7696")) {
                    b2 = 11;
                    break;
                }
                break;
            case 31908:
                if (str.equals("\u7ca4")) {
                    b2 = 18;
                    break;
                }
                break;
            case 33487:
                if (str.equals("\u82cf")) {
                    b2 = 9;
                    break;
                }
                break;
            case 33945:
                if (str.equals("\u8499")) {
                    b2 = 4;
                    break;
                }
                break;
            case 34255:
                if (str.equals("\u85cf")) {
                    b2 = 25;
                    break;
                }
                break;
            case 35947:
                if (str.equals("\u8c6b")) {
                    b2 = cw.f7205m;
                    break;
                }
                break;
            case 36149:
                if (str.equals("\u8d35")) {
                    b2 = 24;
                    break;
                }
                break;
            case 36195:
                if (str.equals("\u8d63")) {
                    b2 = cw.f7203k;
                    break;
                }
                break;
            case 36797:
                if (str.equals("\u8fbd")) {
                    b2 = 5;
                    break;
                }
                break;
            case 37122:
                if (str.equals("\u9102")) {
                    b2 = cw.f7206n;
                    break;
                }
                break;
            case 38397:
                if (str.equals("\u95fd")) {
                    b2 = 12;
                    break;
                }
                break;
            case 38485:
                if (str.equals("\u9655")) {
                    b2 = 27;
                    break;
                }
                break;
            case 38738:
                if (str.equals("\u9752")) {
                    b2 = 29;
                    break;
                }
                break;
            case 40065:
                if (str.equals("\u9c81")) {
                    b2 = cw.f7204l;
                    break;
                }
                break;
            case 40657:
                if (str.equals("\u9ed1")) {
                    b2 = 7;
                    break;
                }
                break;
        }
        switch (b2) {
            case 0:
                for (char c2 = 'A'; c2 <= 'M'; c2 = (char) (c2 + 1)) {
                    arrayList.add(new b(String.valueOf(c2)));
                }
                arrayList.remove(new b("I"));
                arrayList.add(new b("Y"));
                return arrayList;
            case 1:
                for (char c3 = 'A'; c3 <= 'H'; c3 = (char) (c3 + 1)) {
                    arrayList.add(new b(String.valueOf(c3)));
                }
                return arrayList;
            case 2:
                for (char c4 = 'A'; c4 <= 'H'; c4 = (char) (c4 + 1)) {
                    arrayList.add(new b(String.valueOf(c4)));
                }
                arrayList.add(new b("J"));
                arrayList.add(new b("R"));
                arrayList.add(new b(ExifInterface.LATITUDE_SOUTH));
                arrayList.add(new b(ExifInterface.GPS_DIRECTION_TRUE));
                return arrayList;
            case 3:
                for (char c5 = 'A'; c5 <= 'M'; c5 = (char) (c5 + 1)) {
                    arrayList.add(new b(String.valueOf(c5)));
                }
                arrayList.remove(new b("G"));
                arrayList.remove(new b("I"));
                return arrayList;
            case 4:
                for (char c6 = 'A'; c6 <= 'M'; c6 = (char) (c6 + 1)) {
                    arrayList.add(new b(String.valueOf(c6)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 5:
                for (char c7 = 'A'; c7 <= 'P'; c7 = (char) (c7 + 1)) {
                    arrayList.add(new b(String.valueOf(c7)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 6:
                for (char c8 = 'A'; c8 <= 'K'; c8 = (char) (c8 + 1)) {
                    arrayList.add(new b(String.valueOf(c8)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 7:
                for (char c9 = 'A'; c9 <= 'R'; c9 = (char) (c9 + 1)) {
                    arrayList.add(new b(String.valueOf(c9)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 8:
                for (char c10 = 'A'; c10 <= 'D'; c10 = (char) (c10 + 1)) {
                    arrayList.add(new b(String.valueOf(c10)));
                }
                arrayList.add(new b("R"));
                return arrayList;
            case 9:
                for (char c11 = 'A'; c11 <= 'N'; c11 = (char) (c11 + 1)) {
                    arrayList.add(new b(String.valueOf(c11)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 10:
                for (char c12 = 'A'; c12 <= 'L'; c12 = (char) (c12 + 1)) {
                    arrayList.add(new b(String.valueOf(c12)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 11:
                for (char c13 = 'A'; c13 <= 'S'; c13 = (char) (c13 + 1)) {
                    arrayList.add(new b(String.valueOf(c13)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 12:
                for (char c14 = 'A'; c14 <= 'K'; c14 = (char) (c14 + 1)) {
                    arrayList.add(new b(String.valueOf(c14)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 13:
                for (char c15 = 'A'; c15 <= 'M'; c15 = (char) (c15 + 1)) {
                    arrayList.add(new b(String.valueOf(c15)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 14:
                for (char c16 = 'A'; c16 <= 'V'; c16 = (char) (c16 + 1)) {
                    arrayList.add(new b(String.valueOf(c16)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                arrayList.remove(new b("Y"));
                arrayList.add(new b("Y"));
                return arrayList;
            case 15:
                for (char c17 = 'A'; c17 <= 'U'; c17 = (char) (c17 + 1)) {
                    arrayList.add(new b(String.valueOf(c17)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                arrayList.remove(new b("Y"));
                return arrayList;
            case 16:
                for (char c18 = 'A'; c18 <= 'S'; c18 = (char) (c18 + 1)) {
                    arrayList.add(new b(String.valueOf(c18)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 17:
                for (char c19 = 'A'; c19 <= 'N'; c19 = (char) (c19 + 1)) {
                    arrayList.add(new b(String.valueOf(c19)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                arrayList.add(new b("U"));
                return arrayList;
            case 18:
                for (char c20 = 'A'; c20 <= 'Z'; c20 = (char) (c20 + 1)) {
                    arrayList.add(new b(String.valueOf(c20)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 19:
                for (char c21 = 'A'; c21 <= 'P'; c21 = (char) (c21 + 1)) {
                    arrayList.add(new b(String.valueOf(c21)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                arrayList.add(new b("R"));
                return arrayList;
            case 20:
            case 21:
                for (char c22 = 'A'; c22 <= 'E'; c22 = (char) (c22 + 1)) {
                    arrayList.add(new b(String.valueOf(c22)));
                }
                return arrayList;
            case 22:
                for (char c23 = 'A'; c23 <= 'D'; c23 = (char) (c23 + 1)) {
                    arrayList.add(new b(String.valueOf(c23)));
                }
                arrayList.remove(new b("D"));
                arrayList.remove(new b(ExifInterface.LONGITUDE_EAST));
                return arrayList;
            case 23:
                for (char c24 = 'A'; c24 <= 'Z'; c24 = (char) (c24 + 1)) {
                    arrayList.add(new b(String.valueOf(c24)));
                }
                arrayList.remove(new b("G"));
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 24:
            case 25:
                for (char c25 = 'A'; c25 <= 'J'; c25 = (char) (c25 + 1)) {
                    arrayList.add(new b(String.valueOf(c25)));
                }
                arrayList.remove(new b("I"));
                return arrayList;
            case 26:
                arrayList.add(new b("A-V"));
                for (char c26 = 'A'; c26 <= 'S'; c26 = (char) (c26 + 1)) {
                    arrayList.add(new b(String.valueOf(c26)));
                }
                arrayList.remove(new b("B"));
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 27:
                for (char c27 = 'A'; c27 <= 'K'; c27 = (char) (c27 + 1)) {
                    arrayList.add(new b(String.valueOf(c27)));
                }
                arrayList.remove(new b("I"));
                arrayList.add(new b(ExifInterface.GPS_MEASUREMENT_INTERRUPTED));
                return arrayList;
            case 28:
                for (char c28 = 'A'; c28 <= 'P'; c28 = (char) (c28 + 1)) {
                    arrayList.add(new b(String.valueOf(c28)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            case 29:
                for (char c29 = 'A'; c29 <= 'H'; c29 = (char) (c29 + 1)) {
                    arrayList.add(new b(String.valueOf(c29)));
                }
                return arrayList;
            case 30:
                for (char c30 = 'A'; c30 <= 'R'; c30 = (char) (c30 + 1)) {
                    arrayList.add(new b(String.valueOf(c30)));
                }
                arrayList.remove(new b("I"));
                arrayList.remove(new b("O"));
                return arrayList;
            default:
                return arrayList;
        }
    }

    public String toString() {
        return "name=" + this.name;
    }
}
