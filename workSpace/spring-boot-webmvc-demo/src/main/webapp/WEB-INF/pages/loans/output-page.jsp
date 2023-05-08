<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<jsp:include page="/header" />

	<div class="container-fluid p-4">
		<div class="col-sm-6 mx-auto">
			<h4>Loan Details</h4>

			<c:choose>
				<c:when test="${loan != null}">

					<table class="table table-bordered">
						<tr>
							<th>Principal</th>
							<td>${loan.principal}</td>
						</tr>
						<tr>
							<th>Rate Of Interest</th>
							<td>${loan.rateOfInterest}</td>
						</tr>
						<tr>
							<th>Time Period</th>
							<td>${loan.timePeriod}</td>
						</tr>
						<tr>
							<th>Simple Interest</th>
							<td>${loan.simpleInterest}</td>
						</tr>
						<tr>
							<th>Payable Amount</th>
							<td>${loan.totalDebtAmount}</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<p>This page is wrongly routed.</p>
				</c:otherwise>
			</c:choose>
		</div>

	</div>



	<jsp:include page="/footer" />