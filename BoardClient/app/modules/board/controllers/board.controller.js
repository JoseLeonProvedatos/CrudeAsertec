angular.module('ClientApp').controller('boardCtrl', function($scope, $http, init) {
	$scope.r_login = "login";
	$scope.json = init;
	console.log($scope.json, 'JSON: ');
});