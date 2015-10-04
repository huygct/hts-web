(function () {
  'use strict';

  englishDirective.$inject = [];

  function englishDirective () {
    return {
      scope: {

      },
      restrict: 'A',
      controller: 'EnglishController',
      controllerAs: 'vm',
      templateUrl: 'scripts/english/english/directives/english.directive.html'
    }
  }

  angular.module('EnglishApp')
    .directive('english', englishDirective);

})();