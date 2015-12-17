angular.module('ClientApp').controller('loginCtrl', function($scope, $resource, $http, $httpParamSerializer, $cookies, $location, Global) {
	console.log('loginCtrl');
	
	/*$scope.auth = {
		grant_type:"password",
		username: "",
		password: "",
		client_id: "clientIdPassword"
	};

	$scope.encoded = btoa("clientIdPassword:secret");

	$scope.login = function() {
		var req = {
            method: 'POST',
            url: Global.base_url + "spring-security-oauth-server/oauth/token",
            headers: {
                "Authorization": "Basic " + $scope.encoded,
                "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
            },
            data: {}// $httpParamSerializer($scope.auth)
        }

		$http(req).then(function(data) {
			console.log(data);
			$http.defaults.headers.common.Authorization= 'Bearer ' + data.auth.access_token;
			$cookies.put("access_token", data.auth.access_token);
			window.location.href="index";
		});
	}*/
});