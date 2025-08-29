document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(this);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    fetch('/api/registration', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (response.ok) {
                alert('Registration successful!');
                // You can redirect the user to the login page here
                // window.location.href = '/login.html';
            } else {
                alert('Registration failed!');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('An error occurred during registration.');
        });
});