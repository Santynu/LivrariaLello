import DeleteModal from "./deleteModal";

window.onload = function() {
    loadDeleteButtons()

    function loadDeleteButtons() {
        let deleteModal = new DeleteModal();

        document.querySelectorAll<HTMLElement>('[data-button="obliviate"]').forEach(function (value) {
            deleteModal.addDeleteButton(value)
        });
    }
};