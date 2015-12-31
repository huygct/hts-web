(function () {
    'use strict';

    angular
        .module('app.user')
        .controller('UserController', UserController);

    UserController.$inject = ['logger', 'layoutService'];
    /* @ngInject */
    function UserController(logger, layoutService) {
        var vm = this;
        vm.title = 'User';

        activate();

        function activate() {
            logger.info('Activated User View');
        }

        var breadcrumb = [
            {'name': 'Home', url: '/'},
            {'name': 'User', url: '/user'}
        ];

        layoutService.setBreadcrumb(breadcrumb);
        layoutService.page.titlePage = 'User';
    }
})();
