document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(this);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (response.ok) {
                alert('Login successful!');
                // You can redirect the user to another page here
                // window.location.href = '/dashboard';
            } else {
                alert('Login failed!');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('An error occurred during login.');
        });
});