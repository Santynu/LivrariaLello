import fetch from 'node-fetch';

export default class DeleteModal {

    private modal: HTMLElement

    constructor() {
        this.setupEventListeners();
    }

    private setupEventListeners() {
        this.modal = document.getElementById("deleteModal")
        let noButton = document.getElementById("noButton")
        let yesButton = document.getElementById("yesButton")

        let span = document.getElementsByClassName("close")[0]


        span.addEventListener("click", () => this.closeModal())
        yesButton.addEventListener('click', () => this.deleteBook())
        noButton.addEventListener("click", () => this.closeModal())

        window.onclick = function(event) {
            if (event.target == this.modal) {
                this.modal.style.display = "none";
            }
        }

    }

    addDeleteButton(element: HTMLElement) {
        element.addEventListener("click", () => this.openModal(element.dataset.id))
    }

    private openModal(id: string) {
        document.getElementById("id-box").dataset.id = id
        this.modal.style.display = "block"
    }

    private async deleteBook () {
        let idBox = document.getElementById("id-box")
        const response = await fetch('/delete/' + idBox.dataset.id);

        if(response.status == 200) {
            alert("Successfully deleted book")
        } else {
            alert("Error deleting book")
        }

        location.reload()
    }

    private closeModal(){
        document.getElementById("id-box").dataset.id = ""
        this.modal.style.display = "none"
    }
}