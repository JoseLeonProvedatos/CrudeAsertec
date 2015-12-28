"use strict";
angular.module("Auth").factory("authServices", function($http, $resource) {
  var base_url = "http://localhost:8090/user";

  return function(action) {
    return $resource(base_url + action + "/:params", {params:"@_params"});
  };
});