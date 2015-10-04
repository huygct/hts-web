/**
 * Created by Huy Nghi on 9/21/2015.
 */
(function () {

  mainDirective.$inject = ['mainConstant'];
  function mainDirective (mainConstant) {
    return {
      scope: {

      },
      restrict: 'A',
      controller: 'MainController',
      controllerAs: 'vm',
      templateUrl: mainConstant.templateUrl.mainDirective
    }
  }

  angular.module('mainApp')
    .directive('mainApp', mainDirective)

 })();