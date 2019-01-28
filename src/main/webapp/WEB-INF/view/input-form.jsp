<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>



<div class="container">


	<br> <br>

	<div class="p1">Please provide a natural number consisted of a
		combination of 1 to 3 digit blocks, each block separated by space.
		Example given: 6 23 907
	</div>

	<br> <br>

	<form:form class="form-inline" method="POST" action="processForm"
		modelAttribute="userInput">
		<div class="form-group mx-sm-3 mb-2">
			<form:input class="form-control" path="input"
				placeholder="Insert number" />
		</div>
		<button type="submit" class="btn btn-primary mb-2">Check number</button>
	</form:form>

</div>

<%@include file="common/footer.jspf"%>