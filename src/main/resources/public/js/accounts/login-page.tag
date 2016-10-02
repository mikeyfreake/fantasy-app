<login-page>
<div class="center-block" style="max-width: 330px;">
	<form class="form-signin" onsubmit="{ login }">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" name="username" id="inputEmail" class="form-control"
			placeholder="Email address" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required>
		<!-- 
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			 -->
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</div>

	<script>
	login() {
		console.log("Call to login method.");
		var params = {username: this.inputEmail.value, password: this.inputPassword.value};
		$.post('/login', params, function(json) {
		    console.log("JSON response received:\n" + json);
		    $('#authenticated-menu').removeClass('hidden');
		    $('#unauthenticated-menu').addClass('hidden');
		})
	}
	</script>
</login-page>