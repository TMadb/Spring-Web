<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="<c:url value="/CourseServlet" />" method="get">
   <input type="text" name="cid" /><br />
   <input type="text" name="cname" /><br />
   <input type="submit" name="ok" />
  </form>
</body>
</html>