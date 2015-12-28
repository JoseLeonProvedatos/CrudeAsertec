angular.module('login').controller('loginCtrl', function($rootScope, $scope, $http, ajaxServices, authServices, $cookies, $location, $window) {
	$scope.login = function() {
		authServices('/login').save({user:$scope.auth.user, password:$scope.auth.password}, function(data) {
			if (data.status != 500) {
				$cookies.put("access_token", data.token);
				$rootScope.authenticated = true;
				$location.path('/board');
			} else {
				$scope.loginError = true;
				$scope.loginErrorText = data.message;
				$rootScope.authenticated = false;

				if (data.message == "Incorrect password") {
					$scope.auth.password = "";
				}
			}
		});
	}

	$scope.enter = function($event) {
		if ($event.keyCode == 13) {
			$scope.login();
		}
	}

	$scope.next = function($event) {
		if ($event.keyCode == 13) {
			$window.document.getElementById('password').focus();
		}
	}
});