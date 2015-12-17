var app = angular.module('ClientApp', ['ngRoute', 'ngResource', 'Core', 'board', 'ngCookies'])
.config(['$locationProvider' ,'$httpProvider', function($locationProvider, $httpProvider) {
	$locationProvider.hashPrefix('!');

	/*$httpProvider.interceptors.push(['$rootScope', '$q', '$location', '$cookies', function($rootScope, $q, $location, $cookies) {
		return {
			request: function (config) {
			if ($cookies.get("access_token")) {
				$http.defaults.headers.common.Authorization = 'Basic ' + $cookies.get("access_token");
			}

			return config;

			}, response: function(response) {
				return response;
			}, responseError: function(response) {
				console.log(response);
				if(response.status == 401 || response.status == 403) {
					$location.path('/login');
				}

				return $q.reject(response);
			}
		};
	}]);*/
}]);

angular.element(document).ready(function() {
	angular.bootstrap(document, ['ClientApp']);
});

app.factory('Global', function() {
	return {
		base_url : 'http://localhost:8090/'
	}
})