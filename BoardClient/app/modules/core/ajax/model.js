'use strict';
angular.module('Ajax').factory('ajaxServices', function($http) {
  var base_url = 'http://localhost:8090/';

  return {
    get: function(action) {
      return $http.get(base_url + action).then(function(response) {
        return response.data;
      });
    },

    post: function(action, param) {
      return $http.post(base_url + action, param).then(function(response) {
        return response.data;
      });
    }
  };
});