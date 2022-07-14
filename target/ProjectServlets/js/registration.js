function handleFormSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const userObj = {};
    formData.forEach((value, key) => (userObj[key] = value));
    console.log(userObj);

    const sendData = async (data) => {
        const result = await fetch('register', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        console.log(result);
        if (result.status === 200) {
            window.location.href = result.url;
        }
        if (result.status === 409) {
            document.querySelector('#errorMessage').innerText = 'User with email ' + data.email + ' already exists ';
        }
    }
    sendData(userObj);

}
