'use strict';

(function () {
  angular.module('EnglishApp')
    .controller('EffortEnglishController', ['effortEnglishService',
      function (effortEnglishService) {
        var vm = this;

        vm.setUrl = setUrl;
        vm.closePdf = closePdf;
        vm.getLessonsFormId = getLessonsFormId;

        vm.effortEnglish = effortEnglishService.cache;

        function getSubjects() {
          //effortEnglishService.getSubjects()
          //  .then(function () {
          //    vm.effortEnglish.subjects = effortEnglishService.cache.subjects;
          //  }, function () {
          //    throw (Error('Error get subject from server'));
          //  });
        }

        function closePdf() {
          vm.effortEnglish.showPdf = true;
        }

        function getLessonsFormId() {
          for (var i = 0; i < vm.effortEnglish.subjects.length; i++) {
            if (vm.effortEnglish.subjects[i].id === vm.effortEnglish.idSubjectWasSelected) {
              vm.effortEnglish.subjectWasSelected = vm.effortEnglish.subjects[i];
              break;
            }
          }
        }

        function setUrl(lessonDetail) {
          if (lessonDetail.type === 'mp3') {
            vm.effortEnglish.urlAudio = "http://localhost:8080/happyToStudy/main/lessons/getAudio?urlAudio=" + lessonDetail.url;
            vm.effortEnglish.showPdf = true;
          } else {
            if (lessonDetail.type === 'pdf') {
              vm.effortEnglish.showPdf = !vm.effortEnglish.showPdf;
              vm.effortEnglish.urlPdf = "http://localhost:8080/happyToStudy/main/lessons/getPdf?urlPdf=" + lessonDetail.url;
            }
          }
        }

        getSubjects();

      }])

})();
    