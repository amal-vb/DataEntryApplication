
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Transaction Management</title>
    <c:if test="${param.success == '1'}">
    <p style="color: green;">
        Transaction saved successfully!
    </p>
</c:if>
</head>
<body>

    <h1>Customer Transaction Management</h1>

    <form action="${pageContext.request.contextPath}/saveTransaction"
          method="post">

        <label for="customerId">Select Customer:</label>

        <select id="customerId" name="customerId" required>
            <option value="">-- Select Customer --</option>

            <c:forEach var="customer" items="${customers}">
                <option value="${customer.customerId}">
                    <c:out value="${customer.customerName}"/>
                </option>
            </c:forEach>
        </select>

        <br><br>

        <label for="amount">Transaction Amount:</label>
        <input type="number" id="amount" name="amount"
               min="0.01" step="0.01" required>

        <br><br>

        <label for="date">Transaction Date:</label>
        <input type="date" id="date" name="transactionDate"
               required>

        <br><br>

        <button type="submit">Save</button>
        <button type="reset">Clear</button>

    </form>
    <br><br>

	<a href="${pageContext.request.contextPath}/report">
	    View Transactions
	</a>

</body>
</html>
