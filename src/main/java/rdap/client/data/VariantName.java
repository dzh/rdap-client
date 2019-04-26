package rdap.client.data;

/**
 * {
 * "ldhName": "xn--fo-8ja.example",
 * "unicodeName": "foo.example"
 * }
 *
 * @author dzh
 * @date 2019-03-28 13:28
 */
public class VariantName {

    private String ldhName;
    private String unicodeName;

    public String getLdhName() {
        return ldhName;
    }

    public void setLdhName(String ldhName) {
        this.ldhName = ldhName;
    }

    public String getUnicodeName() {
        return unicodeName;
    }

    public void setUnicodeName(String unicodeName) {
        this.unicodeName = unicodeName;
    }
}
