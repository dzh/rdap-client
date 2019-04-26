package rdap.client.data;

import java.util.List;

/**
 * <pre>
 *
 *     "secureDNS":
 *      {
 *        "delegationSigned": true,
 *        "dsData":
 *        [
 *          {
 *            "keyTag": 12345,
 *            "algorithm": 3,
 *            "digestType": 1,
 *            "digest": "49FD46E6C4B45C55D4AC"
 *          }
 *        ]
 *      },
 *
 * </pre>
 *
 * @author dzh
 * @date 2019-03-28 13:34
 */
public class SecureDNS {

    private boolean zoneSigned;
    private boolean delegationSigned;
    /**
     * an integer representing the signature lifetime in
     * seconds to be used when creating the RRSIG DS record in the
     * parent zone [RFC5910].
     */
    private Integer maxSigLife;
    private List<DsData> dsData;
    private List<KeyData> keyData;

    public boolean isZoneSigned() {
        return zoneSigned;
    }

    public void setZoneSigned(boolean zoneSigned) {
        this.zoneSigned = zoneSigned;
    }

    public boolean isDelegationSigned() {
        return delegationSigned;
    }

    public void setDelegationSigned(boolean delegationSigned) {
        this.delegationSigned = delegationSigned;
    }

    public Integer getMaxSigLife() {
        return maxSigLife;
    }

    public void setMaxSigLife(Integer maxSigLife) {
        this.maxSigLife = maxSigLife;
    }

    public List<DsData> getDsData() {
        return dsData;
    }

    public void setDsData(List<DsData> dsData) {
        this.dsData = dsData;
    }

    public List<KeyData> getKeyData() {
        return keyData;
    }

    public void setKeyData(List<KeyData> keyData) {
        this.keyData = keyData;
    }
}
