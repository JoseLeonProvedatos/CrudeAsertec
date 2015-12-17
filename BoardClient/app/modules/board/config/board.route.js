angular.module('board').config(['$routeProvider', function ($routeProvider) {
  $routeProvider.when('/api/board', {
    templateUrl: 'app/modules/board/view/home.html',
    controller: 'boardCtrl',
    resolve: {
      init: function(ajaxServices) {
        return ajaxServices.get('api/board').then(function(data) {
          return data;
        });
      }
    }
  }).when('/login', {
    templateUrl: 'app/modules/board/view/login.html',
    controller: 'loginCtrl'
  }).otherwise({
    redirectTo: '/'
  });
}]);