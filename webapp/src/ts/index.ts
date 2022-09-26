import DeleteModal from "./deleteModal";
import BookInformationModal from "./bookInformationModal";

window.onload = function() {
    loadDeleteButtons()
    loadInformationButtons()

    function loadDeleteButtons() {
        let deleteModal = new DeleteModal()

        document.querySelectorAll<HTMLElement>('[data-button="obliviate"]').forEach(function (value) {
            deleteModal.addDeleteButton(value)
        });
    }

    function loadInformationButtons() {
        let informationModal = new BookInformationModal()
        document.querySelectorAll<HTMLElement>('[data-button="bookInformation"]').forEach(function (value) {
            informationModal.addInformationButton(value)
        });
    }
};