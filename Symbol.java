
/**
 * Created by Kevin L. Wong on 11/28/2023
 * encapsulates symbol attributes, storing their type, kind, and numeric value.
 * This class constructs symbols with specified characteristics and offers
 * methods to retrieve their type, kind, and number
 */
public class Symbol {

    private String mType;
    private String mKind;
    private int mNumber;

    public Symbol(String strType, String strKind, int nNumber) {
        mType = strType;
        mKind = strKind;
        mNumber = nNumber;

    }

    public String getType() {
        return mType;
    }

    public String getKind() {
        return mKind;
    }

    public int getNumber() {
        return mNumber;
    }

}