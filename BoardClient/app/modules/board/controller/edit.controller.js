angular.module("board").controller("editCtrl", function($scope, $location, sharedBoardCtrl, ajaxServices) {
	$scope.formTitle = "Edit the entry";
	$scope.actionText = "Update";
	var per = sharedBoardCtrl.getPerson();

	$scope.person = {};
	$scope.person.id = per.id;
	$scope.person.ci = per.ci;
	$scope.person.name = per.name;
	$scope.person.lastname = per.lastname;
	$scope.person.gender = per.gender;
	$scope.person.phone = per.phone;

	$scope.add = function() {
		ajaxServices("/edit").save($scope.person, function(data) {
			if (data.status != 500 && data.text == "Updated") {
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