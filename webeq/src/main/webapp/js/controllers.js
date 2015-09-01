var raControllers = angular.module('raControllers', []);
 
  
 
raControllers.controller('UsersListController', ['$scope','UsersService',function($scope,UsersService)
 
{
 
       $scope.users=UsersService.users();
 
        
 
}]);
 
  
 
raControllers.controller('UsersDetailsController', ['$scope', '$routeParams','UsersService',
 
 function($scope, $routeParams,UsersService) {
 
   $scope.users = UsersService.users({id: $routeParams.id});
 
 }]);