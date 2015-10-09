
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willian
 */
public class TagLib
        extends TagSupport
{

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            pageContext.getOut().print("Desenvolvendo com tagLib");
        } 
        
        catch (IOException ioe)
        {
            throw new JspTagException("Erro: IOException");
        }

        return SKIP_BODY;
    }
}
