(function() {
  'use strict';

  angular
    .module('app.adminDashboard')
    .run(appRun);

  appRun.$inject = ['routerHelper'];
  /* @ngInject */
  function appRun(routerHelper) {
    routerHelper.configureStates(getStates());
  }

  function getStates() {
    return [
      {
        state: 'adminDashboard',
        config: {
          url: '/adminDashboard',
          templateUrl: 'client/app/adminDashboard/adminDashboard.html',
          controller: 'AdminDashboardController',
          controllerAs: 'vm',
          title: 'adminDashboard',
          settings: {
            nav: 1,
            content: '<i class="fa fa-dashboard"></i> AdminDashboard'
          }
        }
      }
    ];
  }
})();
