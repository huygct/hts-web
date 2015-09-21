(function () {
  'use strict';

  effortEnglishDirective.$inject = [];

  function effortEnglishDirective () {
    return {
      scope: {

      },
      restrict: 'A',
      controller: 'EffortEnglishController',
      controllerAs: 'vm',
      templateUrl: 'scripts/english/effortEnglish/directives/effortEnglish.directive.html'
    }
  }

  angular.module('EnglishApp')
    .directive('effortEnglish', effortEnglishDirective);

})();