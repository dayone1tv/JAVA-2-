package tag;

import entity.Ad;
import entity.AdList;
import entity.User;
import helper.AdListHelper;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class DeleteAd extends SimpleTagSupport {

    private Ad ad;

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void doTag() throws JspException, IOException {
        String errorMessage = null;

        AdList adList = (AdList)
                getJspContext().getAttribute("ads", PageContext.APPLICATION_SCOPE);

        User currentUser = (User) getJspContext().getAttribute("authUser",
                PageContext.SESSION_SCOPE);

        if (currentUser == null || (ad.getId() > 0 &&
                ad.getAuthorId() != currentUser.getId())) {
            errorMessage = "�� ��������� �������� ���������, � �������� �� ��������� ������� �������!";
        }

        if (errorMessage == null) {
            adList.deletedAd(ad);
            AdListHelper.saveAdList(adList);
        }
        getJspContext().setAttribute("errorMessage", errorMessage, PageContext.SESSION_SCOPE);
    }
}