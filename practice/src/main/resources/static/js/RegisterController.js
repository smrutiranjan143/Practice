var app = angular.module('app', []);

app.controller('registerController', function($scope, $http, $location) {
	$scope.submitClick = function(){
	   var url = $location.absUrl() + "register";
	    
	   $http.get(url).success(function (data) {
	     $scope.Data = data;
	   }).
	   error(function(data)) {
	     $scope.postResultMessage = "Error with status: " +  response.statusText;
	   });
	}
});