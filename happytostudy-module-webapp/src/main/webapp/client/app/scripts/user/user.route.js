(function() {
    'use strict';

    angular
        .module('app.user')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.user',
                config: {
                    url: '/user',
                    templateUrl: 'client/app/scripts/user/user.html',
                    controller: 'UserController',
                    controllerAs: 'vm',
                    title: 'User',
                    settings: {
                        nav: 2,
                        icon: 'fa fa-user',
                        name: 'User'
                    }
                }
            }
        ];
    }
})();
