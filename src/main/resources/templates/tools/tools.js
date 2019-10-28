
export const Tools = {

    // Get URL object
    parseURLFragment : () => {

        let fragment = location.hash.slice(1) || '/';
        let params = fragment.split("/")

        // URL object
        let route = { 
            resource: params[1], 
            id: params[2]
        };
        
        return route;
    },

    // Get URL from URL object
    getURLRoute: (route) => {
        let parsedURL = (route.resource ? '/' + route.resource :  '/') + 
                        (route.id ? '/:id' : '');
        return parsedURL;
    }
}