/**
 * Created by Huy Nghi on 9/20/2015.
 */

(function () {

  headerAppDirective.$inject = ['headerConstant'];

  function headerAppDirective(headerConstant) {
    return {
      scope: {

      },
      restrict: 'A',
      controller: 'HeaderDirectiveController',
      controllerAs: 'vm',
      //bindToController: true,
      templateUrl: headerConstant.templateUrl.headerDirective
    }
  }

  angular.module('headerApp')
    .directive('headerApp', headerAppDirective)

 })();   


