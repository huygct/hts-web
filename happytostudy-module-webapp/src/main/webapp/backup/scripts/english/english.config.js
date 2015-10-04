(function () {
  'use strict';
  angular
    .module('EnglishApp', [])

    .config(function ($routeProvider) {
      $routeProvider
        .when('/english', {
          templateUrl: 'scripts/english/english/templates/english.html'
          //controller: 'EnglishController',
          //controllerAs: 'vm'
        })
        .when('/english/:typeEnglish', {
          templateUrl: 'scripts/english/english/templates/english.html'
          //controller: 'EnglishRouterController',
          //controllerAs: 'vm'
        })
    });
})();
