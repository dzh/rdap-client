package rdap.client.data;

import java.util.List;

/**
 * <pre>
 * {
 * "relation" : [ "unregistered", "registration restricted" ],
 * "idnTable": ".EXAMPLE Swedish",
 * "variantNames" :
 *  [
 *      {
 *          "ldhName": "xn--fo-8ja.example",
 *          "unicodeName": "foo.example"
 *      }
 *  ]
 * }
 * </pre>
 *
 * @author dzh
 * @date 2019-03-28 11:41
 */
public class Variant {

    private List<String> relation;
    private String idnTable;
    private List<VariantName> variantNames;

    public List<String> getRelation() {
        return relation;
    }

    public void setRelation(List<String> relation) {
        this.relation = relation;
    }

    public String getIdnTable() {
        return idnTable;
    }

    public void setIdnTable(String idnTable) {
        this.idnTable = idnTable;
    }

    public List<VariantName> getVariantNames() {
        return variantNames;
    }

    public void setVariantNames(List<VariantName> variantNames) {
        this.variantNames = variantNames;
    }
}
