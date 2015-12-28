angular.module("board").config(["$routeProvider", function ($routeProvider) {
	$routeProvider.when("/board", {
		templateUrl: "app/modules/board/view/board.html",
		controller: "boardCtrl",
		resolve: {
			init: function(ajaxServices) {
				return ajaxServices("/board").get(function(data) {
					return data;
				});
			}
		}
	}).when("/addNew", {
		templateUrl: "app/modules/board/view/addNew.html",
		controller: "addNewCtrl"
	}).when("/edit", {
		templateUrl: "app/modules/board/view/addNew.html",
		controller: "editCtrl"
	}).otherwise({
		redirectTo: "/"
	});
}]);