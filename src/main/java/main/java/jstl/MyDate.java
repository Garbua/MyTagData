package main.java.jstl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyDate extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            out.print(dateFormat.format(today));
        } catch (IOException e) {
           throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
}
