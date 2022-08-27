<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Management</title>
    </head>
    <body>
    	<div align="left">
	        <h1>Book List</h1>
	        <h3><a href="newBook">New Book</a></h3>
	        <table border="1">
	        	<th>Id</th>
	        	<th>Book Title</th>
	        	<th>Author</th>
	        	
				<c:forEach var="book" items="${bookList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${book.title}</td>
					<td>${book.author_name}</td>

					<td>
						<a href="editBook?id=${book.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteBook?id=${book.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
