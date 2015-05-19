package pl.edu.agh.siwpia.neo4j_web_app.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pl.edu.agh.siwpia.neo4j_web_app.neo4j.CreateSimpleGraph;



public class FileUploadHandler extends HttpServlet {
    //private  String UPLOAD_DIRECTORY = "/resources/images";
    private  String UPLOAD_DIRECTORY = "C:/uploads";
    //tymczasowo, do kiedy nie zostanie przygotowana tworzenie tymczasowej bazy dla zalogowanego uzytkownika
    private String DB_PATH = "C:/neo4j_database";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	      String group = "";
	      String nodeName = "";
	      String fileName = "";
    	  Path path1 = Paths.get(UPLOAD_DIRECTORY);
  	      
  	      if (!Files.exists(path1)) {
  	    	  File dir = new File(UPLOAD_DIRECTORY);
  	    	  dir.mkdir();
  	      }

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        fileName =  new File(item.getName()).getName();
                        String result;
                        CreateSimpleGraph driver = new CreateSimpleGraph();
                        driver.checkDatabaseIsRunning();
                        String query = "MATCH (Person { name:'"+ group + "' })-[r]-(a{ name: '"+ nodeName  +"'}) SET  Person.URL = '" + UPLOAD_DIRECTORY + "'  RETURN Person";
                        System.out.println("QUERY                 " + query);
                		  result=driver.sendTransactionalCypherQuery(query);
                        System.out.println("RESULT          " + result);
                        if (!result.contains("error")) {
                        	item.write( new File(UPLOAD_DIRECTORY + File.separator + nodeName + "_" + fileName));
                        	request.setAttribute("message", "File Uploaded Successfully");
                        } else {
                        	request.setAttribute("message", "File Upload Failed.There is no group or node in the database.");
                        }
                    } else {
                    	if (item.getFieldName().equals("group")) {
                    		group = item.getString();
                  	        UPLOAD_DIRECTORY += "/" + group; 
	                  	    Path path = Paths.get(UPLOAD_DIRECTORY);
	                	      
	                	      if (!Files.exists(path)) {
	                	    	  File dir = new File(UPLOAD_DIRECTORY);
	                	    	  dir.mkdir();
	                	      }
                    	} else {
                    		nodeName = item.getString();
                    		
                    	}
                    }
                }

        		
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        request.setAttribute("node",
        		nodeName);
        //request.setAttribute("image", imagePath);
        request.getRequestDispatcher("/uploaded").forward(request, response);

    }
    

}


