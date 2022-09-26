import fetch from 'node-fetch';

export default class BookInformationModal {

    private modal: HTMLElement

    constructor() {
        this.setupEventListeners();
    }

    private setupEventListeners() {
        this.modal = document.getElementById("informationBookModal")
        let span = document.getElementsByClassName("closeInformationModal")[0]

        span.addEventListener("click", () => this.closeModal())

        window.onclick = function(event) {
            if (event.target == this.modal) {
                this.modal.style.display = "none";
            }
        }

    }

    addInformationButton(element: HTMLElement) {
        element.addEventListener("click", () => this.openModal(element.dataset.id))
    }

    private async getInfoBook() {
        let isbn = document.getElementById("isbn13")
        const response = await fetch('/' + isbn.dataset.id)
        const json = await response.json();

        if(response.status == 200) {
            document.getElementById("isbn13Info").innerHTML = json["isbn13"]
            document.getElementById("isbn10Info").innerHTML = json["isbn10"]
            document.getElementById("titleInfo").innerHTML = json["title"]
            document.getElementById("authorInfo").innerHTML = json["author"]
            document.getElementById("authorIdInfo").innerHTML = json["authorId"]
            document.getElementById("publishingHouseInfo").innerHTML = json["publishingHouse"]
            document.getElementById("publishingHouseIdInfo").innerHTML = json["publishingHouseId"]
        } else {
            alert("Error consulting the book")
        }
    }

    private openModal(id: string) {
        document.getElementById("isbn13").dataset.id = id
        this.getInfoBook()
        this.modal.style.display = "block"
    }


    private closeModal(){
        document.getElementById("isbn13").dataset.id = ""
        this.modal.style.display = "none"
    }
}