"use strict";
angular.module("Ajax").factory("ajaxServices", function($http, $resource) {
  var base_url = "http://localhost:8090/api";

  return function(action) {
    return $resource(base_url + action + "/:params", {params:"@_params"});
  };
});