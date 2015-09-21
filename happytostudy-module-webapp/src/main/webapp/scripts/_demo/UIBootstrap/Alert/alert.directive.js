(function () {
  'use strict';

  function AlertController ($scope) {
    $scope.alerts = [
      { type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
      { type: 'success', msg: 'Well done! You successfully read this important alert message.' }
    ];

    $scope.addAlert = function() {
      $scope.alerts.push({msg: 'Another alert!'});
    };

    $scope.closeAlert = function(index) {
      $scope.alerts.splice(index, 1);
    };
  }
  AlertController.$inject = ['$scope'];

  function AlertDirective () {
    return {
      scope: {

      },
      restrict: 'A',
      controller: AlertController,
      controllerAs: 'vm',
      templateUrl: 'scripts/_demo/UIBootstrap/Alert/alert.directive.html'
    };
  }

  AlertDirective.$inject = [];

  angular.module('UIBootstrapApp')
    .directive('myAlert', AlertDirective);

})();