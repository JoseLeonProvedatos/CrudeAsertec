var app = angular.module("ClientApp", ["ngRoute", "ngResource", "Core", "ngCookies", "board", "login", "ngTable"])
.config(["$locationProvider" ,"$httpProvider", function($locationProvider, $httpProvider) {
	$locationProvider.hashPrefix("!");

	$httpProvider.interceptors.push(["$rootScope", "$q", "$location", "$cookies", function($rootScope, $q, $location, $cookies) {
		return {
			request: function (config) {
				if ($cookies.get("access_token")) {
					config.headers.Authorization = "Bearer " + $cookies.get("access_token");
					$rootScope.authenticated = true;
				} else {
					$rootScope.authenticated = false;
				}

				return config;

			}, response: function(response) {
				return response;
			}, responseError: function(response) {
				if(response.status == 500 && response.data.message == "Unauthorized") {
					$location.path("/login");
				}

				if (response == null) {
					console.log("Unable to connect to server");
					return $q.reject(response);
				}

				return response;
			}
		};
	}]);
}]);

angular.element(document).ready(function() {
	angular.bootstrap(document, ["ClientApp"]);
});