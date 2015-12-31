(function() {
    'use strict';

    angular
        .module('app.dashboard')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.dashboard',
                config: {
                    url: '/',
                    templateUrl: 'client/app/scripts/dashboard/dashboard.html',
                    controller: 'DashboardController',
                    controllerAs: 'vm',
                    title: 'dashboard',
                    settings: {
                        nav: 1,
                        icon: 'fa fa-dashboard',
                        name: 'Dashboard'
                        //children: [
                        //    {
                        //        url: '/admin2',
                        //        icon: 'fa fa-dashboard',
                        //        name: 'Dashboard 2'
                        //    },
                        //    {
                        //        url: '/admin3',
                        //        icon: 'fa fa-dashboard',
                        //        name: 'Dashboard 3'
                        //    }
                        //]
                        //content: '<i class="fa fa-dashboard"></i> Dashboard'
                    }
                }
            }
        ];
    }
})();
