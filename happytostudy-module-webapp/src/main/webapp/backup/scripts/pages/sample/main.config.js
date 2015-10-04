/**
 * Created by Huy Nghi on 9/21/2015.
 */
(function () {
  angular.module('mainApp', [])
    .config(['$routeProvider', 'mainConstant',
      function ($routeProvider, mainConstant) {
        $routeProvider
          .when('', {
            templateUrl: mainConstant.templateUrl.main,
            controller: 'MainController',
            controllerAs: 'vm'
          })
          .otherwise({
            redirectTo: ''
          });
      }
    ]);
    
 })();   