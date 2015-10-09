/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.io.File;
import java.util.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
/**
 *
 * @author willian
 */
public class UploadBean
{
    private DiskFileItemFactory fileUpload = new DiskFileItemFactory();
    private ServletFileUpload sfu = new ServletFileUpload( fileUpload );
    
    private String diretorio;
    private String filename;
    
    public void setDiretorio( String diretorio )
    {
        this.diretorio = diretorio;
    }
    
    public String getDiretorio()
    {
        return diretorio;
    }
    
    public void setFileName( String filename )
    {
        this.filename = filename;
    }
    
    public String getFilename()
    {
        return this.filename;
    }
    
    public boolean doFilePost( HttpServletRequest request, ServletContext context )
    {
        if ( request.getContentType() == null )
            return false;
        
        if ( !request.getContentType().startsWith( "multipart/formdata" ) )
            return false;
        
        String path = context.getRealPath( getDiretorio() );
        
        try
        {
            List list = sfu.parseRequest( request );
            Iterator iterator = list.iterator();
            
            while( iterator.hasNext() )
            {
                FileItem item = (FileItem) iterator.next();
                
                if ( !item.isFormField() )
                {
                    filename = item.getName();
                    
                    if ( (filename != null) && (!filename.equals("")) )
                    {
                        filename = (new File(filename)).getName();
                        item.write( new File( path + File.separator + filename ) );
                    }
                }
            }
        }
        
        catch( FileUploadException e )
        {
            e.printStackTrace();
        }
        
        catch( Exception e )
        {  
            e.printStackTrace();
        }
        
        return true;
    }
}
