
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction Report</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f5f7fa;
        }

        h1 {
            color: #243447;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #243447;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 16px;
            background-color: #243447;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .empty-message {
            margin-top: 20px;
            color: #555;
        }
    </style>
</head>

<body>

    <h1>Transaction Report</h1>

    <c:choose>
        <c:when test="${empty transactions}">
            <p class="empty-message">No transactions found.</p>
        </c:when>

        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>Customer ID</th>
                        <th>Customer Name</th>
                        <th>Phone</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="transaction" items="${transactions}">
                        <tr>
                            <td>
                                <c:out value="${transaction.transactionId}"/>
                            </td>
                            <td>
                                <c:out value="${transaction.customerId}"/>
                            </td>
                            <td>
                                <c:out value="${transaction.customerName}"/>
                            </td>
                            <td>
                                <c:out value="${transaction.customerPhone}"/>
                            </td>
                            <td>
                                <c:out value="${transaction.transactionAmount}"/>
                            </td>
                            <td>
                                <c:out value="${transaction.transactionDate}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

    <a class="button"
       href="${pageContext.request.contextPath}/transaction">
        Back to Transaction Form
    </a>

</body>
</html>
