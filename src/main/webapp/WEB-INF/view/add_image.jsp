<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Image</title>
</head>
<body>

  <div>
            <h3>Add image to node </h3>
            <form action="upload" method="post" enctype="multipart/form-data">
               <label>User<input type="text" name="group"/>
               </label><br/>
               <label>Node's Name<input type="text" name="node"/>
               </label><br/>
                <input type="file" name="file" accept ="image/jpeg" />
                <br/>
                <input type="submit" value="upload" />
            </form>          
        </div>


</body>
</html>