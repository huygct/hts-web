(function () {
  'use strict';
  angular
    .module('UIBootstrapApp', [])

    .config(function ($routeProvider) {
      $routeProvider
        .when('/uibootstrap', {
          templateUrl: 'scripts/_demo/UIBootstrap/templates/uiBootstrap.html',
          controller: 'UIBootstrapController',
          controllerAs: 'vm'
        })
        .when('/uibootstrap/:uiBootstrap', {
          templateUrl: 'scripts/_demo/UIBootstrap/urlRouter.html',
          controller: 'UIBootstrapRouterController',
          controllerAs: 'vm'
        })
    });
})();
