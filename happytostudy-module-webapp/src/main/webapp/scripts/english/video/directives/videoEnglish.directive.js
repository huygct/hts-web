(function () {
  'use strict';


  videoController.$inject = ['mainService'];
  function videoController (mainService) {
    var vm = this;

  }

  videoEnglishDirective.$inject = [];
  function videoEnglishDirective () {
    return {
      scope: {

      },
      restrict: 'A',
      controller: videoController,
      controllerAs: 'vm',
      templateUrl: 'scripts/english/video/directives/video.directive.html'
    }
  }

  angular.module('EnglishApp')
    .directive ('videoEnglish', videoEnglishDirective)

})();