/**
 * Created by Huy Nghi on 9/21/2015.
 */
(function () {
  angular.module('mainApp', [])
    .config(['$routeProvider', 'mainConstant', '$mdIconProvider',
      function ($routeProvider, mainConstant, $mdIconProvider) {
        $routeProvider
          .when('/home', {
            templateUrl: mainConstant.templateUrl.main
          })
          .otherwise({
            redirectTo: ''
          });

        $mdIconProvider.iconSet("avatar", 'icons/avatar-icons.svg', 128);
      }
    ]);
    
 })();   