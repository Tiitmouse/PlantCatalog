# Plant Catalog 🌿

A desktop application for managing a catalog of plants, built with C# and the .NET framework.

---

## 📸 Program Showcase

*(Application screenshots to be added here later)*

<!--Image to be added: Main application window*
*Image to be added: Viewing plant details*
*Image to be added: Adding or editing a plant*-->

---

## Features

This application allows users to perform full **CRUD** (Create, Read, Update, Delete) operations on a plant database.

* **View** a comprehensive list of all plants in the catalog.
* **Add** new plants with details like name, species, and care instructions.
* **Edit** the information for any existing plant.
* **Delete** plants from the catalog.

---

## Technology Stack

* **Backend API (`BiljkeAPI`):** C# with ASP.NET Core for building the REST API.
* **Desktop App (`BiljkeDesktop`):** C# with a .NET desktop framework (like WPF or Windows Forms).
* **Shared Library (`BiljkeLib`):** .NET Class Library for shared models and logic.

---

## Project Structure

The solution is organized into three main projects:

* `BiljkeAPI/`: Contains the backend REST API that serves plant data to the client.
* `BiljkeDesktop/`: The user-facing desktop application used to interact with the catalog.
* `BiljkeLib/`: A shared library containing common data models and business logic used by both the API and the desktop application.

---

## Getting Started

To run this project locally:

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Tiitmouse/PlantCatalog.git](https://github.com/Tiitmouse/PlantCatalog.git)
    ```
2.  **Open the solution:** Open the `PlantCatalog.sln` file in Visual Studio.
3.  **Run the API:** Set `BiljkeAPI` as the startup project and run it (press F5). This will launch the backend server.
4.  **Run the Desktop App:** Stop the debugger, then set `BiljkeDesktop` as the startup project and run it. The desktop application should now be able to communicate with the API.
