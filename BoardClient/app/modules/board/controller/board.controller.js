angular.module("board").controller("boardCtrl", function($scope, init, $location, $cookies, sharedBoardCtrl, ajaxServices, NgTableParams) {
	$scope.data = init;
	this.tableParams = new NgTableParams({filter: {name: "T"}}, {dataset: $scope.data});
	$scope.json = init;

	$scope.logout = function() {
		$cookies.remove("access_token");
		$location.path("/login");
	}

	$scope.addNew = function() {
		$location.path("/addNew");
	}

	$scope.edit = function() {
		$scope.isEditing = true;
		$scope.isCancellable = true;
	}

	$scope.editEntry = function(person) {
		sharedBoardCtrl.setPerson(person);
		$location.path("/edit");
	}

	$scope.remove = function() {
		$scope.isDeleting = true;
		$scope.isCancellable = true;
	}

	$scope.removeEntry = function(id) {
		ajaxServices("/remove").delete({params: id}, function(data) {
			if (data.status != 500 && data.text == "Removed") {
				$scope.boardError = false;
				$scope.refresh();
			} else {
				$scope.boardError = true;
				$scope.boardErrorText = data.message;
			}
		})
	}

	$scope.cancel = function() {
		$scope.isCancellable = false;
		$scope.isEditing = false;
		$scope.isDeleting = false;
	}

	$scope.refresh = function() {
		ajaxServices("/board").get(function (data) {
			$scope.json = data;
			$scope.cancel();
		});
	}
});

angular.module("board").service("sharedBoardCtrl", function() {
	var person;

	return {
		getPerson: function() {
			return person;
		},

		setPerson: function(value) {
			person = value;
		}
	}
})