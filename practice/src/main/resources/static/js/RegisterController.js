var app = angular.module('app', []);
$scope.userDto = {};

app.controller('registerController', function($scope, $http, $location) {
	$scope.submitClick = function(){
		var url = "http://localhost:9090/Practice/user/register";
		
		$http.post(url, data, config).then(function (response) {
				
			}, function (response) {

			});
	}
});