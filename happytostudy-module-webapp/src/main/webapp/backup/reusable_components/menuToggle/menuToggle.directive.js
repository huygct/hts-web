/**
 * Created by Huy Nghi on 7/23/2015.
 */

(function () {
  angular.module('htl.com.reusableComponents')
    .directive('menuToggle', menuToggle);

  function menuToggle() {
    return {
      restrict: 'EA',
      templateUrl: 'reusable_components/menuToggle/templates/menuToggle.html',
      scope: {
        menuToggleOptions: '='
      },
      link: linkFunc,
      controller: MenuToggleController,
      controllerAs: 'menuToggleCtrl',
      bindToController: true
    };

    function linkFunc() {

    }
  }

  MenuToggleController.$inject = [];

  function MenuToggleController() {
    var self = this;

    self.setExpand = setExpand;
    self.clickChildrenButton = clickChildrenButton;

    function clickChildrenButton(child) {
      self.selected = child.id;

      if (angular.isFunction(self.menuToggleOptions.externalScope.selectedOneItem)) {
        self.menuToggleOptions.externalScope.selectedOneItem(child);
      }
    }

    function setExpand(menu) {
      for (var i = 0; i < self.menuToggleOptions.menus.length; i++) {
        if (self.menuToggleOptions.menus[i].id !== menu.id) {
          self.menuToggleOptions.menus[i].showChildren = false;
        }
        else {
          menu.showChildren = !menu.showChildren;
          self.selected = menu.id;
        }
      }

    }
  }
})();