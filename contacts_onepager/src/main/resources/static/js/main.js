document.addEventListener("DOMContentLoaded", function () {
    const contactTemplateDom = document.querySelector("#contact-template");
    const wrapperDom = document.querySelector("#wrapper");
    const formDom = document.querySelector("#contact-form");

    const renderer = new ContactRenderer(contactTemplateDom, wrapperDom, formDom);
    const client = new ContactClient();
    const contactService = new ContactService(client, renderer);

    const contactWrapperListener = new ContactWrapperListener(contactService);
    const contactFormClickListener = new ContactFormClickListener(contactService);
    //console.log(("content loaded"));

    formDom.addEventListener("click", contactFormClickListener);
    wrapperDom.addEventListener("click", contactWrapperListener);
    wrapperDom.addEventListener("toggle", contactWrapperListener);


});

const HOST = "http://localhost:8080/api/contacts";


class ContactWrapperListener {

    constructor(contactService) {
        this.contactService = contactService;

    }

    handleEvent(event) {
        event.preventDefault();
        const a = event.target.closest("a");

        if (a) {
            this[a.dataset.action](event);
        }
    }

    //TODO clicking on the contact the user should see the details of the contact, add html code with the details into
    // contact template (hidden part)
    toggleDetails(event) {
        console.log("before toggling")
        this.contactService.toggleUserDetails(event);
        console.log("after toggling")

    }

    edit(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactService.startEdit(contactDom.contact);
    }

    delete(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactService.delete(contactDom.contact);

    }
}

//like controller in Java web app
class ContactFormClickListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        event.preventDefault();
        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action](event);
        }
    }


    add(event) {
        const form = event.currentTarget;
        const contact = {
            name: form.elements.name.value,
            lastName: form.elements.lastName.value,
            age: form.elements.age.value,
        }
        this.contactService.add(contact);

    }

    edit(event) {
        const form = event.currentTarget;
        const contact = {
            id: form.elements.id.value,
            name: form.elements.name.value,
            lastName: form.elements.lastName.value,
            age: form.elements.age.value,
        }
        this.contactService.completeEdit(contact);

    }

    cancel(event) {
        this.contactService.cancelEdit();
    }

}

//only for requesting the server
class ContactService {
    constructor(client, renderer) {
        this.client = client;
        this.renderer = renderer;
        this.loadAll();
    }

    async loadAll() {
        const response = await this.client.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.renderer.renderContacts(contacts);
        }
    }

    async add(contact) {
        const response = await this.client.add(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.clearForm();
            this.loadAll();
        }
    }

    async delete(contact) {
        const response = await this.client.removeById(contact.id);
        if (response.ok) {
            this.renderer.clearAll();
            this.loadAll();
        }
    }

    startEdit(contact) {
        this.renderer.toEditForm(contact);
    }

    toggleUserDetails() {
        this.renderer.toShowDetails();
    }

    async completeEdit(contact) {
        const response = await this.client.edit(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.toAddForm();
            this.loadAll();
        }
    }

    cancelEdit() {
        this.renderer.toAddForm();
    }
}

//to render DOM tree
class ContactRenderer {
    constructor(contactTemplateDom, wrapperDom,
                formDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.wrapperDom = wrapperDom;
        this.formDom = formDom;

        this.addButtonDom = this.formDom.querySelector("button[data-action='add']")
        this.editButtonDom = this.formDom.querySelector("button[data-action='edit']")
        this.cancelButtonDom = this.formDom.querySelector("button[data-action='cancel']")

    }

    renderContact(contact) {
        const contactDom = this.contactTemplateDom.cloneNode(true);
        contactDom.contact = contact;
        contactDom.hidden = false;

        contactDom.removeAttribute("id");
        const contactDetailsLink = contactDom.querySelector("a");
        contactDetailsLink.innerHTML = `${contact.name} ${contact.lastName}`;

        contactDom.querySelector('span[data-id="name"]').innerHTML = contact.name;
        contactDom.querySelector('span[data-id="lastName"]').innerHTML = contact.lastName;
        contactDom.querySelector('span[data-id="age"]').innerHTML = contact.age;
        const userDetailsDom = this.contactTemplateDom.querySelector("#user-details");
        userDetailsDom.querySelector('span[data-id="name"]').innerHTML = contact.name;
        userDetailsDom.querySelector('span[data-id="lastName"]').innerHTML = contact.lastName;

        this.wrapperDom.append(contactDom);
    }

    renderContacts(contacts) {
        for (let contact of contacts) {
            this.renderContact(contact);
        }
    }

    clearAll() {
        this.wrapperDom.innerHTML = "";

    }

    clearForm() {
        this.formDom.elements.id.value = "";
        this.formDom.elements.name.value = "";
        this.formDom.elements.lastName.value = "";
        this.formDom.elements.age.value = "";

    }

    toShowDetails() {
        const userDetailsDom = this.contactTemplateDom.querySelector("#user-details");
        userDetailsDom.classList.toggle("hide");
    }


    toEditForm(contact) {
        this.clearForm();
        this.addButtonDom.hidden = true;
        this.editButtonDom.hidden = false;
        this.cancelButtonDom.hidden = false;

        this.formDom.elements.id.value = contact.id;
        this.formDom.elements.name.value = contact.name;
        this.formDom.elements.lastName.value = contact.lastName;
        this.formDom.elements.age.value = contact.age;

    }

    toAddForm() {
        this.clearForm();
        this.addButtonDom.hidden = false;
        this.editButtonDom.hidden = true;
        this.cancelButtonDom.hidden = true;

    }
}

class ContactClient {
    getAll() {
        return fetch(HOST);

    };

    get(id) {
    };

    edit(contact) {
        return fetch(HOST, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    };

//fetch - for interacting with internet servers,  JSON to String to send data
    add(contact) {
        return fetch(HOST, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    };

    removeById(id) {
        return fetch(`${HOST}/${id}`, {
            method: 'DELETE'
        });
    };
}