var app = angular.module('app', []);

app.controller('registerController', function($scope, $http, $location) {
	$scope.submitClick = function(){
	   var url = $location.absUrl() + "getallcustomer";
	    
	   $http.get(url).then(function (response) {
	     $scope.response = response.data
	   }, function error(response) {
	     $scope.postResultMessage = "Error with status: " +  response.statusText;
	   });
	}
});