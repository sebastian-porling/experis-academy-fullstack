window.addEventListener("load", () => {
    /* Initialize the HTML objects needed for getting name, greeting and forms */
    let greeting;
    const form = document.getElementById("greetingForm");
    const nameTextBox = document.getElementById("nameTextBox");
    const reversedForm = document.getElementById("reverseGreetingForm");
    const greetingText = document.getElementById("greetingText");

    /* Event listeners for the forms */
    form.addEventListener( "submit", (event) => {
        event.preventDefault();
        getGreeting();
    });
    reversedForm.addEventListener( "submit", (event) => {
        event.preventDefault();
        reverseGreeting();
    });

    /* Gets the name from the Rest API by sending the name,
    * then reveals the greeting and reverse form */
    function getGreeting() {
        let name = nameTextBox.value;
        $.getJSON("http://localhost:8080/api/greeting?name="+name, (data, status) => {
            setGreeting(data.content);
            reversedForm.hidden = false;
        }).fail((err) => console.log("Couldn't get greeting... ", err));
    }
    /* Reverses the greeting in with the rest API */
    function reverseGreeting() {
        $.getJSON("http://localhost:8080/api/reverseGreeting?greeting="+greeting, (data) => {
            setGreeting(data.content);
        }).fail((err) => console.log("Couldn't get reversed greeting... ", err));
    }

    /* Helper function that sets the greeting and reveals it */
    function setGreeting(content) {
        greeting = content;
        greetingText.innerText = content;
        greetingText.hidden = false;
    }
});