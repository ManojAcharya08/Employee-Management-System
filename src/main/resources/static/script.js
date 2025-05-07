window.onload = function () {
    fetch('/api/employees')  // Make sure the endpoint matches the correct URL
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#employeeTable tbody');
            data.forEach(emp => {
                // Assuming the employee object has a nested department object with a name property
                let row = `<tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.department ? emp.department.name : 'N/A'}</td>  <!-- Display department name -->
                    <td>${emp.email}</td>
                </tr>`;
                tableBody.innerHTML += row;  // Add the row to the table body
            });
        })
        .catch(error => console.error('Error fetching employees:', error));
};
