package main.java.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateAtr extends BodyTagSupport {
    private int n;

    public void setN(int p) {
        this.n = p;
    }

    public int getN() {
        return n;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            if (n>=0){
                for (int i =1; i <= n; i++){
                    out.println(dateFormat.format(today));
                    out.print("<br/>");
                }
            }

        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return EVAL_BODY_INCLUDE;


}



    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
