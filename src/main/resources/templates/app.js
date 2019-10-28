
import { Tools } from "/tools/tools.js";
import { RegisterPage } from "/views/RegisterPage.js";
import { MainPage } from "/views/MainPage.js";
import { ErrorPage } from "/views/ErrorPage.js";

// Routes
const routes = {
    '/': MainPage,
    '/register': RegisterPage
}

// Routing Function
const router = async() => {
    const header = document.getElementById('header_container');
    const content = document.getElementById('content_container');
    const footer = document.getElementById('footer_container');

    // Select new page based on route
    let route = Tools.parseURLFragment();
    let URLRoute = Tools.getURLRoute(route);
    let newContent = routes[URLRoute] || ErrorPage;

    // Render new page
    content.innerHTML = await newContent.render();
    newContent.postRender();
}

// Listeners
window.addEventListener('hashchange', router);
window.addEventListener('load', router);