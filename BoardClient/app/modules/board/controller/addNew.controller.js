angular.module('board').controller('addNewCtrl', function($scope, $location, ajaxServices) {
	$scope.formTitle = "Add new entry";
	$scope.actionText = "Add";

	$scope.add = function() {
		ajaxServices("/addNew").save($scope.person, function(data) {
			if (data.status != 500 && data.text == "Saved") {
				$scope.addError = false;
				$location.path("/board");
			} else {
				$scope.addErrorText = data.message;
				$scope.addError = true;
			}
		});
	}

	$scope.cancel = function() {
		$location.path("/board");
	}
});