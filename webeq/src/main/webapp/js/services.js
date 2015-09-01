var raServices=angular.module('raServices',['ngResource']);
 
  
 
raServices.factory('UsersService', ['$resource',
 
 function($resource){
 
         
 
   return $resource('http://localhost:8080/webeq/service/:call', {}, {
 
     users: {method:'GET',params:{call:'users'},isArray:true},
 
        users:{method:'GET',params:{call:'users'},isArray:false}
 
   });
 
 }]);