package rdap.client.data;

import java.util.List;

/**
 * Some non-answer responses may return entity bodies with information
 * that could be more descriptive.
 *
 * @author dzh
 * @date 2019-03-29 10:16
 */
public class Error extends CommonData {

    private Integer errorCode;
    private String title;
    private List<String> description;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
