var SINGLE_SEARCH_API_URL = 'http://api.fixer.io/latest';
var MULTI_SEARCH_API_URL = 'http://api.fixer.io/latest';
var GET_TARGET_AMOUNT_API_URL = 'http://api.fixer.io/latest';

var app = angular.module('currencyApp', []);
app.controller('currencyCtrl', function($scope,$http) {
	$scope.execSingleSearch = false;
	$scope.waitSingleSearch = false;
    $scope.currency = new Object();
    $scope.currencies = new Array();
    $scope.currencies[0] = new Object();
    $scope.currencies[0].code = 'AUD';
    $scope.currencies[0].description = 'Desc AUD';
    $scope.currencies[0].rate = 0;
    $scope.currencies[1] = new Object();
    $scope.currencies[1].code = 'CHF';
    $scope.currencies[1].description = 'Desc CHF';
    $scope.currencies[1].rate = 0;
    $scope.currencies[2] = new Object();
    $scope.currencies[2].code = 'USD';
    $scope.currencies[2].description = 'Desc USD';
    $scope.currencies[2].rate = 0;
    $scope.amount = new Object();
	$scope.amount.sourceCurrencyCode = 'AUD';
	$scope.amount.targetCurrencyCode = 'CHF';
	$scope.amount.sourceAmount = 100.10;
	$scope.amount.targetAmount = 200.20;
	
    $scope.singleSearch = function() {
        alert('singleSearch start');
		$scope.execSingleSearch = true;
		$scope.waitSingleSearch = true;
		var currencyCode = $scope.currencyCode;
		$http.get(SINGLE_SEARCH_API_URL,{params:{symbols:currencyCode}})
		.success(function(response) {
			alert('singleSearch stop');
			$scope.currency.code = currencyCode;
			$scope.currency.description = 'Desc ' + currencyCode;
			$scope.currency.rate = response.rates[currencyCode];
			$scope.waitSingleSearch = false;
		});		
	};
    $scope.multiSearch = function() {
        alert('multiSearch start');
		$scope.execMultiSearch = true;
		$scope.waitMultiSearch = true;
		$scope.waitMultiSearch = true;
		var currencyCodes = $scope.currencyCodes;
		$http.get(MULTI_SEARCH_API_URL,{params:{symbols:currencyCodes}})
		.success(function(response) {
			alert('multiSearch stop');
			$scope.waitMultiSearch = false;
		});		
    };
    $scope.getTargetAmount = function() {
        alert('getTargetAmount start');
		$scope.execGetTargetAmount = true;
		$scope.waitGetTargetAmount = true;
		var currencyCode = $scope.currencyCode;
		$http.get(GET_TARGET_AMOUNT_API_URL,{params:{symbols:currencyCode}})
		.success(function(response) {
			alert('getTargetAmount stop');
			$scope.waitGetTargetAmount = false;
		});		
    };
});
