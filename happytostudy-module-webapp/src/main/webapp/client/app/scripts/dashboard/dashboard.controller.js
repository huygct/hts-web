(function () {
    'use strict';

    angular
        .module('app.dashboard')
        .controller('DashboardController', DashboardController);

    DashboardController.$inject = ['$q', 'dataservice', 'logger', 'layoutService'];
    /* @ngInject */
    function DashboardController($q, dataservice, logger, layoutService) {
        var vm = this;
        vm.news = {
            title: 'hottowel',
            description: 'Hot Towel Angular is a SPA template for Angular developers.'
        };
        vm.messageCount = 0;
        vm.people = [];
        vm.title = 'Dashboard';

        var breadcrumb = [];
        layoutService.setBreadcrumb(breadcrumb);
        layoutService.page.titlePage = 'Dashboard';

        activate();

        function activate() {
            var promises = [getMessageCount(), getPeople()];
            return $q.all(promises).then(function () {
                logger.info('Activated Dashboard View');
            });
        }

        function getMessageCount() {
            return dataservice.getMessageCount().then(function (data) {
                vm.messageCount = data;
                return vm.messageCount;
            });
        }

        function getPeople() {
            return dataservice.getPeople().then(function (data) {
                vm.people = data;
                return vm.people;
            });
        }

        vm.smallBox = {
            value: 30,
            href: '#',
            name: 'New Order',
            logo: 'ion-bag',
            color: 'bg-red'
        };
    }
})();
