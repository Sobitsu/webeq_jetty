Var restAngular = angular.module('restAngular',['ngRoute','raControllers','raServices']);
 
  
 
restAngular.config(['$routeProvider',
 
 function($routeProvider) {
 
   $routeProvider.
 
     when('/userall', {
 
       templateUrl: 'users-list.html',
 
       controller: 'UsersListController'
 
     }).
 
        when('/users/:id', {
 
       templateUrl: 'users-details.html',
 
       controller: 'UsersDetailsController'
 
     }).
 
     otherwise({
 
       redirectTo: '/users'
 
     });
 
 }]);