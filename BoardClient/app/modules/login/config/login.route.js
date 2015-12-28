angular.module('login').config(['$routeProvider', function ($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl: 'app/modules/login/view/login.html',
		controller: 'loginCtrl'
	}).otherwise({
		redirectTo: '/'
	});
}]);