(function () {
    'use strict';

    angular
        .module('app.core')
        .run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        var otherwise = '/404';
        routerHelper.configureStates(getStates(), otherwise);
    }

    function getStates() {
        return [
            {
                state: 'app',
                config: {
                    abstract: true,
                    templateUrl: 'client/app/share_components/core/main.html',
                    resolve: {
                        env: env
                    },
                    controller: 'CoreController',
                    controllerAs: 'vm'
                }
            },
            {
                state: 'app.404',
                config: {
                    url: '/404',
                    templateUrl: 'client/app/share_components/core/404.html',
                    title: '404'
                }
            }
        ];
    }

    env.$inject = ['coreService'];
    function env (coreService) {
        return coreService.getEnv();
    }

})();
