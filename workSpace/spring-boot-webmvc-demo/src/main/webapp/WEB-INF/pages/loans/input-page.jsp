<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<jsp:include page="/header" />

	<div class="container-fluid p-4">
		<div class="col-sm-6 mx-auto">
			<h4>Loan Input Page</h4>

			<form:form modelAttribute="loan" method="POST">
				<div>
					<label>Principal</label>
					<form:input type="decimal" path="principal" class="form-control"/>
				</div>
				<div>
					<label>Rate Of Interest</label>
					<form:input type="decimal" path="rateOfInterest" class="form-control"/>
				</div>
				<div>
					<label>Time Period In Years</label>
					<form:input type="decimal" path="timePeriod" class="form-control"/>
				</div>
				<div class="d-grid mt-2">
					<button class="btn btn-primary">COMPUTE</button>
				</div>

			</form:form>

		</div>

	</div>



	<jsp:include page="/footer" />