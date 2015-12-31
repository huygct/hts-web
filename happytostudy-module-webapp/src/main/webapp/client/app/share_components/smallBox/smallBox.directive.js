angular
    .module('app.directive')
    .directive('smallBox', smallBoxDirective);

function smallBoxDirective() {
    return  {
        restrict: 'EA',
        templateUrl: 'client/app/share_components/smallBox/smallBox.html',
        scope: {
            value: '=?',
            href: '=?',
            name: '=?',
            logo: '=?',
            color: '=?'
        },
        controller: SmallBoxController,
        controllerAs: 'vm',
        bindToController: true
    };
}

SmallBoxController.$inject = [];

function SmallBoxController() {
    var vm = this;

}
