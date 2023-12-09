const express = require("express");
const app = express();
const port = 3000; // Use the port of your choice

// Add your database connection setup here

app.use(express.static("public")); // Assuming your HTML file is in a 'public' folder

app.get("/search", (req, res) => {
    // Get values from the request query
    const departure = req.query.departure;
    const arrival = req.query.arrival;

    // Perform the database query (replace with your database query logic)
    // Assuming you have a 'flights' collection/table
    const results =
        /* perform your database query here */

        // Send the results back to the client
        res.send(formatResults(results));
});

function formatResults(results) {
    // Format the results as needed for display on the client side
    // Modify this based on your database schema
    return `<h2>Search Results:</h2>
            <ul>${results
                .map(
                    (result) =>
                        `<li>Flight ID: ${result.flightid}, Departure: ${result.departure}, Arrival: ${result.arrival}</li>`
                )
                .join("")}</ul>`;
}

app.listen(port, () => {
    console.log(`Server is listening at http://localhost:${port}`);
});
// Function to search for flights
function searchFlights() {
    // Get user input
    const destination = document.getElementById("search").value;

    // Perform a basic search (you may need to customize this based on your SQL file structure)
    const searchResults = flightsData.filter((flight) =>
        flight.destination.toLowerCase().includes(destination.toLowerCase())
    );

    // Display search results
    displaySearchResults(searchResults);
}
// Function to display search results
function displaySearchResults(results) {
    const resultsContainer = document.getElementById("searchResults");
    resultsContainer.innerHTML = "";

    if (results.length === 0) {
        resultsContainer.innerHTML = "<p>No flights found.</p>";
    } else {
        results.forEach((result) => {
            const flightInfo = document.createElement("div");
            flightInfo.innerHTML = `<p>${result.flightNumber} - ${result.destination} - ${result.departureTime}</p>`;
            resultsContainer.appendChild(flightInfo);
        });
    }
}
