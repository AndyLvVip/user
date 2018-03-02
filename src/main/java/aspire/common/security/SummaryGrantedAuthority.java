package aspire.common.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/24
 * @Description:
 */
public class SummaryGrantedAuthority implements GrantedAuthority {

    public List<String> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<String> authorityList) {
        this.authorityList = authorityList;
    }

    private List<String> authorityList = new ArrayList<>();

    @Override
    public String getAuthority() {
        return null;
    }
}
