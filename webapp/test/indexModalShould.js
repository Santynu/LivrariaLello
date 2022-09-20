test(`open and close when interacting with the opening and closing trigger`, () => {
    document.body.innerHTML = `<div id="modal-element"></div><div id="open-trigger"></div><div id="close-trigger"></div>`;
    const modalElement = document.getElementById("modal-element")
    const openTrigger = document.getElementById("open-trigger")
    const closeTrigger = document.getElementById("close-trigger")
    new Modal({
        pageData: pageData,
        element: modalElement,
        openTrigger: openTrigger,
        closeTrigger: closeTrigger
    });

    openTrigger.click();
    expect(modalElement.className).toContain("displayed");

    closeTrigger.click();
    expect(modalElement.className).not.toContain("displayed");
});